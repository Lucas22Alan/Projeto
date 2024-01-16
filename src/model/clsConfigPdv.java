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
public class clsConfigPdv {
    String pdv,apenasComanda,controlaEstoque,impFichaCons,vendeEstZerado,gerarMesa,
            portaBal,digEtiqueta,impCoz,impBar,impCupom,textoFicha,perguntaImpressao,integracaopix,tipoimpressora=null;
    String csc,toke,serie=null;
    String geraproducao="N",obrigavendedor="N",cancelafina="N",exibeEstoqueBusca="N",rodapecupom="",fechamentoCego="N";
    String tipoLeituraBalanca="0";
    String alertaSonoro="N",temtef="N",quebraLinha="N";
    int qntImprime=1;
    String tokenAnota="",modo;

    public String getModo() {
        return modo;
    }

    public void setModo(String modo) {
        this.modo = modo;
    }

    public String getQuebraLinha() {
        return quebraLinha;
    }

    public void setQuebraLinha(String quebraLinha) {
        this.quebraLinha = quebraLinha;
    }

    public int getQntImprime() {
        return qntImprime;
    }

    public void setQntImprime(int qntImprime) {
        this.qntImprime = qntImprime;
    }

    public String getTokenAnota() {
        return tokenAnota;
    }

    public void setTokenAnota(String tokenAnota) {
        this.tokenAnota = tokenAnota;
    }

    public String getTemtef() {
        return temtef;
    }

    public void setTemtef(String temtef) {
        this.temtef = temtef;
    }

    
    
    public String getAlertaSonoro() {
        return alertaSonoro;
    }

    public void setAlertaSonoro(String alertaSonoro) {
        this.alertaSonoro = alertaSonoro;
    }
    
    

    public String getFechamentoCego() {
        return fechamentoCego;
    }

    public void setFechamentoCego(String fechamentoCego) {
        this.fechamentoCego = fechamentoCego;
    }

    public String getTipoLeituraBalanca() {
        return tipoLeituraBalanca;
    }

    public void setTipoLeituraBalanca(String tipoLeituraBalanca) {
        this.tipoLeituraBalanca = tipoLeituraBalanca;
    }
    
    

    public String getRodapecupom() {
        return rodapecupom;
    }

    public void setRodapecupom(String rodapecupom) {
        this.rodapecupom = rodapecupom;
    }

    
    public String getExibeEstoqueBusca() {
        return exibeEstoqueBusca;
    }

    public void setExibeEstoqueBusca(String exibeEstoqueBusca) {
        this.exibeEstoqueBusca = exibeEstoqueBusca;
    }

    
  

    public String getIntegracaopix() {
        return integracaopix;
    }

    public void setIntegracaopix(String integracaopix) {
        this.integracaopix = integracaopix;
    }

    public String getTipoimpressora() {
        return tipoimpressora;
    }

    public void setTipoimpressora(String tipoimpressora) {
        this.tipoimpressora = tipoimpressora;
    }

    
    
    public String getGeraproducao() {
        return geraproducao;
    }

    public void setGeraproducao(String geraproducao) {
        this.geraproducao = geraproducao;
    }

    public String getObrigavendedor() {
        return obrigavendedor;
    }

    public void setObrigavendedor(String obrigavendedor) {
        this.obrigavendedor = obrigavendedor;
    }

    public String getCancelafina() {
        return cancelafina;
    }

    public void setCancelafina(String cancelafina) {
        this.cancelafina = cancelafina;
    }
    
    

    @Override
    public String toString() {
        return  getPdv();
    }

    public String getTextoFicha() {
        return textoFicha;
    }

    public void setTextoFicha(String textoFicha) {
        this.textoFicha = textoFicha;
    }

    public String getPerguntaImpressao() {
        return perguntaImpressao;
    }

    public void setPerguntaImpressao(String perguntaImpressao) {
        this.perguntaImpressao = perguntaImpressao;
    }
    
    
    
    

    public String getPdv() {
        return pdv;
    }

    public void setPdv(String pdv) {
        this.pdv = pdv;
    }

    public String getApenasComanda() {
        return apenasComanda;
    }

    public void setApenasComanda(String apenasComanda) {
        this.apenasComanda = apenasComanda;
    }

    public String getControlaEstoque() {
        return controlaEstoque;
    }

    public void setControlaEstoque(String controlaEstoque) {
        this.controlaEstoque = controlaEstoque;
    }

    public String getImpFichaCons() {
        return impFichaCons;
    }

    public void setImpFichaCons(String impFichaCons) {
        this.impFichaCons = impFichaCons;
    }

    public String getVendeEstZerado() {
        return vendeEstZerado;
    }

    public void setVendeEstZerado(String vendeEstZerado) {
        this.vendeEstZerado = vendeEstZerado;
    }

    public String getGerarMesa() {
        return gerarMesa;
    }

    public void setGerarMesa(String gerarMesa) {
        this.gerarMesa = gerarMesa;
    }

    public String getPortaBal() {
        return portaBal;
    }

    public void setPortaBal(String portaBal) {
        this.portaBal = portaBal;
    }

    public String getDigEtiqueta() {
        return digEtiqueta;
    }

    public void setDigEtiqueta(String digEtiqueta) {
        this.digEtiqueta = digEtiqueta;
    }

    public String getImpCoz() {
        return impCoz;
    }

    public void setImpCoz(String impCoz) {
        this.impCoz = impCoz;
    }

    public String getImpBar() {
        return impBar;
    }

    public void setImpBar(String impBar) {
        this.impBar = impBar;
    }

    public String getImpCupom() {
        return impCupom;
    }

    public void setImpCupom(String impCupom) {
        this.impCupom = impCupom;
    }

    public String getCsc() {
        return csc;
    }

    public void setCsc(String csc) {
        this.csc = csc;
    }

    public String getToke() {
        return toke;
    }

    public void setToke(String toke) {
        this.toke = toke;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }
    
    
    
    
}
