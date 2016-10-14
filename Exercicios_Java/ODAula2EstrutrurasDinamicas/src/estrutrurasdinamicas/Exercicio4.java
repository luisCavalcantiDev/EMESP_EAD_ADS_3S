/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package estrutrurasdinamicas;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 *
 * @author Marcelo
 */
public class Exercicio4 {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        Queue<Integer> filaA = new <Integer> LinkedList();
        Queue<Integer> filaB = new <Integer> LinkedList();
        Queue<Integer> filaC = new <Integer> LinkedList();
        for (int i = 1; i <= 13; i++) {
            filaA.offer(i);
        }
        for (int i = 1; i <= 13; i++) {
            filaB.offer(i);
        }
        int opcao;
        do {
            System.out.println("Escolha uma das opções: ");
            System.out.println("1- Embaralhar");
            System.out.println("2- Terminar o programa");
            opcao = teclado.nextInt();
            if (opcao == 1) {
                System.out.println("Fila A: " + filaA);
                System.out.println("Fila B: " + filaB);
                while (!filaA.isEmpty() && !filaB.isEmpty()) {
                    filaC.offer(filaA.poll());
                    filaC.offer(filaB.poll());
                }
                System.out.println("Fila C (embaralhada): " + filaC);
                for (int i = 0; i < 13; i++) {
                    filaA.offer(filaC.poll());
                }
                for (int i = 0; i < 13; i++) {
                    filaB.offer(filaC.poll());
                }
                System.out.println("");
            } else if (opcao != 2) {
                System.out.println("Opção Inválida");
            }
        } while (opcao != 2);
    }
}
