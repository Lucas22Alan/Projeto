/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;
import java.sql.Time;

/**
 *
 * @author Lucas
 */
public class clsLancDocCabecalho {
    String document,serie,baseicms,valoricms,basest,valorst,outrasdesp,desconto,totalprod,total,idmovimento,idparceiro,chaveacesso,modelo,origem,mvtoOrigem=null;
    String tipomovimento,valor_pis,valor_cofins,valoripi,cfop,numpdv=null;
    String vlFrete="0.00",vlfcp="0.00";

    public String getVlfcp() {
        return vlfcp;
    }

    public void setVlfcp(String vlfcp) {
        this.vlfcp = vlfcp;
    }
    
    

    public String getVlFrete() {
        return vlFrete;
    }

    public void setVlFrete(String vlFrete) {
        this.vlFrete = vlFrete;
    }
    Time horafinalizado=null;

    public String getNumpdv() {
        return numpdv;
    }

    public void setNumpdv(String numpdv) {
        this.numpdv = numpdv;
    }

    
    public String getCfop() {
        
        
        
        return cfop;
    }

    public void setCfop(String cfop) {
        this.cfop = cfop;
    }

    
    
    public String getMvtoOrigem() {
        return mvtoOrigem;
    }

    public String getValoripi() {
        return valoripi;
    }

    public void setValoripi(String valoripi) {
        this.valoripi = valoripi;
    }

    
    
    public void setMvtoOrigem(String mvtoOrigem) {
        this.mvtoOrigem = mvtoOrigem;
    }

    
    
    public Time getHorafinalizado() {
        return horafinalizado;
    }

    public void setHorafinalizado(Time horafinalizado) {
        this.horafinalizado = horafinalizado;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }
    
    
    

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    
    public String getValor_pis() {
        return valor_pis;
    }

    public void setValor_pis(String valor_pis) {
        this.valor_pis = valor_pis;
    }

    public String getValor_cofins() {
        return valor_cofins;
    }

    public void setValor_cofins(String valor_cofins) {
        this.valor_cofins = valor_cofins;
    }

    
    
    public String getChaveacesso() {
        return chaveacesso;
    }

    public void setChaveacesso(String chaveacesso) {
        this.chaveacesso = chaveacesso;
    }

    
    
    public String getTipomovimento() {
        return tipomovimento;
    }

    public void setTipomovimento(String tipomovimento) {
        this.tipomovimento = tipomovimento;
    }
    public String getIdparceiro() {
        return idparceiro;
    }

    public void setIdparceiro(String idparceiro) {
        this.idparceiro = idparceiro;
    }
    Date emissao,lancamento=null;
    public String getIdmovimento() {
        return idmovimento;
    }

    public void setIdmovimento(String idmovimento) {
        this.idmovimento = idmovimento;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public Date getEmissao() {
        return emissao;
    }

    public void setEmissao(Date emissao) {
        this.emissao = emissao;
    }

    public Date getLancamento() {
        return lancamento;
    }

    public void setLancamento(Date lancamento) {
        this.lancamento = lancamento;
    }

    public String getBaseicms() {
        return baseicms;
    }

    public void setBaseicms(String baseicms) {
        this.baseicms = baseicms;
    }

    public String getValoricms() {
        return valoricms;
    }

    public void setValoricms(String valoricms) {
        this.valoricms = valoricms;
    }

    public String getBasest() {
        return basest;
    }

    public void setBasest(String basest) {
        this.basest = basest;
    }

    public String getValorst() {
        return valorst;
    }

    public void setValorst(String valorst) {
        this.valorst = valorst;
    }

    public String getOutrasdesp() {
        return outrasdesp;
    }

    public void setOutrasdesp(String outrasdesp) {
        this.outrasdesp = outrasdesp;
    }

    public String getDesconto() {
        return desconto;
    }

    public void setDesconto(String desconto) {
        this.desconto = desconto;
    }

    public String getTotalprod() {
        return totalprod;
    }

    public void setTotalprod(String totalprod) {
        this.totalprod = totalprod;
    }

    public String getTotal() {
        return total;
    }

    @Override
    public String toString() {
        return "clsLancDocCabecalho{" + "document=" + document + ", serie=" + serie + ", baseicms=" + baseicms + ", valoricms=" + valoricms + ", basest=" + basest + ", valorst=" + valorst + ", outrasdesp=" + outrasdesp + ", desconto=" + desconto + ", totalprod=" + totalprod + ", total=" + total + ", idmovimento=" + idmovimento + ", idparceiro=" + idparceiro + ", chaveacesso=" + chaveacesso + ", modelo=" + modelo + ", origem=" + origem + ", mvtoOrigem=" + mvtoOrigem + ", tipomovimento=" + tipomovimento + ", valor_pis=" + valor_pis + ", valor_cofins=" + valor_cofins + ", valoripi=" + valoripi + ", cfop=" + cfop + ", numpdv=" + numpdv + ", horafinalizado=" + horafinalizado + ", emissao=" + emissao + ", lancamento=" + lancamento + '}';
    }

    public void setTotal(String total) {
        this.total = total;
    }
}
