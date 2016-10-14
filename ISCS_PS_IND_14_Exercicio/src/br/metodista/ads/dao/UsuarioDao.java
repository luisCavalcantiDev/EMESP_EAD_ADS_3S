package br.metodista.ads.dao;

import br.metodista.ads.modelos.Usuario;
import java.sql.*;
import java.util.*;
import java.util.logging.*;

public class UsuarioDao extends BaseDao {

    public UsuarioDao() {
        super();
    }

    public void inserir(Usuario usuario) {
       int _ret = 0;
       String _query = "INSERT INTO USUARIOS(ID, NOME, LOGIN,SENHA)VALUES(USUARIOS_LIVROS_SEQ.NEXTVAL, ?,?,?)";
       
        try(PreparedStatement _cmd = this.getConn().prepareStatement(_query)){
            _cmd.setString(1,usuario.getNome());
            _cmd.setString(2,usuario.getLogin());
            _cmd.setString(3,usuario.getSenha());
            
            _ret = _cmd.executeUpdate();
            if (_ret <= 0) {
                throw new SQLException("Erro ao inserir Usuario --> query: " + _query);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void atualizar(Usuario usuario) {
       int _ret = 0;
       String _query = "UPDATE USUARIOS SET NOME = ?, SENHA = ? WHERE ID = ?";
       
        try(PreparedStatement _cmd = this.getConn().prepareStatement(_query)){
            _cmd.setString(1,usuario.getNome());
            _cmd.setString(2,usuario.getSenha());
            _cmd.setInt(3,usuario.getID());
            
            _ret = _cmd.executeUpdate();
            if (_ret <= 0) {
                throw new SQLException("Erro ao atualizar Usuario --> query: " + _query);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List<Usuario>listar(){
        List<Usuario> _ret = new ArrayList();
        String _query = "SELECT ID, NOME, LOGIN FROM USUARIOS ORDER BY ID";
        
        try(Statement _cmd = this.getConn().createStatement()){
           ResultSet _rs = _cmd.executeQuery(_query);
            while (_rs.next()) {
                Usuario _usuario = new Usuario();
                _usuario.setID(_rs.getInt("ID"));
                _usuario.setNome(_rs.getString("NOME"));
                _usuario.setLogin(_rs.getString("LOGIN"));
                
                _ret.add(_usuario);
            }
        }catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return _ret;
    }        
    
    public void excluir(int idUsuario) {
        int _ret = 0;
        String _query = "DELETE FROM USUARIOS WHERE ID = ?";

        try (PreparedStatement _cmd = this.getConn().prepareStatement(_query)) {
            _cmd.setInt(1, idUsuario);

            _ret = _cmd.executeUpdate();
            if (_ret <= 0) {
                throw new SQLException("Erro ao excluir Usuario --> query: " + _query);
            }

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
