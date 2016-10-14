package br.metodista.ead.scs15.main;

import br.metodista.ead.scs15.modelos.*;
import br.metodista.ead.scs15.interfaces.*;
import java.util.LinkedList;

public class RepositorioAlunos implements VetorDinamico<Aluno> {

    private LinkedList<Aluno> _container = null;
    
    public RepositorioAlunos(){
        _container   = new LinkedList<>();
    }

    @Override
    public Aluno removerUltimoElemento() {
        return _container.removeLast();
    }

    @Override
    public void adicionarElemento(Aluno elemento) {
        _container.add(elemento);
    }

    @Override
    public void substituirElemento(Aluno elemento, int posicao) {
        _container.set(posicao, elemento);
    }

    @Override
    public void eliminarPosicao(int posicao) {
        _container.remove(posicao);
    }   
}
