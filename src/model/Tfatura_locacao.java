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
public class Tfatura_locacao {
    String idlocacao,datagerado,pago,idfatura;
    Double total;

   @Override
    public String toString() {
        return  idlocacao ;
    }

    
    
    public String getIdfatura() {
        return idfatura;
    }

    public void setIdfatura(String idfatura) {
        this.idfatura = idfatura;
    }

    
    public String getIdlocacao() {
        return idlocacao;
    }

    public void setIdlocacao(String idlocacao) {
        this.idlocacao = idlocacao;
    }

    public String getDatagerado() {
        return datagerado;
    }

    public void setDatagerado(String datagerado) {
        this.datagerado = datagerado;
    }

    public String getPago() {
        return pago;
    }

    public void setPago(String pago) {
        this.pago = pago;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
    
    
    
}
