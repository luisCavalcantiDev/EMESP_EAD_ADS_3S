package br.metodista.ead.scs13.enumeracoes;

public enum Cursos {
    ADS("Análise e Desenvolvimento de Sistemas", "Exatas"),
    TI("Gestão em Tecnologia da Informaçao", "Extatas"),
    RH("Gestão de Recursos Houmanos", "Humanas"),
    ADM("Administração de Empresas", "Humanas");

    private String _nome;
    private String _tipo;

    public String getNome() {
        return _nome;
    }

    public String getTipo() {
        return _tipo;
    }

    private Cursos(String nome, String tipo) {
        _nome = nome;
        _tipo = tipo;
    }
}
