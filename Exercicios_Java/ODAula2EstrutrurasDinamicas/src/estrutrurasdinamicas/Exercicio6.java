/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package estrutrurasdinamicas;

import java.util.LinkedList;
import java.util.Scanner;

/**
 *
 * @author Marcelo
 */
public class Exercicio6 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        LinkedList <String> lista1 = new LinkedList <String> ();
        LinkedList <String> lista2 = new LinkedList <String> ();
        LinkedList <String> lista3 = new LinkedList <String> ();
        System.out.println("Digite as palavras da primeira lista");
        String palavra = teclado.next();
        while(!palavra.equals(".")){
            lista1.addLast(palavra);
            palavra = teclado.next();
        }
        System.out.println("Digite as palavras da segunda lista");
        palavra = teclado.next();
        while(!palavra.equals(".")){
            lista2.addLast(palavra);
            palavra = teclado.next();
        }
        for (int i = 0; i < lista1.size(); i++){
            lista3.addLast(lista1.get(i));
        }
        for (int i = 0; i < lista2.size(); i++){
            lista3.addLast(lista2.get(i));
        }
        System.out.println("Lista 1: " + lista1);
        System.out.println("Lista 2: " + lista2);
        System.out.println("Lista 3: " + lista3);
    }
    
}
