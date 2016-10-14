package br.metodista.ads.dao;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class BaseDao implements AutoCloseable {

    private Connection _conn;

    public Connection getConn() {
        return _conn;
    }

    public String getURL() {
        return _URL;
    }    
    private final String _URL = "jdbc:oracle:thin:LIVROS//@localhost:1521:XE";
    private final String _USER = "LIVROS";
    private final String _PASS = "123456";

    public BaseDao() {
        init();
    }

    private void init() {
        try {
            _conn = DriverManager.getConnection(_URL, _USER, _PASS);
        } catch (SQLException ex) {
            Logger.getLogger(BaseDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void close() {
        if (this._conn != null) {
            try {
                this._conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(BaseDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
