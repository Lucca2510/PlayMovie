<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>





<c:choose>

    <c:when test="${user==null}">
        <header>
            <div class="flex-container">
                <%--
                    <a href="index.jsp"><h3 id="textMenu">PLAY MOVIE</h3></a>
                --%>

                <img src="img/mask1.png" alt="mascara" style="width:80px;height:80px;">
                <a href="index.jsp"><img src="img/logoMenor.png" alt="coisas" style="width:80px;height:80px;"></a>

                <ul>

                    <a href="contatos.jsp"><li>Contacts</li></a>
                    <a href="about.jsp"><li>About</li></a>


                </ul>

                <form action="Controller" method="POST">
                    <input type="hidden" value="Userproj.login" name="command"/>
                    <label for="username"><input type="text" name="username" placeholder="username" required/></label>
                    <label for="username"><input type="password" name="password" placeholder="password" required/></label>
                    <input type="submit" value="Login"/>
                    <a href="register.jsp">Register</a> 
                </form>
                <img src="img/mask2.png" alt="mascara" style="width:80px;height:80px;">
            </div>

        </header>
    </c:when>


    <c:when test="${user!=null}">
        <header>
            <div class="flex-container">
                <img src="img/mask1.png" alt="mascara" style="width:80px;height:80px;">
                <a href="home.jsp"><img src="img/logoMenor.png" alt="coisas" style="width:80px;height:80px;"></a>
                <ul>
                    <a href="Controller?command=Movielist.getAll"><li>Home</li></a>
                    <a href="profile.jsp"><li>Profile</li></a>
                    <a href="Controller?command=Movielist.getByUser"><li>Movielists</li></a>
                    <a href="contatos.jsp"><li>Contacts</li></a>
                    <a href="about.jsp"><li>About</li></a>
                </ul>
                <a href="Controller?command=Userproj.logout"><input type="button" class="button" value="Logout"/><br></a>
                <img src="img/mask2.png" alt="mascara" style="width:80px;height:80px;"/>
            </div>
        </header>
    </c:when>


</c:choose>
<div style="margin-left: 35%; margin-top: 10px;">
    <form action="Controller" method="POST">
        <input type="text" name="movieName" placeholder="Movie Name" required/>
        <input type="hidden" name="command" value="Movie.searchByName"/>
        <input type="submit" value="Search"/>
    </form>
</div>

