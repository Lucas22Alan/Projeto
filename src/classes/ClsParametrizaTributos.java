/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import model.produtos;

/**
 *
 * @author Mk Solucoes
 */
public class ClsParametrizaTributos {
    
    public produtos parmetrizaCstSimplesNacional(produtos prod){
        
        switch (prod.getSittributaria()){
            case "" : prod.setSittributaria("102");
            break;
            case "00" : prod.setSittributaria("102");
            break;
            case "10" : prod.setSittributaria("500");
            break;
            case "20" : prod.setSittributaria("102");
            break;
            case "40" : prod.setSittributaria("102");
            break;
            case "41" : prod.setSittributaria("102");
            break;
            case "51" : prod.setSittributaria("102");
            break;
            case "60" : prod.setSittributaria("500");
            break;
            case "70" : prod.setSittributaria("102");
            break;
            case "102" : prod.setSittributaria("102");
            break;
            case "101" : prod.setSittributaria("102");
            break;
            case "103" : prod.setSittributaria("102");
            break;
            case "400" : prod.setSittributaria("102");
            break;
            case "500" : prod.setSittributaria("500");
            break;
            case "900" : prod.setSittributaria("102");
            break;
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
}
