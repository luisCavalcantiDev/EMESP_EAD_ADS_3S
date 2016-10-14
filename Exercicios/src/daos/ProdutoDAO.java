/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import entidades.Cliente;
import entidades.Produto;

/**
 *
 * @author cristianocamilo
 */
public class ProdutoDAO {

    public boolean inserir(Produto ent) {
        Conexao con = new Conexao();
        int result = con.executarDML("INSERT INTO PRODUTO VALUES ("+ ent.getCodigo()+"," 
                + "'" + ent.getNome() + "' , " + ent.getIntqtdEstoque()+ " )");
        if(result>0){
            return true;
        }
        return false;
    }

    public boolean excluir(Produto ent) {
        Conexao con = new Conexao();
        int result = con.executarDML("DELETE FROM PRODUTO WHERE CODIGO = " 
                + ent.getCodigo());
        if(result>0){
            return true;
        }
        return false;
    }

    public boolean alterar(Produto ent) {
        Conexao con = new Conexao();
        int result = con.executarDML("UPDATE PRODUTO SET NOME = '" 
                + ent.getNome() + "' , QTD_ESTOQUE = " + ent.getIntqtdEstoque()
                + "  WHERE CODIGO = "+ ent.getCodigo() );
        if(result>0){
            return true;
        }
        return false;
    }

    public Produto consultar(int codigo) {
        Conexao con = new Conexao();
        Produto[] produtos = con.executarSQLProduto("SELECT * FROM PRODUTO WHERE CODIGO = " + codigo);
        if(produtos!=null){
            return produtos[0];
        }
        return null;
    }
    
    public Produto[] consultarTodos() {
        Conexao con = new Conexao();
        Produto[] produtos = con.executarSQLProduto("SELECT * FROM PRODUTO ");
        if(produtos!=null){
            return produtos;
        }
        return null;
    }
    
}
