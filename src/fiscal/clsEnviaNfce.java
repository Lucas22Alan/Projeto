package fiscal;
import DAO.configuracaoDAO;
import DAO.lancDocumentDAO;
import DAO.nfeDAO;
import Logs.gravarLog;
import br.com.swconsultoria.certificado.exception.CertificadoException;
import br.com.swconsultoria.impressao.model.Impressao;
import br.com.swconsultoria.impressao.service.ImpressaoService;
import br.com.swconsultoria.impressao.util.ImpressaoUtil;
import br.com.swconsultoria.nfe.Nfe;
import br.com.swconsultoria.nfe.dom.ConfiguracoesNfe;
import br.com.swconsultoria.nfe.dom.enuns.DocumentoEnum;
import br.com.swconsultoria.nfe.dom.enuns.ServicosEnum;
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
import br.com.swconsultoria.nfe.schema_4.retConsSitNFe.TRetConsSitNFe;
import br.com.swconsultoria.nfe.util.ChaveUtil;
import br.com.swconsultoria.nfe.util.ConstantesUtil;
import br.com.swconsultoria.nfe.util.NFCeUtil;
import br.com.swconsultoria.nfe.util.RetornoUtil;
import br.com.swconsultoria.nfe.util.WebServiceUtil;
import br.com.swconsultoria.nfe.util.XmlNfeUtil;
import model.clientes;
import model.clsConfigPdv;
import model.clsDadosEmpresa;
import model.clsLancDocCabecalho;
import model.clsLancDocument;
import model.clsNfe;
import classes.clsaux;
import conexoes.conexao;

import java.io.FileWriter;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRXmlDataSource;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Random;


import javax.swing.JDialog;
import javax.swing.JOptionPane;

import model.clsConfig;
import net.sf.jasperreports.view.JasperViewer;


public class clsEnviaNfce {

	private static String chave;
	private static ConfiguracoesNfe config;
	private static String cnpj;
	private static String modelo;
	private static String tipoemissao;
	private static String cnf;
        private static String token;
        private static String csc;
	private static int serie;
	private static int numero;
	private static int indiceitem=1;
	private static LocalDateTime dataemissao;
	private static clsLancDocCabecalho movimento=new clsLancDocCabecalho();
	private static clientes cliente=new clientes();
	private static clsNfe movimentonf=new clsNfe();
	private static List<clsLancDocument> itens=new ArrayList();

	public clsEnviaNfce(Long idmovimento) throws Exception {
		// inicia dados da nf
		
		config = conexao.iniciaConfifNfe();
                iniciaVariaveisNfe(idmovimento);
	
                // cria os dados da nfe
		TEnviNFe tenvnfe = criaEnviNfe();
		
		// valida e assina o xml o ultimo parametro é para deixar ativado a validacao do xml antes de assinar
		tenvnfe = Nfe.montaNfe(config, tenvnfe, true);
		
                //monta qrcode
                String qr=preencheQRCode(tenvnfe, config, token, csc);
                
                TNFe.InfNFeSupl infNFeSupl= new TNFe.InfNFeSupl();
                infNFeSupl.setQrCode(qr);
                infNFeSupl.setUrlChave(WebServiceUtil.getUrl(config, DocumentoEnum.NFCE, ServicosEnum.URL_CONSULTANFCE));
                tenvnfe.getNFe().get(0).setInfNFeSupl(infNFeSupl);
                
                        
                try{
                
		// envio nfe para sefaz
                    TRetEnviNFe retorno = Nfe.enviarNfe(config, tenvnfe, DocumentoEnum.NFCE);
                    movimentonf.setMotivo(retorno.getXMotivo());
                    movimentonf.setCstat(retorno.getCStat());
                    String xmlfinal=null;
                    //faz verificacao retono e faz consulta do status do lote com recibo
                   gravarArquivoXmlEnvio(XmlNfeUtil.objectToXml(tenvnfe),chave);
                   if(RetornoUtil.isRetornoAssincrono(retorno)) {
                            br.com.swconsultoria.nfe.schema_4.retConsReciNFe.TRetConsReciNFe tRetConsReciNFe=verificaEnvioAssincrono(retorno);
                            RetornoUtil.validaAssincrono(tRetConsReciNFe);
                            xmlfinal=XmlNfeUtil.criaNfeProc(tenvnfe, tRetConsReciNFe.getProtNFe().get(0));
                            System.out.println("Retorno assincrono xmlfinal: " + xmlfinal);
                            atualizaDadosNfe(retorno);
                            gravarArquivoXml(xmlfinal,chave.replace("NFe", ""));
                            atualizaDadosNfe(retorno);

                            ///throw new NfeException(retorno.getProtNFe().getInfProt().getXMotivo()); 
                    }else {
                            RetornoUtil.validaSincrono(retorno);
                            xmlfinal=XmlNfeUtil.criaNfeProc(tenvnfe, retorno.getProtNFe());
                            System.out.println("Retorno sincrono xmlfinal: " + xmlfinal);
                            atualizaDadosNfe(retorno);
                            gravarArquivoXml(xmlfinal,chave.replace("NFe", ""));
                            //throw new NfeException(retorno.getProtNFe().getInfProt().getXMotivo()); 

                    }
                }catch(NfeException e){
                    // deve atualizar o motivo no cadastro da nfce
                    nfeDAO.inserirMovimentoNfe(movimentonf);
                }
        }

    
   

