package br.metodista.ead.scs13.enumeracoes;

public enum Tecnologias {
    NET(".NET Framework","Microsoft"),
    JAVA("Plataforma Java","Oracle"),
    NODE_JS("Node JavaScript Server","Node.Org"),
    ANGULAR_JS("Angular JavaScript Client","Google");
    
    private String _descricao;
    private String _empresa;

    public String getDescricao() {
        return _descricao;
    }

    public String getEmpresa() {
        return _empresa;
    }

    private Tecnologias(String descricao, String empresa){
        _descricao = descricao;
        _empresa = empresa;
    }
}
