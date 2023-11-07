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
public class tlocacao_pagamento {
 
    String idlocacao,idfinalizadora,nomefinalizadora,tipo,referencia,estado,datainf,idfatura="";
    Double valor,troco;

  
    

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

    public String getIdfinalizadora() {
        return idfinalizadora;
    }

    public void setIdfinalizadora(String idfinalizadora) {
        this.idfinalizadora = idfinalizadora;
    }

    public String getNomefinalizadora() {
        return nomefinalizadora;
    }

    public void setNomefinalizadora(String nomefinalizadora) {
        this.nomefinalizadora = nomefinalizadora;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getDatainf() {
        return datainf;
    }

    public void setDatainf(String datainf) {
        this.datainf = datainf;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Double getTroco() {
        return troco;
    }

    public void setTroco(Double troco) {
        this.troco = troco;
    }
    
    
}
