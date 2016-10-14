package br.metodista.ads.modelos;

public class Livro {
  private int ID;    
  private String titulo;
  private String autor;
  private String isbn;
  private int paginas;
  private int edicao;
  private Emprestimo emprestimo;
  
  public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

  public String getTitulo() {
    return titulo;
  }

  public void setTitulo(String titulo) {
    this.titulo = titulo;
  }

  public String getAutor() {
    return autor;
  }

  public void setAutor(String autor) {
    this.autor = autor;
  }

  public String getIsbn() {
    return isbn;
  }

  public void setIsbn(String isbn) {
    this.isbn = isbn;
  }

  public int getPaginas() {
    return paginas;
  }

  public void setPaginas(int paginas) {
    this.paginas = paginas;
  }

  public int getEdicao() {
    return edicao;
  }

  public void setEdicao(int edicao) {
    this.edicao = edicao;
  }

  public Emprestimo getEmprestimo() {
    return emprestimo;
  }

  public void setEmprestimo(Emprestimo emprestimo) {
    this.emprestimo = emprestimo;
  }
  
  public Object[] getDados() {
    String temEmprestimo = emprestimo == null ? "Disponível" : emprestimo.getUsuario().getNome();
    return new Object[] {titulo, autor, isbn, paginas, edicao, temEmprestimo};
  }
}
