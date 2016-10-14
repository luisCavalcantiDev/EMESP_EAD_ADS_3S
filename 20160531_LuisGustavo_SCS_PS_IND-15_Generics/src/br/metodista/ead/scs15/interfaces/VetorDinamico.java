package br.metodista.ead.scs15.interfaces;

public interface VetorDinamico<T> {

// Remove o ultimo elemento do vetor
    public T removerUltimoElemento();

// Adiciona elemento no vetor
    public void adicionarElemento(T elemento);

// substitui o elemento da posição solicitada por outro
    public void substituirElemento(T elemento, int posicao);

// Remove o elemento da posição indicada. Os elementos restantes devem ser reorganizados para “eliminar” a lacuna
    public void eliminarPosicao(int posicao);
}
