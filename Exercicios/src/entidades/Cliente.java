/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.util.List;

public class Cliente  extends GenericEntity {
    private Long cpf;
    private String nome;
    private Integer idade;
    private List<Compra> compraList;

    public Cliente() {
    }

    public Cliente(Long cpf) {
        this.cpf = cpf;
    }

    public Long getCpf() {
        return cpf;
    }

    public void setCpf(Long cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public List<Compra> getCompraList() {
        return compraList;
    }

    public void setCompraList(List<Compra> compraList) {
        this.compraList = compraList;
    }
    @Override
    public String toString() {
        return "CLIENTE -  cpf:[" + this.cpf + "] " +
                          "nome:[" + this.nome + "] " +
                          "idade:[" + this.idade + "] "  ;
    }
    
}
