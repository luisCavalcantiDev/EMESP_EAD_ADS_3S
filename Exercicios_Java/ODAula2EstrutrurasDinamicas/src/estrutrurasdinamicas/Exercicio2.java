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
public class Exercicio2 {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        LinkedList <Integer> lista = new <Integer> LinkedList();
        LinkedList <Integer> novaLista = new <Integer> LinkedList();
        System.out.println("Digite os números inteiros da lista");
        int numero = teclado.nextInt();
        while (numero != -9999) {
            lista.addLast(numero);
            numero = teclado.nextInt();
        }
        System.out.println("Lista: " + lista);
        novaLista = limpaLista(lista);
        System.out.println("Nova lista: " + novaLista);
    }

    public static LinkedList limpaLista(LinkedList<Integer> lista) {
        LinkedList <Integer> novaLista = new <Integer> LinkedList();
        int item;
        while (lista.size() > 0) {
            item = lista.removeFirst();
            while (lista.contains(item)) {
                lista.removeFirstOccurrence(item);
            }
            novaLista.addLast(item);
        }
        return (novaLista);
    }
}
