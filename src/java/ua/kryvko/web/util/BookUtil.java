/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.kryvko.web.util;

import java.util.List;
import java.util.stream.Collectors;
import ua.kryvko.web.beans.Book;

/**
 *
 * @author Artem Kryvko
 */
public class BookUtil {
    public static List<Book> getBooksByGenre(List<Book> allBooks, Long genre_id) {
        System.out.println("312 " + genre_id);
        List<Book> selectedBooks =  allBooks.stream()
                .filter(book -> genre_id.equals(book.getGenre_id()))
                .collect(Collectors.toList());
        return selectedBooks;
    }
}
