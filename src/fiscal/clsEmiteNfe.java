package fiscal;

import DAO.PagamentosAdmDAO;
import DAO.clienteDAO;
import DAO.lancDocumentDAO;
import DAO.nfeDAO;
import Logs.gravarLog;
import br.com.swconsultoria.impressao.model.Impressao;
import br.com.swconsultoria.impressao.service.ImpressaoService;
import br.com.swconsultoria.impressao.util.ImpressaoUtil;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import br.com.swconsultoria.nfe.Nfe;
import br.com.swconsultoria.nfe.dom.ConfiguracoesNfe;
import br.com.swconsultoria.nfe.dom.enuns.DocumentoEnum;
import br.com.swconsultoria.nfe.dom.enuns.StatusEnum;
import br.com.swconsultoria.nfe.exception.NfeException;
import br.com.swconsultoria.nfe.schema_4.enviNFe.ObjectFactory;
import br.com.swconsultoria.nfe.schema_4.enviNFe.TEnderEmi;
import br.com.swconsultoria.nfe.schema_4.enviNFe.TEndereco;
import br.com.swconsultoria.nfe.schema_4.enviNFe.TEnviNFe;
import br.com.swconsultoria.nfe.schema_4.enviNFe.TInfRespTec;
import br.com.swconsultoria.nfe.schema_4.enviNFe.TNFe;
import br.com.swconsultoria.nfe.schema_4.enviNFe.TNFe.InfNFe.Dest;
import br.com.swconsultoria.nfe.schema_4.enviNFe.TNFe.InfNFe.Det;
import br.com.swconsultoria.nfe.schema_4.enviNFe.TNFe.InfNFe.Det.Imposto;
import br.com.swconsultoria.nfe.schema_4.enviNFe.TNFe.InfNFe.Det.Imposto.COFINS.COFINSNT;
import br.com.swconsultoria.nfe.schema_4.enviNFe.TNFe.InfNFe.Det.Imposto.ICMS;
import br.com.swconsultoria.nfe.schema_4.enviNFe.TNFe.InfNFe.Det.Imposto.PIS.PISAliq;
import br.com.swconsultoria.nfe.schema_4.enviNFe.TNFe.InfNFe.Det.Imposto.PIS.PISNT;
import br.com.swconsultoria.nfe.schema_4.enviNFe.TNFe.InfNFe.Det.Prod;
import br.com.swconsultoria.nfe.schema_4.enviNFe.TNFe.InfNFe.Emit;
import br.com.swconsultoria.nfe.schema_4.enviNFe.TNFe.InfNFe.Ide;
import br.com.swconsultoria.nfe.schema_4.enviNFe.TNFe.InfNFe.Total.ICMSTot;
import br.com.swconsultoria.nfe.schema_4.enviNFe.TRetEnviNFe;
import br.com.swconsultoria.nfe.schema_4.enviNFe.TUf;
import br.com.swconsultoria.nfe.schema_4.enviNFe.TUfEmi;
import br.com.swconsultoria.nfe.util.ChaveUtil;
import br.com.swconsultoria.nfe.util.ConstantesUtil;
import br.com.swconsultoria.nfe.util.RetornoUtil;
import br.com.swconsultoria.nfe.util.XmlNfeUtil;
import model.clientes;
import model.clsDadosEmpresa;
import model.clsLancDocCabecalho;
import model.clsLancDocument;
import model.clsNfTransporte;
import model.clsNfe;
import classes.clsaux;
import conexoes.conexao;
import java.time.Instant;
import java.time.ZoneId;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import model.clsConfig;
import model.clsPagamentos;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.view.JasperViewer;

public class clsEmiteNfe {

	private static ChaveUtil chave;
	private static ConfiguracoesNfe config;
	private static String cnpj;
	private static String modelo;
	private static String tipoemissao;
	private static String cnf;
	private static int serie;
	private static int numero;
	private static int indiceitem=1;
	private static LocalDateTime dataemissao;
	private static clsLancDocCabecalho movimento=new clsLancDocCabecalho();
	private static clientes cliente=new clientes();
	private static clsNfe movimentonf=new clsNfe();
	private static clsNfTransporte trans=new clsNfTransporte();
	private static List<clsLancDocument> itens=new ArrayList();
        private static List<String> referencias= new ArrayList<>();
        private static List<clsPagamentos> pagamentos= new ArrayList<>();
        

	public clsEmiteNfe(Long idmovimento) throws Exception {
		// inicia dados da nf
		
		
		iniciaVariaveisNfe(idmovimento);
		// iniciando as configurações do certificado

		config = conexao.iniciaConfifNfe();
                ZoneId zoneId = ZoneId.of("GMT-3");
                config.setZoneId(zoneId);
		// monta o objeto da nfe
		

		montaChaveNfe(config);
		nfeDAO.atualizaChaveMovimento(idmovimento, chave.getChaveNF().replace("NFe", ""));
		movimento.setChaveacesso(chave.getChaveNF().replace("NFe", ""));
		// cria os dados da nfe
		TEnviNFe tenvnfe = criaEnviNfe();
		
		// valida e assina o xml o ultimo parametro é para deixar ativado a validacao do xml antes de assinar
		tenvnfe = Nfe.montaNfe(config, tenvnfe, true);
		
		// envio nfe para sefaz
		TRetEnviNFe retorno = Nfe.enviarNfe(config, tenvnfe, DocumentoEnum.NFE);
		String xmlfinal=null;
		//faz verificacao retono e faz consulta do status do lote com recibo
		if(RetornoUtil.isRetornoAssincrono(retorno)) {
			br.com.swconsultoria.nfe.schema_4.retConsReciNFe.TRetConsReciNFe tRetConsReciNFe=verificaEnvioAssincrono(retorno);
			RetornoUtil.validaAssincrono(tRetConsReciNFe);
			System.out.println("status: " + tRetConsReciNFe.getProtNFe().get(0).getInfProt().getCStat());
			System.out.println("protocolo: " + tRetConsReciNFe.getProtNFe().get(0).getInfProt().getNProt());
			xmlfinal=XmlNfeUtil.criaNfeProc(tenvnfe, tRetConsReciNFe.getProtNFe().get(0));
			System.out.println("xmlfinal: " + xmlfinal);
			atualizaDadosNfe(retorno);
			gravarArquivoXml(xmlfinal,retorno);
			realizaImpresaoNfe(xmlfinal);
			throw new NfeException(retorno.getProtNFe().getInfProt().getXMotivo()); 
			
			
		}else {
			RetornoUtil.validaSincrono(retorno);
			System.out.println("status retorno sincrono: " + retorno.getProtNFe().getInfProt().getCStat());
			System.out.println("protocolo: " + retorno.getProtNFe().getInfProt().getNProt());
			xmlfinal=XmlNfeUtil.criaNfeProc(tenvnfe, retorno.getProtNFe());
			System.out.println("xmlfinal: " + xmlfinal);
			atualizaDadosNfe(retorno);
			gravarArquivoXml(xmlfinal,retorno);
			realizaImpresaoNfe(xmlfinal);
			throw new NfeException(retorno.getProtNFe().getInfProt().getXMotivo()); 
			
		}
		
		
		
	}

