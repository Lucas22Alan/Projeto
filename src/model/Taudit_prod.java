/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Lucas
 */
public class Taudit_prod {
    
    int id;
    String idproduto;
    Double valorant;
    Double valornovo;
    String usuario;
    String dataoperacao;

    public Taudit_prod() {
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIdproduto() {
        return idproduto;
    }

    public void setIdproduto(String idproduto) {
        this.idproduto = idproduto;
    }

    public Double getValorant() {
        return valorant;
    }

    public void setValorant(Double valorant) {
        this.valorant = valorant;
    }

    public Double getValornovo() {
        return valornovo;
    }

    public void setValornovo(Double valornovo) {
        this.valornovo = valornovo;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getDataoperacao() {
        return dataoperacao;
    }

    public void setDataoperacao(String dataoperacao) {
        this.dataoperacao = dataoperacao;
    }
    
    
}
