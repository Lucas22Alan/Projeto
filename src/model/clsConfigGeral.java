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
public class clsConfigGeral {
        String consTiro,fidelidade,crediCliente,precCategoria,mesaIni,mesaFim,atacarejo,contJuros="N";
        String dtinifdelidade,dtinventario,dtmovcaixa,urllicenca=null;
        String certificado,senha,hamb,serienfe,tipoCertificado,caminhodll,marca,ultimanfe,cadastroProdAutomatico,caminhoxml=null;
        String calculajuros=null,associacaoCompra;
        Double percMulta,percJuros=0.00;
        int carencia=0;
        Date ultima_consulta=null,ultima_verificacao=null;
        String impressaoCondicionalPadrao="";
        String chavePix,clientid,clientsecret="",iptef,codlojatef;
        String usaLocacao="N",ambinetepix="H",zerarSeq="N";
        String tipoImpOs="";

    public String getTipoImpOs() {
        return tipoImpOs;
    }

    public void setTipoImpOs(String tipoImpOs) {
        this.tipoImpOs = tipoImpOs;
    }
        

    public String getAmbinetepix() {
        return ambinetepix;
    }

    public String getZerarSeq() {
        return zerarSeq;
    }

    public void setZerarSeq(String zerarSeq) {
        this.zerarSeq = zerarSeq;
    }

    public void setAmbinetepix(String ambinetepix) {
        this.ambinetepix = ambinetepix;
    }
        
        

    public String getUsaLocacao() {
        return usaLocacao;
    }

    public void setUsaLocacao(String usaLocacao) {
        this.usaLocacao = usaLocacao;
    }

        
    public String getCaminhoxml() {
        return caminhoxml;
    }

    public void setCaminhoxml(String caminhoxml) {
        this.caminhoxml = caminhoxml;
    }

        
        
    public String getIptef() {
        return iptef;
    }

    public void setIptef(String iptef) {
        this.iptef = iptef;
    }

    public String getCodlojatef() {
        return codlojatef;
    }

    public void setCodlojatef(String codlojatef) {
        this.codlojatef = codlojatef;
    }
        
        

        

        
    public Date getUltima_verificacao() {
        return ultima_verificacao;
    }

    public void setUltima_verificacao(Date ultima_verificacao) {
        this.ultima_verificacao = ultima_verificacao;
    }
        
    public String getAssociacaoCompra() {
        return associacaoCompra;
    }

    public void setAssociacaoCompra(String associacaoCompra) {
        this.associacaoCompra = associacaoCompra;
    }

        
    public String getCadastroProdAutomatico() {
        return cadastroProdAutomatico;
    }

    public void setCadastroProdAutomatico(String cadastroProdAutomatico) {
        this.cadastroProdAutomatico = cadastroProdAutomatico;
    }

        
    public String getUltimanfe() {
        return ultimanfe;
    }

    public void setUltimanfe(String ultimanfe) {
        this.ultimanfe = ultimanfe;
    }

  

        
    public String getAtacarejo() {
        return atacarejo;
    }

    public void setAtacarejo(String atacarejo) {
        this.atacarejo = atacarejo;
    }

    public String getContJuros() {
        return contJuros;
    }

    public void setContJuros(String contJuros) {
        this.contJuros = contJuros;
    }

    public String getChavePix() {
        return chavePix;
    }

    public void setChavePix(String chavePix) {
        this.chavePix = chavePix;
    }

    public String getClientid() {
        return clientid;
    }

    public void setClientid(String clientid) {
        this.clientid = clientid;
    }

    public String getClientsecret() {
        return clientsecret;
    }

    public void setClientsecret(String clientsecret) {
        this.clientsecret = clientsecret;
    }
        
        
        

    public String getTipoCertificado() {
        return tipoCertificado;
    }

    public void setTipoCertificado(String tipoCertificado) {
        this.tipoCertificado = tipoCertificado;
    }

    public String getCaminhodll() {
        return caminhodll;
    }

    public void setCaminhodll(String caminhodll) {
        this.caminhodll = caminhodll;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

        
        
    public String getImpressaoCondicionalPadrao() {
        return impressaoCondicionalPadrao;
    }

    public void setImpressaoCondicionalPadrao(String impressaoCondicionalPadrao) {
        this.impressaoCondicionalPadrao = impressaoCondicionalPadrao;
    }
        
        

    public int getCarencia() {
        return carencia;
    }

    public void setCarencia(int carencia) {
        this.carencia = carencia;
    }

        
        
    public String getCalculajuros() {
        return calculajuros;
    }

    public void setCalculajuros(String calculajuros) {
        this.calculajuros = calculajuros;
    }

    public Double getPercMulta() {
        return percMulta;
    }

    public void setPercMulta(Double percMulta) {
        this.percMulta = percMulta;
    }

    public Double getPercJuros() {
        return percJuros;
    }

    public void setPercJuros(Double percJuros) {
        this.percJuros = percJuros;
    }

        
        
        
    public String getUrllicenca() {
        return urllicenca;
    }

    public void setUrllicenca(String urllicenca) {
        this.urllicenca = urllicenca;
    }

  
        
    public Date getUltima_consulta() {
        return ultima_consulta;
    }

    public void setUltima_consulta(Date ultima_consulta) {
        this.ultima_consulta = ultima_consulta;
    }
        
        
    public String getSerienfe() {
        return serienfe;
    }

    public void setSerienfe(String serienfe) {
        this.serienfe = serienfe;
    }
        
        

    public String getHamb() {
        return hamb;
    }

    public void setHamb(String hamb) {
        this.hamb = hamb;
    }

        
    public String getCertificado() {
        return certificado;
    }

    public void setCertificado(String certificado) {
        this.certificado = certificado;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
        
        
        

    public String getConsTiro() {
        return consTiro;
    }

    public void setConsTiro(String consTiro) {
        this.consTiro = consTiro;
    }

    public String getFidelidade() {
        return fidelidade;
    }

    public void setFidelidade(String fidelidade) {
        this.fidelidade = fidelidade;
    }

    public String getCrediCliente() {
        return crediCliente;
    }

    public void setCrediCliente(String crediCliente) {
        this.crediCliente = crediCliente;
    }

    public String getPrecCategoria() {
        return precCategoria;
    }

    public void setPrecCategoria(String precCategoria) {
        this.precCategoria = precCategoria;
    }

    public String getMesaIni() {
        return mesaIni;
    }

    public void setMesaIni(String mesaIni) {
        this.mesaIni = mesaIni;
    }

    public String getMesaFim() {
        return mesaFim;
    }

    public void setMesaFim(String mesaFim) {
        this.mesaFim = mesaFim;
    }

    public String getDtinifdelidade() {
        return dtinifdelidade;
    }

    public void setDtinifdelidade(String dtinifdelidade) {
        this.dtinifdelidade = dtinifdelidade;
    }

    public String getDtinventario() {
        return dtinventario;
    }

    public void setDtinventario(String dtinventario) {
        this.dtinventario = dtinventario;
    }

    public String getDtmovcaixa() {
        return dtmovcaixa;
    }

    public void setDtmovcaixa(String dtmovcaixa) {
        this.dtmovcaixa = dtmovcaixa;
    }
        
        
    
    
}
