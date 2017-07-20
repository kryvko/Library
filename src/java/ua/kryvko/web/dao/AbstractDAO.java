/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.kryvko.web.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import ua.kryvko.web.beans.DBBean;
import ua.kryvko.web.names.ResourseNames;

/**
 *
 * @author Artem Kryvko
 */
public abstract class AbstractDAO<T extends DBBean> implements GenericDAO<T>{
    
    /**
     * @return SQL query to retrieve all records
     * 
     * SELECT * FROM [Table]
     */
    protected abstract String getSelectQuery();
    
    /**
     * @return SQL query to retrieve record by UUID
     * 
     * SELECT * FROM [Table] WHERE id = ...
     */
    protected String getSelectByIdQuery(Long id) {
        return getSelectQuery() + " WHERE id = " + id;
    }
    
    /**
     * Parse Result Set
     * @param rs 
     * @return list of T-type relevant data in table
     */
    protected abstract List<T> parseResultSet(ResultSet rs);

    protected Connection getConnection() {
        Connection conn = null;
        try {
            InitialContext ic = new InitialContext();
            DataSource ds = (DataSource) ic.lookup(ResourseNames.JNDI);
            conn = ds.getConnection();
        } catch (NamingException ex) {
            Logger.getLogger(AbstractDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AbstractDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conn;
    }

    @Override
    public List<T> getAll() {
        return getDataBySQL(getSelectQuery());
    }

    @Override
    public T getDataById(Long id) {
        return getDataBySQL(getSelectByIdQuery(id)).get(0);
    }
    
    @Override
    public List<T> getDataBySQL(String sqlQuery) {
        List<T> list = null;
        try(Connection conn = getConnection()) {
            try(Statement st = conn.createStatement()) {
                try(ResultSet rs = st.executeQuery(sqlQuery)) {
                    list = parseResultSet(rs);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(AbstractDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

}
