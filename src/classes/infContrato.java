/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

/**
 *
 * @author Lucas
 */
public class infContrato {
    String data_filiacao, data_fim_vigencia, venc_pri_parce, dia_venciento, quantidade_messes,valor,plano,valor_plano=null;

    public String getPlano() {
        return plano;
    }

    public void setPlano(String plano) {
        this.plano = plano;
    }

    public String getValor_plano() {
        return valor_plano;
    }

    public void setValor_plano(String valor_plano) {
        this.valor_plano = valor_plano;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getData_filiacao() {
        return data_filiacao;
    }

    public void setData_filiacao(String data_filiacao) {
        this.data_filiacao = data_filiacao;
    }

    public String getData_fim_vigencia() {
        return data_fim_vigencia;
    }

    public void setData_fim_vigencia(String data_fim_vigencia) {
        this.data_fim_vigencia = data_fim_vigencia;
    }

    public String getVenc_pri_parce() {
        return venc_pri_parce;
    }

    public void setVenc_pri_parce(String venc_pri_parce) {
        this.venc_pri_parce = venc_pri_parce;
    }

    public String getDia_venciento() {
        return dia_venciento;
    }

    public void setDia_venciento(String dia_venciento) {
        this.dia_venciento = dia_venciento;
    }

    public String getQuantidade_messes() {
        return quantidade_messes;
    }

    public void setQuantidade_messes(String quantidade_messes) {
        this.quantidade_messes = quantidade_messes;
    }
    
}
