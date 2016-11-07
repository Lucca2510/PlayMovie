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
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet"/>

        <link href="css/estilo.css" rel="stylesheet" type="text/css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>PlayMovies</title>
    </head>

    <body>
        <c:import url="menu.jsp"></c:import>
            <section id="main">
                
                <div>
                    <div style="padding: 10px; border: 1px solid black;">
                        <form action="Controller" method="POST">
                            <input type="hidden" name="command" value="Movielist.newMovielist"/>
                            Movielist name : <input type="text" name="mvname"/> <input type="submit" value="Add"/>
                        </form>
                    <c:forEach items="${movielistsbyuser}"  var="movielist">
                        <ul style=" list-style: none; ">
                            <a style="color:black;" href="Controller?command=Movielist.viewmovielist&id_movielist=${movielist.getIdMovielist()}"><li> ${movielist.getName()}  </li>  </a>  <a href="Controller?command=Movielist.deletemovielist&id_movielist=${movielist.getIdMovielist()}"><button class="button"><i class="material-icons">delete</i></button></a>                        
                        </ul>                        
                    </c:forEach>
                        
                    </div>
                </div>
            </section>
        <c:import url="footer.jspf"></c:import>

    </body>

</html>

