
package model;

import java.util.Date;



/**
 *
 * @author Lucas
 */
public class CadDocMovConta {
    String idconta,idparceiro="0",n_doc,tipo_mov,subtipo_mov,entrada,saida,data_venc,idfinalizadora,desc_mov,observacao,
            idmov,data_alterado_hr_alterado,parcela, iddocumento=null;

    public String getIddocumento() {
        return iddocumento;
    }

    public void setIddocumento(String iddocumento) {
        this.iddocumento = iddocumento;
    }

    public String getParcela() {
        return parcela;
    }

    public void setParcela(String parcela) {
        this.parcela = parcela;
    }

    public String getIdmov() {
        return idmov;
    }

    public void setIdmov(String idmov) {
        this.idmov = idmov;
    }

    public String getData_alterado_hr_alterado() {
        return data_alterado_hr_alterado;
    }

    public void setData_alterado_hr_alterado(String data_alterado_hr_alterado) {
        this.data_alterado_hr_alterado = data_alterado_hr_alterado;
    }
    Date data_lancamento=null;
    public String getDesc_mov() {
        return desc_mov;
    }

    public void setDesc_mov(String desc_mov) {
        this.desc_mov = desc_mov;
    }
 
  
    public String getIdconta() {
        return idconta;
    }

    public String getIdfinalizadora() {
        return idfinalizadora;
    }

    public void setIdfinalizadora(String idfinalizadora) {
        this.idfinalizadora = idfinalizadora;
    }

    public void setIdconta(String idconta) {
        this.idconta = idconta;
    }

    public String getIdparceiro() {
        return idparceiro;
    }

    public void setIdparceiro(String idparceiro) {
        this.idparceiro = idparceiro;
    }

    public String getN_doc() {
        return n_doc;
    }

    public void setN_doc(String n_doc) {
        this.n_doc = n_doc;
    }

    public Date getData_lancamento() {
        return data_lancamento;
    }

    public void setData_lancamento(Date data_lancamento) {
        this.data_lancamento = data_lancamento;
    }

    public String getTipo_mov() {
        return tipo_mov;
    }

    public void setTipo_mov(String tipo_mov) {
        this.tipo_mov = tipo_mov;
    }

    public String getSubtipo_mov() {
        return subtipo_mov;
    }

    public void setSubtipo_mov(String subtipo_mov) {
        this.subtipo_mov = subtipo_mov;
    }

    public String getEntrada() {
        return entrada;
    }

    public void setEntrada(String entrada) {
        this.entrada = entrada;
    }

    public String getSaida() {
        return saida;
    }

    public void setSaida(String saida) {
        this.saida = saida;
    }

    public String getData_venc() {
        return data_venc;
    }

    public void setData_venc(String data_venc) {
        this.data_venc = data_venc;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
    
}
