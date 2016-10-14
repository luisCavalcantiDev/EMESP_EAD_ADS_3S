package br.com.metodista.ead.iscs17.main;

import java.util.Set;
import java.util.TreeSet;
import java.util.HashSet;

public class Exercicio2 {

    public static void main(String[] args) {

        System.out.println("Inserindo 50.000 números em TreeSet...");
        System.out.println("");
        System.out.println("Cronômetro: " + System.currentTimeMillis());
        System.out.println("");

        Set<Integer> listaTreeSet = new TreeSet<>();

        for (int i = 0; i < 50000; i++) {
            listaTreeSet.add((i + 1));
        }

        System.out.println("");
        System.out.println("Cronômetro: " + System.currentTimeMillis());
        System.out.println("");

        System.out.println("Inserindo 50.000 números em HashSet...");
        System.out.println("");

        System.out.println("");
        System.out.println("Cronômetro: " + System.currentTimeMillis());
        System.out.println("");

        Set<Integer> listaHashSet = new HashSet<>();

        for (int i = 0; i < 50000; i++) {
            listaHashSet.add((i + 1));
        }

        System.out.println("");
        System.out.println("Cronômetro: " + System.currentTimeMillis());
        System.out.println("");

        System.out.println("Consultando 50.000 números em TreeSet...");
        System.out.println("");

        System.out.println("");
        System.out.println("Cronômetro: " + System.currentTimeMillis());
        System.out.println("");

        for (Integer integer : listaTreeSet) {
            integer.byteValue();
        }

        System.out.println("");
        System.out.println("Cronômetro: " + System.currentTimeMillis());
        System.out.println("");

        System.out.println("******************************************");

        System.out.println("Consultando 50.000 números em HashSet...");
        System.out.println("");

        System.out.println("");
        System.out.println("Cronômetro: " + System.currentTimeMillis());
        System.out.println("");

        for (Integer integer : listaHashSet) {
            integer.byteValue();
        }

        System.out.println("");
        System.out.println("Cronômetro: " + System.currentTimeMillis());
        System.out.println("");

        System.out.println("******************************************");
    }
}
