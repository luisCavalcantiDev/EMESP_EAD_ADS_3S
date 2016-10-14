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
public class Exercicio3 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        Stack <String> pilhaCandidatos = new <String> Stack();
        Stack <String> pilhaNaoClassificados = new <String> Stack();
        Stack <String> pilhaClassificados = new <String> Stack();
        System.out.print("Digite os nomes dos candidatos em ordem decrecente ");
        System.out.println("e digite ponto (.) quando terminar ");
        String palavra = teclado.next();
        while (!palavra.equals(".")){
            pilhaCandidatos.push(palavra);
            palavra = teclado.next();
        }
        System.out.println("Digite o número de classificados: ");
        int classificados = teclado.nextInt();
        for (int i = 0; i < classificados && !pilhaCandidatos.isEmpty(); i++){
            pilhaClassificados.push(pilhaCandidatos.pop());
        }
        while (!pilhaCandidatos.isEmpty()){
            pilhaNaoClassificados.push(pilhaCandidatos.pop());
        }
        System.out.println("Pilha de Classificados:");
        System.out.println(pilhaClassificados);
        System.out.println("Pilha de Não Classificados:");
        System.out.println(pilhaNaoClassificados);
    }
}