        public  clsEnviaNfce(Long mvto , TRetConsSitNFe protocolo) throws Exception{
            
                iniciaVariaveisNfe(mvto);
                config = conexao.iniciaConfifNfe();
                TEnviNFe tenvnfe = criaEnviNfe();
                tenvnfe = Nfe.montaNfe(config, tenvnfe, true);
                String qr=preencheQRCode(tenvnfe, config, token, csc);
                TNFe.InfNFeSupl infNFeSupl= new TNFe.InfNFeSupl();
                infNFeSupl.setQrCode(qr);
                infNFeSupl.setUrlChave(WebServiceUtil.getUrl(config, DocumentoEnum.NFCE, ServicosEnum.URL_CONSULTANFCE));
                tenvnfe.getNFe().get(0).setInfNFeSupl(infNFeSupl);
                
                String xmlfinal = XmlNfeUtil.criaNfeProc(tenvnfe, protocolo.getProtNFe());
                gravarArquivoXml(xmlfinal,chave.replace("NFe", ""));
             
        }
        
        
	private void atualizaDadosNfe(TRetEnviNFe retorno) {
		movimentonf.setDataaut(clsaux.retornaData(clsaux.retornaDataUTC(retorno.getProtNFe().getInfProt().getDhRecbto())));
		movimentonf.setProtocoloaut(retorno.getProtNFe().getInfProt().getNProt());
		movimentonf.setCstat(retorno.getProtNFe().getInfProt().getCStat());
		nfeDAO.inserirMovimentoNfe(movimentonf);
	}

