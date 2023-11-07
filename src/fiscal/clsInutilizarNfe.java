package fiscal;

import DAO.lancDocumentDAO;
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
import br.com.swconsultoria.nfe.dom.enuns.DocumentoEnum;
import br.com.swconsultoria.nfe.exception.NfeException;
import br.com.swconsultoria.nfe.schema_4.inutNFe.TInutNFe;
import br.com.swconsultoria.nfe.util.InutilizacaoUtil;
import br.com.swconsultoria.nfe.util.RetornoUtil;
import model.clsDadosEmpresa;
import model.clsLancDocCabecalho;
import model.clsNfe;
import classes.clsaux;
import conexoes.conexao;
import model.clsConfig;



public class clsInutilizarNfe {
	
	private static ConfiguracoesNfe config;
	

	public clsInutilizarNfe(clsLancDocCabecalho movimento) throws NfeException, CertificadoException, JAXBException, IOException {
		lancDocumentDAO mv= new lancDocumentDAO();
		config=conexao.iniciaConfifNfe();
		clsNfe dadosnf = nfeDAO.retornaDadosMovNf(Long.parseLong(movimento.getIdmovimento()));
		String cnpjEmitente=clsDadosEmpresa.getCnpj().trim();
		int serie= Integer.parseInt(movimento.getSerie());
		int numeroinicio = Integer.parseInt(movimento.getDocument());
                String modelo= movimento.getModelo();
		String justificativa="numeracao não utilizada para emissao";
		LocalDateTime datainu= LocalDateTime.now();
		
		// monta inutilizacao
                 TInutNFe inut=null;
                br.com.swconsultoria.nfe.schema_4.inutNFe.TRetInutNFe retorno=null;
                String basecam="";
                if(modelo.equals("55")){
                    inut=InutilizacaoUtil.montaInutilizacao(DocumentoEnum.NFE, cnpjEmitente, serie, numeroinicio, numeroinicio, justificativa, datainu, config);
                    //envia inutilizacao
                    retorno =Nfe.inutilizacao(config, inut, DocumentoEnum.NFE, true);
                    basecam=clsConfig.configuracaogeral.getCaminhoxml()+"nfe\\inutilizadas\\";

                }else if(modelo.equals("65")){
                 
                    inut=InutilizacaoUtil.montaInutilizacao(DocumentoEnum.NFCE, cnpjEmitente, serie, numeroinicio, numeroinicio, justificativa, datainu, config);
                    //envia inutilizacao
                    retorno =Nfe.inutilizacao(config, inut, DocumentoEnum.NFCE, true);
                    basecam=clsConfig.configuracaogeral.getCaminhoxml()+"nfce\\inutilizadas\\";
                }
		
		
		
		//valida retorno
		
		RetornoUtil.validaInutilizacao(retorno);
		
		//cria proc da inutilizacao
		
		String proc=InutilizacaoUtil.criaProcInutilizacao(config, inut, retorno);
		
		String caminho=basecam+retorno.getInfInut().getNNFIni()+"-"+retorno.getInfInut().getNNFFin()+".xml";
		FileWriter arq = new FileWriter(caminho);
		PrintWriter gravarArq = new PrintWriter(arq);
		gravarArq.printf(proc);
		arq.close();
		
		dadosnf.setCstat("102");
		dadosnf.setDatacanc(clsaux.retornaData(clsaux.retornaDataUTC(retorno.getInfInut().getDhRecbto())));
		dadosnf.setProtocolocanc(retorno.getInfInut().getNProt());
		
		nfeDAO.inserirMovimentoNfe(dadosnf);
		
		
		throw new NfeException(retorno.getInfInut().getXMotivo()); 
		
	}

	
	
	
}

