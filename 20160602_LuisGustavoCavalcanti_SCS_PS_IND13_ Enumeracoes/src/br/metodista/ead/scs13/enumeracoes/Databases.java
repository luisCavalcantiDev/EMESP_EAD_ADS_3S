package br.metodista.ead.scs13.enumeracoes;

public enum Databases {
    ORACLE("Oracle","XE11"),
    MSSQLSERVER("Microsoft","2014"),
    POSTGRESQL("PostgreSQL.org","9.6"),
    MYSQL("MySQL.com","5.7");
    
    private String _fornecedor;
    private String _versao;

    private Databases(String _fornecedor, String _versao) {
        this._fornecedor = _fornecedor;
        this._versao = _versao;
    }

    public String getFornecedor() {
        return _fornecedor;
    }

    public String getVersao() {
        return _versao;
    }  
}