	private void atualizaDadosNfe(TRetEnviNFe retorno) {
		movimentonf.setDataaut(clsaux.retornaData(clsaux.retornaDataUTC(retorno.getProtNFe().getInfProt().getDhRecbto())));
		movimentonf.setProtocoloaut(retorno.getProtNFe().getInfProt().getNProt());
		movimentonf.setCstat(retorno.getProtNFe().getInfProt().getCStat());
		nfeDAO.inserirMovimentoNfe(movimentonf);
	}

	
	private void iniciaVariaveisNfe(Long idmovimento) {
		lancDocumentDAO moviDAO= new lancDocumentDAO();
		movimento.setIdmovimento(idmovimento.toString());
		movimentonf=nfeDAO.retornaDadosMovNf(idmovimento);
		movimento=moviDAO.buscaCabecalhoDoc(movimento);
		cliente=clienteDAO.buscar("Nao Informado", cliente, movimento.getIdparceiro());
		itens=lancDocumentDAO.buscaItens(idmovimento.toString());
                trans.setIdmovimento(idmovimento.toString());
		trans=nfeDAO.retornaDadosTransporte(trans);
                pagamentos=new PagamentosAdmDAO().retornaPagamentos(movimento.getIdmovimento());
                referencias=nfeDAO.retornaInfReferencia(idmovimento.toString());
		cnpj = clsDadosEmpresa.getCnpj();
		modelo = "55";
		serie = Integer.parseInt(movimento.getSerie());
		numero = Integer.parseInt(movimento.getDocument());
		tipoemissao = "1";
		cnf = String.format("%08d", new Random().nextInt(99999999));
                java.util.Date utilDate = new java.util.Date(movimento.getEmissao().getTime());
                Instant instant =utilDate.toInstant();
                dataemissao = LocalDateTime.ofInstant(instant, ZoneId.of("GMT-3"));
                LocalDateTime resultado = LocalDateTime.now();
                resultado = resultado.withYear(dataemissao.getYear())
                                     .withMonth(dataemissao.getMonthValue())
                                     .withDayOfMonth(dataemissao.getDayOfMonth());
                dataemissao=resultado;
               
}

	private void gravarArquivoXml(String xmlfinal, TRetEnviNFe retorno) throws IOException {
		String chavenfe=clsConfig.configuracaogeral.getCaminhoxml()+"nfe\\xml\\"+retorno.getProtNFe().getInfProt().getChNFe()+".xml";
		FileWriter arq = new FileWriter(chavenfe);
		PrintWriter gravarArq = new PrintWriter(arq);
		gravarArq.printf(xmlfinal);
		arq.close();
	}

	
	public static void realizaImpresaoNfe(String xmlfinal) throws JRException, ParserConfigurationException, IOException, SAXException {
		 try {

	                //Aqui está pegando o Layout Padrão
	                Impressao impressao = ImpressaoUtil.impressaoPadraoNFe(xmlfinal);
	                
	                impressao.setJasper(new FileInputStream("c:/esfhera/adm/nfe/jasper/DanfeNfe1.jasper"));
	                impressao.getParametros().put("SUBREPORT", "c:/esfhera/adm/nfe/jasper/Danfe_fatura1.jasper");
	                impressao.getParametros().put("Logo",  new FileInputStream("C:/esfhera/adm/imagens/nfe.jpg"));

	                //Faz a impressão em pdf File passando o caminho do Arquivo
	                ImpressaoService.impressaoPdfArquivo(impressao, "C:\\esfhera\\adm\\nfe\\pdf\\"+chave.getChaveNF()+".pdf");
	               
	                impressao = ImpressaoUtil.impressaoPadraoNFe(xmlfinal);
	                
		        impressao.setJasper(new FileInputStream("c:/esfhera/adm/nfe/jasper/DanfeNfe1.jasper"));
	                impressao.getParametros().put("SUBREPORT", "c:/esfhera/adm/nfe/jasper/Danfe_fatura1.jasper");
	                impressao.getParametros().put("Logo",  new FileInputStream("C:/esfhera/adm/imagens/nfe.jpg"));
	                
                         JasperViewer jasperview= ImpressaoService.impressaoPreview(impressao);
                         
                         JDialog dialog=new JDialog(new javax.swing.JFrame(),"Visualização dA NFe", true);
                         dialog.setSize(900, 700);
                         dialog.setLocationRelativeTo(null);
                         dialog.getContentPane().add(jasperview.getContentPane());
                         dialog.setVisible(true);
	               
	               // ImpressaoService.impressaoPreview(impressao);

	        } catch (Exception e) {
	           
	        	gravarLog.main(e.getMessage()+e.getClass());
	        	JOptionPane.showMessageDialog(null, "Erro ao inserir dados \n" +e.getMessage());
	            e.printStackTrace();
	        }
		
	}
	
