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
public class clsOrcamentoItem {
    
    String idorcamento,codibarra,estado,vendedor,obs,iditem,unidade,descricao=null;
    Double qnt,unitario,total,desc,acres,subtotal=0.00;
    String datalanc,datacanc=null;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    
    public String getIditem() {
        return iditem;
    }

    public void setIditem(String iditem) {
        this.iditem = iditem;
    }
    

    public String getIdorcamento() {
        return idorcamento;
    }

    public void setIdorcamento(String idorcamento) {
        this.idorcamento = idorcamento;
    }

    public String getCodibarra() {
        return codibarra;
    }

    public void setCodibarra(String codibarra) {
        this.codibarra = codibarra;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getVendedor() {
        return vendedor;
    }

    public void setVendedor(String vendedor) {
        this.vendedor = vendedor;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public Double getQnt() {
        return qnt;
    }

    public void setQnt(Double qnt) {
        this.qnt = qnt;
    }

    public Double getUnitario() {
        return unitario;
    }

    public void setUnitario(Double unitario) {
        this.unitario = unitario;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Double getDesc() {
        return desc;
    }

    public void setDesc(Double desc) {
        this.desc = desc;
    }

    public Double getAcres() {
        return acres;
    }

    public void setAcres(Double acres) {
        this.acres = acres;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }

    public String getDatalanc() {
        return datalanc;
    }

    public void setDatalanc(String datalanc) {
        this.datalanc = datalanc;
    }

    public String getDatacanc() {
        return datacanc;
    }

    public void setDatacanc(String datacanc) {
        this.datacanc = datacanc;
    }

    
    
    
}
