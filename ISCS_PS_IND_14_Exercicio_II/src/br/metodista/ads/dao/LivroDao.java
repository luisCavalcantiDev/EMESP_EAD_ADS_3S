package br.metodista.ads.dao;

import br.metodista.ads.modelos.Livro;
import java.sql.*;
import java.util.*;
import java.util.logging.*;

public class LivroDao extends BaseDao {

    public LivroDao() {
        super();
    }

    public void inserir(Livro livro) {
       int _ret = 0;
       String _query = "INSERT INTO LIVROS(ID, TITULO, AUTOR, ISBN, PAGINAS, EDICAO)VALUES(LIVROS_LIVROS_SEQ.NEXTVAL, ?,?,?,?,?)";
       
        try(PreparedStatement _cmd = this.getConn().prepareStatement(_query)){
            _cmd.setString(1,livro.getTitulo());
            _cmd.setString(2,livro.getAutor());
            _cmd.setString(3,livro.getIsbn());
            _cmd.setInt(4,livro.getPaginas());
            _cmd.setInt(5,livro.getEdicao());
            
            _ret = _cmd.executeUpdate();
            if (_ret <= 0) {
                throw new SQLException("Erro ao inserir Livro --> query: " + _query);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void atualizar(Livro livro) {
       int _ret = 0;
       String _query = "UPDATE LIVROS "
               + "SET AUTOR = ?, "
               + "ISBN = ?, "
               + "PAGINAS = ?, "
               + "EDICAO = ?  "
               + "WHERE ID = ?";
       
        try(PreparedStatement _cmd = this.getConn().prepareStatement(_query)){
           _cmd.setString(1,livro.getAutor());
            _cmd.setString(2,livro.getIsbn());
            _cmd.setInt(3,livro.getPaginas());
            _cmd.setInt(4,livro.getEdicao());
            _cmd.setInt(5,livro.getID());
            
            _ret = _cmd.executeUpdate();
            if (_ret <= 0) {
                throw new SQLException("Erro ao atualizar Livro --> query: " + _query);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List<Livro>listar(){
        List<Livro> _ret = new ArrayList();
        String _query = "SELECT ID, TITULO, AUTOR, ISBN, PAGINAS, EDICAO FROM LIVROS ORDER BY ID";
        
        try(Statement _cmd = this.getConn().createStatement()){
           ResultSet _rs = _cmd.executeQuery(_query);
            while (_rs.next()) {
                Livro _livro = new Livro();
                _livro.setID(_rs.getInt("ID"));
                _livro.setTitulo(_rs.getString("TITULO"));
                _livro.setAutor(_rs.getString("AUTOR"));
                _livro.setIsbn(_rs.getString("ISBN"));
                _livro.setPaginas(_rs.getInt("PAGINAS"));
                _livro.setEdicao(_rs.getInt("EDICAO"));
                
                _ret.add(_livro);
            }
        }catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return _ret;
    }
    
    public void excluir(int idLivro) {
        int _ret = 0;
        String _query = "DELETE FROM LIVROS WHERE ID = ?";

        try (PreparedStatement _cmd = this.getConn().prepareStatement(_query)) {
            _cmd.setInt(1, idLivro);

            _ret = _cmd.executeUpdate();
            if (_ret <= 0) {
                throw new SQLException("Erro ao excluir Livro --> query: " + _query);
            }

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
