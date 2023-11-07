/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.produtoDAO;
import classes.ClsParametrizaTributos;
import classes.clsaux;
import model.clsLancDocument;
import model.produtos;
import util.validaDigitosBarras;

/**
 *
 * @author Lucas
 */
public class BaseLancamentoDocumento {
    
      public produtos cadastraProdutoAutomaticoXml(clsLancDocument pro){
        produtoDAO dao= new produtoDAO();
        produtos prod = new produtos();
        Double custoreal=0.00;
        custoreal=(clsaux.capturaValores(pro.getSubtotal())+clsaux.capturaValores(pro.getValor_st())+clsaux.capturaValores(pro.getValor_seguro())+clsaux.capturaValores(pro.getValor_outras())
                +clsaux.capturaValores(pro.getValor_ipi())+clsaux.capturaValores(pro.getValor_frete()))/clsaux.capturaValores(pro.getQuantidade());
        String desc="";
        if(pro.getDescricaofornecedor().length()>60)desc=pro.getDescricaofornecedor().substring(0, 59);
        else desc=pro.getDescricaofornecedor();
        prod.setNomelongo(desc);
        prod.setNomecurto(desc);
        prod.setNcm(pro.getNcm());
        prod.setPreco_custo(clsaux.formatoNfe(custoreal));
        prod.setCusto_atual(clsaux.formatoNfe(custoreal));
        prod.setCusto_medio(clsaux.formatoNfe(custoreal));
        prod.setMargem("100");
        prod.setPreco_venda("0.00");
        prod.setFator("1");
        prod.setReferencia("");
        prod.setEstminimo("0");
        prod.setUnid_venda("Un");
        prod.setSittributaria(pro.getCst());
        prod.setAliq_icms("0");
        prod.setPis_ent(pro.getPis_cofins());
        prod.setPis_sai(pro.getPis_cofins());
        prod.setPtsvale("0");
        prod.setPtsretira("0");
        prod.setTipo("0");
        prod.setPreco_oferta(0.00);
        prod.setComeco(null);
        prod.setFim(null);
        prod.setDatavalidade(null);
        prod.setPesagem_aut("Nao");
        prod.setImp_ficha("N");
        prod.setAtivo("S");
        prod.setBaixa_producao("N");
        prod.setImprimeEtiqueta("N");
        prod.setTemAtacarejo("N");
        prod.setTemLocacao("N");
        prod.setPesavel("Nao");
        prod.setBalanca("0");
        prod.setGrupo("0");
        prod.setSubgrupo("0");
        prod.setSetor("0");
        prod.setCest("0");
        if(pro.getBarras().equals("Sem Gtin")||pro.getBarras().equals("SEM GTIN")||pro.getBarras().equals("00000000000000")){
            // deve gerar um codigo de barras para o item
            String cod=validaDigitosBarras.preencheCodigo(produtoDAO.PegaIdCodBarra());
            prod.setCodigo(cod);
            prod.setBaixa(cod);
        }else{
            prod.setCodigo(pro.getBarras());
            prod.setBaixa(pro.getBarras());   
        }
        ClsParametrizaTributos parametriza=new ClsParametrizaTributos();
        prod=parametriza.parmetrizaCstSimplesNacional(prod);
         dao.Inserir(prod);
        return prod;
    }
    
}
