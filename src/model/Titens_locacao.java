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
public class Titens_locacao {
    
    String idlocacao,iditem,codigoitem,estado,numeroserie,obs,tipo=null;
    Double qntunitaria,qntdias,qnthr,valor,total,pago=0.00,qntpecas=0.00,permanencia=0.00;
    String retirada,devolucao,lancamento,descricao="";

    @Override
    public String toString() {
        return "Titens_locacao{" + "idlocacao=" + idlocacao + ", iditem=" + iditem + ", codigoitem=" + codigoitem + ", estado=" + estado + ", numeroserie=" + numeroserie + ", obs=" + obs + ", tipo=" + tipo + ", qntunitaria=" + qntunitaria + ", qntdias=" + qntdias + ", qnthr=" + qnthr + ", valor=" + valor + ", total=" + total + ", pago=" + pago + ", qntpecas=" + qntpecas + ", permanencia=" + permanencia + ", retirada=" + retirada + ", devolucao=" + devolucao + ", lancamento=" + lancamento + ", descricao=" + descricao + '}';
    }

    
    public Double getPermanencia() {
        return permanencia;
    }

    public void setPermanencia(Double permanencia) {
        this.permanencia = permanencia;
    }

    
    public Double getQntpecas() {
        return qntpecas;
    }

    public void setQntpecas(Double qntpecas) {
        this.qntpecas = qntpecas;
    }
    
    

    public Double getPago() {
        return pago;
    }

    public void setPago(Double pago) {
        this.pago = pago;
    }

    
    
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    
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

    
    
    
    public String getIdlocacao() {
        return idlocacao;
    }

    public void setIdlocacao(String idlocacao) {
        this.idlocacao = idlocacao;
    }

    public String getIditem() {
        return iditem;
    }

    public void setIditem(String iditem) {
        this.iditem = iditem;
    }

    public String getCodigoitem() {
        return codigoitem;
    }

    public void setCodigoitem(String codigoitem) {
        this.codigoitem = codigoitem;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getNumeroserie() {
        return numeroserie;
    }

    public void setNumeroserie(String numeroserie) {
        this.numeroserie = numeroserie;
    }

    public Double getQntunitaria() {
        return qntunitaria;
    }

    public void setQntunitaria(Double qntunitaria) {
        this.qntunitaria = qntunitaria;
    }

    public Double getQntdias() {
        return qntdias;
    }

    public void setQntdias(Double qntdias) {
        this.qntdias = qntdias;
    }

    public Double getQnthr() {
        return qnthr;
    }

    public void setQnthr(Double qnthr) {
        this.qnthr = qnthr;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public String getRetirada() {
        return retirada;
    }

    public void setRetirada(String retirada) {
        this.retirada = retirada;
    }

    public String getDevolucao() {
        return devolucao;
    }

    public void setDevolucao(String devolucao) {
        this.devolucao = devolucao;
    }

    public String getLancamento() {
        return lancamento;
    }

    public void setLancamento(String lancamento) {
        this.lancamento = lancamento;
    }
    
    
    
    
}
