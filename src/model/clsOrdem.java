/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;

/**
 *
 * @author lucas
 */
public class clsOrdem {
    String idparc,idmovto,marca,modelo,serie,obs,problema,tipo,situacao,placa=null;
    String dataent,datasai=null;
    String vlprod, vlservico, desc, total,obsgeral=null;

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    
    public String getObsgeral() {
        return obsgeral;
    }

    public void setObsgeral(String obsgeral) {
        this.obsgeral = obsgeral;
    }

    public String getVlprod() {
        return vlprod;
    }

    public void setVlprod(String vlprod) {
        this.vlprod = vlprod;
    }

    public String getVlservico() {
        return vlservico;
    }

    public void setVlservico(String vlservico) {
        this.vlservico = vlservico;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }
public String getIdparc() {
        return idparc;
    }

    public void setIdparc(String idparc) {
        this.idparc = idparc;
    }

    public String getIdmovto() {
        return idmovto;
    }

    public void setIdmovto(String idmovto) {
        this.idmovto = idmovto;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public String getProblema() {
        return problema;
    }

    public void setProblema(String problema) {
        this.problema = problema;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public String getDataent() {
        return dataent;
    }

    public void setDataent(String dataent) {
        this.dataent = dataent;
    }

    public String getDatasai() {
        return datasai;
    }

    public void setDatasai(String datasai) {
        this.datasai = datasai;
    }

   
    
    
}
