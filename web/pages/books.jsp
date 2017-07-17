<%-- 
    Document   : book
    Created on : Jul 17, 2017, 1:40:44 PM
    Author     : Artem Kryvko
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<% request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html>
<%-- header.jspf like prelude --%>
<%@include file="../WEB-INF/jspf/left_menu.jspf" %>

<div class="book">
    <h3>${param.name}</h3>
    
    <jsp:useBean id="bookDAO" class="ua.kryvko.web.dao.BookDAO" scope="session" />
    <jsp:useBean id="bookUtil" class="ua.kryvko.web.util.BookUtil" scope="session" />
    <c:set var="books" value="${bookDAO.all}" scope="session" />
    <c:set var="genre_id" value="${param.genre_id}" scope="request" />
    
    <table cellpadding="30">

        <c:forEach items="${bookUtil.getBooksByGenre(books, genre_id)}" var="book">
            <tr>
                <td class="info">
                    <p class="bookTitle"><c:out value="${book.name}" /></p>
                    <br><strong>ISBN:</strong><span> <c:out value="${book.isbn}" /></span>
                    <br><strong>Издательство:</strong><span> <c:out value="${book.publisher_id}" /></span>

                    <br><strong>Количество страниц:</strong><span> <c:out value="${book.page_count}" /></span>
                    <br><strong>Год издания:</strong><span> <c:out value="${book.publish_year}" /></span>
                    <br><strong>Автор:</strong><span> <c:out value="${book.author_id}" /></span>
                           <p class="link"> <a href="#">Читать</a></p>
                    </td>
                    <td class="img">
                        <img src="/Library/BookImg?id=${book.id}" alt="форзац" height="130px">
                    </td>
                </tr>
    </c:forEach>

    </table>
    
</div>

<%-- footer.jspf like coda --%>
