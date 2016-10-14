package br.com.metodista.ead.iscs17.modelo;

public class Aluno {

    private String nome;
    private String matricula;
    private int vitorias;
    private int derrotas;

    public Aluno(String nome, String matricula, int vitorias, int derrotas) {
        this.nome = nome;
        this.matricula = matricula;
        this.vitorias = vitorias;
        this.derrotas = derrotas;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public int getVitorias() {
        return vitorias;
    }

    public void setVitorias(int vitorias) {
        this.vitorias = vitorias;
    }

    public int getDerrotas() {
        return derrotas;
    }

    public void setDerrotas(int derrotas) {
        this.derrotas = derrotas;
    }

}
