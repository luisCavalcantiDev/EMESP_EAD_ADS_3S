package br.metodista.ead.scs152.main;

import br.metodista.ead.scs152.interfaces.*;
import java.util.LinkedList;

public class RepositorioFloat implements Operador<Float> {
    
    private LinkedList<Float> _container;
    
    public RepositorioFloat(){
        _container = new LinkedList<Float>();
    }
    
    public void adicionar(Float numero){
        _container.add(numero);
    }

    @Override
    public Float somar() {
        Float _total = new Float(0);
        
        for (int i = 0; i < _container.size(); i++) {
            _total += _container.get(i);
        }
        
        return _total;
    }

    @Override
    public Float subtracao() {
        Float _total = new Float(0);
        
        for (int i = 0; i < _container.size(); i++) {
            _total -= _container.get(i);
        }
        
        return _total;
    }

    @Override
    public Float dividir() {
        Float _total = new Float(0);
        
        for (int i = 0; i < _container.size(); i++) {
            _total /= _container.get(i);              
        }
        
        return _total;
    }

    @Override
    public Float multiplicar() {
        Float _total = new Float(0);
        
        for (int i = 0; i < _container.size(); i++) {
            _total *= _container.get(i);              
        }
        
        return _total;
    }

    @Override
    public Float modulo() {
        Float _total = new Float(0);
        
        for (int i = 0; i < _container.size(); i++) {
            _total %= _container.get(i);
        }
        
        return _total;
    }
    
    
    
}
