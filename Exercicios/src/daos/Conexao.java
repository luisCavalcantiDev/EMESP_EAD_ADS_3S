/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import entidades.Cliente;
import entidades.Compra;
import entidades.Produto;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author cristianocamilo
 */
class Conexao {

    Connection con;
    
    public static void main(String[] args) {
        Conexao c = new Conexao();
        c.conectar();
        Cliente[] c2 = c.executarSQLCliente("SELECT * FROM CLIENTE");
        System.out.println(Arrays.toString(c2));
        c.desconectar();
    }

    private void conectar() {
        try {
            DriverManager.registerDriver(new org.apache.derby.jdbc.ClientDriver());
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/ads3exc1", "ads3", "ads3");
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void desconectar() {
        try {
            this.con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Cliente[] executarSQLCliente(String sql) {
        Cliente[] retorno = null;
        this.conectar();
        Statement stm;
        try {
            stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            if (rs != null) {
                retorno = this.processarRSCliente(rs);
            }
            stm.close();
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.desconectar();
        return retorno;
    }

    private Cliente[] processarRSCliente(ResultSet rs) {
        Cliente[] produtos = new Cliente[1000];
        int cont = 0;
        try {
            while(rs.next()){
                Cliente cli = new Cliente();
                cli.setNome(rs.getString("NOME"));
                cli.setIdade(rs.getInt("IDADE"));
                cli.setCpf(rs.getLong("CPF"));
                produtos[cont++] = cli;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return produtos;
    }

    public Produto[] executarSQLProduto(String sql) {
        Produto[] retorno = null;
        this.conectar();
        Statement stm;
        try {
            stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            if (rs != null) {
                retorno = this.processarRSProduto(rs);
            }
            stm.close();
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.desconectar();
        return retorno;
    }

    private Produto[] processarRSProduto(ResultSet rs) {
        Produto[] produtos = new Produto[1000];
        int cont = 0;
        try {
            while(rs.next()){
                Produto prod = new Produto();
                prod.setNome(rs.getString("NOME"));
                prod.setCodigo(rs.getInt("CODIGO"));
                prod.setIntqtdEstoque(rs.getInt("QTD_ESTOQUE"));
                produtos[cont++] = prod;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return produtos;
    }
    
    public Compra executarSQLCompra(Long cpf) {
        Compra retorno = null;
        this.conectar();
        Statement stm;
        try {
            stm = con.createStatement();
            Cliente[] cc = this.executarSQLCliente("SELECT * FROM CLIENTE WHERE CPF = " + cpf);
            Cliente cli = null;
            if(cc!=null){
                cli = cc[0];
            } else {
                return null;
            }
            ResultSet rs = stm.executeQuery("SELECT * FROM COMPRA WHERE CLIENTE_CPF = " + cpf);
            if (rs != null) {
                retorno = this.processarRSCompra(rs);
            } else {
                return null;
            }
            if(retorno!=null){
                retorno.setClienteCpf(cli);
            }
            stm.close();
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.desconectar();
        return retorno;
    }

    private Compra processarRSCompra(ResultSet rs) {
        Compra compra = null;
        Produto[] produtos = new Produto[1000];
        int cont = 0;
        try {
            while(rs.next()){
                Produto[] prod = this.executarSQLProduto("SELECT * FROM PRODUTO WHERE CODIGO = " + rs.getInt("PRODUTO_CODIGO")); 
                if(prod!=null){
                    produtos[cont++] = prod[0];
                    if(compra==null){
                        compra = new Compra();
                    }
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(compra!=null){
            compra.setProdutos(produtos);
        }
        return compra;
    }
    
    public int executarDML(String sql) {
        Statement stm;
        int resp = 0;
        try {
            this.conectar();
            stm = con.createStatement();
            resp = stm.executeUpdate(sql);
            this.desconectar();
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resp;
    }

}
