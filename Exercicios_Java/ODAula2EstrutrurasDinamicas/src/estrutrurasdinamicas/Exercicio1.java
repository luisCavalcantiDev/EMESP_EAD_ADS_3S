/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package estrutrurasdinamicas;

import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author Marcelo
 */
public class Exercicio1 {

    public static void main(String[] args) {
        Scanner leOpcao = new Scanner(System.in);
        Scanner leModelo = new Scanner(System.in);
        Stack <String> pilha = new <String> Stack();
        int opcao;
        do {
            System.out.println("Escolha uma das opções: ");
            System.out.println("1- inserir automóvel");
            System.out.println("2- remover automóvel");
            System.out.println("3- mostrar topo");
            System.out.println("4- encerrar o programa");
            opcao = leOpcao.nextInt();
            switch (opcao) {
                case 1:
                    System.out.println("Digite o modelodo automóvel a ser inserido na pilha");
                    pilha.push(leModelo.nextLine());
                    break;
                case 2:
                    if (!pilha.isEmpty()) {
                        System.out.println("Removido: " + pilha.pop());
                    } else {
                        System.out.println("Não é possível remover. Pilha Vazia");
                    }
                    break;
                case 3:
                    if (!pilha.isEmpty()) {
                        System.out.println("Topo: " + pilha.peek());
                    } else {
                        System.out.println("Não é possível mostrar. Pilha Vazia");
                    }
                    break;
                case 4:
                    System.out.println("Fim do Programa");
                    break;
                default:
                    System.out.println("Opção Inválida");
            }
            System.out.println("");
        } while (opcao != 4);
    }
}
