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
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;
import ua.kryvko.web.beans.Author;
import ua.kryvko.web.db.Database;

/**
 *
 * @author Artem Kryvko
 */
public class AuthorList extends BeanListImpl<Author> {
    public static final String TABLE = "author";
    public static final String ID = "id";
    public static final String FIO = "fio";
    public static final String BIRTHDAY = "birthday";
    
    @Override
    void getData() {
        try(Connection conn = Database.getConnection()) {
            try(Statement st = conn.createStatement()) {
                try(ResultSet rs = st.executeQuery(QUERY + TABLE)) {
                    while(rs.next()) {
                        Author author = new Author();
                        author.setId(rs.getLong(ID));
                        author.setFio(rs.getString(FIO));
                        author.setBirthday(rs.getDate(BIRTHDAY));
                        beanList.add(author);
                    }
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(AuthorList.class.getName()).log(Level.SEVERE, null, ex);
        }
        Collections.sort(beanList, AuthorList::authorCompare);
    }
    
    private static int authorCompare(Author ob1, Author ob2) {
            return String.valueOf(ob1.getFio()).compareTo(ob2.getFio());
    }
    
}
