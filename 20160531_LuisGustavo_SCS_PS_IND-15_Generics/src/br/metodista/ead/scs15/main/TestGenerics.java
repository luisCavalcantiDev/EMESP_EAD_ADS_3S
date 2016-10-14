package br.metodista.ead.scs15.main;

import br.metodista.ead.scs15.modelos.Aluno;
import java.util.Scanner;

public class TestGenerics {

    public static void main(String[] args) {
        Scanner _teclado = new Scanner(System.in);
        RepositorioAlunos _repositorio = new RepositorioAlunos();
        
        System.out.println("************************************************");
        System.out.println("Gerenciamento de Objetos com Generics");
        System.out.println("************************************************");

        int opcao;
        do {
            System.out.println("************************************************");
            System.out.println("Respositório de Alunos - Menu:");
            System.out.println("************************************************");
            System.out.println("Selecione uma opção:");
            System.out.println("1 - Adicionar Elemento");
            System.out.println("2 - Substituir Elemento de determinada posição");
            System.out.println("3 - Eliminar Elemento de determinada posição");
            System.out.println("4 - Remover Último Elemento");
            System.out.println("5 - Encerrar");
            opcao = _teclado.nextInt();
            switch (opcao) {
                case 1:
                    System.out.println("Opção 1 - Adicionar Elemento");
                    Aluno _novoAluno = new Aluno();
                    System.out.print("Insira o RA do aluno: ");
                    _novoAluno.setRA(_teclado.next());

                    System.out.print("Insira o nome do aluno: ");
                    _novoAluno.setNome(_teclado.next());
                    
                    System.out.print("Insira a idade do aluno: ");
                    _novoAluno.setIdade(_teclado.nextInt());
                    
                    System.out.print("Insira o Polo do aluno: ");
                    _novoAluno.setPolo(_teclado.next());
                    
                    _repositorio.adicionarElemento(_novoAluno);
                    System.out.println("Aluno inserido com sucesso!!!");

                    break;
                case 2:
                    System.out.println("Opção 2 - Substituir Elemento de determinada posição");
                    System.out.println("Insira as informações do aluno para substituição");
                    Aluno _alunoSubstituir = new Aluno();
                    System.out.print("Insira o RA do aluno: ");
                    _alunoSubstituir.setRA(_teclado.next());

                    System.out.print("Insira o nome do aluno: ");
                    _alunoSubstituir.setNome(_teclado.next());
                    
                    System.out.print("Insira a idade do aluno: ");
                    _alunoSubstituir.setIdade(_teclado.nextInt());
                    
                    System.out.print("Insira o Polo do aluno: ");
                    _alunoSubstituir.setPolo(_teclado.next());
                    
                    System.out.print("Digite a posição para substituição: ");
                    int _posicaoSubstituir = _teclado.nextInt();
                    
                    _repositorio.substituirElemento(_alunoSubstituir, _posicaoSubstituir);
                    
                    System.out.println("Aluno substituído com sucesso!!!");
                    
                    break;
                case 3:
                    System.out.println("Opção 3 - Eliminar Elemento de determinada posição");
                    System.out.print("Insira a posição: ");
                    int _posicaoEliminar = _teclado.nextInt();

                    _repositorio.eliminarPosicao(_posicaoEliminar);

                    System.out.println("Aluno eliminado com sucesso!!!");
                    break;
                case 4:
                    System.out.println("Opção 4 - Remover Último Elemento");
                    _repositorio.removerUltimoElemento();
                    System.out.println("Aluno removido  com sucesso!!!");
                    break;
                case 5:
                    System.out.println("Fim do Programa");                    
                    break;
                default:
                    System.out.println("Opção selecionada inválida.");
            }

        } while (opcao != 5);
    }
}
