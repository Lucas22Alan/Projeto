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
public class ClsValoresDashboard {
    Double faturamentoTotal;
    Double faturamentoSistema;
    Double faturamentoMeuMenu;
    Double faturamentoBalcao;
    Double faturamentoEntrega;

    @Override
    public String toString() {
        return "ClsValoresDashboard{" + "faturamentoTotal=" + faturamentoTotal + ", faturamentoSistema=" + faturamentoSistema + ", faturamentoMeuMenu=" + faturamentoMeuMenu + ", faturamentoBalcao=" + faturamentoBalcao + ", faturamentoEntrega=" + faturamentoEntrega + '}';
    }

    public Double getFaturamentoTotal() {
        return faturamentoTotal;
    }

    public void setFaturamentoTotal(Double faturamentoTotal) {
        this.faturamentoTotal = faturamentoTotal;
    }

    public Double getFaturamentoSistema() {
        return faturamentoSistema;
    }

    public void setFaturamentoSistema(Double faturamentoSistema) {
        this.faturamentoSistema = faturamentoSistema;
    }

    public Double getFaturamentoMeuMenu() {
        return faturamentoMeuMenu;
    }

    public void setFaturamentoMeuMenu(Double faturamentoMeuMenu) {
        this.faturamentoMeuMenu = faturamentoMeuMenu;
    }

    public Double getFaturamentoBalcao() {
        return faturamentoBalcao;
    }

    public void setFaturamentoBalcao(Double faturamentoBalcao) {
        this.faturamentoBalcao = faturamentoBalcao;
    }

    public Double getFaturamentoEntrega() {
        return faturamentoEntrega;
    }

    public void setFaturamentoEntrega(Double faturamentoEntrega) {
        this.faturamentoEntrega = faturamentoEntrega;
    }
    
    
}
