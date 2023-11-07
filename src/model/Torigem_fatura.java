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
public class Torigem_fatura {
    String datainicio,datafim,idfatura,tipo;
    Double periodo,valor,total;
    Titens_locacao item;

    public String getDatainicio() {
        return datainicio;
    }

    public void setDatainicio(String datainicio) {
        this.datainicio = datainicio;
    }

    public String getDatafim() {
        return datafim;
    }

    public void setDatafim(String datafim) {
        this.datafim = datafim;
    }

    public String getIdfatura() {
        return idfatura;
    }

    public void setIdfatura(String idfatura) {
        this.idfatura = idfatura;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Double getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Double periodo) {
        this.periodo = periodo;
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

    public Titens_locacao getItem() {
        return item;
    }

    public void setItem(Titens_locacao item) {
        this.item = item;
    }
    
    
    
    
}
