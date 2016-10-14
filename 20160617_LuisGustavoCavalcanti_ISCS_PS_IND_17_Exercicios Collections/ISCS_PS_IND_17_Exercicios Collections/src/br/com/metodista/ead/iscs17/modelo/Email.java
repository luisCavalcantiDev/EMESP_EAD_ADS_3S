package br.com.metodista.ead.iscs17.modelo;

public class Email {

    private String destinatario;
    private String assunto;
    private String conteudo;

    public Email(String destinatario, String assunto, String conteudo) {
        this.destinatario = destinatario;
        this.assunto = assunto;
        this.conteudo = conteudo;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    @Override
    public String toString() {
        return "Email{" + "destinatario=" + destinatario + ", assunto=" + assunto + ", conteudo=" + conteudo + '}';
    }    
}
