/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author lucas
 */
public class Cst {
    String cst, descricao, regime="";
    
    public String GetCst(){
        return cst;
    }
    public void SetCst(String cst){
        this.cst= cst;
    }
    public String GetDescricao(){
        return descricao;
    }
    public void SetDescricao(String descricao){
        this.descricao=descricao;
    }
    public String GetRegime(){
            return regime;
    }
    public void SetRegime(String regime){
        this.regime=regime;
    }
}
