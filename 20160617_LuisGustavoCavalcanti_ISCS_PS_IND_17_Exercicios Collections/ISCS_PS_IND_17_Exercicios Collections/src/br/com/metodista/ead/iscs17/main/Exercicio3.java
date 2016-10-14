package br.com.metodista.ead.iscs17.main;

import br.com.metodista.ead.iscs17.modelo.Aluno;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Exercicio3 {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        Map<String, Aluno> cadastroAlunos = new HashMap<String, Aluno>();
        Aluno aluno = null;

        String nome;
        String matricula;
        int vitorias;
        int derrotas;

        try {
            int opcao = -1;
            while (opcao != 0) {
                System.out.println("************************");
                System.out.println("***Cadastro de Alunos***");
                System.out.println("************************");
                System.out.println("Menu Principal");
                System.out.println("************************");
                System.out.println("1 - Cadastrar;");
                System.out.println("2 - Alterar;");
                System.out.println("3 - Consultar;");
                System.out.println("4 - Excluir;");
                System.out.println("5 - Sair");
                System.out.print("Selecione uma opção: ");

                opcao = teclado.nextInt();

                switch (opcao) {
                    case 1:

                        System.out.println("**1 - Novo Cadastro:*****");

                        System.out.print("Digite o nome do Aluno: ");
                        nome = teclado.next();
                        System.out.print("Insira o nº de matrícula: ");
                        matricula = teclado.next();
                        
                        if (cadastroAlunos.containsKey(matricula)) {
                            System.out.println("***ATENÇÃO*********************");
                            System.out.print("Já existe um aluno com o nº de matrícula " + matricula + ". [Nome: " + cadastroAlunos.get(matricula).getNome() + "].");
                            System.out.println("************************");
                            break;
                        }
                        
                        System.out.print("Insira o nº de vitorias ");
                        vitorias = teclado.nextInt();
                        System.out.print("Insira o nº de derrotas ");
                        derrotas = teclado.nextInt();

                        aluno = new Aluno(nome, matricula, vitorias, derrotas);

                        cadastroAlunos.put(matricula, aluno);

                        System.out.println("**Cadastro efetuado com sucesso*****");

                        break;

                    case 2:
                        System.out.println("**2 - Alterar Cadastro:*****");
                        System.out.print("Digite nº de matrícula: ");

                        matricula = teclado.next();

                        aluno = cadastroAlunos.get(matricula);
                        if (aluno != null) {
                            System.out.println("**2 - Alterando Aluno: " + aluno.getNome() + "*****");

                            System.out.print("Insira o nº de vitorias ");
                            vitorias = teclado.nextInt();
                            System.out.print("Insira o nº de derrotas ");
                            derrotas = teclado.nextInt();

                            cadastroAlunos.remove(matricula);
                            cadastroAlunos.put(matricula, aluno);
                        }

                        break;

                    case 3:
                        System.out.println("**3 - Consultando Aluno:*****");
                        System.out.print("Digite nº de matrícula: ");

                        matricula = teclado.next();

                        aluno = cadastroAlunos.get(matricula);
                        if (aluno != null) {
                            System.out.println("**Dados do Aluno: ");
                            System.out.println("Nome: " + aluno.getNome());
                            System.out.println("Vitórias: " + aluno.getVitorias());
                            System.out.println("Derrotas: " + aluno.getDerrotas());
                        } else {
                            System.out.println("Aluno com matrícula " + matricula + " não está cadastrado");
                        }

                        break;

                    case 4:

                        System.out.println("**4 - Removendo Aluno:*****");
                        System.out.print("Digite nº de matrícula: ");

                        matricula = teclado.next();

                        aluno = cadastroAlunos.get(matricula);
                        if (aluno != null) {
                            System.out.println("**Deseja realmente excluir o aluno " + aluno.getNome() + "? (S-Sim/N-Não)");

                            String excluir = teclado.next();
                            if (excluir.equals("S")) {
                                cadastroAlunos.remove(matricula);

                                System.out.println("Aluno com matrícula " + matricula + " foi excluído");
                            }
                        }
                        break;

                    case 5:
                        System.out.println("Encerrando programa...");
                        System.exit(0);
                        break;
                }

            }
        } catch (Exception e) {
            System.out.println("Opção ou operação inválida. Erro: " + e.getStackTrace().toString());
        }
    }
}
