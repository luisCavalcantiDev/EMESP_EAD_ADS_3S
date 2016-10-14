package br.metodista.ead.scs13.enumeracoes;

public enum Profissoes {
    DESENVOLVEDOR("Desenvolvedor de Software",5000),
    ANALISTA("Analisa de Sistemas",6000),
    GERENTE("Gerente de TI",8000),
    ADMINISTRADOR("Administrador de Empresas",3500);
    
    private String _descricao;
    private double _mediaSalario;

    public String getDescricao() {
        return _descricao;
    }

    public double getMediaSalario() {
        return _mediaSalario;
    }
    
    private Profissoes(String descricao, double mediaSalario){
        _descricao = descricao;
        _mediaSalario = mediaSalario;
    }
}
