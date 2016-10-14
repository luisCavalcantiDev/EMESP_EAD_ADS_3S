package br.metodista.ead.scs152.interfaces;

public interface Operador<T extends Number> {
    
    //Retorna o valor da soma dos valores
    public T somar();

    //Retorna o valor da subtração dos valores
    public T subtracao();

    //Retorna o valor da divisão dos valores
    public T dividir();

    //Retorna o valor da multiplicação dos valores
    public T multiplicar();

    //Retorna o valor do resto da divisão entre os dois números
    public T modulo();
}
