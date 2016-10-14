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
public class FilaCircular {
    /*
    10.	Crie os seguintes atributos da classe: 
        a. capacidade: contem o número de itens que cabe na fila
        b. inicio: indica a posição do primeiro item da fila
        c. fim: indica a posição do último item da fila
        d. quantidadeArmazenada: indica a quantidade de itens armazenados na fila
        e. vetor: vetor que armazena na fila os objetos Produto
    */
    private int capacidade;
    private int inicio;
    private int fim;
    private int quantidadeArmazenada;
    private Produto[] vetor;
    
    /*
    11.	Crie o método construtor da classe que recebe como parâmetro a 
    capacidade, cria o vetor do tamanho da capacidade e inicializa os parâmetros 
    capacidade e quantidadeArmazenada.
    */
    public FilaCircular(int capacidade){
        this.vetor = new Produto[capacidade];
        this.capacidade = capacidade;
        this.quantidadeArmazenada = 0;
    }
    
    /*
    12.	Crie o método “filaVazia” que retorna true caso a fila esteja vazia e 
    retorna false caso não esteja vazia.
    */
    public boolean filaVazia(){
        if (this.quantidadeArmazenada == 0){
            return true;
        } else {
            return false;
        }
    }
    
    /*
    13.	Crie o método “filaCheia” que retorna true caso a fila esteja cheia e 
    retorna false caso não esteja cheia.
    */
    public boolean filaCheia(){
        if (this.quantidadeArmazenada == this.capacidade){
            return true;
        } else {
            return false;
        }
    }
    
    /*
    14.	Crie o método “size” que retorna a quantidade de objetos armazenados na fila.
    */
    public int size(){
        return quantidadeArmazenada;
    }
    
    /*
    15.	Crie o método “insere” que recebe como parâmetro um objeto Produto e, 
    caso a fila esteja vazia, inicializa o atributo inicio com valor 0 e o 
    atributo fim com o valor -1. Caso a fila não esteja cheia, atualiza o 
    atributo fim, insere o objeto no final da fila, atualiza o atributo 
    quantidadeArmazenada e retorna true. Caso a fila esteja cheia, retorna false. 
    LEMBRETE: a fila é circular e a atualização do atributo fim deve levar isso 
    em consideração.
    */
    public boolean insere(Produto merc){
        if (filaVazia()){
            this.inicio = 0;
            this.fim = -1;
        }
        if (!filaCheia()){
            this.fim = (this.fim + 1) % this.capacidade;
            vetor[fim] = merc;
            quantidadeArmazenada++;
            return true;
        } else {
            return false;
        }
    }
    
    /*
    16.	Crie o método “remove” que, caso a fila não esteja vazia, atualiza os 
    atributos inicio e quantidadeArmazenada, remove e retorna o objeto 
    Produto que está início da fila. Caso a fila esteja vazia, retorna 
    null. LEMBRETE: a fila é circular e a atualização do atributo inicio deve 
    levar isso em consideração.
    */
    public Produto remove(){
        if (!filaVazia()){
            int temp = this.inicio;
            this.inicio = (this.inicio + 1) % this.capacidade;
            this.quantidadeArmazenada++;
            return this.vetor[temp];
        } else {
            return null;
        }
    }
    
    /*
    17.	Crie o método “início” que retorna o primeiro item da fila, caso ela 
    não esteja vazia. Se estive vazia retorna null.
    */
    public Produto inicio(){
        if (!filaVazia()){
            return this.vetor[inicio];
        } else {
            return null;
        }
    }
}
