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
public class PilhaEstatica {
    /*
    1.Crie os seguintes atributos da classe: 
        a.capacidade: contém o número de itens que cabe na pilha
        b.topo: indica a posição do topo da pilha
        c.vetor: é o vetor que armazena os produtos (classe Produto) da pilha

    */
    private int capacidade;
    private int topo;
    private Produto[] vetor;
    
    /*
    2.	Crie o método construtor da classe que recebe como parâmetro 
    a capacidade, cria o vetor do tamanho da capacidade e inicializa 
    os parâmetros capacidade e topo.
    */
    public PilhaEstatica(int capacidade){
        this.vetor = new Produto[capacidade];
        this.capacidade = capacidade;
        this.topo = -1;
    }
    
    /*
    3. Crie o método “pilhaVazia” que retorna true caso a pilha esteja vazia 
    e retorna false caso não esteja vazia.
    */
    public boolean pilhaVazia(){
        if (this.topo == -1){
            return true;
        } else {
            return false;
        }
    }
    
    /*
    4.	Crie o método “pilhaCheia” que retorna true caso a pilha esteja cheia 
    e retorna false caso não esteja cheia.
    */
    public boolean pilhaCheia(){
        if (this.topo == this.capacidade-1){
            return true;
        } else {
            return false;
        }
    }
    
    /*
    5.	Crie o método “insereNaPilha” que recebe como parâmetro um objeto Produto e, 
    caso a pilha não esteja cheia, insere esse objeto no topo, atualiza o 
    atributo topo e retorna true. Caso a pilha esteja cheia, retorna false.
    */
    public boolean insereNaPilha(Produto merc){
        if (!pilhaCheia()){
            this.topo++;
            this.vetor[this.topo] = merc;
            return true;
        } else {
            return false;
        }
    }
    
    /*
    6.	Crie o método “removeDaPilha” que, caso a pilha não esteja vazia, remove e 
    retorna o objeto Produto que está no topo, atualizando o atributo topo. 
    Caso a pilha esteja vazia, retorna null.
    */
    public Produto removeDaPilha(){
        if (!pilhaVazia()){
            this.topo--;
            return vetor[topo+1];
        } else {
            return null;
        }
    }
    
    /*
    7.	Crie o método “topoDaPilha” que retorna o topo da pilha, caso ela não 
    esteja vazia. Se estiver vazia retorna null.
    */
    public Produto topoDaPilha(){
        if (!pilhaVazia()){
            return this.vetor[this.topo];
        } else {
            return null;
        }
    }
    
}
