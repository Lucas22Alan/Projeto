/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import model.clsLancDocument;
import model.produtos;

/**
 *
 * @author Mk Solucoes
 */
public class ClsParametrizaTributos {
    
    public produtos parmetrizaCstSimplesNacional(produtos prod){
        
        if(prod.getSit_tributaria()!=null){
        switch (prod.getSit_tributaria()){
            case "" : prod.setSit_tributaria("102");
            break;
            case "00" : prod.setSit_tributaria("102");
            break;
            case "10" : prod.setSit_tributaria("500");
            break;
            case "20" : prod.setSit_tributaria("102");
            break;
            case "40" : prod.setSit_tributaria("102");
            break;
            case "41" : prod.setSit_tributaria("102");
            break;
            case "51" : prod.setSit_tributaria("102");
            break;
            case "60" : prod.setSit_tributaria("500");
            break;
            case "70" : prod.setSit_tributaria("500");
            break;
            case "102" : prod.setSit_tributaria("102");
            break;
            case "101" : prod.setSit_tributaria("102");
            break;
            case "103" : prod.setSit_tributaria("102");
            break;
            case "400" : prod.setSit_tributaria("102");
            break;
            case "500" : prod.setSit_tributaria("500");
            break;
            case "900" : prod.setSit_tributaria("102");
            break;
            }
        }else{
            prod.setSit_tributaria("102");
        }
        return prod;
    }
    
    public String parametricaCfopConformeCstNfe(String cst, String finalidade, String direcao,String interno){
        String cfop="5102";
        if(cst.equals("102")||cst.equals("101")||cst.equals("103")||cst.equals("400")||cst.equals("900")){
            if(finalidade.equals("4")&&interno.equals("1")&&direcao.equals("E")){
                cfop="1202";
            }else if(finalidade.equals("4")&&interno.equals("2")&&direcao.equals("E")){
                cfop="2202";
            }else if(finalidade.equals("4")&&interno.equals("2")&&direcao.equals("S")){
                cfop="6202";
            }else if(finalidade.equals("4")&&interno.equals("1")&&direcao.equals("S")){
                cfop="5202";
            }else if(finalidade.equals("1")&&interno.equals("1")&&direcao.equals("S")){
                cfop="5102";
            }else if(finalidade.equals("1")&&interno.equals("1")&&direcao.equals("E")){
                cfop="1102";
            }else if(finalidade.equals("1")&&interno.equals("2")&&direcao.equals("S")){
                cfop="6102";
            }else if(finalidade.equals("1")&&interno.equals("2")&&direcao.equals("E")){
                cfop="2102";
            }
        
        }else if(cst.equals("500")){
        
            if(finalidade.equals("4")&&interno.equals("1")&&direcao.equals("E")){
                cfop="1411";
            }else if(finalidade.equals("4")&&interno.equals("2")&&direcao.equals("E")){
                cfop="2411";
            }else if(finalidade.equals("4")&&interno.equals("2")&&direcao.equals("S")){
                cfop="6411";
            }else if(finalidade.equals("4")&&interno.equals("1")&&direcao.equals("S")){
                cfop="5411";
            }else if(finalidade.equals("1")&&interno.equals("1")&&direcao.equals("S")){
                cfop="5405";
            }else if(finalidade.equals("1")&&interno.equals("1")&&direcao.equals("E")){
                cfop="1405";
            }else if(finalidade.equals("1")&&interno.equals("2")&&direcao.equals("S")){
                cfop="6405";
            }else if(finalidade.equals("1")&&interno.equals("2")&&direcao.equals("E")){
                cfop="2105";
            }
        }
        return cfop;
    }

    public clsLancDocument calculaValoresItem(clsLancDocument item){
        Double qnt,preco,subtotal,tota,baseicms,basest,baseipi,aliq,aliqipi;
        Double vlst,vlicms,vlipi,vlpis,vlcofins;
        
        qnt=clsaux.capturaValores(item.getQuantidade());
        preco=clsaux.capturaValores(item.getPrecovenda());
        subtotal=qnt*preco;
        aliq=clsaux.capturaValores(item.getAliq_icms());
        aliqipi=clsaux.capturaValores(item.getAliq_ipi());
        basest=0.00;
        vlst=0.00;
        if(aliq>0){
            baseicms=subtotal;
            vlicms=baseicms*aliq/100;
        }else{
            baseicms=0.00;
            vlicms=0.00;
        }
        if(aliqipi>0){
            baseipi=subtotal;
            vlipi=baseipi*aliqipi/100;
        }else{
            baseipi=0.00;
            vlipi=0.00;
        }
        vlpis=subtotal*(clsaux.capturaValores(item.getAliq_pis()))/100;
        vlcofins=subtotal*(clsaux.capturaValores(item.getAliq_cofins()))/100;
        
        tota=subtotal+vlst+vlipi;
        
        item.setTotal(tota.toString());
        item.setQntComercial(item.getQuantidade());
        item.setBase_icms(baseicms.toString());
        item.setValor_icms(vlicms.toString());
        item.setBase_st(basest.toString());
        item.setValor_st(vlst.toString());
        item.setBase_pis(subtotal.toString());
        item.setValor_pis(vlpis.toString());
        item.setValor_cofins(vlcofins.toString());
        item.setBase_ipi(baseipi.toString());
        item.setValor_ipi(vlipi.toString());
        return item;
    }
}
