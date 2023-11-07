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
public class clsSuprimentoSangria {
    String motivo,descricao,idfinalizadora=null;
    Double valor=0.00;
    String data="";

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getIdfinalizadora() {
        return idfinalizadora;
    }

    public void setIdfinalizadora(String idfinalizadora) {
        this.idfinalizadora = idfinalizadora;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
    

  

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }
    
    
    
    
}
