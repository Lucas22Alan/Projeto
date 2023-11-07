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
public class Tcad_adicional {
    String id,descricao,estado,cod_base,descricao_base,tipo;
    Double qntusar=0.00,prec_venda=0.00,custo_base=0.00;

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    
    public String getDescricao_base() {
        return descricao_base;
    }

    public void setDescricao_base(String descricao_base) {
        this.descricao_base = descricao_base;
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCod_base() {
        return cod_base;
    }

    public void setCod_base(String cod_base) {
        this.cod_base = cod_base;
    }

   

    public Double getQntusar() {
        return qntusar;
    }

    public void setQntusar(Double qntusar) {
        this.qntusar = qntusar;
    }

    public Double getPrec_venda() {
        return prec_venda;
    }

    public void setPrec_venda(Double prec_venda) {
        this.prec_venda = prec_venda;
    }

    public Double getCusto_base() {
        return custo_base;
    }

    public void setCusto_base(Double custo_base) {
        this.custo_base = custo_base;
    }
    
    
    
}
