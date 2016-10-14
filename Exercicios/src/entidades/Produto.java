/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.util.List;

/**
 *
 * @author cristianocamilo
 */
public class Produto extends GenericEntity{
    private Integer codigo;
    private String nome;
    private int intqtdEstoque;

    public Produto() {
    }

    public Produto(Integer codigo) {
        this.codigo = codigo;
    }

    public Produto(Integer codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIntqtdEstoque() {
        return intqtdEstoque;
    }

    public void setIntqtdEstoque(int intqtdEstoque) {
        this.intqtdEstoque = intqtdEstoque;
    }

    @Override
    public String toString() {
        return "PRODUTO -  codigo:[" + this.codigo + "] " +
                          "nome:[" + this.nome + "] " +
                          "estoque:[" + this.intqtdEstoque + "] ";
    }
    
}
