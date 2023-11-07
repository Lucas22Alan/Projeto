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
public class Tfinalizadoras {
    
    String id,descricao,observacao,pdv,retaguarda,troco,consfluxo="";
    String validaCondicao,condicaoPadrao="";
    Double taxaadm=0.00;

    public String getValidaCondicao() {
        return validaCondicao;
    }

    public void setValidaCondicao(String validaCondicao) {
        this.validaCondicao = validaCondicao;
    }

    public String getCondicaoPadrao() {
        return condicaoPadrao;
    }

    public void setCondicaoPadrao(String condicaoPadrao) {
        this.condicaoPadrao = condicaoPadrao;
    }

    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public String getPdv() {
        return pdv;
    }

    public void setPdv(String pdv) {
        this.pdv = pdv;
    }

    public String getRetaguarda() {
        return retaguarda;
    }

    public void setRetaguarda(String retaguarda) {
        this.retaguarda = retaguarda;
    }

    public String getTroco() {
        return troco;
    }

    public void setTroco(String troco) {
        this.troco = troco;
    }

    public String getConsfluxo() {
        return consfluxo;
    }

    public void setConsfluxo(String consfluxo) {
        this.consfluxo = consfluxo;
    }

    public Double getTaxaadm() {
        return taxaadm;
    }

    public void setTaxaadm(Double taxaadm) {
        this.taxaadm = taxaadm;
    }
    
    
    
}