	public static void realizaImpresaoNfeAntiga(String chave) throws JRException, ParserConfigurationException, IOException, SAXException {
		 try {
	            //Faça a leitura do Arquivo
	             String xml = ImpressaoUtil.leArquivo(clsConfig.configuracaogeral.getCaminhoxml()+"nfe\\xml\\"+chave+".xml");
	           //  xml = ImpressaoUtil.leArquivo("C:\\esfhera-erp\\nfe\\nf.xml");

	                //Aqui está pegando o Layout Padrão
	                Impressao impressao = ImpressaoUtil.impressaoPadraoNFe(xml);
	                
	                
	                impressao.setJasper(new FileInputStream("c:/esfhera/adm/nfe/jasper/DanfeNfe1.jasper"));
	                impressao.getParametros().put("SUBREPORT", "c:/esfhera/adm/nfe/jasper/Danfe_fatura1.jasper");
	                impressao.getParametros().put("Logo",  new FileInputStream("C:/esfhera/adm/imagens/nfe.jpg"));
	               
                        System.out.println(impressao.getJasper());
	                System.out.println(impressao.getParametros());

	                //Faz a impressão em pdf File passando o caminho do Arquivo
	               // ImpressaoService.impressaoPdfArquivo(impressao, "C:\\esfhera-erp\\nfe\\nfe.pdf");
	                JasperViewer jasperview= ImpressaoService.impressaoPreview(impressao);
	                 
                         
                         JDialog dialog=new JDialog(new javax.swing.JFrame(),"Visualização dA NFe", true);
                         dialog.setSize(900, 700);
                         dialog.setLocationRelativeTo(null);
                         dialog.getContentPane().add(jasperview.getContentPane());
                         dialog.setVisible(true);
	                
	                
	              
	               

	        } catch (Exception e) {
	            //Trate seus erros aqui
	        	gravarLog.main(e.getMessage());
	        	JOptionPane.showMessageDialog(null, "Erro ao Imprimir \n" +e.getMessage()+"\n"+e.getStackTrace());
                        e.printStackTrace();
	        }
		
	}
	
	
	

	private br.com.swconsultoria.nfe.schema_4.retConsReciNFe.TRetConsReciNFe verificaEnvioAssincrono(TRetEnviNFe retorno) throws Exception {
			 String recibo= retorno.getInfRec().getNRec();
			 nfeDAO.gravarReciboNfe(movimento.getIdmovimento(), recibo); // gravar recibo no banco de dados para consultar depois
			 int tentativa=0;
			 br.com.swconsultoria.nfe.schema_4.retConsReciNFe.TRetConsReciNFe reciboConsulta=null;
			 while(true) {
			  reciboConsulta = Nfe.consultaRecibo(config, recibo, DocumentoEnum.NFE);
			 if (reciboConsulta.getCStat().equals(StatusEnum.LOTE_EM_PROCESSAMENTO.getCodigo())){
				Thread.sleep(2000);
				 tentativa++;
				 if (tentativa> 10) {
					
					 
					 throw new Exception("Lote em processamento");
				 }
			 }else {
				 break;
			 }
			}
		return reciboConsulta;
		
	}

	private void montaChaveNfe(ConfiguracoesNfe config) {
		chave = new ChaveUtil(config.getEstado(), cnpj, modelo, serie, numero, tipoemissao, cnf, dataemissao);

	}

	private TEnviNFe criaEnviNfe() {
		TEnviNFe enviNfe = new TEnviNFe();
		enviNfe.setVersao(ConstantesUtil.VERSAO.NFE);
		enviNfe.setIdLote("1");
		enviNfe.setIndSinc("1");
		TNFe nfe = new TNFe();
		TNFe.InfNFe infNfe = getInfNfe();
		nfe.setInfNFe(infNfe);
		enviNfe.getNFe().add(nfe);

		return enviNfe;
	}

	// chamada de todos os metodos necessarios para a emissao da nfe
	private TNFe.InfNFe getInfNfe() {
		TNFe.InfNFe infnfe = new TNFe.InfNFe();

		infnfe.setId(chave.getChaveNF());
		infnfe.setVersao(ConstantesUtil.VERSAO.NFE);
		infnfe.setIde(montaIde());

		infnfe.setEmit(montaEmitente());
		infnfe.setDest(montaDestinatario());

		infnfe.getDet().addAll(montaDet());
		infnfe.setTransp(montaTranspotadora());
                infnfe.setPag(montaPagamento());
		infnfe.setInfAdic(montaInfAdicional());
		infnfe.setInfRespTec(montaResponsavel());
		infnfe.setTotal(montaTotal());
                if(pagamentos.size()==0);
                else{
                    infnfe.setCobr(montaCobranca());
                }
                

		return infnfe;

	}
        
        private TNFe.InfNFe.InfAdic montaInfAdicional(){
            TNFe.InfNFe.InfAdic adc= new TNFe.InfNFe.InfAdic();
            String obs="";
            if(clsaux.trataCampoNulo(movimentonf.getObservacaoNf()).length()>1){
               obs=movimentonf.getObservacaoNf()+" ";
            }
            if(referencias.size()>0){//&& movimentonf.getFinalidade().equals("4")){
                obs=obs+"Chave Acesso Referenciada: ";
                for(String novo:referencias ){
                    obs=obs+" "+ novo;
                 }
            }
            if(movimentonf.getFinalidade().equals("4")){
                obs=obs+"Valor Impostos Devolvido: "+movimento.getValoripi();
            }
            if(obs.length()>1){
                adc.setInfCpl(obs);
            }
            return adc;
        }

