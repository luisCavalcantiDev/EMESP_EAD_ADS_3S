package br.metodista.ads.modelos;

public class Usuario {

    private int ID;
    private String nome;
    private String login;
    private String senha;

    public Usuario(String text, String text0, String toString) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Usuario() {
    }

    public int getID() {
        return ID;
    }

    public String getNome() {
        return nome;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Object[] getDados() {
        return new Object[]{ID, nome, login, senha};
    }
}
