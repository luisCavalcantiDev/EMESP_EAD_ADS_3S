package br.metodista.ead.scs13.enumeracoes;

public enum PolosMetodista {
    SALVADOR(29, "Bahia"),
    FORTALEZA(23, "Ceará"),
    BRASILIA(53, "Distrito Federal"),
    SANTOS(35,"São Paulo");
    
    private int _UF;
    private String _nomeEstado;

    public int getUF() {
        return _UF;
    }

    public String getNomeEstado() {
        return _nomeEstado;
    }
    
    private PolosMetodista(int UF, String nomeEstado){
        _UF = UF;
        _nomeEstado = nomeEstado;
    }
}
