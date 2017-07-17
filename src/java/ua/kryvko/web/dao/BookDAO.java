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
import ua.kryvko.web.beans.Book;
import ua.kryvko.web.names.BookCols;

/**
 *
 * @author Artem Kryvko
 */
public class BookDAO extends AbstractDAO<Book>{
    public static final String SELECT_QUERY = "SELECT * FROM book";


    @Override
    protected String getSelectQuery() {
        return SELECT_QUERY;
    }

    @Override
    protected List<Book> parseResultSet(ResultSet rs) {
        List<Book> books = new ArrayList<>();
        try {
            while(rs.next()) {
                Book book = new Book();
                book.setId(rs.getLong(BookCols.ID));
                book.setName(rs.getString(BookCols.NAME));
                //book.setContent(rs.getBytes(BookCols.CONTENT));
                book.setPage_count(rs.getInt(BookCols.PAGE_COUNT));
                book.setIsbn(rs.getString(BookCols.ISBN));
                book.setGenre_id(rs.getLong(BookCols.GENRE_ID));
                book.setAuthor_id(rs.getLong(BookCols.AUTHOR_ID));
                book.setPublish_year(rs.getDate(BookCols.PUBLISH_YEAR));
                book.setPublisher_id(rs.getLong(BookCols.PUBLISHER_ID));
                book.setImage(rs.getBytes(BookCols.IMAGE));
                books.add(book);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BookDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return books;
    }
    
}
