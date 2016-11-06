<%-- 
    Document   : home
    Created on : 10/09/2016, 14:39:16
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
                <article>
                <c:if test="${user==null}">
                    <c:redirect url="index.jsp"></c:redirect>
                </c:if>
                    <h1 class="title">Bem Vindo, ${user.getUsername()}!</h1>
                </article>
                 <c:forEach items="${allmovielists}"  var="movielist">
                        <ul style=" list-style: none; ">
                            <a href="Controller?command=Movielist.viewmovielist&id_movielist=${movielist.getIdMovielist()}"><li> ${movielist.getName()}  </li>  </a>                
                        </ul>                        
                    </c:forEach>
            </section>

        <c:import url="footer.jspf"></c:import>

    </body>

</html>

