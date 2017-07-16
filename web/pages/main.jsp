<%-- 
    Document   : main
    Created on : Jul 8, 2017, 1:23:25 PM
    Author     : Artem Kryvko
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <% request.setCharacterEncoding("UTF-8"); %>
        <title>Main</title>
        <link href="../css/main.css" rel="stylesheet">
    </head>
    <body>
        <header>
            <div class="logo">
                <a href="/Library">
                    <div class="ref">
                        <img src="../images/logo.png" alt="logo" height="70px">
                        <span>На&nbsp;главную</span>
                    </div>
                </a>
            </div>
            <div class="search">
                <form>
                    <input type="search" name="query" placeholder="Найти...">
                    <input type="submit" value="Поиск">
                    <select name="table">
                        <option value="author">По автору</option>
                        <option value="book" selected>По названию</option>
                    </select>

                </form>
            </div>
        </header>
        <div class="content">
            <div class="contentImg">
                <div class="authorList">
                    <h4>Список авторов</h4>
                    <ul class="nav">
                        <jsp:useBean id="genres" class="ua.kryvko.web.dao.GenreDAO" scope="request"/>
                        <c:forEach var="genre" items="${genres.all}">
                            <li><a href='#'><span>
                            <c:out value="${genre.name}" />
                            </span></a></li>
                        </c:forEach>
                    </ul>    
                </div>
                <div class="book">
                    Content
                </div>
            </div>
        </div>
    </body>
</html>
