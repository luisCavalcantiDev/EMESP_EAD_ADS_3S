/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import entidades.Compra;
import entidades.Produto;

/**
 *
 * @author cristianocamilo
 */
public class CompraDAO {

    public boolean inserir(long cpf,int codigo) {
        ProdutoDAO prodDAO =new ProdutoDAO();
        Produto prod = prodDAO.consultar(codigo);
        if(prod.getIntqtdEstoque()<=0){
            System.out.println("\n");
            System.out.println("###############################################");
            System.out.println("Quantidade em estoque de produtos insuficiente!");
            System.out.println("###############################################");
            return false;
        }
        prod.setIntqtdEstoque(prod.getIntqtdEstoque()-1);
        prodDAO.alterar(prod);
        Conexao con = new Conexao();
        int result = con.executarDML("INSERT INTO COMPRA VALUES (" + cpf + "," + codigo + ")");
        if(result>0){
            return true;
        }
        return false;
    }

    public boolean excluir(long cpf) {
        Conexao con = new Conexao();
        int result = con.executarDML("DELETE FROM COMPRA WHERE CLIENTE_CPF = " 
                + cpf);
        if(result>0){
            return true;
        }
        return false;
    }

    public Compra consultarPorCliente(long cpf) {
        Conexao con = new Conexao();
        Compra compra = con.executarSQLCompra(cpf);
        if(compra!=null){
            return compra;
        }
        return null;
    }
    
}
