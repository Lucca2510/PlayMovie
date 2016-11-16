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
            
            <div>
                <c:if test="${success!=null}">
                    <p><h1 style="color: greenyellow"> ${success}</h1></p>
                    <c:set var="success" value="" scope="session" ></c:set>
                </c:if>
                <c:if test="${user==null}">
                    <c:redirect url="index.jsp"></c:redirect>
                </c:if>
            <article id="welcomeTitle">
                <h1 class="title">Welcome, ${user.getUsername()}!</h1>
                <h3>This are the most popular movie lists on our site</h3>                
            </article>
                <div>
                    
                    <c:forEach items="${allmovielists}"  var="movielist">
                        <ul style=" list-style: none; ">
                            <a style="color: black;" href="Controller?command=Movielist.viewmovielist&id_movielist=${movielist.getIdMovielist()}"><li> ${movielist.getName()}  </li>  </a>                
                        </ul>                        
                    </c:forEach>
                </div>
            </div>
        </section>

        <c:import url="footer.jspf"></c:import>

    </body>

</html>

