/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.kryvko.web.beanlists;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import ua.kryvko.web.beans.Genre;
import ua.kryvko.web.db.Database;

/**
 *
 * @author Artem Kryvko
 */
public class GenreList extends BeanListImpl<Genre> {
    public static final String TABLE = "genre";
    public static final String ID = "id";
    public static final String NAME = "name";
    
    
    @Override
    void getData() {
        try(Connection conn = Database.getConnection()) {
            try(Statement st = conn.createStatement()) {
                try(ResultSet rs = st.executeQuery(QUERY + TABLE)) {
                    while(rs.next()) {
                        Genre genre = new Genre();
                        genre.setId(rs.getLong(ID));
                        genre.setName(rs.getString(NAME));
                        beanList.add(genre);
                    }
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(GenreList.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
