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
 * @author Mk Solucoes
 */
public class clsOrcamento {
    String id,parceiro,parceiro_nome,parceiro_cpf,parceiro_telefone,estado,situacao,vendedor,tipo,obs=null;
    Double subtotal,total,acrescimo,desconto=0.00;
    Date data_lancamento=null;
    Time hr_lancamento=null;

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    
    
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    
    public String getId() {
        return id;
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

    public String getParceiro_nome() {
        return parceiro_nome;
    }

    public void setParceiro_nome(String parceiro_nome) {
        this.parceiro_nome = parceiro_nome;
    }

    public String getParceiro_cpf() {
        return parceiro_cpf;
    }

    public void setParceiro_cpf(String parceiro_cpf) {
        this.parceiro_cpf = parceiro_cpf;
    }

    public String getParceiro_telefone() {
        return parceiro_telefone;
    }

    public void setParceiro_telefone(String parceiro_telefone) {
        this.parceiro_telefone = parceiro_telefone;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public String getVendedor() {
        return vendedor;
    }

    public void setVendedor(String vendedor) {
        this.vendedor = vendedor;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Double getAcrescimo() {
        return acrescimo;
    }

    public void setAcrescimo(Double acrescimo) {
        this.acrescimo = acrescimo;
    }

    public Double getDesconto() {
        return desconto;
    }

    public void setDesconto(Double desconto) {
        this.desconto = desconto;
    }

    public Date getData_lancamento() {
        return data_lancamento;
    }

    public void setData_lancamento(Date data_lancamento) {
        this.data_lancamento = data_lancamento;
    }

    public Time getHr_lancamento() {
        return hr_lancamento;
    }

    public void setHr_lancamento(Time hr_lancamento) {
        this.hr_lancamento = hr_lancamento;
    }
    
    
    
    
}
