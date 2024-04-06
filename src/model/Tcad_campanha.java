/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import classes.clsaux;

/**
 *
 * @author Lucas
 */
public class Tcad_campanha {
    
    private String nome,situacao,tipo;
    private Integer idcampanha;
    private Double seg,ter,qua,qui,sex,sab,dom;

    @Override
    public String toString() {
        return idcampanha + "- "+nome;
    }

    
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Integer getIdcampanha() {
        return idcampanha;
    }

    public void setIdcampanha(Integer idcampanha) {
        this.idcampanha = idcampanha;
    }

    public Double getSeg() {
        return seg;
    }

    public void setSeg(Double seg) {
        this.seg = seg;
    }

    public Double getTer() {
        return ter;
    }

    public void setTer(Double ter) {
        this.ter = ter;
    }

    public Double getQua() {
        return qua;
    }

    public void setQua(Double qua) {
        this.qua = qua;
    }

    public Double getQui() {
        return qui;
    }

    public void setQui(Double qui) {
        this.qui = qui;
    }

    public Double getSex() {
        return sex;
    }

    public void setSex(Double sex) {
        this.sex = sex;
    }

    public Double getSab() {
        return sab;
    }

    public void setSab(Double sab) {
        this.sab = sab;
    }

    public Double getDom() {
        return dom;
    }

    public void setDom(Double dom) {
        this.dom = dom;
    }
    
    
    public Double getPrecoDia(){
       String dia=clsaux.retornaDiaDaSemana();
        Double vl=0.00;
       switch(dia){
           case "Terça-feira": vl=ter;
           break;
           case "Segunda-feira": vl=seg;
           break;
           case "Quarta-feira": vl=qua;
           break;
           case "Quinta-feira": vl=qui;
           break;
           case "Sexta-feira": vl=sex;
           break;
           case "Sábado": vl=sab;
           break;
           case "Domingo":vl=dom;
           break;
       }
       return vl;
    }
    
}
