/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
/**
 *
 * @author Artem Kryvko
 */
public class TestConnection {
    
    private final static String QUERY = "SELECT * FROM genre";
    private final static String COLUMN = "name";
    private final static String ENV = "java:comp/env";
    private final static String JNDI = "jdbc/Library";
    

     
    public  static String test() {
        StringBuilder sb = new StringBuilder();
        try {
            Context initContext = new InitialContext();
            Context webContext = (Context)initContext.lookup(ENV);
            DataSource dc = (DataSource)webContext.lookup(JNDI);
            Connection con = dc.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(QUERY);
            
            while(rs.next()) {
                System.out.println(rs.getString(COLUMN));
               sb.append(rs.getString(COLUMN));
            }
        } catch (SQLException ex) {
            Logger.getLogger(TestConnection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            Logger.getLogger(TestConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
             return sb.toString();
        
    }
    
}
