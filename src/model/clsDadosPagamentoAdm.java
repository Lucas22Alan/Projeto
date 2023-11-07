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
public class clsDadosPagamentoAdm {
    String idos,idcondicional,idpedido,tipo,parceiro,idfinalizadora,mvto,origem,direcao,idtipo=null;
    Double vlprod,vltotal,desconto,vlservico,subtotal=0.00;
    String dataVencimento=null;

    public String getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(String dataVencimento) {
        this.dataVencimento = dataVencimento;
    }
        
    public String getIdtipo() {
        return idtipo;
    }

    public void setIdtipo(String idtipo) {
        this.idtipo = idtipo;
    }

    
    public String getDirecao() {
        return direcao;
    }

    public void setDirecao(String direcao) {
        this.direcao = direcao;
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

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }
    

    
    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }

    
    public String getParceiro() {
        return parceiro;
    }

    public void setParceiro(String parceiro) {
        this.parceiro = parceiro;
    }

    
    public String getIdos() {
        return idos;
    }

    public void setIdos(String idos) {
        this.idos = idos;
    }

    public String getIdcondicional() {
        return idcondicional;
    }

    public void setIdcondicional(String idcondicional) {
        this.idcondicional = idcondicional;
    }

    public String getIdpedido() {
        return idpedido;
    }

    public void setIdpedido(String idpedido) {
        this.idpedido = idpedido;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Double getVlprod() {
        return vlprod;
    }

    public void setVlprod(Double vlprod) {
        this.vlprod = vlprod;
    }

    public Double getVltotal() {
        return vltotal;
    }

    public void setVltotal(Double vltotal) {
        this.vltotal = vltotal;
    }

    public Double getDesconto() {
        return desconto;
    }

    public void setDesconto(Double desconto) {
        this.desconto = desconto;
    }

    public Double getVlservico() {
        return vlservico;
    }

    public void setVlservico(Double vlservico) {
        this.vlservico = vlservico;
    }
    
    
    
    
    
    
}
