/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

/**
 *
 * @author Mk Solucoes
 */
public class ClsRetornoLicenca {
    String estado,diasliberar="";

    @Override
    public String toString() {
        return "ClsRetornoLicenca{" + "estado=" + estado + ", diasliberar=" + diasliberar + '}';
    }

  

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getDiasliberar() {
        return diasliberar;
    }

    public void setDiasliberar(String diasliberar) {
        this.diasliberar = diasliberar;
    }
  
}
