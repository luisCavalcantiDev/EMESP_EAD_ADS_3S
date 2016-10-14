/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pilhaefilaestaticas;

/**
 *
 * @author Marcelo Módolo
 */
public class Produto {
    /*
    Criação dos  atributos da classe: 
        - codigo: número inteiro que identifica o produto
        - quantidade: número inteiro que identifica a quantidade do produto
        - valor: número real com o proço de compra do produto
    */
    private int codigo;
    private int quantidade;
    private double valor;
    
    /*
    Criação do método construtor da classe que recebe como parâmetro o código, a quantidade e 
    o valor e inicializa esses atributos.
    */
    public Produto(int codigo, int quantidade, double valor){
        this.codigo = codigo;
        this.quantidade = quantidade;
        this.valor = valor;
    }

    /*
    Criação dos métodos get e set para cada um dos atributos.
    */
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    
    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
    
    /*
    Criação do método “to String” para mostrar o objeto Produto.
     */
    @Override
    public String toString() {
        return "Codigo: " + codigo + " Quantidade = " + quantidade + " Valor = " + valor;
    }
    
}
