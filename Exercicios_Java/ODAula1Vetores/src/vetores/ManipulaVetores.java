/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vetores;

import java.util.Scanner;

/**
 *
 * @author marcelo.modolo
 */
public class ManipulaVetores {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        // Criar o objeto da Classe Scanner
        Scanner teclado = new Scanner(System.in);

        //1.a. Crie um vetor de reais com capacidade para armazenar 50 valores; 
        double vetor[] = new double[50];

            //1.b. Crie uma variável (int) para controlar a quantidade de 
        //itens do vetor e a inicialize com zero;
        int quantidade = 0;

        //1.c. Crie uma variável (double) para receber um item;
        double item;

            //6.a. Insira oito itens no vetor usando o método inserirItem 
        //(não se esqueça de atualizar a variável com a quantidade de 
        //itens a cada número inserido);
        for (int i = 1; i <= 8; i++) {
            inserirItem(vetor, (i * 2.1), quantidade);
            quantidade++;
        }

        //6.b. Mostre todos os itens do vetor usando o método mostrarVetor;
        mostrarVetor(vetor, quantidade);

            //6.c. Leia um número digitado no teclado (use a classe Scanner) e
        //insira no vetor usando o método inserirItem (não esqueça de somar
        //um à variável quantidade se o método inserirItem retornar true));
        System.out.println("Digite o item a ser inserido: ");
        item = teclado.nextDouble();
        if (inserirItem(vetor, item, quantidade) == true) {
            quantidade++;
        } else {
            System.out.println("Não foi possível inserir. Vetor cheio");
        }

        //6.d. Mostre todos os itens do vetor usando o método mostrarVetor;
        mostrarVetor(vetor, quantidade);

            //6.e. Leia um número digitado no teclado e procure esse número 
        //no vetor usando o método procurarItem. Se o número for 
        //encontrado mostre a sua posição e se não for encontrado 
        //mostre uma mensagem informando.
        System.out.println("Digite o item a ser procurado: ");
        item = teclado.nextDouble();
        int posicao = procurarItem(vetor, item);
        if (posicao > -1) {
            System.out.println("Item encontrado na posição " + posicao);
        } else {
            System.out.println("Item não encontrado");
        }

            //6.f. Leia um número digitado no teclado e remova esse item 
        //usando o método removerItem (não se esqueça de diminuir um 
        //da variável quantidade se o item for removido);
        System.out.println("Digite o item a ser removido: ");
        item = teclado.nextDouble();
        if (removerItem(vetor, item, quantidade) == true) {
            quantidade--;
        } else {
            System.out.println("Item não encontrado");
        }

        //6.g. Mostre todos os itens do vetor usando o método mostrarVetor;
        mostrarVetor(vetor, quantidade);

        teclado.close();
    }

    /*
     2. Crie o método inserirItem que recebe como parâmetro o vetor, 
     o número real a ser inserido e a quantidade de itens do vetor. 
     O método deve inserir esse número real na posição seguinte ao 
     último item e retornar true. Caso não seja possível inserir 
     porque o vetor está cheio, deve retornar false.	
     */
    public static boolean inserirItem(double[] vet, double item, int quant) {
        if (quant >= vet.length) {
            return false;
        } else {
            vet[quant] = item;
            return true;
        }
    }

    /*
     3. Crie o método mostrarVetor que recebe como parâmetro o vetor e 
     a quantidade de itens. O método deve mostrar os itens do vetor 
     separados por um espaço.
     */
    public static void mostrarVetor(double[] vet, int quant) {
        for (int i = 0; i < quant; i++) {
            System.out.print(vet[i] + " ");
        }
        System.out.println();
    }

    /*
     4. Crie o método procurarItem que recebe como parâmetro o vetor, 
     o número real a ser procurado e a quantidade de itens do vetor. 
     O método deve percorrer o vetor procurando o número e retornar 
     seu índice quando encontrá-lo. Caso o número não seja encontrado, 
     deve retornar -1.
     */
    public static int procurarItem(double[] vet, double item) {
        for (int i = 0; i < vet.length; i++) {
            if (item == vet[i]) {
                return i;
            }
        }
        return -1;
    }

    /*
     5. Crie o método removerItem que recebe como parâmetro o vetor, 
     um número real a ser removido e a quantidade de itens do vetor. 
     O método deve procurar o item usando o método procurarItem e, 
     se encontrado, deve ser removido e todos os itens das posições 
     seguintes devem ser movidos para que a posição do item removido 
     não fique vazia. Caso o item seja removido retornar true, 
     caso não seja encontrado retornar false.
     */
    public static boolean removerItem(double[] vet, double item, int quant) {
        int pos = procurarItem(vet, item);
        if (pos > -1) {
            for (int i = pos; i < quant - 1; i++) {
                vet[i] = vet[i + 1];
            }
            return true;
        } else {
            return false;
        }
    }

}
