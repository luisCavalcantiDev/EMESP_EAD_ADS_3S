package br.com.metodista.ead.iscs17.main;

import java.util.*;

import br.com.metodista.ead.iscs17.modelo.Email;

public class Exercicio1 {

    public static void main(String[] args) {

        System.out.println("Criando 5 objetos de Email.....");
        System.out.println("");

        Email obj1 = new Email("luis.cavafila.offer(obj1);lcanti583@gmail.com", "email obj1", "enviar email de obj1");
        System.out.println(obj1.toString());

        Email obj2 = new Email("maria.aparecida@hotmail.com", "email obj2", "enviar email de obj2");
        System.out.println(obj2.toString());

        Email obj3 = new Email("jose123@outlook.com", "email obj3", "enviar email de obj3");
        System.out.println(obj3.toString());

        Email obj4 = new Email("manoel.silva@gmail.com", "email obj4", "enviar email de obj4");
        System.out.println(obj4.toString());

        Email obj5 = new Email("joanam_almeida@gmail.com", "email obj5", "enviar email de obj5");
        System.out.println(obj5.toString());

        System.out.println("");
        System.out.println("Criando uma fila de Emails....");

        Queue<Email> fila = new LinkedList<>();
        fila.offer(obj1);
        fila.offer(obj2);
        fila.offer(obj3);
        fila.offer(obj4);
        fila.offer(obj5);

        System.out.println("");
        System.out.println("Criando uma pilha de Emails....");

        List<Email> pilha;
        pilha = new Stack<>();
        pilha.add(obj1);
        pilha.add(obj2);
        pilha.add(obj3);
        pilha.add(obj4);
        pilha.add(obj5);

        System.out.println("********************************************");
        System.out.println("Exibindo os itens na fila de Emails....");
        System.out.println("");

        for (Email email : fila) {
            System.out.println(email.toString());
            System.out.println("");
        }

        System.out.println("********************************************");

        System.out.println("********************************************");
        System.out.println("Exibindo os itens na pilha de Emails....");
        System.out.println("");

        for (Email email : pilha) {
            System.out.println(email.toString());
            System.out.println("");
        }

        System.out.println("********************************************");
    }
}
