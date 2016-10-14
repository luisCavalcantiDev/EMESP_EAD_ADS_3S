package br.metodista.ead.scs15.modelos;

public class Aluno {
    
    private String _RA;
    private String _nome;
    private int _idade;
    private String _polo;    

    public Aluno(String _RA, String _nome, int _idade, String _polo) {
        this._RA = _RA;
        this._nome = _nome;
        this._idade = _idade;
        this._polo = _polo;
    }

    public Aluno() {
    }

    public String getRA() {
        return _RA;
    }

    public void setRA(String _RA) {
        this._RA = _RA;
    }

    public String getNome() {
        return _nome;
    }

    public void setNome(String _nome) {
        this._nome = _nome;
    }

    public int getIdade() {
        return _idade;
    }

    public void setIdade(int _idade) {
        this._idade = _idade;
    }

    public String getPolo() {
        return _polo;
    }

    public void setPolo(String _polo) {
        this._polo = _polo;
    }
}
