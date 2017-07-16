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

/**
 *
 * @author Artem Kryvko
 */
public class BookDAO extends AbstractDAO<Book>{
    public static final String SELECT_QUERY = "SELECT * FROM book";
    public static final String ID = "id";
    public static final String NAME = "name";
    public static final String CONTENT = "content";
    public static final String PAGE_COUNT = "page_count";
    public static final String ISBN = "isbn";
    public static final String GENRE_ID = "genre_id";
    public static final String AUTHOR_ID = "author_id";
    public static final String PUBLISH_YEAR = "publish_year";
    public static final String PUBLISHER_ID = "publisher_id";
    public static final String IMAGE = "image";

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
                book.setId(rs.getLong(ID));
                book.setName(rs.getString(NAME));
                book.setContent(rs.getBytes(CONTENT));
                book.setPage_count(rs.getInt(PAGE_COUNT));
                book.setIsbn(rs.getString(ISBN));
                book.setGenre_id(rs.getLong(GENRE_ID));
                book.setAuthor_id(rs.getLong(AUTHOR_ID));
                book.setPublish_year(rs.getDate(PUBLISH_YEAR));
                book.setPublisher_id(rs.getLong(PUBLISHER_ID));
                book.setImage(rs.getBytes(IMAGE));
                books.add(book);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BookDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return books;
    }
    
}
