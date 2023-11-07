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
public class clsItemComposicao {
    
    String codigoItemAcabado,codigoMateriaPrima,descricao=null;
    Double quantidade,perca,custo=0.00;

    @Override
    public String toString() {
        return "clsItemComposicao{" + "codigoItemAcabado=" + codigoItemAcabado + ", codigoMateriaPrima=" + codigoMateriaPrima + ", descricao=" + descricao + ", quantidade=" + quantidade + ", perca=" + perca + ", custo=" + custo + '}';
    }

    
    public String getCodigoItemAcabado() {
        return codigoItemAcabado;
    }

    public void setCodigoItemAcabado(String codigoItemAcabado) {
        this.codigoItemAcabado = codigoItemAcabado;
    }

    public String getCodigoMateriaPrima() {
        return codigoMateriaPrima;
    }

    public void setCodigoMateriaPrima(String codigoMateriaPrima) {
        this.codigoMateriaPrima = codigoMateriaPrima;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Double quantidade) {
        this.quantidade = quantidade;
    }

    public Double getPerca() {
        return perca;
    }

    public void setPerca(Double perca) {
        this.perca = perca;
    }

    public Double getCusto() {
        return custo;
    }

    public void setCusto(Double custo) {
        this.custo = custo;
    }
    
    
    
    
}
