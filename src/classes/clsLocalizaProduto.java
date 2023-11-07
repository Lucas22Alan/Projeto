/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

/**
 *
 * @author lucas
 */
public class clsLocalizaProduto {
    String codibarra,codibaixa, descricao, unidade,fator,idproduto=null; 
    Double preccusto,precvenda=0.00,oferta=0.00;

    public Double getOferta() {
        return oferta;
    }

    public void setOferta(Double oferta) {
        this.oferta = oferta;
    }
    
    

    public String getIdproduto() {
        return idproduto;
    }

    public void setIdproduto(String idproduto) {
        this.idproduto = idproduto;
    }

    public String getCodibarra() {
        return codibarra;
    }

    public void setCodibarra(String codibarra) {
        this.codibarra = codibarra;
    }

    public String getCodibaixa() {
        return codibaixa;
    }

    public void setCodibaixa(String codibaixa) {
        this.codibaixa = codibaixa;
    }

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

    public Double getPreccusto() {
        return preccusto;
    }

    public void setPreccusto(Double preccusto) {
        this.preccusto = preccusto;
    }

    public Double getPrecvenda() {
        return precvenda;
    }

    public void setPrecvenda(Double precvenda) {
        this.precvenda = precvenda;
    }

   
    public String getFator() {
        return fator;
    }

    public void setFator(String fator) {
        this.fator = fator;
    }
}
