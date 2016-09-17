<%-- 
    Document   : register
    Created on : 07/09/2016, 11:11:05
    Author     : lgd25
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>PlayMovies</title>

        <link href="css/estilo.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <c:import url="menu.jsp"></c:import>

            <section id="main">
                <article id="register">
                    <h1 class="title">Register</h1>
                    <form action="Controller" method="POST" id="register">

                        <p><label for="username">Username:</br><input type="text" name="username"/></label></p>
                        <p><label for="password">Password:</br><input type="password" name="password"/></label></p>
                        <p><label for="password2">Confirm Password:</br><input type="password" name="password2"/></label></p>
                        <p><label for="fullname">Full name:</br><input type="text" name="fullname"/></label></p>
                        <p><label for="email">Email:</br><input type="text" name="email"/></label></p>
                        <p><label for="phone">Phone:</br><input type="text" name="phone"/></label></p>
                        <p><label for="birthday">Birthday:</br><input type="date" name="birthday"/></label></p>
                        <input type="hidden" name="command" value="Userproj.register"/>
                        <p><label for="submit"></br><input type="submit" value="Register"/></label></p>                       

                    </form>
                </article>
            </section>



        <c:import url="footer.jspf"></c:import>


    </body>
</html>
