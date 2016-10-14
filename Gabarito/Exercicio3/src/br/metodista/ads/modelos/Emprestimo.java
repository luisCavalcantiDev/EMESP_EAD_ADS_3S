package br.metodista.ads.modelos;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Rafael Guimarães Sakurai
 */
public class Emprestimo {
  private Livro livro;
  private Usuario usuario;
  private Date dataEmprestimo;
  private Date dataDevolucao;

  public Livro getLivro() {
    return livro;
  }

  public void setLivro(Livro livro) {
    this.livro = livro;
  }

  public Usuario getUsuario() {
    return usuario;
  }

  public void setUsuario(Usuario usuario) {
    this.usuario = usuario;
  }

  public Date getDataEmprestimo() {
    return dataEmprestimo;
  }

  public void setDataEmprestimo(Date dataEmprestimo) {
    this.dataEmprestimo = dataEmprestimo;
  }

  public Date getDataDevolucao() {
    return dataDevolucao;
  }

  public void setDataDevolucao(Date dataDevolucao) {
    this.dataDevolucao = dataDevolucao;
  }
  
  public Object[] carregarGrid() {
    DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
    return new Object[] {getUsuario().getNome(), livro.getTitulo(), df.format(getDataEmprestimo())};
  }
}
