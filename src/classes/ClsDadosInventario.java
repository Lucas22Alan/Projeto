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
public class ClsDadosInventario {
    
    String barras;
    String nome;
    Double custo;
    Double estoque;

    public ClsDadosInventario(String barras, String nome, Double custo, Double estoque) {
        this.barras = barras;
        this.nome = nome;
        this.custo = custo;
        this.estoque = estoque;
    }

    
    public String getBarras() {
        return barras;
    }

    public void setBarras(String barras) {
        this.barras = barras;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getCusto() {
        return custo;
    }

    public void setCusto(Double custo) {
        this.custo = custo;
    }

    public Double getEstoque() {
        return estoque;
    }

    public void setEstoque(Double estoque) {
        this.estoque = estoque;
    }
    

   
}
