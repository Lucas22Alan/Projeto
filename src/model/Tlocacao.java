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
public class Tlocacao {
    String id,parceiro,obs,local,bairro,cidade,responsavel,fone,estado,dias=null;
    String dataPreRetirada,dataPreDev,dataReti,dataDev=null;
    Double total,subtotal,acres,desc,faturado=0.00;

    public Double getFaturado() {
        return faturado;
    }

    public void setFaturado(Double faturado) {
        this.faturado = faturado;
    }

    
    
    public String getDias() {
        return dias;
    }

    public void setDias(String dias) {
        this.dias = dias;
    }

    
    
    public String getId() {
        return id;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    

    public void setId(String id) {
        this.id = id;
    }

    public String getParceiro() {
        return parceiro;
    }

    public void setParceiro(String parceiro) {
        this.parceiro = parceiro;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    public String getFone() {
        return fone;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }

    public String getDataPreRetirada() {
        return dataPreRetirada;
    }

    public void setDataPreRetirada(String dataPreRetirada) {
        this.dataPreRetirada = dataPreRetirada;
    }

    public String getDataPreDev() {
        return dataPreDev;
    }

    public void setDataPreDev(String dataPreDev) {
        this.dataPreDev = dataPreDev;
    }

    public String getDataReti() {
        return dataReti;
    }

    public void setDataReti(String dataReti) {
        this.dataReti = dataReti;
    }

    public String getDataDev() {
        return dataDev;
    }

    public void setDataDev(String dataDev) {
        this.dataDev = dataDev;
    }

   

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }

    public Double getAcres() {
        return acres;
    }

    public void setAcres(Double acres) {
        this.acres = acres;
    }

    public Double getDesc() {
        return desc;
    }

    public void setDesc(Double desc) {
        this.desc = desc;
    }
    
    
}
