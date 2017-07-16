<%-- 
    Document   : index
    Created on : Jul 8, 2017, 12:36:43 PM
    Author     : Artem Kryvko
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome</title>
        <link href="css/form.css" rel="stylesheet">
    
       <div class="loginForm">
           <p class="title">Онлайн библиотека</p>
           <p class="text">Добро пожаловать в онлайн библиотеку, где вы сможете найти любую книгу на ваш вкус. Доступны функции поиска, просмотра, сортировки и многие другие.</p>
           <p class="text">Проект находится в разработке, поэтому дизайн и функционал будет постоянно дорабатываться.</p>
           <p class="text">По всем вопросам обращайтесь по адресу <a href="mailto:support@testlibrary.com">support@testlibrary.com</a></p>
           <p>&nbsp;</p>
           <form action="pages/main.jsp" method="POST">
                   <label for="checkLogin">Имя: </label>
                   <input type="text" name="login" id="checkLogin">
               <input type="submit" value="Войти">
           </form>
       </div>
        <footer>
            <p>
                Artem Kryvko
            </p>
        </footer>
    
</html>
