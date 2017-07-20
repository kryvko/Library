<%-- 
    Document   : book
    Created on : Jul 17, 2017, 1:40:44 PM
    Author     : Artem Kryvko
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="ua.kryvko.web.names.SearchType" %>
<%@taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!DOCTYPE html>
<%-- header.jspf like prelude --%>
<%@include file="../WEB-INF/jspf/left_menu.jspf" %>

<div class="book">
    
    <jsp:useBean id="bookDAO" class="ua.kryvko.web.dao.BookDAO" scope="session" />
    <jsp:useBean id="bookUtil" class="ua.kryvko.web.util.BookUtil" scope="session" />
    <jsp:useBean id="bookLogic" class="ua.kryvko.web.logic.BookLogic" scope="session" />
    
    <c:if test="${not empty param.genreId}">
        <c:choose>
            <c:when test="${param.genreId eq 0}">
                <c:set var="allBooks" value="${bookDAO.all}" scope="session"/>
            </c:when>
            <c:otherwise>
                <c:set var="allBooks" value="${bookLogic.getBooksByGenre(param.genreId)}" scope="session"/>
            </c:otherwise>
        </c:choose>
    </c:if>
    <c:if test="${not empty param.searchString}">
        <c:set var="searchType" value="<%=SearchType.valueOf(request.getParameter("searchType").toUpperCase())%>" scope="request"/>
        <c:set var="allBooks" value="${bookLogic.getBooksBySearch(param.searchString, searchType)}" scope="session" />
    </c:if>
    <c:choose>
        <c:when test="${not empty param.letter}">
            <c:set var="books" value="${bookUtil.getBooksByLetter(allBooks, param.letter)}" scope="request" />
        </c:when>
        <c:otherwise>
            <c:set var="books" value="${allBooks}" scope="request" />
        </c:otherwise>
    </c:choose>

    <p class="letters">
    <c:forEach items="${bookUtil.getFirstCaracters(allBooks)}" var="letter"> 
        
        <c:choose>
            <c:when test="${param.letter eq letter}">
                <a class="selected" href="${pageContext.request.contextPath}/pages/books.jsp?letter=${letter}">
            </c:when>
            <c:otherwise>
                <a href="${pageContext.request.contextPath}/pages/books.jsp?letter=${letter}">
            </c:otherwise>
        </c:choose>
            <c:out value="${letter}" /></span>
        </a>
    </c:forEach>
    </p>
 
    
    <table cellpadding="30">

        <c:forEach items="${books}" var="book">
            <tr>
                <td class="info">
                    <p class="bookTitle"><c:out value="${book.name}" /></p>
                    <br><strong>ISBN:</strong><span> <c:out value="${book.isbn}" /></span>
                    <br><strong>Издательство:</strong><span> <c:out value="${book.publisher_id}" /></span>

                    <br><strong>Количество страниц:</strong><span> <c:out value="${book.page_count}" /></span>
                    <br><strong>Год издания:</strong><span> <c:out value="${book.publish_year}" /></span>
                    <br><strong>Автор:</strong><span> <c:out value="${book.author_id}" /></span>
                    <p class="link"> <a href="${pageContext.request.contextPath}/PDFContent?id=${book.id}" target="_blank">Читать</a></p>
                    </td>
                    <td class="img">
                        <img src="${pageContext.request.contextPath}/BookImg?id=${allBooks.indexOf(book)}" alt="форзац" height="130px">
                    </td>
                </tr>
    </c:forEach>

    </table>
    
</div>

<%-- footer.jspf like coda --%>