	private TNFe.InfNFe.Total montaTotal() {
		TNFe.InfNFe.Total total= new TNFe.InfNFe.Total();
		ICMSTot icmsTotal = new ICMSTot();
		icmsTotal.setVBC(clsaux.formatoNfe(Double.parseDouble(movimento.getBaseicms())));
		
		icmsTotal.setVICMS(movimento.getValoricms());
		icmsTotal.setVICMSDeson("0.00");
		icmsTotal.setVFCP("0.00");
		icmsTotal.setVBCST(movimento.getBasest());
		icmsTotal.setVST(movimento.getValorst());
		icmsTotal.setVFCPSTRet("0.00");
		icmsTotal.setVFCPST("0.00");
		icmsTotal.setVProd(clsaux.formatoNfe(Double.parseDouble(movimento.getTotalprod())));
		icmsTotal.setVFrete(clsaux.formatoNfe(Double.parseDouble(movimento.getVlFrete())));
		icmsTotal.setVSeg("0.00");
		icmsTotal.setVDesc(clsaux.formatoNfe(Double.parseDouble(movimento.getDesconto())));
		icmsTotal.setVII("0.00");
                
		
		icmsTotal.setVPIS(clsaux.formatoNfe(Double.parseDouble(movimento.getValor_pis())));
		icmsTotal.setVCOFINS(clsaux.formatoNfe(Double.parseDouble(movimento.getValor_cofins())));
		icmsTotal.setVOutro(clsaux.formatoNfe(Double.parseDouble(movimento.getOutrasdesp())));
		icmsTotal.setVNF(clsaux.formatoNfe(Double.parseDouble(movimento.getTotal())));
		if(movimentonf.getFinalidade().equals("4")){
                    icmsTotal.setVIPI("0.00");
                    icmsTotal.setVIPIDevol(clsaux.formatoNfe(Double.parseDouble(movimento.getValoripi())));
                }else{
                    icmsTotal.setVIPI(clsaux.formatoNfe(Double.parseDouble(movimento.getValoripi())));
                    icmsTotal.setVIPIDevol("0.00");
                }
                
                total.setICMSTot(icmsTotal );
		
		return total;
	}

	private TInfRespTec montaResponsavel() {
		TInfRespTec resp = new TInfRespTec();
		resp.setCNPJ("47767810000131");
		resp.setEmail("Lucas_eng.software@outlook.com");
		resp.setFone("42984071225");
		resp.setXContato("Lucas Alan Rodrigues");

		return resp;
	}

	private TNFe.InfNFe.Pag montaPagamento() {
		TNFe.InfNFe.Pag pag = new TNFe.InfNFe.Pag();
		TNFe.InfNFe.Pag.DetPag detPag = new TNFe.InfNFe.Pag.DetPag();
                if(movimentonf.getFinalidade().equals("3")||movimentonf.getFinalidade().equals("4")){
                     detPag.setVPag("0.00");
                    detPag.setTPag("90");
                    
                }else{
                    
                    detPag.setVPag(clsaux.formatoNfe(Double.parseDouble(movimento.getTotal())));
                    detPag.setTPag("01");
                }
                pag.getDetPag().add(detPag);

		return pag;
	}

        private TNFe.InfNFe.Cobr montaCobranca(){
            TNFe.InfNFe.Cobr cob= new TNFe.InfNFe.Cobr();
            TNFe.InfNFe.Cobr.Fat fat= new TNFe.InfNFe.Cobr.Fat();
            
            fat.setNFat(movimento.getDocument());
            fat.setVOrig(clsaux.formatoNfe(Double.parseDouble(movimento.getTotal())));
            fat.setVLiq(clsaux.formatoNfe(Double.parseDouble(movimento.getTotal())));
            cob.setFat(fat);
            
            for(clsPagamentos pg :pagamentos){
                if(pg.getIdfinalizadora().equals("4")){
                     TNFe.InfNFe.Cobr.Dup dp= new TNFe.InfNFe.Cobr.Dup();
                     dp.setNDup(String.format("%03d", Integer.parseInt(pg.getParcela())));
                     dp.setVDup(clsaux.formatoNfe(Double.parseDouble(pg.getValor())));
                     dp.setDVenc(pg.getDatavencimento());
                     cob.getDup().add(dp);
                }
            }
            return cob;
        }
        
	private TNFe.InfNFe.Transp montaTranspotadora() {
		TNFe.InfNFe.Transp transp = new TNFe.InfNFe.Transp();
                transp.setModFrete(trans.getModfrete().trim());
                if(trans.getModfrete().equals("9"));
                else{
                   TNFe.InfNFe.Transp.Transporta tr= new TNFe.InfNFe.Transp.Transporta();
                   tr.setCNPJ(trans.getCnpj());
                   tr.setXNome(trans.getRazao());
                   tr.setUF(TUf.valueOf(trans.getUf()));
                   tr.setXEnder(trans.getEndereco());
                   tr.setXMun(trans.getCidade());
                   transp.setTransporta(tr);
                   TNFe.InfNFe.Transp.Vol vl= new TNFe.InfNFe.Transp.Vol();
                   vl.setEsp(trans.getEspecie());
                   vl.setNVol(String.valueOf(clsaux.capturaValores(trans.getNumero()).intValue()));
                   vl.setPesoB(clsaux.formatoNfe3(clsaux.capturaValores(trans.getPesobruto())));
                   vl.setPesoL(clsaux.formatoNfe3(clsaux.capturaValores(trans.getPesoliq())));
                   vl.setQVol(String.valueOf(clsaux.capturaValores(trans.getVolumes()).intValue()));
                   transp.getVol().add(vl);
                }

		return transp;
	}

	private List<Det> montaDet() {
		//itens=movimento.getItens();
		
		//indiceitem=itens.size();
		int iditem=1;
		List<Det> listaItens=new ArrayList();
		//TNFe.InfNFe.Det det = new Det();
		System.out.println(itens.toString());
		for(indiceitem=0; indiceitem<itens.size(); indiceitem++) {
			TNFe.InfNFe.Det det = new Det();
			
			det.setNItem(String.valueOf(iditem)); // numero de cada item campo retorna da base id_item em ordem sequencial
			det.setProd(montaProduto());
			det.setImposto(montaImposto());
                        if(movimentonf.getFinalidade().equals("4")){
                            det.setImpostoDevol(impostodevolvido());
                        
                        
                        }
                        iditem++;
			listaItens.add(det);
		}
		return listaItens;
	}

