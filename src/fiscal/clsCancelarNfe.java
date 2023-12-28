package fiscal;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import javax.xml.bind.JAXBException;

import DAO.nfeDAO;
import br.com.swconsultoria.certificado.exception.CertificadoException;
import br.com.swconsultoria.nfe.Nfe;
import br.com.swconsultoria.nfe.dom.ConfiguracoesNfe;
import br.com.swconsultoria.nfe.dom.Evento;
import br.com.swconsultoria.nfe.dom.enuns.DocumentoEnum;
import br.com.swconsultoria.nfe.exception.NfeException;
import br.com.swconsultoria.nfe.schema.envEventoCancNFe.TEnvEvento;
import br.com.swconsultoria.nfe.schema.envEventoCancNFe.TRetEnvEvento;
import br.com.swconsultoria.nfe.util.CancelamentoUtil;
import br.com.swconsultoria.nfe.util.RetornoUtil;
import classes.ClsCancelamentos;
import model.clsDadosEmpresa;
import model.clsNfe;
import classes.clsaux;
import conexoes.conexao;
import java.time.ZoneId;
import model.clsConfig;


public class clsCancelarNfe {
	
	private static ConfiguracoesNfe config;
	private static clsNfe dadosnf;
        

	public clsCancelarNfe(Long movimento,String chave,String mod) throws NfeException, CertificadoException, JAXBException, IOException {
		
		
		config= conexao.iniciaConfifNfe();
                ZoneId zoneId = ZoneId.of("GMT-3");
                config.setZoneId(zoneId);
		dadosnf=nfeDAO.retornaDadosMovNf(movimento);
		Evento cancelamento= new Evento();
		
		cancelamento.setChave(chave);
		cancelamento.setProtocolo(dadosnf.getProtocoloaut().trim());
		cancelamento.setCnpj(clsDadosEmpresa.getCnpj());
                
		cancelamento.setDataEvento(LocalDateTime.now());
               
		cancelamento.setMotivo("Erros nos dados da nfe");
		
		TEnvEvento envEvento= CancelamentoUtil.montaCancelamento(cancelamento, config);// monta e evento de cancelamento
		String basecam="";
		TRetEnvEvento retorno=null;
                if(mod.equals("55")){
                    retorno= Nfe.cancelarNfe(config, envEvento, true, DocumentoEnum.NFE);// envia o evento cancelamento para sefaz
                    basecam=clsConfig.configuracaogeral.getCaminhoxml()+"nfe\\cancelamento\\";
                }else{
                     retorno= Nfe.cancelarNfe(config, envEvento, true, DocumentoEnum.NFCE);// envia o evento cancelamento para sefaz
                      basecam=clsConfig.configuracaogeral.getCaminhoxml()+"nfce\\cancelados\\";
                }
                       
		
		RetornoUtil.validaCancelamento(retorno); // valida retorno do cancelamento da sefaz
		
		/*retorno.getRetEvento().forEach(resultado ->{
			System.out.println("# Chave: " + resultado.getInfEvento().getChNFe());
            System.out.println("# Status: " + resultado.getInfEvento().getCStat() + " - " + resultado.getInfEvento().getXMotivo());
            System.out.println("# Protocolo: " + resultado.getInfEvento().getNProt());
		});*/
		
		
		// cria string que vira xml do ProcEvento
		
		String proc= CancelamentoUtil.criaProcEventoCancelamento(config, envEvento, retorno.getRetEvento().get(0));
		
		//salva o arquivo proc em xml no pc
		
		String caminho= basecam+"ProcEvent-"+chave+".xml";
		FileWriter arq = new FileWriter(caminho);
		PrintWriter gravarArq = new PrintWriter(arq);
		gravarArq.printf(proc);
		arq.close();
		
		dadosnf.setCstat("101");
		dadosnf.setDatacanc(clsaux.retornaData(clsaux.retornaDataUTC(retorno.getRetEvento().get(0).getInfEvento().getDhRegEvento())));
		dadosnf.setProtocolocanc(retorno.getRetEvento().get(0).getInfEvento().getNProt());
		
		nfeDAO.inserirMovimentoNfe(dadosnf);
                if(retorno.getRetEvento().get(0).getInfEvento().getCStat().equals("135")){
                    ClsCancelamentos can= new ClsCancelamentos();
                    can.cancelarMovimentacaoReferente(String.valueOf(movimento));
                }
		
		
		throw new NfeException(retorno.getRetEvento().get(0).getInfEvento().getXMotivo()+"--"+retorno.getRetEvento().get(0).getInfEvento().getXEvento()); 
		
		
		
		
	}
	
	
	
	
	

}
