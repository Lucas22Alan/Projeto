/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import DAO.CondicaoDAO;
import grafic.interfac.CRUDCondicoes;
import java.util.List;

/**
 *
 * @author Mk Solucoes
 */
public class Tcondicoes_venda {
    
    String id, descricao,parcelas,dados,finalizadora,parceiro=null;
    Double taxa=0.00;
    String gera_receber="N";

    
    
    public Tcondicoes_venda getCondicaoPorId(String id,Tcondicoes_venda ven){
        CondicaoDAO dao= new CondicaoDAO();
        for(Tcondicoes_venda no:dao.buscaDados()){
            if(no.getId().equals(id)){
                ven=no;
            }
        }
        return ven;
    }
    public String getGera_receber() {
        return gera_receber;
    }

    public void setGera_receber(String gera_receber) {
        this.gera_receber = gera_receber;
    }
    
    

    public String getParceiro() {
        return parceiro;
    }

    public void setParceiro(String parceiro) {
        this.parceiro = parceiro;
    }

    
    
    public String getFinalizadora() {
        return finalizadora;
    }

    public void setFinalizadora(String finalizadora) {
        this.finalizadora = finalizadora;
    }

    public Double getTaxa() {
        return taxa;
    }

    public void setTaxa(Double taxa) {
        this.taxa = taxa;
    }
    

    
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getParcelas() {
        return parcelas;
    }

    public void setParcelas(String parcelas) {
        this.parcelas = parcelas;
    }

    public String getDados() {
        return dados;
    }

    public void setDados(String dados) {
        this.dados = dados;
    }
    
    
}
