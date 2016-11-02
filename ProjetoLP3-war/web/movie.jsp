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
                   
                        <p>Title: ${selectedMovie.getTitle()}</p>
                        <p>Rated: ${selectedMovie.getRated()}</p>
                        <p>Released: ${selectedMovie.getRelease()}</p>                        
                        <p>Runtime: ${selectedMovie.getRuntime()}</p>
                        <p>Genre: ${selectedMovie.getGenre()}</p>
                        <p>Director: ${selectedMovie.getDirector()}</p>
                        <p>Actors: ${selectedMovie.getActors()}</p>
                        <p>Plot: ${selectedMovie.getPlot()}</p>
                        <p>Metascore: ${selectedMovie.getMetascore()}</p>
                        
                        <c:choose>
                            <c:when test="${user!=null}">
                                <a href="Controller?command=Movielist.selectMovie"><button>Add to Movielist</button></a>
                            </c:when>
                            
                        </c:choose>
                    
                    
                    
                </div>
            </section>
        <c:import url="footer.jspf"></c:import>

    </body>

</html>