        private TNFe.InfNFe.Det.ImpostoDevol impostodevolvido(){
             TNFe.InfNFe.Det.ImpostoDevol imp= new Det.ImpostoDevol();
             criaImpostoIPIdevolvido(imp);
             return imp;
        }
	private Imposto montaImposto() {
		TNFe.InfNFe.Det.Imposto imposto = new TNFe.InfNFe.Det.Imposto();
                criaImpostoIcms(imposto);
		criaImpostoPis(imposto);
		criaImpostoCofins(imposto);
               
		return imposto;
	}
        
       private void criaImpostoIPIdevolvido(TNFe.InfNFe.Det.ImpostoDevol imposto){
            TNFe.InfNFe.Det.ImpostoDevol.IPI ipi= new Det.ImpostoDevol.IPI();
                 
                 ipi.setVIPIDevol(itens.get(indiceitem).getValor_ipi());
            imposto.setPDevol(itens.get(indiceitem).getAliq_ipi());
            imposto.setIPI(ipi);
           
        }
        

	private void criaImpostoPis(TNFe.InfNFe.Det.Imposto imposto) {
		TNFe.InfNFe.Det.Imposto.PIS pis = new TNFe.InfNFe.Det.Imposto.PIS();
		if (itens.get(indiceitem).getPis_cofins().trim().equals("01")||itens.get(indiceitem).getPis_cofins().trim().equals("02")) {
			PISAliq pisAliq = new PISAliq();
			pisAliq.setCST(itens.get(indiceitem).getPis_cofins());
			pisAliq.setVBC(itens.get(indiceitem).getBase_pis());
			pisAliq.setPPIS(itens.get(indiceitem).getAliq_pis());
			pisAliq.setVPIS(itens.get(indiceitem).getValor_pis());
			pis.setPISAliq(pisAliq);
		}else {
			PISNT pisnt=new PISNT();
			pisnt.setCST(itens.get(indiceitem).getPis_cofins());
			pis.setPISNT(pisnt);
		}
		imposto.getContent().add(new ObjectFactory().createTNFeInfNFeDetImpostoPIS(pis));

	}

	private void criaImpostoCofins(TNFe.InfNFe.Det.Imposto imposto) {
		TNFe.InfNFe.Det.Imposto.COFINS cofins = new TNFe.InfNFe.Det.Imposto.COFINS();
		if (itens.get(indiceitem).getPis_cofins().trim().equals("01")||itens.get(indiceitem).getPis_cofins().trim().equals("02")) {
			TNFe.InfNFe.Det.Imposto.COFINS.COFINSAliq cofinsAliq = new TNFe.InfNFe.Det.Imposto.COFINS.COFINSAliq();
			cofinsAliq.setCST(itens.get(indiceitem).getPis_cofins());
			cofinsAliq.setVBC(itens.get(indiceitem).getBase_pis());
			cofinsAliq.setPCOFINS(itens.get(indiceitem).getAliq_cofins());
			cofinsAliq.setVCOFINS(itens.get(indiceitem).getValor_cofins());
			cofins.setCOFINSAliq(cofinsAliq);
		}else {
			COFINSNT cofinsnt=new COFINSNT();
			cofinsnt.setCST(itens.get(indiceitem).getPis_cofins());
			cofins.setCOFINSNT(cofinsnt);
		}
		imposto.getContent().add(new ObjectFactory().createTNFeInfNFeDetImpostoCOFINS(cofins));

	}

	private void criaImpostoIcms(TNFe.InfNFe.Det.Imposto imposto) {
		TNFe.InfNFe.Det.Imposto.ICMS icms = new TNFe.InfNFe.Det.Imposto.ICMS();
                int cst=Integer.parseInt(itens.get(indiceitem).getCst());
		switch(cst) {
			case 101:icms=criaImposto0101(icms);
			break;
			case 103:icms=criaImposto0102(icms);
			break;
			case 300:icms=criaImposto0102(icms);
			break;
			case 400:icms=criaImposto0102(icms);
			break;
			case 102: icms=criaImposto0102(icms);
			break;
			case 500: icms=criaImposto0500(icms);
			break;
			case 201: icms=criaImposto0201(icms);
			break;
			case 202: icms=criaImposto0202(icms);
			break;
			case 900: icms=criaImposto0900(icms);
			break;
			/*case 0: icms=criaImposto0(icms);
			break;
			case 10: icms=criaImposto10(icms);
			break;
			case 20: icms=criaImposto20(icms);
			break;
			case 30: icms=criaImposto30(icms);
			break;
			case 40: icms=criaImposto40(icms);
			break;
			case 51: icms=criaImposto51(icms);
			break;
			case 60: icms= criaImposto60(icms);
			break;
			case 70: icms=criaImposto70(icms);
			break;
			case 90: icms=criaImposto90(icms);*/
			
		
		}
		imposto.getContent().add(new ObjectFactory().createTNFeInfNFeDetImpostoICMS(icms));

	}

