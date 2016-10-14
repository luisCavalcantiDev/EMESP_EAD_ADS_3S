/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package estrutrurasdinamicas;

import java.util.LinkedList;
import java.util.Scanner;

/**
 *
 * @author marcelo.modolo
 */
public class Exercicio7 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner teclado = new Scanner(System.in);
        LinkedList<String> lista = new <String> LinkedList();
        int opcao;
        do {
            System.out.println("");
            System.out.println("Menu:");
            System.out.println("1.Inserir elemento no início da lista");
            System.out.println("2.Inserir elemento no final da lista");
            System.out.println("3.Inserir elemento em uma determinada posição da lista");
            System.out.println("4.Mostrar um elemento de determinada posição da lista");
            System.out.println("5.Mostrar a posição de um determinado elemento");
            System.out.println("6.Mostrar e excluir o primeiro elemento da lista");
            System.out.println("7.Mostrar e excluir o último elemento da lista");
            System.out.println("8.Mostrar e excluir o elemento de determinada posição da lista");
            System.out.println("9.Excluir determinado elemento da lista e mostrar se foi excluído ou não");
            System.out.println("10.Substituir por outro o elemento de determinada posição da lista");
            System.out.println("11.Mostrar todos os elementos da lista");
            System.out.println("12.Remover todos os elementos da lista");
            System.out.println("13.Sair do programa");
            System.out.println("Digite o número da opção desejada:");
            opcao = teclado.nextInt();
            switch (opcao) {
                case 1:
                    System.out.println("Digite o elemento a ser inserido");
                    lista.addFirst(teclado.next());
                    break;
                case 2:
                    System.out.println("Digite o elemento a ser inserido");
                    lista.addLast(teclado.next());
                    break;
                case 3:
                    System.out.println("Digite a posição e o elemento a ser inserido");
                    int pos = teclado.nextInt();
                    lista.add(pos, teclado.next());
                    break;
                case 4:
                    System.out.println("Digite a posição do elemento a ser mostrado");
                    System.out.println("O elemento é " + lista.get(teclado.nextInt()));
                    break;
                case 5:
                    System.out.println("Digite o elemento que deve ser buscado");
                    System.out.println("A posição desse elemento é " + lista.indexOf(teclado.next()));
                    break;
                case 6:
                    System.out.println("O elemento excluído foi " + lista.removeFirst());
                    break;
                case 7:
                    System.out.println("O elemento excluído foi " + lista.removeLast());
                    break;
                case 8:
                    System.out.println("Digite a posição do elemento que deve ser excluído");
                    System.out.println("O elemento excluído foi " + lista.remove(teclado.nextInt()));
                    break;
                case 9:
                    System.out.println("Digite o elemento que deve ser excluído");
                    if (lista.remove(teclado.next())) {
                        System.out.println("O elemento foi excluído com sucesso");
                    } else {
                        System.out.println("O elemento não foi excluído porque não existe na lista");
                    }
                    break;
                case 10:
                    System.out.println("Digite a posição e o novo elemento");
                    pos = teclado.nextInt();
                    System.out.println("O elemento substitutído foi " + lista.set(pos, teclado.next()));
                    break;
                case 11:
                    System.out.println("Lista:");
                    System.out.println(lista);
                    break;
                case 12:
                    System.out.println("Tem certeza que quer remover todos os elementos? (s/n)");
                    char certeza = teclado.next().charAt(0);
                    if (certeza == 's'){
                        lista.clear();
                        System.out.println("Todos os elementos da lista foram removidos");
                    } else {
                        System.out.println("Elementos não foram removidos");
                    }
                    break;
                case 13:
                    System.out.println("Fim do Programa");
                    break;
                default:
                    System.out.println("Opção inválida");
            }

        } while (opcao != 13);
    }
}
