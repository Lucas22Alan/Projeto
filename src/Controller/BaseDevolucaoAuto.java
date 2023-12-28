/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.BaseGeralDAO;
import DAO.clienteDAO;
import DAO.lancDocumentDAO;
import DAO.nfeDAO;
import classes.ClsParametrizaTributos;
import classes.clsaux;
import java.util.ArrayList;
import java.util.List;
import model.clientes;
import model.clsConfig;
import model.clsDadosEmpresa;
import model.clsLancDocCabecalho;
import model.clsLancDocument;
import model.clsNfe;

/**
 *
 * @author Lucas
 */
public class BaseDevolucaoAuto {
    
    public void gerarDevolucaoAutomatica(String idmovimentoOrigem){
        
        // verifica se o tipo de movimento é uma compra, e pega cabecalho e itens
        clsLancDocCabecalho ld = new clsLancDocCabecalho();
        lancDocumentDAO ldDAO= new lancDocumentDAO();
        ld.setIdmovimento(idmovimentoOrigem);
        ldDAO.buscaCabecalhoDoc(ld);
        List<clsLancDocument> itens = ldDAO.buscaItens(idmovimentoOrigem);
        List<clsLancDocument> itensNovo = new ArrayList<>();
        clsNfe nf = new clsNfe();
        clientes cliente=new clientes();
        if(clsaux.retornaId(ld.getTipomovimento()).equals("3")){
        // carrega classes necessarias
            String idmovNovo=new BaseGeralDAO().gerarIds("GEN_TMOVIMENTO_ID");
            String chaveCompra=ld.getChaveacesso();
            cliente=  clienteDAO.buscar("nada", cliente, ld.getIdparceiro());
            ld.setIdmovimento(idmovNovo);
            nf=gerarInfNfe(nf, ld,cliente);
            ld=limparDadosReg(ld);
            for(clsLancDocument ite:itens){
                ite.setIdmovto(idmovNovo);
                ite.setCfop(new ClsParametrizaTributos().parametricaCfopConformeCstNfe(ite.getCst(), "4", "S", nf.getInddest()));
                itensNovo.add(ite);
            }


            ldDAO.atualizaRegistroMovto(ld);

            for(clsLancDocument ite:itensNovo){
                ldDAO.insereItensReferenteMovto(ite);
            }
             nfeDAO.inserirMovimentoNfe(nf);
             nfeDAO.gravaInfReferencia(idmovNovo, chaveCompra);

            // gravar os dados
        }
    }
    
    public clsLancDocCabecalho limparDadosReg(clsLancDocCabecalho lb){
        lb.setChaveacesso("");
        lb.setDocument(nfeDAO.gerarNumeroNfe());
        lb.setSerie(clsConfig.configuracaogeral.getSerienfe());
        lb.setTipomovimento("11");
        lb.setModelo("55");
        lb.setEmissao(clsaux.retornaData(clsaux.preencheData()));
        
        return lb;
    }
    public clsNfe gerarInfNfe(clsNfe nf,clsLancDocCabecalho ld,clientes cliente){
       nf.setId_movimento(ld.getIdmovimento());
       nf.setCstat("0");
       nf.setConsfinal("1");
       nf.setFinalidade("4");
       nf.setIdentificado("N");
       
       nf.setIndie("1");
       nf.setPrescomp("1");
       nf.setObservacaoNf("Devolucao Referente A NF: "+ld.getDocument());
       
       if(cliente.getEstado().equals(clsDadosEmpresa.getEstado())){
          nf.setInddest("1");
          ld.setCfop("5202");
       }else{
           nf.setInddest("2");
           ld.setCfop("6202");
       }
        
        return nf;
    }
    
}