	private ICMS criaImposto90(ICMS icms) {
		TNFe.InfNFe.Det.Imposto.ICMS.ICMS90 icms90=new TNFe.InfNFe.Det.Imposto.ICMS.ICMS90();
		icms90.setOrig(itens.get(indiceitem).getOrigem_produto());
		icms90.setCST("90");
		icms90.setModBC(itens.get(indiceitem).getModbc());
		icms90.setVBC(itens.get(indiceitem).getBase_icms());
		icms90.setPICMS(itens.get(indiceitem).getAliq_icms());
		icms90.setVICMS(itens.get(indiceitem).getValor_icms());
		icms90.setModBCST(itens.get(indiceitem).getModbc());
		icms90.setVBCST(itens.get(indiceitem).getBase_st());
		icms90.setPICMSST("0.00");
		icms90.setVICMSST(itens.get(indiceitem).getValor_st());
		icms90.setVICMSDeson("0.00");
		icms90.setMotDesICMS("9");
		icms.setICMS90(icms90);
		
		return icms;
	}
/*
	private ICMS criaImposto70(ICMS icms) {
		TNFe.InfNFe.Det.Imposto.ICMS.ICMS70 icms70=new TNFe.InfNFe.Det.Imposto.ICMS.ICMS70();
		icms70.setOrig(itens.get(indiceitem).getOrigem_item());
		icms70.setCST("70");
		icms70.setModBC(itens.get(indiceitem).getModalidade_icms());
		icms70.setPRedBC(clsaux.formatoNfe(itens.get(indiceitem).getRed_baseicms()));
		icms70.setVBC(clsaux.formatoNfe(itens.get(indiceitem).getBaseicms()));
		icms70.setPICMS(clsaux.formatoNfe(itens.get(indiceitem).getAliqicms()));
		icms70.setVICMS(clsaux.formatoNfe(itens.get(indiceitem).getVlicms()));
		icms70.setModBCST(itens.get(indiceitem).getModalidade_bc_st());
		icms70.setVBCST(clsaux.formatoNfe(itens.get(indiceitem).getBasest()));
		icms70.setPICMSST(clsaux.formatoNfe(itens.get(indiceitem).getAliqst()));
		icms70.setVICMSST(clsaux.formatoNfe(itens.get(indiceitem).getVlst()));
		icms70.setVICMSDeson(clsaux.formatoNfe(itens.get(indiceitem).getVl_icms_desonerado()));
		icms70.setMotDesICMS("9");
		icms.setICMS70(icms70);
		
		return icms;
	}

	private ICMS criaImposto60(ICMS icms) {
		TNFe.InfNFe.Det.Imposto.ICMS.ICMS60 icms60=new TNFe.InfNFe.Det.Imposto.ICMS.ICMS60();
		icms60.setOrig(itens.get(indiceitem).getOrigem_item());
		icms60.setCST("60");
		icms60.setVBCSTRet(clsaux.formatoNfe(itens.get(indiceitem).getBc_st_retido()));
		icms60.setVICMSSTRet(clsaux.formatoNfe(itens.get(indiceitem).getVl_st_retido()));
		icms.setICMS60(icms60);
		return icms;
	}

	private ICMS criaImposto51(ICMS icms) {
		TNFe.InfNFe.Det.Imposto.ICMS.ICMS51 icms51=new TNFe.InfNFe.Det.Imposto.ICMS.ICMS51();
		icms51.setOrig(itens.get(indiceitem).getOrigem_item());
		icms51.setCST("51");
		icms.setICMS51(icms51);
		return icms;
	}

	private ICMS criaImposto40(ICMS icms) {
		TNFe.InfNFe.Det.Imposto.ICMS.ICMS40 icms40=new TNFe.InfNFe.Det.Imposto.ICMS.ICMS40();
		icms40.setOrig(itens.get(indiceitem).getOrigem_item());
		icms40.setCST(String.valueOf( itens.get(indiceitem).getCst()));
		icms40.setVICMSDeson(clsaux.formatoNfe(itens.get(indiceitem).getVl_icms_desonerado()));
		icms40.setMotDesICMS("9");
		icms.setICMS40(icms40);
		return icms;
	}

	private ICMS criaImposto30(ICMS icms) {
		TNFe.InfNFe.Det.Imposto.ICMS.ICMS30 icms30=new TNFe.InfNFe.Det.Imposto.ICMS.ICMS30();
		icms30.setOrig(itens.get(indiceitem).getOrigem_item());
		icms30.setCST("30");
		icms30.setModBCST(itens.get(indiceitem).getModalidade_bc_st());
		icms30.setVBCST(clsaux.formatoNfe(itens.get(indiceitem).getBasest()));
		icms30.setPICMSST(clsaux.formatoNfe(itens.get(indiceitem).getAliqst()));
		icms30.setVICMSST(clsaux.formatoNfe(itens.get(indiceitem).getVlst()));
		icms30.setVICMSDeson(clsaux.formatoNfe(itens.get(indiceitem).getVl_icms_desonerado()));
		icms30.setMotDesICMS("9");
		icms.setICMS30(icms30);
		return icms;
	}

	private ICMS criaImposto20(ICMS icms) {
		TNFe.InfNFe.Det.Imposto.ICMS.ICMS20 icms20=new TNFe.InfNFe.Det.Imposto.ICMS.ICMS20();
		icms20.setOrig(itens.get(indiceitem).getOrigem_item());
		icms20.setCST("20");
		icms20.setModBC(itens.get(indiceitem).getModalidade_icms());
		icms20.setPRedBC(clsaux.formatoNfe(itens.get(indiceitem).getRed_baseicms()));
		icms20.setVBC(clsaux.formatoNfe(itens.get(indiceitem).getBaseicms()));
		icms20.setPICMS(clsaux.formatoNfe(itens.get(indiceitem).getAliqicms()));
		icms20.setVICMS(clsaux.formatoNfe(itens.get(indiceitem).getVlicms()));
		icms20.setVICMSDeson(clsaux.formatoNfe(itens.get(indiceitem).getVl_icms_desonerado()));
		icms20.setMotDesICMS("9");
		icms.setICMS20(icms20);
		
		return icms;
	}

	private ICMS criaImposto10(ICMS icms) {
		TNFe.InfNFe.Det.Imposto.ICMS.ICMS10 icms10=new TNFe.InfNFe.Det.Imposto.ICMS.ICMS10();
		icms10.setOrig(itens.get(indiceitem).getOrigem_item());
		icms10.setCST("10");
		icms10.setModBC(itens.get(indiceitem).getModalidade_icms());
		icms10.setVBC(clsaux.formatoNfe(itens.get(indiceitem).getBaseicms()));
		icms10.setPICMS(clsaux.formatoNfe(itens.get(indiceitem).getAliqicms()));
		icms10.setVICMS(clsaux.formatoNfe(itens.get(indiceitem).getVlicms()));
		icms10.setModBCST(itens.get(indiceitem).getModalidade_bc_st().trim());
		icms10.setVBCST(clsaux.formatoNfe(itens.get(indiceitem).getBasest()));
		icms10.setPICMSST(clsaux.formatoNfe(itens.get(indiceitem).getAliqst()));
		icms10.setVICMSST(clsaux.formatoNfe(itens.get(indiceitem).getVlst()));
		icms.setICMS10(icms10);
		return icms;
	}

	private ICMS criaImposto0(ICMS icms) {
		TNFe.InfNFe.Det.Imposto.ICMS.ICMS00 icms00=new TNFe.InfNFe.Det.Imposto.ICMS.ICMS00();
		icms00.setOrig(itens.get(indiceitem).getOrigem_item());
		icms00.setCST("00");
		icms00.setModBC(itens.get(indiceitem).getModalidade_icms());
		icms00.setVBC(clsaux.formatoNfe(itens.get(indiceitem).getBaseicms()));
		icms00.setPICMS(clsaux.formatoNfe(itens.get(indiceitem).getAliqicms()));
		icms00.setVICMS(clsaux.formatoNfe(itens.get(indiceitem).getVlicms()));
		icms.setICMS00(icms00);
		
		return icms;
	}
        */
	private ICMS criaImposto0900(ICMS icms) {
		TNFe.InfNFe.Det.Imposto.ICMS.ICMSSN900 icms900 = new TNFe.InfNFe.Det.Imposto.ICMS.ICMSSN900();
		icms900.setOrig(itens.get(indiceitem).getOrigem_produto());
		icms900.setCSOSN("900");
		icms900.setModBC(itens.get(indiceitem).getModbc());
		icms900.setVBC(itens.get(indiceitem).getBase_icms());
		icms900.setPICMS(itens.get(indiceitem).getAliq_icms());
		icms900.setVICMS(itens.get(indiceitem).getValor_icms());
		icms900.setModBCST("3");
		icms900.setVBCST(itens.get(indiceitem).getBase_st());
		icms900.setPICMSST(itens.get(indiceitem).getAliq_icms());
		icms900.setVICMSST(itens.get(indiceitem).getValor_st());
		icms900.setPCredSN("0.00");
		icms900.setVCredICMSSN("0.00");
		icms.setICMSSN900(icms900);
		return icms;
	}

