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
import ua.kryvko.web.names.AuthorCols;

/**
 *
 * @author Artem Kryvko
 */
public class AuthorDAO extends AbstractDAO<Author>{
    
    private final static String SELECT_QUERY = "SELECT * FROM author"; 

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
                author.setId(rs.getLong(AuthorCols.ID));
                author.setFio(rs.getString(AuthorCols.FIO));
                author.setBirthday(rs.getDate(AuthorCols.BIRTHDAY));
                authors.add(author);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AuthorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return authors;
    }
 
}
