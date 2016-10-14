package br.metodista.ead.scs152.main;

import br.metodista.ead.scs152.interfaces.*;
import java.util.LinkedList;

public class RepositorioDouble implements Operador<Double> {
    
    private LinkedList<Double> _container;
    
    public RepositorioDouble(){
        _container = new LinkedList<Double>();
    }
    
    public void adicionar(Double numero){
        _container.add(numero);
    }

    @Override
    public Double somar() {
        Double _total = new Double(0);
        
        for (int i = 0; i < _container.size(); i++) {
            _total += _container.get(i);
        }
        
        return _total;
    }

    @Override
    public Double subtracao() {
        Double _total = new Double(0);
        
        for (int i = 0; i < _container.size(); i++) {
            _total -= _container.get(i);
        }
        
        return _total;
    }

    @Override
    public Double dividir() {
        Double _total = new Double(0);
        
        for (int i = 0; i < _container.size(); i++) {
            _total /= _container.get(i);              
        }
        
        return _total;
    }

    @Override
    public Double multiplicar() {
        Double _total = new Double(0);
        
        for (int i = 0; i < _container.size(); i++) {
            _total *= _container.get(i);              
        }
        
        return _total;
    }

    @Override
    public Double modulo() {
        Double _total = new Double(0);
        
        for (int i = 0; i < _container.size(); i++) {
            _total %= _container.get(i);
        }
        
        return _total;
    }
    
    
    
}