	private ICMS criaImposto0202(ICMS icms) {
		TNFe.InfNFe.Det.Imposto.ICMS.ICMSSN202 icms202 = new TNFe.InfNFe.Det.Imposto.ICMS.ICMSSN202	();
		icms202.setOrig(itens.get(indiceitem).getOrigem_produto());
		icms202.setCSOSN("202");
		icms202.setModBCST(itens.get(indiceitem).getModbc());
		icms202.setVBCST(itens.get(indiceitem).getBase_st());
		icms202.setPICMSST(itens.get(indiceitem).getAliq_icms());
		icms202.setVICMSST(itens.get(indiceitem).getValor_st());
		icms.setICMSSN202(icms202);
		return icms;
	}

	private ICMS criaImposto0201(ICMS icms) {
		TNFe.InfNFe.Det.Imposto.ICMS.ICMSSN201 icms201 = new TNFe.InfNFe.Det.Imposto.ICMS.ICMSSN201	();
		icms201.setOrig(itens.get(indiceitem).getOrigem_produto());
		icms201.setCSOSN("201");
		icms201.setModBCST(itens.get(indiceitem).getModbc());
		icms201.setVBCST(itens.get(indiceitem).getBase_st());
		icms201.setPICMSST(itens.get(indiceitem).getAliq_icms());
		icms201.setVICMSST(itens.get(indiceitem).getValor_st());
		icms201.setPCredSN("0.00");
		icms201.setVCredICMSSN("0.00");
		icms.setICMSSN201(icms201);
		return icms;
	}

	private ICMS criaImposto0500(ICMS icms) {
		TNFe.InfNFe.Det.Imposto.ICMS.ICMSSN500 icms500 = new TNFe.InfNFe.Det.Imposto.ICMS.ICMSSN500();
		icms500.setOrig(itens.get(indiceitem).getOrigem_produto());
		icms500.setCSOSN("500");
		icms500.setVBCSTRet("0.00");
		icms500.setPST("0.00");
		icms500.setVICMSSTRet("0.00");
		icms.setICMSSN500(icms500);
		return icms;
	}

	private ICMS criaImposto0101(ICMS icms) {
		TNFe.InfNFe.Det.Imposto.ICMS.ICMSSN101 icms101 = new TNFe.InfNFe.Det.Imposto.ICMS.ICMSSN101();
		icms101.setOrig(itens.get(indiceitem).getOrigem_produto());
		icms101.setCSOSN("101");
		icms101.setPCredSN("0.00");
		icms101.setVCredICMSSN("0.00");
		icms.setICMSSN101(icms101);
		return icms;
	}

	private ICMS criaImposto0102(ICMS icms) {
		TNFe.InfNFe.Det.Imposto.ICMS.ICMSSN102 icms102 = new TNFe.InfNFe.Det.Imposto.ICMS.ICMSSN102();
		icms102.setOrig(itens.get(indiceitem).getOrigem_produto());
		icms102.setCSOSN("102");
		icms.setICMSSN102(icms102);
		return icms;
	}

