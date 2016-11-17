<%-- 
    Document   : about
    Created on : 24/09/2016, 13:50:25
    Author     : NAGOYA
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>PlayMovies</title>
        <link href="css/estilo.css" rel="stylesheet" type="text/css"/>
    </head>
    <body >
        <c:import url="menu.jsp"></c:import>
            <section id="main">

                <div id='aboutF' class='about'>
                    <img src="img/aboutF.png" alt="about fernando" style="width: 350px;height:350px;"/>                                    
                    <p><b>Nome:</b>Fernando Goia</p>
                    <p><b>Idade: </b> 19 anos</p>
                    <p><b>Hobbies:</b>Navegar na internet e compor músicas</p>
                    
                </div>
                <div id='aboutG' class='about'>
                     <img src="img/aboutL.png" alt="about Lucca" style="width: 350px;height:350px;"/>                                                    
                    <p><b>Nome:</b>Lucca Gabriel Dias</p>
                    <p><b>Idade: </b> 20 anos</p>
                    <p><b>Hobbies: </b>Malhar e assistir filmes séries</p>
                </div>
                <div id='aboutL' class='about'>
                    <img src="img/aboutG.png" alt="about Gabriel" style="width: 350px;height:350px;"/>                                       
                    <p><b>Nome:</b>Gabriel Manfredi</p>
                    <p><b>Idade: </b> 19 anos</p>
                    <p><b>Hobbies: </b>Futebol, youtuber e construir coisas</p>
                </div>
                
                
            </section>
        <c:import url="footer.jspf"></c:import>
    </body>
</html>
