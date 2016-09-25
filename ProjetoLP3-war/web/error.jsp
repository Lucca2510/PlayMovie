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
                <div id="divError">
                    <h1 class="title">Error</h1>
                    <img src="img/errorMSG.png" alt="about fernando" style="width: 650px;height:250px;"/>  
                    <p>${error}</p>
                </div>
            </section>

        <c:import url="footer.jspf"></c:import>

    </body>

</html>