	private Prod montaProduto() {
		TNFe.InfNFe.Det.Prod produto = new Prod();
		produto.setCProd(itens.get(indiceitem).getBarras());// pode vir o id do produto ou codigo referencial do item
		produto.setCEAN("SEM GTIN"); // funcao para validar se o gtin é valido ou nao
		produto.setXProd(itens.get(indiceitem).getDescricaofornecedor());
		produto.setNCM(itens.get(indiceitem).getNcm());
		if (itens.get(indiceitem).getCst().equals("500")||itens.get(indiceitem).getCst().equals("10")||itens.get(indiceitem).getCst().equals("60")) {
			produto.setCEST("8600500");
		}
		//produto.setCEST("0000000");
		//produto.setIndEscala("S");
		produto.setCFOP(itens.get(indiceitem).getCfop());
		produto.setUCom(itens.get(indiceitem).getUnidade());
		produto.setQCom(itens.get(indiceitem).getQuantidade());
		produto.setVUnCom(itens.get(indiceitem).getPrecovenda());
		produto.setVProd(clsaux.formatoNfe(Double.parseDouble(itens.get(indiceitem).getPrecovenda())*clsaux.capturaValores(itens.get(indiceitem).getQuantidade())));
		produto.setCEANTrib("SEM GTIN");
		produto.setUTrib(itens.get(indiceitem).getUnidade());
		produto.setQTrib(itens.get(indiceitem).getQuantidade());
		produto.setVUnTrib(itens.get(indiceitem).getPrecovenda());
		produto.setIndTot("1");
                if (clsaux.capturaValores(itens.get(indiceitem).getDesconto())>0.00) produto.setVDesc(clsaux.formatoNfe(clsaux.capturaValores(itens.get(indiceitem).getDesconto())));
		if (clsaux.capturaValores(itens.get(indiceitem).getAcrescimo())>0.00) produto.setVOutro(clsaux.formatoNfe(clsaux.capturaValores(itens.get(indiceitem).getAcrescimo())));
                if (clsaux.capturaValores(itens.get(indiceitem).getValor_frete())>0.00) produto.setVFrete(clsaux.formatoNfe(clsaux.capturaValores(itens.get(indiceitem).getValor_frete())));
                
                return produto;
	}

	private Dest montaDestinatario() {
		TNFe.InfNFe.Dest dest = new Dest();
		if (config.getAmbiente().getCodigo().equals("2")) {
			dest.setXNome("NF-E EMITIDA EM AMBIENTE DE HOMOLOGACAO - SEM VALOR FISCAL");
		}else {
			dest.setXNome(cliente.getRazaoSocial().trim());
		}
		
		if(cliente.getCnpj().trim().length()>11) {
			dest.setCNPJ(cliente.getCnpj().trim());
			
			dest.setIndIEDest(movimentonf.getIndie());
                        if((movimentonf.getIndie().equals("1"))){
                            dest.setIE(cliente.getInscricaoEstadual());
                        }
			
		}else {
			dest.setCPF(cliente.getCnpj());
			dest.setIndIEDest(movimentonf.getIndie());
		}
		TEndereco endereco = new TEndereco();
		endereco.setXLgr(cliente.getRua());
		endereco.setXBairro(cliente.getBairro());
		endereco.setNro(cliente.getNumero());
		//endereco.setXCpl(enderecoCliente.getComplemento().trim());
		endereco.setCMun(cliente.getCodmun());
		endereco.setXMun(cliente.getCidade());
		endereco.setUF(TUf.valueOf(cliente.getEstado()));
		endereco.setCEP(cliente.getCep().replace("-", ""));
		dest.setEnderDest(endereco);

		return dest;
	}

	private Emit montaEmitente() {
		TNFe.InfNFe.Emit emit = new TNFe.InfNFe.Emit();
		emit.setXNome(clsDadosEmpresa.getRazao());
		emit.setCNPJ(cnpj);
		emit.setIE(clsDadosEmpresa.getIncricao_estadual());
		emit.setCRT("1");
		TEnderEmi endereco = new TEnderEmi();
		endereco.setXLgr(clsDadosEmpresa.getRua());
		endereco.setXBairro(clsDadosEmpresa.getBairro());
		endereco.setNro(clsDadosEmpresa.getNumero());
		endereco.setXCpl("Complemento");
		endereco.setCMun("4109401");
		endereco.setXMun(clsDadosEmpresa.getCidade());
		endereco.setUF(TUfEmi.valueOf(config.getEstado().name()));
		endereco.setCEP("85053030");
		emit.setEnderEmit(endereco);
		return emit;
	}

	private Ide montaIde() {
		TNFe.InfNFe.Ide ide = new TNFe.InfNFe.Ide();
		ide.setCUF(config.getEstado().getCodigoUF());
		ide.setCNF(cnf);
		ide.setNatOp(validaCfop(itens.get(0).getCfop()));
		ide.setMod(modelo);
		ide.setSerie(String.valueOf(serie));
		ide.setNNF(String.valueOf(numero));
                ide.setDhEmi(XmlNfeUtil.dataNfe(dataemissao));
                //ide.setTpNF("1");//define se é saida ou entrada
		ide.setIdDest(movimentonf.getInddest());
		ide.setCMunFG("4109401");
		ide.setTpImp("1");
		ide.setTpEmis(tipoemissao);
		ide.setCDV(chave.getDigitoVerificador());
		ide.setTpAmb(config.getAmbiente().getCodigo());
		ide.setFinNFe(movimentonf.getFinalidade());
		ide.setIndFinal(movimentonf.getConsfinal());
		ide.setIndPres(movimentonf.getPrescomp());
		ide.setProcEmi("0");
		ide.setVerProc("Esfhera Light 1.0.1");
                 
                switch (clsaux.retornaId(movimento.getTipomovimento())){
                    case "3" : ide.setTpNF("0");
                    break;
                    case "10" : ide.setTpNF("0");
                    break;
                    
                    default: ide.setTpNF("1");
                
                }
                
                //JOptionPane.showMessageDialog(null, movimento.getTipomovimento()+"-"+ide.getTpNF());
                for(String novo:referencias){
                   TNFe.InfNFe.Ide.NFref ref= new Ide.NFref();
                        ref.setRefNFe(novo);
                        ide.getNFref().add(ref);
                        
                }
                return ide;
	}
        
        private String validaCfop(String cfop){
            String ret="Venda Mercadoria";
            switch (cfop){
                case "5202": ret="Devolucao De Compra";
                break;
                case "6202": ret="Devolucao De Compra";
                break;
                case "6411": ret="Devolucao De Mercadoria";
                break;
                case "5411": ret="Devolucao De Mercadoria";
                break;
                case "5917": ret="Remessa Em Consignacao";
                break;
                case "1411": ret="Devolucao de Venda";
                break;
                case "1202": ret="Devolucao de Venda";
                break;
             }
            return ret;
            
        }

}
