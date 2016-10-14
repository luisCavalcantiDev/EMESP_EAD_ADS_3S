/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import entidades.Cliente;

/**
 *
 * @author cristianocamilo
 */
public class ClienteDAO {

    public boolean inserir(Cliente ent) {
        Conexao con = new Conexao();
        int result = con.executarDML("INSERT INTO CLIENTE VALUES ("+ ent.getCpf() +"," 
                + "'" + ent.getNome() + "',"
                + ent.getIdade() + ")");
        if(result>0){
            return true;
        }
        return false;
    }

    public boolean excluir(Cliente ent) {
        Conexao con = new Conexao();
        int result = con.executarDML("DELETE FROM CLIENTE WHERE CPF = " 
                + ent.getCpf() );
        if(result>0){
            return true;
        }
        return false;
    }

    public boolean alterar(Cliente ent) {
        Conexao con = new Conexao();
        int result = con.executarDML("UPDATE CLIENTE SET NOME = '" 
                + ent.getNome() + "' , IDADE = " + ent.getIdade() 
                + "  WHERE CPF = "+ ent.getCpf() +"," );
        if(result>0){
            return true;
        }
        return false;
    }

    public Cliente consultar(long cpf) {
        Conexao con = new Conexao();
        Cliente[] clientes = con.executarSQLCliente("SELECT * FROM CLIENTE WHERE CPF = " + cpf);
        if(clientes!=null){
            return clientes[0];
        }
        return null;
    }
    
    public Cliente[] consultarTodos() {
        Conexao con = new Conexao();
        Cliente[] clientes = con.executarSQLCliente("SELECT * FROM CLIENTE ");
        if(clientes!=null){
            return clientes;
        }
        return null;
    }
    
}
