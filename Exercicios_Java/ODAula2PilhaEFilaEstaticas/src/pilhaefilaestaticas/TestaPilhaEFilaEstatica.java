/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pilhaefilaestaticas;

import java.util.Scanner;

/**
 *
 * @author Marcelo Módolo
 */
public class TestaPilhaEFilaEstatica {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        /*
        9.No método main: chame o método testaPilhaEstatica para que seja executado.
        */
        testaPilhaEstatica();
        
        /*
        19.No método main: chame o método testaFilaCircular para que seja executado.
        */
        testaFilaCircular();
        
    }
    
    /*
    8.	Crie um método estático chamado testaPilhaEstatica sem parâmetros e 
    sem retorno. 
    */
    public static void testaPilhaEstatica(){
        /*
        a. Crie um objeto PilhaEstatica com capacidade para armazenar 10 
        objetos Produto; 
        */
        PilhaEstatica pilha = new PilhaEstatica(50);
        
        /*
        b. Crie um objeto do tipo Scanner para ler os atributos dos 
        objetos Produto que serão digitados no teclado. Faça a importação 
        da classe Scanner (import java.util.Scanner);
        */
        Scanner teclado = new Scanner (System.in);
        
        /*
        c. Crie um laço para inserir 10 objetos Produto na pilha usando 
        o método inserir (não se esqueça mostrar uma mensagem solicitando que 
        os atributos dos objetos sejam digitados);
        */
        System.out.println("Digite o código, a quantidade e o valor de 10 produtos:");
        for (int i = 0; i < 10; i++){
            Produto prod = (new Produto (teclado.nextInt(), teclado.nextInt(), teclado.nextDouble()));
            pilha.insereNaPilha(prod);
        }
        
        /*
        d. Mostre o topo da pilha;
        */
        System.out.println("Topo:");
        System.out.println(pilha.topoDaPilha());
        
        /*
        e. Verifique se a pilha está cheia e mostre uma mensagem informando;
        */
        if (pilha.pilhaCheia()){
            System.out.println("Pilha está cheia");
        } else {
            System.out.println("Pilha não está cheia");
        }
        
        /*
        f. Remova e mostre três objetos da pilha;
        */
        System.out.println("Removido 1o objeto");
        System.out.println(pilha.removeDaPilha());
        System.out.println("Removido 2o objeto");
        System.out.println(pilha.removeDaPilha());
        System.out.println("Removido 3o objeto");
        System.out.println(pilha.removeDaPilha());
        
        /*
        g. Verifique se a pilha está vazia e mostre uma mensagem informando;
        */
        if (pilha.pilhaVazia()){
            System.out.println("Pilha está vazia");
        } else {
            System.out.println("Pilha não está vazia");
        }
        
        /*
        h. Mostre o topo da pilha.
        */
        System.out.println("Topo:");
        System.out.println(pilha.topoDaPilha());        
    }
    
    /*
    18.	Crie um método estático chamado testaFilaCircular sem parâmetros e 
    sem retorno. 
    */
    public static void testaFilaCircular(){
        /*
        a. Crie um objeto FilaCircular com capacidade para armazenar 10 
        objetos Produto; 
        */
        FilaCircular fila = new FilaCircular(10);
        
        /*
        b. Crie um objeto do tipo Scanner para ler os atributos dos objetos 
        Produto que serão digitados no teclado;
        */
        Scanner teclado = new Scanner(System.in);
        
        /*
        c. Verifique se a fila está vazia e mostre uma mensagem informando;
        */
        if (fila.filaVazia()){
            System.out.println("Fila está vazia");
        } else {
            System.out.println("Fila não está vaiza");
        }

        /*
        d. Crie um laço para inserir 10 objetos na fila usando o método inserir 
        (não se esqueça de mostrar uma mensagem solicitando que os atributos 
        dos objetos Produto sejam digitados);
        */
        System.out.println("Digite o código, a quantidade e o valor de 10 produtos:");
        for (int i = 0; i < 10; i++){
            fila.insere(new Produto(teclado.nextInt(), teclado.nextInt(), teclado.nextDouble()));
        }
        
        /*
        e. Verifique se a fila está cheia e mostre uma mensagem informando;
        */
        if (fila.filaCheia()){
            System.out.println("Fila está cheia");
        } else {
            System.out.println("Fila não está cheia");
        }
        
        /*
        f. Mostre o início da fila;
        */
        System.out.println("Inicio:");
        System.out.println(fila.inicio());
        
        /*
        g. Remova e mostre um objeto da fila;
        */
        System.out.println("Removido:");
        System.out.println(fila.remove());
        
        /*
        h. Mostre o início da fila;
        */
        System.out.println("Inicio:");
        System.out.println(fila.inicio());
        
        /*
        i. Insira um novo objeto na fila com código = 10001, 
        quantidade = 50  e valor = 1.920,50 e mostre uma mensagem informando 
        se foi inserido ou não com sucesso.
        */
        if (fila.insere(new Produto(10001, 50, 1920.5))){
            System.out.println("Produto inserido com sucesso");
        }else{
            System.out.println("Produto NÃO inserido. Fila cheia!");
        }
        
        /*
        j. Mostre o início da fila.
        */
        System.out.println("Inicio:");
        System.out.println(fila.inicio());
    }
}
