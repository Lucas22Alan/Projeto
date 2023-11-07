/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;

/**
 *
 * @author Mk Solucoes
 */
public class tprecos_atacarejo {
    String codigo=null;
    Double preco=0.00,quantidade=0.00;
    Date dataincluido;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Double quantidade) {
        this.quantidade = quantidade;
    }

    public Date getDataincluido() {
        return dataincluido;
    }

    public void setDataincluido(Date dataincluido) {
        this.dataincluido = dataincluido;
    }
    
    
    
}
