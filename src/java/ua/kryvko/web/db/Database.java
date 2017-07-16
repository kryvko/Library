/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.kryvko.web.db;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author Artem Kryvko
 */
public class Database {
    private static InitialContext ic;
    private static DataSource ds;
    private static Connection conn;
    private final static String JNDI = "java:comp/env/jdbc/Library";
    
    public static Connection getConnection() {
        try {
           if(conn == null) {
                ic = new InitialContext();
                ds = (DataSource)ic.lookup(JNDI);
                conn = ds.getConnection();
            }
            if(conn.isClosed()) {
                conn = ds.getConnection();
            }
        } catch (NamingException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conn;
    }
    
}
