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
public class clsDadosEstoque {
    String codigo="",idproduto="";
    Double estoque=0.00,custoatual=0.00,customedio=0.00,custocompra=0.00,estoquerua=0.00,estoquedisponivel=0.00;

    public String getIdproduto() {
        return idproduto;
    }

    public void setIdproduto(String idproduto) {
        this.idproduto = idproduto;
    }

    
    
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Double getEstoque() {
        return estoque;
    }

    public void setEstoque(Double estoque) {
        this.estoque = estoque;
    }

    public Double getCustoatual() {
        return custoatual;
    }

    public void setCustoatual(Double custoatual) {
        this.custoatual = custoatual;
    }

    public Double getCustomedio() {
        return customedio;
    }

    public void setCustomedio(Double customedio) {
        this.customedio = customedio;
    }

    public Double getCustocompra() {
        return custocompra;
    }

    public void setCustocompra(Double custocompra) {
        this.custocompra = custocompra;
    }

    public Double getEstoquerua() {
        return estoquerua;
    }

    public void setEstoquerua(Double estoquerua) {
        this.estoquerua = estoquerua;
    }

    public Double getEstoquedisponivel() {
        return estoquedisponivel;
    }

    public void setEstoquedisponivel(Double estoquedisponivel) {
        this.estoquedisponivel = estoquedisponivel;
    }


    
    
}
