<%-- 
    Document   : profile
    Created on : 13/09/2016, 20:41:20
    Author     : lgd25
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>

        <link href="css/estilo.css" rel="stylesheet" type="text/css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>PlayMovies</title>
    </head>

    <body>
        <c:import url="menu.jsp"></c:import>

            <section id="main">

                <article class="mainProfile">

                    <h1 class="title">Update your profile</h1>


                    <form action="Controller" method="POST" id="register">

                        <p><label for="username">Username:</br><input type="text" name="username" value="${user.username}" disabled/></label></p>       
                    <p><label for="fullname">Full name:</br><input type="text" name="fullname" value="${user.userinfo.fullname}" /></label></p>
                    <p><label for="email">Email:</br><input type="text" name="email" value="${user.userinfo.email}" disabled /></label></p>
                    <p><label for="phone">Phone:</br><input type="text" name="phone" value="${user.userinfo.phone}" /> </label></p>
                    <p><label for="birthday">Birthday:</br><input type="date" name="birthday" value="${user.userinfo.getDateChrome()}"/></label></p>
                    <input type="hidden" name="command" value="Userproj.update"/>
                    <p><label for="submit"></br><input type="submit" value="Update"/></label></p>      

                </form>

            </article>

        </section>

        <c:import url="footer.jspf"></c:import>

    </body>

</html>
