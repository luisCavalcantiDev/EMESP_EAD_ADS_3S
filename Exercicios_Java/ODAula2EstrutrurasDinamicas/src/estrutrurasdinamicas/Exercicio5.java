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
public class Exercicio5 {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        Queue <Integer> fila = new LinkedList <Integer> ();
        int p, c = 3, t;
        System.out.println("Digite os números positivos dos processos com um dígito "
                + "e digite zero (0) para encerrar:");
        int digito = teclado.nextInt();
        int processo, cont = 1;
        while (digito >= 1 && digito <= 9){
            processo = digito + (cont * 10);
            fila.offer(processo);
            digito = teclado.nextInt();
            cont++;
        }
        System.out.println(fila);
        while (!fila.isEmpty()) {
            processo = fila.poll();
            p = processo / 10;
            t = processo % 10;
            if (t > c) {
                processo = p * 10 + (t - c);
                fila.offer(processo);
            }
            System.out.println(fila);
        }
    }
}
