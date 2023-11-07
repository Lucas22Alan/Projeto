/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Mk Solucoes
 */
public class tfechamento_cego {
    
    String nomefinalizadora="",idfinalizadora="",idcaixa;
    Double valor=0.00;
    String datalanc,horalanc="";
    String obs="";

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }
    
    

    public String getNomefinalizadora() {
        return nomefinalizadora;
    }

    public void setNomefinalizadora(String nomefinalizadora) {
        this.nomefinalizadora = nomefinalizadora;
    }

    public String getIdfinalizadora() {
        return idfinalizadora;
    }

    public void setIdfinalizadora(String idfinalizadora) {
        this.idfinalizadora = idfinalizadora;
    }

    public String getIdcaixa() {
        return idcaixa;
    }

    public void setIdcaixa(String idcaixa) {
        this.idcaixa = idcaixa;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getDatalanc() {
        return datalanc;
    }

    public void setDatalanc(String datalanc) {
        this.datalanc = datalanc;
    }

    public String getHoralanc() {
        return horalanc;
    }

    public void setHoralanc(String horalanc) {
        this.horalanc = horalanc;
    }
   
    
}
