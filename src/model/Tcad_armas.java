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
public class Tcad_armas {
    
    int idparceiro;
    String cpf,especie,marca,modelo,calibre,sigma,registro;

    public Tcad_armas(int idparceiro, String cpf) {
        this.idparceiro = idparceiro;
        this.cpf = cpf;
    }

    public Tcad_armas() {
    }

    
    public int getIdparceiro() {
        return idparceiro;
    }

    public void setIdparceiro(int idparceiro) {
        this.idparceiro = idparceiro;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCalibre() {
        return calibre;
    }

    public void setCalibre(String calibre) {
        this.calibre = calibre;
    }

    public String getSigma() {
        return sigma;
    }

    public void setSigma(String sigma) {
        this.sigma = sigma;
    }

    public String getRegistro() {
        return registro;
    }

    public void setRegistro(String registro) {
        this.registro = registro;
    }
    
    
    
    
}