	private void gravarArquivoXmlEnvio(String xmlfinal, String chaveacesso) throws IOException {
		String chavenfe=clsConfig.configuracaogeral.getCaminhoxml()+"nfce\\xmlenvio\\"+chaveacesso+".xml";
		FileWriter arq = new FileWriter(chavenfe);
		PrintWriter gravarArq = new PrintWriter(arq);
                System.out.println(xmlfinal);
		gravarArq.printf(xmlfinal);
		arq.close();
	}
	private void iniciaVariaveisNfe(Long idmovimento) {
		lancDocumentDAO moviDAO= new lancDocumentDAO();
		movimento.setIdmovimento(idmovimento.toString());
		movimentonf=nfeDAO.retornaDadosMovNf(idmovimento);
		movimento=moviDAO.buscaCabecalhoDoc(movimento);
		itens=lancDocumentDAO.buscaItens(idmovimento.toString());
               
                cnpj = clsDadosEmpresa.cnpj;
		modelo = "65";
		serie = Integer.parseInt(movimento.getSerie());
		numero = Integer.parseInt(movimento.getDocument());
		tipoemissao = movimentonf.getTipoemissao();
		dataemissao = LocalDateTime.parse(""+movimento.getEmissao()+"T"+movimento.getHorafinalizado());
                if(clsaux.trataCampoNulo(movimento.getChaveacesso()).length()<40){
                    cnf =String.format("%08d", new Random().nextInt(99999999));
                    
                    ChaveUtil chaveutil = new ChaveUtil(config.getEstado(), cnpj, modelo, serie, numero, tipoemissao, cnf, dataemissao);
                    chave =chaveutil.getChaveNF().replace("NFe", "");
                    nfeDAO.atualizaChaveMovimento(idmovimento, chave);
                    
                }else{
                    cnf =movimento.getChaveacesso().substring(35, 43);
                    chave =movimento.getChaveacesso();
                }
                configuracaoDAO cfdao= new configuracaoDAO();
                clsConfigPdv cfg= cfdao.buscarPdvs("0").get(0);
                token=cfg.getToke();
                csc=cfg.getCsc();
		if(tipoemissao.equals("1")){
                    dataemissao=LocalDateTime.now();
                }
	}

	private void gravarArquivoXml(String xmlfinal, String chaveacesso) throws IOException {
		String chavenfe=clsConfig.configuracaogeral.getCaminhoxml()+"nfce\\xml\\"+chaveacesso+".xml";
		FileWriter arq = new FileWriter(chavenfe);
		PrintWriter gravarArq = new PrintWriter(arq);
		gravarArq.printf(xmlfinal);
		arq.close();
	}
        
       public static void salvaPdf(String xmlfinal) throws JRException, ParserConfigurationException, IOException, SAXException {
		 try {

                        String xml = ImpressaoUtil.leArquivo(clsConfig.configuracaogeral.getCaminhoxml()+"nfce\\xml\\"+xmlfinal+".xml");
	                //Aqui está pegando o Layout Padrão
	                Impressao impressao = ImpressaoUtil.impressaoPadraoNFCe(xml, "http://www.fazenda.pr.gov.br/nfce/consulta");
                       
                        ImpressaoService.impressaoPdfArquivo(impressao, clsConfig.configuracaogeral.getCaminhoxml()+"Nfce\\pdf\\NFce"+xmlfinal+".pdf");

	        } catch (Exception e) {
	            //Trate seus erros aqui
	        	gravarLog.main(e.getMessage()+e.getClass());
	        	JOptionPane.showMessageDialog(null, "Erro ao inserir dados \n" +e.getMessage());
	            e.printStackTrace();
	        }
		
	}
	
	public static void realizaImpresaoNfeAntiga(String chave,String mvtos) throws JRException, ParserConfigurationException, IOException, SAXException {
		 try {
	            //Faça a leitura do Arquivo
	             String xml = ImpressaoUtil.leArquivo(clsConfig.configuracaogeral.getCaminhoxml()+"nfce\\xml\\"+chave+".xml");
                     
                     movimentonf=nfeDAO.retornaDadosMovNf(Long.parseLong(mvtos));
                     Impressao impressao = ImpressaoUtil.impressaoPadraoNFCe(xml,"http://www.fazenda.pr.gov.br/nfce/consulta");
                       //JasperPrint jasperview= ImpressaoService.impressaoPreview(impressao);
                        JasperPrint jasperPrint= geraImpressao(impressao);
	                 
                         
                         
                        JasperViewer jv = new JasperViewer(jasperPrint, true);
                         
                        JDialog viewer = new JDialog(new javax.swing.JFrame(),"Visualização Nfce", true);
                        viewer.setSize(1024,720);
                        viewer.setLocationRelativeTo(null);
                        viewer.getContentPane().add(jv.getContentPane());
                        viewer.setVisible(true);
                 } catch (Exception e) {
	            //Trate seus erros aqui
	        	gravarLog.main(e.getMessage());
	        	JOptionPane.showMessageDialog(null, "Erro ao Imprimir \n" +e.getMessage()+"\n"+e.getStackTrace());
                        e.printStackTrace();
	        }
		
	}
        
