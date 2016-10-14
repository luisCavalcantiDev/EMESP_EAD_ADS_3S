package br.metodista.ead.scs152.main;

import java.util.Scanner;

public class TestGenerics {

    public static void main(String[] args) {

        Scanner _teclado = new Scanner(System.in);

        System.out.println("************************************************");
        System.out.println("Gerenciamento de Números com Generics");
        System.out.println("************************************************");
        System.out.println("Selecione um Tipo de Número: 1 - Double ou 2 - Float");

        int _tipo = _teclado.nextInt();
        switch (_tipo) {
            case 1:
                
                System.out.println("Iniciando Gerenciamento de Números com Double...");
                RepositorioDouble _repositorioDouble = new RepositorioDouble();
                System.out.println("Adicionando MIN_VALUE...");
                _repositorioDouble.adicionar(Double.MIN_VALUE);
                System.out.println("Adicionando MAX_VALUE...");
                _repositorioDouble.adicionar(Double.MAX_VALUE);
                System.out.println("Exibindo a soma: " + _repositorioDouble.somar());
                System.out.println("Exibindo a subtração: " + _repositorioDouble.somar());
                System.out.println("Exibindo a multiplicação: " + _repositorioDouble.multiplicar());
                System.out.println("Exibindo a divisão: " + _repositorioDouble.dividir());
                System.out.println("Exibindo o módulo: " + _repositorioDouble.modulo());
                System.out.println("Finalizando Gerenciamento de Números com Double...");
                break;

            case 2:
                
                System.out.println("Iniciando Gerenciamento de Números com Float...");
                RepositorioFloat _repositorioFloat = new RepositorioFloat();
                System.out.println("Adicionando MIN_VALUE...");
                _repositorioFloat.adicionar(Float.MIN_VALUE);
                System.out.println("Adicionando MAX_VALUE...");
                _repositorioFloat.adicionar(Float.MAX_VALUE);
                System.out.println("Exibindo a soma: " + _repositorioFloat.somar());
                System.out.println("Exibindo a subtração: " + _repositorioFloat.somar());
                System.out.println("Exibindo a multiplicação: " + _repositorioFloat.multiplicar());
                System.out.println("Exibindo a divisão: " + _repositorioFloat.dividir());
                System.out.println("Exibindo o módulo: " + _repositorioFloat.modulo());
                System.out.println("Finalizando Gerenciamento de Números com Float...");
                break;
                
            default:
                System.out.println("Opção Inválida...Finalizando...");
                break;
        }
    }
}
