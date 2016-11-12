<%-- 
    Document   : index
    Created on : 04/09/2016, 14:05:44
    Author     : lgd25
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet"/>
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
                        <h2>${selectedmovielist.getName()}</h2>
                    <p style=" border-bottom: 2px solid #a1a1a1;margin: 10px;">Created by: ${selectedmovielist.getFkUser().getUsername()}</p>
                    <p>Likes: ${selectedmovielist.getThumbupCollection().size()} <a href="Controller?command=Thumbup.likelist&list=${selectedmovielist}"></br><button class="button">Like</button></a></p>
                    <table>
                        <tr>
                            <th>Name</th>
                            <th>View</th>
                        </tr>
                        <c:forEach items="${selectedmovielist.getMovieonlistCollection()}"  var="movieonlist">
                            <tr>
                                <td>${movieonlist.getMovieName()}</td> <td><a href="Controller?command=Movie.searchByName&movieName=${movieonlist.getMovieName()}"> <button class="button"><i class="material-icons">visibility</i></button> </a></td>             
                            </tr>
                        </c:forEach> 
                    </table>
                </div>
            </div>
        </section>
        <c:import url="footer.jspf"></c:import>

    </body>

</html>
