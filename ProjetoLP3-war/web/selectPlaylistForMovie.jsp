<%-- 
    Document   : index
    Created on : 04/09/2016, 14:05:44
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
                
                <div>
                    <div>
                        <form action="Controller" method="POST">
                            <input type="hidden" name="command" value="Movielist.newMovielist"/>
                            Movielist name : <input type="text" name="mvname"/> <input type="submit" value="Add"/>
                        </form>
                    <c:forEach items="${user.getMovielistCollection()}"  var="movielist">
                        <ul style=" list-style: none; ">
                            <a href="Controller?command=movielist.addMovie&id_playlist=${movielist.getIdMovielist()}&idMovie=${selectedmovie.imdbId}><li> ${movielist.getName()}  </li>  </a>                          
                        </ul>                        
                    </c:forEach>
                        
                    </div>
                </div>
            </section>
        <c:import url="footer.jspf"></c:import>

    </body>

</html>
