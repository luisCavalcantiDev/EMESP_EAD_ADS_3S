package lanchonete.modelo;

/**
 *
 * @author sakurai
 */
public class Pedido {
  private String lanche = "";
  private double precoLanche = 0.0;
  private String batataFrita = "";
  private double precoBatataFrita = 0.0;
  private String ingredientes = "";
  private double precoIngredientes = 0.0;

  public String getLanche() {
    return lanche;
  }

  public void setLanche(String lanche) {
    this.lanche = lanche;
  }

  public String getBatataFrita() {
    return batataFrita;
  }

  public void setBatataFrita(String batataFrita) {
    this.batataFrita = batataFrita;
  }

  public String getIngredientes() {
    return ingredientes;
  }

  public void setIngredientes(String ingredientes) {
    this.ingredientes = ingredientes;
  }

  public double getPrecoLanche() {
    return precoLanche;
  }

  public void setPrecoLanche(double precoLanche) {
    this.precoLanche = precoLanche;
  }

  public double getPrecoBatataFrita() {
    return precoBatataFrita;
  }

  public void setPrecoBatataFrita(double precoBatataFrita) {
    this.precoBatataFrita = precoBatataFrita;
  }

  public double getPrecoIngredientes() {
    return precoIngredientes;
  }

  public void setPrecoIngredientes(double precoIngredientes) {
    this.precoIngredientes = precoIngredientes;
  }

  public double getTotal() {
    return precoLanche + precoBatataFrita + precoIngredientes;
  }

}
