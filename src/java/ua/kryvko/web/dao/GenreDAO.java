/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.kryvko.web.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import ua.kryvko.web.beans.DBBean;
import ua.kryvko.web.beans.Genre;
import ua.kryvko.web.names.GenreCols;

/**
 *
 * @author Artem Kryvko
 */
public class GenreDAO extends AbstractDAO<Genre>{
    public static final String SELECT_QUERY = "SELECT * FROM genre";


    @Override
    protected String getSelectQuery() {
        return SELECT_QUERY;
    }

    @Override
    protected List<Genre> parseResultSet(ResultSet rs) {
        List<Genre> genres = new ArrayList<>();
        try {
            while(rs.next()) {
                Genre genre = new Genre();
                genre.setId(rs.getLong(GenreCols.ID));
                genre.setName(rs.getString(GenreCols.NAME));
                genres.add(genre);
            }
        } catch (SQLException ex) {
            Logger.getLogger(GenreDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        Collections.sort(genres, GenreDAO::genreCompare);
        return genres;
    }
    
    /**
     * Implementation of the functional interface Comparator<Genre>
     * @param g1
     * @param g2
     * @return compares its two arguments for order
     */
    private static int genreCompare(Genre g1, Genre g2) {
        return String.valueOf(g1.getName()).compareTo(g2.getName());
    }
    
    
}
