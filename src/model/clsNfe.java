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
public class clsNfe {
    String id_movimento,cstat,recibo,protocoloaut,protocolocanc,finalidade,inddest,prescomp,consfinal,indie,tipoemissao=null;
    Date dataaut,datacanc;
    String identificado="N",cfp,razao_social,rua,bairro,numero,cep,cidade,uf,codmun,observacaoNf,motivo;

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    
    
    public String getObservacaoNf() {
        return observacaoNf;
    }

    public void setObservacaoNf(String observacaoNf) {
        this.observacaoNf = observacaoNf;
    }

    
    
    public String getIdentificado() {
        return identificado;
    }

    public void setIdentificado(String identificado) {
        this.identificado = identificado;
    }

    public String getCfp() {
        return cfp;
    }

    public void setCfp(String cfp) {
        this.cfp = cfp;
    }

    public String getRazao_social() {
        return razao_social;
    }

    public void setRazao_social(String razao_social) {
        this.razao_social = razao_social;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getCodmun() {
        return codmun;
    }

    public void setCodmun(String codmun) {
        this.codmun = codmun;
    }

    
    
    public String getTipoemissao() {
        return tipoemissao;
    }

    public void setTipoemissao(String tipoemissao) {
        this.tipoemissao = tipoemissao;
    }

    
    public String getConsfinal() {
        return consfinal;
    }

    public void setConsfinal(String consfinal) {
        this.consfinal = consfinal;
    }

    public String getId_movimento() {
        return id_movimento;
    }

    public void setId_movimento(String id_movimento) {
        this.id_movimento = id_movimento;
    }

    public String getCstat() {
        return cstat;
    }

    public void setCstat(String cstat) {
        this.cstat = cstat;
    }

    public String getRecibo() {
        return recibo;
    }

    public void setRecibo(String recibo) {
        this.recibo = recibo;
    }

    public String getProtocoloaut() {
        return protocoloaut;
    }

    public void setProtocoloaut(String protocoloaut) {
        this.protocoloaut = protocoloaut;
    }

    public String getProtocolocanc() {
        return protocolocanc;
    }

    public void setProtocolocanc(String protocolocanc) {
        this.protocolocanc = protocolocanc;
    }

    public String getFinalidade() {
        return finalidade;
    }

    public void setFinalidade(String finalidade) {
        this.finalidade = finalidade;
    }

    public String getInddest() {
        return inddest;
    }

    public void setInddest(String inddest) {
        this.inddest = inddest;
    }

    public String getPrescomp() {
        return prescomp;
    }

    public void setPrescomp(String prescomp) {
        this.prescomp = prescomp;
    }

    public String getIndie() {
        return indie;
    }

    public void setIndie(String indie) {
        this.indie = indie;
    }

    public Date getDataaut() {
        return dataaut;
    }

    public void setDataaut(Date dataaut) {
        this.dataaut = dataaut;
    }

    public Date getDatacanc() {
        return datacanc;
    }

    public void setDatacanc(Date datacanc) {
        this.datacanc = datacanc;
    }
    
    
    
}
