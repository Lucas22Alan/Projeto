/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Lucas
 */
public class tconfig_integracao {
    
    int id;
    String integra;
    String codloja;
    String lancautomatico;
    String feedback;
    String pdvIntegrado;
    String idloja;
    String tempo;

    public String getTempo() {
        return tempo;
    }

    public void setTempo(String tempo) {
        this.tempo = tempo;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIntegra() {
        return integra;
    }

    public void setIntegra(String integra) {
        this.integra = integra;
    }

    public String getCodloja() {
        return codloja;
    }

    public void setCodloja(String codloja) {
        this.codloja = codloja;
    }

    public String getLancautomatico() {
        return lancautomatico;
    }

    public void setLancautomatico(String lancautomatico) {
        this.lancautomatico = lancautomatico;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public String getPdvIntegrado() {
        return pdvIntegrado;
    }

    public void setPdvIntegrado(String pdvIntegrado) {
        this.pdvIntegrado = pdvIntegrado;
    }

    public String getIdloja() {
        return idloja;
    }

    public void setIdloja(String idloja) {
        this.idloja = idloja;
    }
    
    
}
