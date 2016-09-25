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
                    <img src="img/PLAY MOVIE - LOGO.png" alt="coisas" style="width:600px;height:600px;"/><br>             
                    <h1><b>Welcome to PlayMovie!</b></h1>
                    <p>The site where you can build you movie lists!</p> 
                    <div >
                        <img src="img/pop.png" alt="pipoca loka" style="width:150px;height:150px;"/>
                        <p>teste</p>
                    </div>
                    <div > 
                        <img src="img/ticket.png" alt="oscar" style="width:150px;height:150px;"/>
                        <p>teste</p>
                    </div>
                    <div > 
                        <img src="img/oscar.png" alt="oscar" style="width:150px;height:150px;"/>
                        <p>teste</p>
                    </div>
                </div>
            </section>
        <c:import url="footer.jspf"></c:import>

    </body>

</html>
