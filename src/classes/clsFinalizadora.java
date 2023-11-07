/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

/**
 *
 * @author Lucas Rodrigues
 */
public class clsFinalizadora {
    String id,nome=null;
    Double valor=0.00,vldigitado=0.00;

    public Double getVldigitado() {
        return vldigitado;
    }

    public void setVldigitado(Double vldigitado) {
        this.vldigitado = vldigitado;
    }

    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

 
}
