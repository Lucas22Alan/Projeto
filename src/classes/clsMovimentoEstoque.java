/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

/**
 *
 * @author Mk Solucoes
 */
public class clsMovimentoEstoque {
    String codigo,movto,parceiro,estado,documento,modelo,serie,direcao,descMov=null;
    Double qnd,estoqueant,estoquepos,valortotal;
    String data,hora;

    public String getDescMov() {
        return descMov;
    }

    public void setDescMov(String descMov) {
        this.descMov = descMov;
    }

    
    
    public String getDirecao() {
        return direcao;
    }

    public void setDirecao(String direcao) {
        this.direcao = direcao;
    }
    
    

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getMovto() {
        return movto;
    }

    public void setMovto(String movto) {
        this.movto = movto;
    }

    public String getParceiro() {
        return parceiro;
    }

    public void setParceiro(String parceiro) {
        this.parceiro = parceiro;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
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

    public Double getQnd() {
        return qnd;
    }

    public void setQnd(Double qnd) {
        this.qnd = qnd;
    }

    public Double getEstoqueant() {
        return estoqueant;
    }

    public void setEstoqueant(Double estoqueant) {
        this.estoqueant = estoqueant;
    }

    public Double getEstoquepos() {
        return estoquepos;
    }

    public void setEstoquepos(Double estoquepos) {
        this.estoquepos = estoquepos;
    }

    public Double getValortotal() {
        return valortotal;
    }

    public void setValortotal(Double valortotal) {
        this.valortotal = valortotal;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }
    
    
    
}
