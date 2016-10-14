/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vetoresdeobjetos;

import java.util.Scanner;
 
/**
 *
 * @author marcelo.modolo
 */
public class ManipulaVetoresDeObjetos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner teclado = new Scanner(System.in);
        Scanner linha = new Scanner(System.in);
        Funcionario vetorFuncionarios[] = new Funcionario[80];
        String nome;
        int matricula;
        double salario;
        int opcao;
        do {
            System.out.println("Menu:");
            System.out.println("1) Inserir um funcionário na próxima posição vazia;");
            System.out.println("2) Procurar um funcionário por matrícula;");
            System.out.println("3) Procurar um funcionário por nome;");
            System.out.println("4) Remover um funcionário por matrícula;");
            System.out.println("5) Alterar o salário de um funcionário por matrícula;");
            System.out.println("6) Mostrar todos os funcionários;");
            System.out.println("7) Encontrar o maior salário;");
            System.out.println("8) Finalizar o programa.");
            System.out.println("Digite o número da opção desejada:");
            opcao = teclado.nextInt();
            switch (opcao) {
                case 1:
                    System.out.println("Inserindo funcionário...");
                    System.out.println("Digite o nome, a matrícula e o salário do funcionário a ser inserido");
                    nome = linha.nextLine();
                    matricula = teclado.nextInt();
                    salario = teclado.nextDouble();
                    if (inserirFuncionario(vetorFuncionarios, nome, matricula, salario)) {
                        System.out.println("Funcionario inserido com sucesso.");
                    } else {
                        System.out.println("Funcionario não foi inserido. Vetor cheio.");
                    }
                    break;
                case 2:
                    System.out.println("Procurando funcionário por matrícula...");
                    System.out.println("Digite a matrícula do funcionario procurado");
                    matricula = teclado.nextInt();
                    Funcionario encontrado = procurarMatricula(vetorFuncionarios, matricula);
                    if (encontrado != null) {
                        System.out.println("O funcionario procurado é " + encontrado);
                    } else {
                        System.out.println("O funcionario não foi encontrado. A matrícula não existe.");
                    }
                    break;
                case 3:
                    System.out.println("Procurando funcionário por nome...");
                    System.out.println("Digite o nome do funcionario procurado");
                    nome = linha.nextLine();
                    matricula = procurarNome(vetorFuncionarios, nome);
                    if (matricula > -1) {
                        System.out.println("A matrícula do funcionario procurado é " + matricula);
                    } else {
                        System.out.println("O funcionario não foi encontrado. O nome não existe.");
                    }
                    break;
                case 4:
                    System.out.println("Removendo funcinário por matrícula...");
                    System.out.println("Digite a matrícula do funcionario a ser removido");
                    matricula = teclado.nextInt();
                    Funcionario removido = removerFuncionario(vetorFuncionarios, matricula);
                    if (removido != null) {
                        System.out.println("Funcionario removido com sucesso: "
                                + removido);
                    } else {
                        System.out.println("O funcionario não foi encontrado. A matrícula não existe.");
                    }
                    break;
                case 5:
                    System.out.println("Alternado salário por matrícula...");
                    System.out.println("Digite a matrícula e o novo salário do funcionario");
                    matricula = teclado.nextInt();
                    salario = teclado.nextDouble();
                    Funcionario alterado = procurarMatricula(vetorFuncionarios, matricula);
                    if (alterado != null) {
                        alterado.setSalario(salario);
                        System.out.println("Salário alterado com sucesso.");
                        System.out.println(alterado);
                    } else {
                        System.out.println("O funcionario não foi encontrado. A matrícula não existe.");
                    }
                    break;
                case 6:
                    System.out.println("Mostrando todo os funcionários...");
                    if (vetorFuncionarios[0] == null) {
                        System.out.println("Vetor está vazio.");
                    } else {
                        mostrarVetor(vetorFuncionarios);
                    }
                    break;
                case 7:
                    System.out.println("Encontrando maior salário...");
                    double maiorSal = EncontrarMaiorSalario(vetorFuncionarios);
                    if (maiorSal > -1) {
                        System.out.println("O maior salário é " + maiorSal);
                    } else {
                        System.out.println("Não foi possível encontrar. Vetor está vazio.");
                    }
                    break;
                case 8:
                    System.out.println("Fim do Programa");
                    break;
                default:
                    System.out.println("Opção Inválida");
            }
            System.out.println();

        } while (opcao != 8);

        teclado.close();
        linha.close();
    }

    public static boolean inserirFuncionario(Funcionario[] vetFuncionario, String nome, int matr,
            double salario) {
        for (int i = 0; i < vetFuncionario.length; i++) {
            if (vetFuncionario[i] == null) {
                vetFuncionario[i] = new Funcionario(nome, matr, salario);
                return true;
            }
        }
        return false;
    }

    public static void mostrarVetor(Funcionario[] vetFuncionario) {
        for (int i = 0; i < vetFuncionario.length && vetFuncionario[i] != null; i++) {
            System.out.println(vetFuncionario[i]);
        }
    }

    public static Funcionario procurarMatricula(Funcionario[] vetFuncionario, int matr) {
        for (int i = 0; i < vetFuncionario.length && vetFuncionario[i] != null; i++) {
            if (vetFuncionario[i].getMatricula() == matr) {
                return vetFuncionario[i];
            }
        }
        return null;
    }

    public static int procurarNome(Funcionario[] vetFuncionario, String nome) {
        for (int i = 0; i < vetFuncionario.length && vetFuncionario[i] != null; i++) {
            if (vetFuncionario[i].getNome().equals(nome)) {
                return vetFuncionario[i].getMatricula();
            }
        }
        return -1;
    }

    public static Funcionario removerFuncionario(Funcionario[] vetFuncionario, int matr) {
        for (int i = 0; i < vetFuncionario.length && vetFuncionario[i] != null; i++) {
            if (vetFuncionario[i].getMatricula() == matr) {
                Funcionario removido = vetFuncionario[i];
                int j = i;
                while (j < (vetFuncionario.length - 1) && vetFuncionario[j] != null) {
                    vetFuncionario[j] = vetFuncionario[j + 1];
                    j++;
                }
                vetFuncionario[j] = null;
                return removido;
            }
        }
        return null;
    }

    public static boolean alterarSalario(Funcionario[] vetFuncionario,
            int matr, double novoSal) {
        Funcionario alterado = procurarMatricula(vetFuncionario, matr);
        if (alterado != null) {
            alterado.setSalario(novoSal);
            return true;
        } else {
            return false; 
        }
    }

    public static double EncontrarMaiorSalario(Funcionario[] vetFuncionario) {
        if (vetFuncionario[0] == null) {
            return -1;
        }
        double maior = vetFuncionario[0].getSalario();
        for (int i = 1; i < vetFuncionario.length && vetFuncionario[i] != null; i++) {
            if (vetFuncionario[i].getSalario() > maior) {
                maior = vetFuncionario[i].getSalario();
            }
        }
        return maior;
    }

}