        public static JasperPrint geraImpressao(Impressao impressao) throws IOException, SAXException, ParserConfigurationException, JRException {
        DocumentBuilder docBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document document = docBuilder.parse(new InputSource(new StringReader(impressao.getXml())));
        JRDataSource xmlDataSource = new JRXmlDataSource( document, impressao.getPathExpression());
        System.out.println(xmlDataSource.toString());
        return JasperFillManager.fillReport(impressao.getJasper(), impressao.getParametros(), xmlDataSource);
    }
	
	
	private static String preencheQRCode(TEnviNFe enviNFe, ConfiguracoesNfe config, String idToken, String csc) throws NfeException, NoSuchAlgorithmException {

        //QRCODE EMISAO ONLINE
        String qrcod=null;
        if(tipoemissao.equals("1")){
            qrcod= NFCeUtil.getCodeQRCode(
                enviNFe.getNFe().get(0).getInfNFe().getId().substring(3),
                config.getAmbiente().getCodigo(),
                idToken,
                csc,
                WebServiceUtil.getUrl(config,DocumentoEnum.NFCE, ServicosEnum.URL_QRCODE));
       }else if (tipoemissao.equals("9")){
             qrcod= NFCeUtil.getCodeQRCodeContingencia(
                enviNFe.getNFe().get(0).getInfNFe().getId().substring(3),
                config.getAmbiente().getCodigo(),
                enviNFe.getNFe().get(0).getInfNFe().getIde().getDhEmi(),
                enviNFe.getNFe().get(0).getInfNFe().getTotal().getICMSTot().getVNF(),
                Base64.getEncoder().encodeToString(enviNFe.getNFe().get(0).getSignature().getSignedInfo().getReference().getDigestValue()),
                idToken,
                csc,
                WebServiceUtil.getUrl(config, DocumentoEnum.NFCE, ServicosEnum.URL_QRCODE));
       
       
       }
        return qrcod;
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

		infnfe.setId("NFe"+chave);
		infnfe.setVersao(ConstantesUtil.VERSAO.NFE);
		infnfe.setIde(montaIde());

		infnfe.setEmit(montaEmitente());
		          System.out.println(movimentonf.toString());
                if (movimentonf.getIdentificado().equals("S")){
                    infnfe.setDest(montaDestinatario());
                }

		infnfe.getDet().addAll(montaDet());
		infnfe.setTransp(montaTranspotadora());
		infnfe.setPag(montaPagamento());
		// infnfe.setInfAdic(null);
		infnfe.setInfRespTec(montaResponsavel());
		infnfe.setTotal(montaTotal());

		return infnfe;

	}

