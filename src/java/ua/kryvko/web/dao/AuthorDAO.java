/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.kryvko.web.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import ua.kryvko.web.beans.Author;

/**
 *
 * @author Artem Kryvko
 */
public class AuthorDAO extends AbstractDAO<Author>{
    
    private final static String SELECT_QUERY = "SELECT * FROM author"; 
    public static final String ID = "id";
    public static final String FIO = "fio";
    public static final String BIRTHDAY = "birthday";

    @Override
    protected String getSelectQuery() {
        return SELECT_QUERY;
    }

    @Override
    protected List<Author> parseResultSet(ResultSet rs) {
        List<Author> authors = new ArrayList<>();
        try {
            while (rs.next()) {
                Author author = new Author();
                author.setId(rs.getLong(ID));
                author.setFio(rs.getString(FIO));
                author.setBirthday(rs.getDate(BIRTHDAY));
                authors.add(author);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AuthorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return authors;
    }
    
}
