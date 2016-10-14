/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

public class Compra  extends GenericEntity {
    private static final long serialVersionUID = 1L;
    private Cliente cliente;
    private Produto[] produtos;

    public Compra() {
    }

    public Cliente getClienteCpf() {
        return cliente;
    }

    public void setClienteCpf(Cliente clienteCpf) {
        this.cliente = clienteCpf;
    }

    public Produto[] getProdutos() {
        return produtos;
    }

    public void setProdutos(Produto[] produtos) {
        this.produtos = produtos;
    }
    
    @Override
    public String toString() {
        String resp = this.cliente.toString();
        resp += "\n";
        for(Produto prod : this.produtos){
            if(prod !=null){
                resp += "\t" + prod.toString() + "\n";
            }
        }
        return resp;
    }
}
