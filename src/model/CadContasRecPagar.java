
package model;

import java.sql.Date;

public class CadContasRecPagar {
    String numero,tipo,parceiro,parcela,tipo_titulo,banco,vendedor,conta,historico,valor,juros,desconto,finan,saldo,idcontrato,idmovto,tipo_pag,estadotitulo,numboleto=null;
    String observacao,razaoparceiro,qntParcelas=null;
    String tipofinanceiro,subtipofinanceiro=null;
    String idtitulo,multa,valorpago,valortotal=null;
    Date emisao,vencimento,pagamento=null;

    public String getQntParcelas() {
        return qntParcelas;
    }

    public void setQntParcelas(String qntParcelas) {
        this.qntParcelas = qntParcelas;
    }

    
    public String getNumboleto() {
        return numboleto;
    }

    public void setNumboleto(String numboleto) {
        this.numboleto = numboleto;
    }

    
    
    
    public String getValortotal() {
        return valortotal;
    }

    public void setValortotal(String valortotal) {
        this.valortotal = valortotal;
    }
    
    

    public String getValorpago() {
        return valorpago;
    }

    public void setValorpago(String valorpago) {
        this.valorpago = valorpago;
    }

    
    public Date getPagamento() {
        return pagamento;
    }

    public void setPagamento(Date pagamento) {
        this.pagamento = pagamento;
    }
    
    
    
    public String getRazaoparceiro() {
        return razaoparceiro;
    }

    public void setRazaoparceiro(String razaoparceiro) {
        this.razaoparceiro = razaoparceiro;
    }

    
    public String getMulta() {
        return multa;
    }

    public void setMulta(String multa) {
        this.multa = multa;
    }
    
    

    public String getIdtitulo() {
        return idtitulo;
    }

    public void setIdtitulo(String idtitulo) {
        this.idtitulo = idtitulo;
    }
    
    

    public String getTipofinanceiro() {
        return tipofinanceiro;
    }

    public void setTipofinanceiro(String tipofinanceiro) {
        this.tipofinanceiro = tipofinanceiro;
    }

    public String getSubtipofinanceiro() {
        return subtipofinanceiro;
    }

    public void setSubtipofinanceiro(String subtipofinanceiro) {
        this.subtipofinanceiro = subtipofinanceiro;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
    public String getEstadotitulo() {
        return estadotitulo;
    }

    public void setEstadotitulo(String estadotitulo) {
        this.estadotitulo = estadotitulo;
    }

    public String getTipo_pag() {
        return tipo_pag;
    }

    public void setTipo_pag(String tipo_pag) {
        this.tipo_pag = tipo_pag;
    }

    public String getIdcontrato() {
        return idcontrato;
    }

    public void setIdcontrato(String idcontrato) {
        this.idcontrato = idcontrato;
    }

    public String getIdmovto() {
        return idmovto;
    }

    public void setIdmovto(String idmovto) {
        this.idmovto = idmovto;
    }
    
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getParceiro() {
        return parceiro;
    }

    public void setParceiro(String parceiro) {
        this.parceiro = parceiro;
    }

    public String getParcela() {
        return parcela;
    }

    public void setParcela(String parcela) {
        this.parcela = parcela;
    }

    public Date getEmisao() {
        return emisao;
    }

    public void setEmisao(Date emisao) {
        this.emisao = emisao;
    }

    public Date getVencimento() {
        return vencimento;
    }

    public void setVencimento(Date vencimento) {
        this.vencimento = vencimento;
    }

    public String getTipo_titulo() {
        return tipo_titulo;
    }

    public void setTipo_titulo(String tipo_titulo) {
        this.tipo_titulo = tipo_titulo;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public String getVendedor() {
        return vendedor;
    }

    public void setVendedor(String vendedor) {
        this.vendedor = vendedor;
    }

    public String getConta() {
        return conta;
    }

    public void setConta(String conta) {
        this.conta = conta;
    }

    public String getHistorico() {
        return historico;
    }

    public void setHistorico(String historico) {
        this.historico = historico;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getJuros() {
        return juros;
    }

    public void setJuros(String juros) {
        this.juros = juros;
    }

    public String getDesconto() {
        return desconto;
    }

    public void setDesconto(String desconto) {
        this.desconto = desconto;
    }

    public String getFinan() {
        return finan;
    }

    public void setFinan(String finan) {
        this.finan = finan;
    }

    public String getSaldo() {
        return saldo;
    }

    public void setSaldo(String saldo) {
        this.saldo = saldo;
    }
    
    
}
