/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.kryvko.web.util;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import ua.kryvko.web.beans.Book;

/**
 *
 * @author Artem Kryvko
 */
public class BookUtil {
    
    public static List<Book> getBooksByGenre(List<Book> allBooks, Long genre_id) {
        return  allBooks.stream()
                .filter(book -> genre_id.equals(book.getGenre_id()))
                .collect(Collectors.toList());
    }
    
    public static List<Book> getBooksByLetter(List<Book> allBooks, String letter) {
         return allBooks.stream()
                 .filter(book -> book.getName().startsWith(letter))
                 .collect(Collectors.toList());
    }
    
    public static Set<Character> getFirstCaracters(List<Book> books) {
        return books.stream()
                .map(book -> book.getName().charAt(0))
                .collect(Collectors.toCollection(TreeSet::new));
    }
} 
