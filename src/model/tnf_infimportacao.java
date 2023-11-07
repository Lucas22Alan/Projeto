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
public class tnf_infimportacao {
    
    String idmvto,idorigem,tipo=null;
    Double percentual=0.00;

    public String getIdmvto() {
        return idmvto;
    }

    public void setIdmvto(String idmvto) {
        this.idmvto = idmvto;
    }

    public String getIdorigem() {
        return idorigem;
    }

    public void setIdorigem(String idorigem) {
        this.idorigem = idorigem;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Double getPercentual() {
        return percentual;
    }

    public void setPercentual(Double percentual) {
        this.percentual = percentual;
    }
    
    
    
}
