/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import daos.ClienteDAO;
import daos.CompraDAO;
import daos.ProdutoDAO;
import entidades.Cliente;
import entidades.Compra;
import entidades.Produto;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author cristianocamilo
 */
public class Principal {

    private static final String SUCESSO = "\n -------------------\n  Operação realizada com sucesso !!! \n -------------------";
    private static final String FALHA = "\n -------------------\n  Operação não efetuada !!! \n -------------------";

    public static void main(String[] args) {
        menuPrincipal();
    }

    public static void menuPrincipal() {
        Scanner teclado = new Scanner(System.in);
        char opc = 's';
        do {
            System.out.println("\n\n");
            System.out.println("MENU PRINCIPAL");
            System.out.println("-------------------");
            System.out.println("(c) Cliente");
            System.out.println("(o) Compra");
            System.out.println("(p) Produto");
            System.out.println("(s) Sair");
            System.out.print("Escolha uma opção..: ");
            opc = teclado.next().charAt(0);
            switch (opc) {
                case 'c':
                case 'C':
                    menuCliente(teclado);
                    break;
                case 'o':
                case 'O':
                    menuCompra(teclado);
                    break;
                case 'p':
                case 'P':
                    menuProduto(teclado);
                    break;
                default:
                    if (opc != 's' && opc != 'S') {
                        System.out.println("\n -------------------\n Opção Inválida!!! \n -------------------");
                    }
            }
        } while (opc != 's' && opc != 'S');
        System.out.println("\n\n");
        System.out.println(" # # # FIM DE EXECUÇão # # # ");
    }

    private static void menuCliente(Scanner teclado) {
        char opc = 's';
        do {
            System.out.println("\n\n");
            System.out.println("MENU CLIENTE");
            System.out.println("-------------------");
            System.out.println("(i) Inserir");
            System.out.println("(a) Alterar");
            System.out.println("(c) Consultar");
            System.out.println("(e) Excluir");
            System.out.println("(t) Todos");
            System.out.println("(s) Voltar");
            System.out.print("Escolha uma opção..: ");
            opc = teclado.next().charAt(0);
            Cliente cli = null;
            ClienteDAO cliDAO = new ClienteDAO();
            boolean resp = false;
            switch (opc) {
                case 'I':
                case 'i':
                    cli = lerCliente(teclado);
                    resp = cliDAO.inserir(cli);
                    System.out.println(resp ? SUCESSO : FALHA);
                    break;
                case 'A':
                case 'a':
                    cli = lerCliente(teclado);
                    resp = cliDAO.alterar(cli);
                    System.out.println(resp ? SUCESSO : FALHA);
                    break;
                case 'C':
                case 'c':
                    System.out.println("Digite o CPF: ");
                    long cpf = teclado.nextLong();
                    Cliente cliente = cliDAO.consultar(cpf);
                    if (cliente != null) {
                        System.out.println(cliente);
                    }
                    break;
                case 'E':
                case 'e':
                    cli = lerCliente(teclado);
                    resp = cliDAO.excluir(cli);
                    System.out.println(resp ? SUCESSO : FALHA);
                    break;
                case 'T':
                case 't':
                    Cliente[] clientes = cliDAO.consultarTodos();
                    for (Cliente client : clientes) {
                        if(client!=null){
                            System.out.println(client);
                        }
                    }
                    break;
                default:
                    if (opc != 's' && opc != 'S') {
                        System.out.println("\n -------------------\n Opção Inválida!!! \n -------------------");
                    }
            }
        } while (opc != 's' && opc != 'S');
    }