	private TNFe.InfNFe.Total montaTotal() {
		TNFe.InfNFe.Total total= new TNFe.InfNFe.Total();
		ICMSTot icmsTotal = new ICMSTot();
		icmsTotal.setVBC(clsaux.formatoNfe(clsaux.capturaValores(movimento.getBaseicms())));
		icmsTotal.setVICMS(clsaux.formatoNfe(clsaux.capturaValores(movimento.getValoricms())));
		icmsTotal.setVICMSDeson("0.00");
		icmsTotal.setVFCP("0.00");
		icmsTotal.setVBCST(clsaux.formatoNfe(clsaux.capturaValores(movimento.getBasest())));
		icmsTotal.setVST(clsaux.formatoNfe(clsaux.capturaValores(movimento.getValorst())));
		icmsTotal.setVFCPSTRet("0.00");
		icmsTotal.setVFCPST("0.00");
		icmsTotal.setVProd(clsaux.formatoNfe(clsaux.capturaValores(movimento.getTotalprod())));
		icmsTotal.setVFrete("0.00");
		icmsTotal.setVSeg("0.00");
		icmsTotal.setVDesc(clsaux.formatoNfe(clsaux.capturaValores(movimento.getDesconto())));
		icmsTotal.setVII("0.00");
		icmsTotal.setVIPI("0.00");
		icmsTotal.setVIPIDevol("0.00");
		icmsTotal.setVPIS(clsaux.formatoNfe(clsaux.capturaValores(movimento.getValor_pis())));
		icmsTotal.setVCOFINS(clsaux.formatoNfe(clsaux.capturaValores(movimento.getValor_cofins())));
		icmsTotal.setVOutro(clsaux.formatoNfe(clsaux.capturaValores(movimento.getOutrasdesp())));
		icmsTotal.setVNF(clsaux.formatoNfe(clsaux.capturaValores(movimento.getTotal())));
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

		detPag.setVPag(clsaux.formatoNfe(clsaux.capturaValores(movimento.getTotal())));
		detPag.setTPag("01");
		pag.getDetPag().add(detPag);

		return pag;
	}

	private TNFe.InfNFe.Transp montaTranspotadora() {
		TNFe.InfNFe.Transp transp = new TNFe.InfNFe.Transp();

		transp.setModFrete("9");

		return transp;
	}

	private List<Det> montaDet() {
		int iditem=1;
		List<Det> listaItens=new ArrayList();
		for(indiceitem=0; indiceitem<itens.size(); indiceitem++) {
			TNFe.InfNFe.Det det = new Det();
			
			det.setNItem(String.valueOf(iditem)); // numero de cada item campo retorna da base id_item em ordem sequencial
			det.setProd(montaProduto());
			det.setImposto(montaImposto());
			iditem++;
			listaItens.add(det);
		}
		return listaItens;
	}

	private Imposto montaImposto() {
		TNFe.InfNFe.Det.Imposto imposto = new TNFe.InfNFe.Det.Imposto();

		criaImpostoIcms(imposto);
		criaImpostoPis(imposto);
		criaImpostoCofins(imposto);
		return imposto;
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

	/*private ICMS criaImposto90(ICMS icms) {
		TNFe.InfNFe.Det.Imposto.ICMS.ICMS90 icms90=new TNFe.InfNFe.Det.Imposto.ICMS.ICMS90();
		icms90.setOrig(itens.get(indiceitem).getOrigem_item());
		icms90.setCST("90");
		icms90.setModBC(itens.get(indiceitem).getModalidade_icms());
		icms90.setVBC(clsaux.formatoNfe(itens.get(indiceitem).getBaseicms()));
		icms90.setPICMS(clsaux.formatoNfe(itens.get(indiceitem).getAliqicms()));
		icms90.setVICMS(clsaux.formatoNfe(itens.get(indiceitem).getVlicms()));
		icms90.setModBCST(itens.get(indiceitem).getModalidade_bc_st());
		icms90.setVBCST(clsaux.formatoNfe(itens.get(indiceitem).getBasest()));
		icms90.setPICMSST(clsaux.formatoNfe(itens.get(indiceitem).getAliqst()));
		icms90.setVICMSST(clsaux.formatoNfe(itens.get(indiceitem).getVlst()));
		icms90.setVICMSDeson(clsaux.formatoNfe(itens.get(indiceitem).getVl_icms_desonerado()));
		icms90.setMotDesICMS("9");
		icms.setICMS90(icms90);
		
		return icms;
	}

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
	}*/

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
		produto.setVProd(clsaux.formatoNfe(Double.parseDouble(itens.get(indiceitem).getPrecovenda()) * Double.parseDouble(itens.get(indiceitem).getQuantidade())));
		produto.setCEANTrib("SEM GTIN");
		produto.setUTrib(itens.get(indiceitem).getUnidade());
		produto.setQTrib(itens.get(indiceitem).getQuantidade());
		produto.setVUnTrib(itens.get(indiceitem).getPrecovenda());
		produto.setIndTot("1");
                if(Double.parseDouble(itens.get(indiceitem).getDesconto())>0.00)produto.setVDesc(clsaux.formatoNfe(Double.parseDouble(itens.get(indiceitem).getDesconto())));
                if(clsaux.capturaValores(itens.get(indiceitem).getAcrescimo())>0.00) produto.setVOutro(clsaux.formatoNfe(clsaux.capturaValores(itens.get(indiceitem).getAcrescimo())));
		return produto;
	}

