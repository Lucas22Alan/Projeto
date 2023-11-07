/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import classes.clsaux;
import java.util.List;

/**
 *
 * @author Mk Solucoes
 */
public class clsPagamentos {
    String mvto,valor,parcela,dataemissao,datavencimento,idfinalizadora,condicao,idLancamento,descricao,troco=null;

    @Override
    public String toString() {
        return "clsPagamentos{" + "mvto=" + mvto + ", valor=" + valor + ", parcela=" + parcela + ", dataemissao=" + dataemissao + ", datavencimento=" + datavencimento + ", idfinalizadora=" + idfinalizadora + ", condicao=" + condicao + '}';
    }

    public String getTroco() {
        return troco;
    }

    public void setTroco(String troco) {
        this.troco = troco;
    }

    
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    
    public String getIdLancamento() {
        return idLancamento;
    }

    public void setIdLancamento(String idLancamento) {
        this.idLancamento = idLancamento;
    }
    
    
    
    

    public String getCondicao() {
        return condicao;
    }

    public void setCondicao(String condicao) {
        this.condicao = condicao;
    }

    
    
    public String getIdfinalizadora() {
        return idfinalizadora;
    }

    public void setIdfinalizadora(String idfinalizadora) {
        this.idfinalizadora = idfinalizadora;
    }

    
    
    public String getMvto() {
        return mvto;
    }

    public void setMvto(String mvto) {
        this.mvto = mvto;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getParcela() {
        return parcela;
    }

    public void setParcela(String parcela) {
        this.parcela = parcela;
    }

    public String getDataemissao() {
        return dataemissao;
    }

    public void setDataemissao(String dataemissao) {
        this.dataemissao = dataemissao;
    }

    public String getDatavencimento() {
        return datavencimento;
    }

    public void setDatavencimento(String datavencimento) {
        this.datavencimento = datavencimento;
    }
    
    public static String getNomeFormasPgto(List<clsPagamentos> lista){
        String ret="";
        for(clsPagamentos atual:lista){
            ret=clsaux.retornaAposId(atual.getIdfinalizadora());
        }
    return ret;
   }
    
    
    
}
