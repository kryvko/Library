/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.kryvko.web.logic;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import ua.kryvko.web.beans.Book;
import ua.kryvko.web.dao.BookDAO;
import ua.kryvko.web.names.AuthorCols;
import ua.kryvko.web.names.BookCols;
import ua.kryvko.web.names.SearchType;

/**
 *
 * @author Artem Kryvko
 */
public class BookLogic extends BookDAO{
    
    public List<Book> getBooksByGenre(Long genreId) {
        String sqlQuery = SELECT_QUERY + " WHERE " 
                + BookCols.GENRE_ID + " = " + genreId
                + " ORDER BY " + BookCols.NAME;
        return getDataBySQL(sqlQuery);
    }
    
    public List<Book> getBooksBySearch(String searchStr, SearchType searchType) {
        StringBuilder sqlQuery = new StringBuilder(SELECT_QUERY + " INNER JOIN author on "
                + BookCols.AUTHOR_ID + "=" + AuthorCols.ID + " WHERE lower(");
        if(searchType == SearchType.AUTHOR) {
            sqlQuery.append(AuthorCols.FIO);
        } else if(searchType == SearchType.TITLE) {
            sqlQuery.append(BookCols.NAME);
        } 
        sqlQuery.append(") like '%")
                .append(searchStr.toLowerCase())
                .append("%' ORDER BY " + BookCols.NAME);
        return getDataBySQL(sqlQuery.toString());
    }
    
    public byte[] getContentById(Long id) {
        String sqlQuery = "SELECT " + BookCols.CONTENT 
                + " FROM book WHERE " + BookCols.ID + "=" + id;
        byte[] content = null;
        try(Connection conn = getConnection()) {
            try(Statement st = conn.createStatement()) {
                try(ResultSet rs = st.executeQuery(sqlQuery)) {
                    if(rs.next())
                        content = rs.getBytes(BookCols.CONTENT);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(BookLogic.class.getName()).log(Level.SEVERE, null, ex);
        }
        return content;
    }
    
    
}
