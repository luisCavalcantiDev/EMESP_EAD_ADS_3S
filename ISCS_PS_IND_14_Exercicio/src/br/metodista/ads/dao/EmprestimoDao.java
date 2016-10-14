package br.metodista.ads.dao;

import br.metodista.ads.modelos.Emprestimo;
import br.metodista.ads.modelos.Livro;
import br.metodista.ads.modelos.Usuario;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.*;

public class EmprestimoDao extends BaseDao {
    
    public EmprestimoDao(){
        super();
    }
    
    public void inserir(Emprestimo emprestimo) {
       int _ret = 0;
       String _query = "";
       
        try(Statement _cmd = this.getConn().createStatement()){
            DateFormat df = new SimpleDateFormat("yyyyMMdd");
            
            _query = "INSERT INTO EMPRESTIMOS(ID, ID_USUARIO, ID_LIVRO, DT_EMP)"
                    + "VALUES(EMPRESTIMO_LIVROS_SEQ.NEXTVAL, "
                    + emprestimo.getUsuario().getID() + ","
                    + emprestimo.getLivro().getID() + ","
                    + "TO_DATE('" + df.format(emprestimo.getDataEmprestimo()) + "','YYYYMMDD'))";
            
            _ret = _cmd.executeUpdate(_query);
            if (_ret <= 0) {
                throw new SQLException("Erro ao inserir Livro --> query: " + _query);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Emprestimo listar(int ID) {
        Emprestimo _ret = null;
        String _query = "SELECT ID, ID_USUARIO, ID_LIVRO, DT_EMP, DT_DEVOL FROM EMPRESTIMOS WHERE (ID = " + ID + " AND DT_DEVOL IS NULL)" ;

        try (Statement _cmd = this.getConn().createStatement()) {
            ResultSet _rs = _cmd.executeQuery(_query);
            while (_rs.next()) {
                _ret = new Emprestimo();
                _ret.setID(_rs.getInt("ID"));
                _ret.setUsuario(this.listarParaRegistrarEmprestimo(_rs.getInt("ID_USUARIO")));
                _ret.setLivro(this.listarParaRetirarLivro(_rs.getInt("ID_LIVRO")));
                _ret.setDataEmprestimo(_rs.getDate("DT_EMP"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return _ret;
    }
    
    public List<Emprestimo> listar() {
        List<Emprestimo> _ret = new ArrayList();
        String _query = "SELECT ID, ID_USUARIO, ID_LIVRO, DT_EMP FROM EMPRESTIMOS WHERE DT_DEVOL IS NULL ORDER BY ID" ;

        try (Statement _cmd = this.getConn().createStatement()) {
            ResultSet _rs = _cmd.executeQuery(_query);
            while (_rs.next()) {
                Emprestimo emprestimo = new Emprestimo();
                emprestimo.setID(_rs.getInt("ID"));
                emprestimo.setUsuario(this.listarParaRegistrarEmprestimo(_rs.getInt("ID_USUARIO")));
                emprestimo.setLivro(this.listarParaRetirarLivro(_rs.getInt("ID_LIVRO")));
                emprestimo.setDataEmprestimo(_rs.getDate("DT_EMP"));
                
                _ret.add(emprestimo);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return _ret;
    }
    
    public List<Livro>listarParaEmprestimos(){
        List<Livro> _ret = new ArrayList();
        String _query = "SELECT L.ID, TITULO, AUTOR, ISBN, PAGINAS, EDICAO, E.ID AS EMPRESTIMO "
                + "FROM LIVROS L"
                + " LEFT JOIN EMPRESTIMOS E ON (L.ID = E.ID_LIVRO AND E.DT_DEVOL IS NULL) "
                + " WHERE E.DT_DEVOL IS NULL "
                + "ORDER BY L.ID";
        
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
                _livro.setEmprestimo(this.listar(_rs.getInt("EMPRESTIMO")));
                
                _ret.add(_livro);
            }
        }catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return _ret;
    }
    
    public Usuario listarParaRegistrarEmprestimo(int ID){
        Usuario _ret = null;
        String _query = "SELECT ID, NOME, LOGIN FROM USUARIOS WHERE ID = " + ID;
        
        try(Statement _cmd = this.getConn().createStatement()){
           ResultSet _rs = _cmd.executeQuery(_query);
            while (_rs.next()) {
                _ret = new Usuario();
                _ret.setID(_rs.getInt("ID"));
                _ret.setNome(_rs.getString("NOME"));
                _ret.setLogin(_rs.getString("LOGIN"));
            }
        }catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return _ret;
    }
    
    public Livro listarParaRetirarLivro(int ID){
        Livro _ret = null;
        String _query = "SELECT ID, TITULO, AUTOR, ISBN, PAGINAS, EDICAO FROM LIVROS WHERE ID = " + ID;
        
        try(Statement _cmd = this.getConn().createStatement()){
           ResultSet _rs = _cmd.executeQuery(_query);
            while (_rs.next()) {
                _ret = new Livro();
                _ret.setID(_rs.getInt("ID"));
                _ret.setTitulo(_rs.getString("TITULO"));
                _ret.setAutor(_rs.getString("AUTOR"));
                _ret.setIsbn(_rs.getString("ISBN"));
                _ret.setPaginas(_rs.getInt("PAGINAS"));
                _ret.setEdicao(_rs.getInt("EDICAO"));
            }
        }catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return _ret;
    }
    
    public void atualizar(Emprestimo emprestimo) {
       int _ret = 0;
       String _query = "UPDATE EMPRESTIMOS "
               + "SET DT_DEVOL = TO_DATE(?,'YYYYMMDD') WHERE ID = ?";
       
        try(PreparedStatement _cmd = this.getConn().prepareStatement(_query)){
           DateFormat df = new SimpleDateFormat("yyyyMMdd");
            _cmd.setString(1,df.format(emprestimo.getDataDevolucao()));                             
            _cmd.setInt(2,emprestimo.getID());
            
            _ret = _cmd.executeUpdate();
            if (_ret <= 0) {
                throw new SQLException("Erro ao atualizar Emprestimo --> query: " + _query);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }       
}
