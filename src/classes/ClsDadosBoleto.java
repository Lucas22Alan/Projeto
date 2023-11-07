/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.util.Calendar;

/**
 *
 * @author Mk Solucoes
 */
public class ClsDadosBoleto {
    String idtitulo,agencia,digagencia,codigo,digcodigo,convenio,carteira,numeroboleto,locais,instucoes,banco="";
    String pagRua,pagBairro,pagCep,pagCidade,pagUf,pagNome,pagDoc="";
    Double valor;
    Calendar datDocumento,datProcessamento,datVencimento;

    @Override
    public String toString() {
        return "ClsDadosBoleto{" + "idtitulo=" + idtitulo + ", agencia=" + agencia + ", digagencia=" + digagencia + ", codigo=" + codigo + ", digcodigo=" + digcodigo + ", convenio=" + convenio + ", carteira=" + carteira + ", numeroboleto=" + numeroboleto + ", locais=" + locais + ", instucoes=" + instucoes + ", banco=" + banco + ", pagRua=" + pagRua + ", pagBairro=" + pagBairro + ", pagCep=" + pagCep + ", pagCidade=" + pagCidade + ", pagUf=" + pagUf + ", pagNome=" + pagNome + ", pagDoc=" + pagDoc + ", valor=" + valor + ", datDocumento=" + datDocumento + ", datProcessamento=" + datProcessamento + ", datVencimento=" + datVencimento + '}';
    }

    
    
    public Double getValor() {
        return valor;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }
    
    

    public void setValor(Double valor) {
        this.valor = valor;
    }

    
    
    public String getLocais() {
        return locais;
    }

    public void setLocais(String locais) {
        this.locais = locais;
    }

    public String getInstucoes() {
        return instucoes;
    }

    public void setInstucoes(String instucoes) {
        this.instucoes = instucoes;
    }

    
    
    public String getIdtitulo() {
        return idtitulo;
    }

    public void setIdtitulo(String idtitulo) {
        this.idtitulo = idtitulo;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getDigagencia() {
        return digagencia;
    }

    public void setDigagencia(String digagencia) {
        this.digagencia = digagencia;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDigcodigo() {
        return digcodigo;
    }

    public void setDigcodigo(String digcodigo) {
        this.digcodigo = digcodigo;
    }

    public String getConvenio() {
        return convenio;
    }

    public void setConvenio(String convenio) {
        this.convenio = convenio;
    }

    public String getCarteira() {
        return carteira;
    }

    public void setCarteira(String carteira) {
        this.carteira = carteira;
    }

    public String getNumeroboleto() {
        return numeroboleto;
    }

    public void setNumeroboleto(String numeroboleto) {
        this.numeroboleto = numeroboleto;
    }

    public String getPagRua() {
        return pagRua;
    }

    public void setPagRua(String pagRua) {
        this.pagRua = pagRua;
    }

    public String getPagBairro() {
        return pagBairro;
    }

    public void setPagBairro(String pagBairro) {
        this.pagBairro = pagBairro;
    }

    public String getPagCep() {
        return pagCep;
    }

    public void setPagCep(String pagCep) {
        this.pagCep = pagCep;
    }

    public String getPagCidade() {
        return pagCidade;
    }

    public void setPagCidade(String pagCidade) {
        this.pagCidade = pagCidade;
    }

    public String getPagUf() {
        return pagUf;
    }

    public void setPagUf(String pagUf) {
        this.pagUf = pagUf;
    }

    public String getPagNome() {
        return pagNome;
    }

    public void setPagNome(String pagNome) {
        this.pagNome = pagNome;
    }

    public String getPagDoc() {
        return pagDoc;
    }

    public void setPagDoc(String pagDoc) {
        this.pagDoc = pagDoc;
    }

    public Calendar getDatDocumento() {
        return datDocumento;
    }

    public void setDatDocumento(Calendar datDocumento) {
        this.datDocumento = datDocumento;
    }

    public Calendar getDatProcessamento() {
        return datProcessamento;
    }

    public void setDatProcessamento(Calendar datProcessamento) {
        this.datProcessamento = datProcessamento;
    }

    public Calendar getDatVencimento() {
        return datVencimento;
    }

    public void setDatVencimento(Calendar datVencimento) {
        this.datVencimento = datVencimento;
    }
    
    
    
    
}