    private static void menuProduto(Scanner teclado) {
        char opc = 's';
        do {
            System.out.println("\n\n");
            System.out.println("MENU PRODUTO");
            System.out.println("-------------------");
            System.out.println("(i) Inserir");
            System.out.println("(a) Alterar");
            System.out.println("(c) Consultar");
            System.out.println("(e) Excluir");
            System.out.println("(t) Todos");
            System.out.println("(s) Voltar");
            System.out.print("Escolha uma opção..: ");
            opc = teclado.next().charAt(0);
            Produto prod = null;
            ProdutoDAO prodDAO = new ProdutoDAO();
            boolean resp = false;
            switch (opc) {
                case 'I':
                case 'i':
                    prod = lerProduto(teclado);
                    resp = prodDAO.inserir(prod);
                    System.out.println(resp ? SUCESSO : FALHA);
                    break;
                case 'A':
                case 'a':
                    prod = lerProduto(teclado);
                    resp = prodDAO.alterar(prod);
                    System.out.println(resp ? SUCESSO : FALHA);
                    break;
                case 'C':
                case 'c':
                    System.out.println("Digite o Código: ");
                    int cod = teclado.nextInt();
                    Produto produto = prodDAO.consultar(cod);
                    if (produto != null) {
                        System.out.println(produto);
                    }
                    break;
                case 'E':
                case 'e':
                    prod = lerProduto(teclado);
                    resp = prodDAO.excluir(prod);
                    System.out.println(resp ? SUCESSO : FALHA);
                    break;
                case 'T':
                case 't':
                    Produto[] produtos = prodDAO.consultarTodos();
                    for (Produto produt : produtos) {
                        if(produt!=null){
                            System.out.println(produt);
                        }
                    }
                    break;
                default:
                    if (opc != 's' && opc != 'S') {
                        System.out.println("\n -------------------\n Opção Inválida!!! \n -------------------");
                    }
            }
        } while (opc != 's' && opc != 'S');
    }

    private static void menuCompra(Scanner teclado) {
        char opc = 's';
        do {
            System.out.println("\n\n");
            System.out.println("MENU COMPRA");
            System.out.println("-------------------");
            System.out.println("(r) Registrar");
            System.out.println("(c) Consultar compras por cliente");
            System.out.println("(e) Excluir compras por cliente");
            System.out.println("(s) Voltar");
            System.out.print("Escolha uma opção..: ");
            opc = teclado.next().charAt(0);
            Produto prod = null;
            CompraDAO compraDAO = new CompraDAO();
            boolean resp = false;
            switch (opc) {
                case 'R':
                case 'r':
                    System.out.println("Digite o CPF: ");
                    long cpf = teclado.nextLong();
                    System.out.println("Digite o código do produto: ");
                    int cod = teclado.nextInt();
                    resp = compraDAO.inserir(cpf, cod);
                    System.out.println(resp ? SUCESSO : FALHA);
                    break;
                case 'C':
                case 'c':
                    System.out.println("Digite o CPF: ");
                    long cpfC = teclado.nextLong();
                    Compra compra = compraDAO.consultarPorCliente(cpfC);
                    if (compra != null) {
                        System.out.println(compra);
                    }
                    break;
                case 'E':
                case 'e':
                    System.out.println("Digite o CPF: ");
                    long cpfE = teclado.nextLong();
                    resp = compraDAO.excluir(cpfE);
                    System.out.println(resp ? SUCESSO : FALHA);
                    break;
                default:
                    if (opc != 's' && opc != 'S') {
                        System.out.println("\n -------------------\n Opção Inválida!!! \n -------------------");
                    }
            }
        } while (opc != 's' && opc != 'S');
    }

    private static Cliente lerCliente(Scanner teclado) {
        Cliente cli = new Cliente();
        System.out.println("\n\n");
        System.out.println("Digite os dados do cliente");
        System.out.println("----------------------------");
        System.out.println("Digite o CPF: ");
        cli.setCpf(teclado.nextLong());
        System.out.println("Digite o nome: ");
        cli.setNome(teclado.next());
        System.out.println("Digite a idade: ");
        cli.setIdade(teclado.nextInt());
        return cli;
    }

    private static Produto lerProduto(Scanner teclado) {
        Produto prod = new Produto();
        System.out.println("\n\n");
        System.out.println("Digite os dados do produto");
        System.out.println("----------------------------");
        System.out.println("Digite o Código: ");
        prod.setCodigo(teclado.nextInt());
        System.out.println("Digite o nome: ");
        prod.setNome(teclado.next());
        System.out.println("Digite a quantidade em estoque: ");
        prod.setIntqtdEstoque(teclado.nextInt());
        return prod;
    }

}
