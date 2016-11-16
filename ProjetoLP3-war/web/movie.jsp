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

                    <div >
                        <img id="poster" src="${selectedMovie.getPoster()}" alt="pipoca loka" style="width:150px;height:200px;"/>

                    <p><b>Title:</b> ${selectedMovie.getTitle()}</p>
                    <p><b>Rated:</b> ${selectedMovie.getRated()}</p>
                    <p><b>Released:</b> ${selectedMovie.getRelease()}</p>                        
                    <p><b>Runtime:</b> ${selectedMovie.getRuntime()}</p>
                    <p><b>Genre:</b>${selectedMovie.getGenre()}</p>
                    <p><b>Director:</b> ${selectedMovie.getDirector()}</p>
                    <p><b>Actors:</b> ${selectedMovie.getActors()}</p>
                    <p><b>Plot:</b> ${selectedMovie.getPlot()}</p>
                    <p><b>Metascore:</b> ${selectedMovie.getMetascore()}</p>

                    <c:choose>
                        <c:when test="${user!=null}">
                            <a href="Controller?command=Movielist.addMovie"><button class="button" style="margin-bottom: 20px;">Add to Movielist</button></a>
                        </c:when>

                    </c:choose>



                </div>
        </section>
        <c:import url="footer.jspf"></c:import>

    </body>

</html>