	private Dest montaDestinatario() {
		TNFe.InfNFe.Dest dest = new Dest();
               	dest.setXNome(movimentonf.getRazao_social());
		if(movimentonf.getCfp().trim().length()>11) {
			dest.setCNPJ(movimentonf.getCfp());
			dest.setIndIEDest("9");
			
		}else {
			
			dest.setCPF(movimentonf.getCfp());
			dest.setIndIEDest("9");
		}
		
		if(clsaux.verificaNulo(movimentonf.getRua())==true){
                
                }else{
                        TEndereco endereco = new TEndereco();
                        endereco.setXLgr(movimentonf.getRua());
                        endereco.setXBairro(movimentonf.getBairro());
                        endereco.setNro(movimentonf.getNumero());
                        //endereco.setXCpl(enderecoCliente.getComplemento().trim());
                        endereco.setCMun("4109401");
                        endereco.setXMun(movimentonf.getCidade());
                        endereco.setUF(TUf.valueOf(config.getEstado().name()));
                        endereco.setCEP(movimentonf.getCep().replace("-", ""));
                        dest.setEnderDest(endereco);
                        }
                return dest;
	}

	private Emit montaEmitente() {
		TNFe.InfNFe.Emit emit = new TNFe.InfNFe.Emit();
		emit.setXNome(clsDadosEmpresa.razao);
		emit.setCNPJ(cnpj);
		emit.setIE(clsDadosEmpresa.incricao_estadual);
		emit.setCRT("1");
		TEnderEmi endereco = new TEnderEmi();
		endereco.setXLgr(clsDadosEmpresa.rua);
		endereco.setXBairro(clsDadosEmpresa.bairro);
		endereco.setNro(clsDadosEmpresa.numero);
		endereco.setXCpl("Complemento");
		endereco.setCMun("4109401");
		endereco.setXMun(clsDadosEmpresa.cidade)    ;
		endereco.setUF(TUfEmi.valueOf(config.getEstado().name()));
		endereco.setCEP("85053030");
		emit.setEnderEmit(endereco);
		return emit;
	}

	private Ide montaIde() {
		TNFe.InfNFe.Ide ide = new TNFe.InfNFe.Ide();
		ide.setCUF(config.getEstado().getCodigoUF());
		ide.setCNF(cnf);
		ide.setNatOp("NOTA FISCAL CONSUMIDOR ELETRONICA");
		ide.setMod(modelo);
		ide.setSerie(String.valueOf(serie));
		ide.setNNF(String.valueOf(numero));
		ide.setDhEmi(XmlNfeUtil.dataNfe(dataemissao));
		ide.setTpNF("1");//define se é saida ou entrada
		ide.setIdDest(movimentonf.getInddest());
		ide.setCMunFG("4109401");
		ide.setTpImp("4");
		ide.setTpEmis(tipoemissao);
		ide.setCDV(chave.substring(43, 44));
		ide.setTpAmb(config.getAmbiente().getCodigo());
		ide.setFinNFe("1");
		ide.setIndFinal("1");
		ide.setIndPres("1");
		ide.setProcEmi("0");
		ide.setVerProc("1.0.0");
                if(tipoemissao.equals("9")) {
                    ide.setDhCont(XmlNfeUtil.dataNfe(dataemissao));
                    ide.setXJust("Falha de comunicação com a Sefaz");
                }
		return ide;
	}
}
