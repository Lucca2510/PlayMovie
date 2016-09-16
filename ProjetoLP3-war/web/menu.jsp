<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>





<c:choose>

    <c:when test="${user==null}">
        <header>
            <div class="flex-container">
                <a href="index.jsp"><h3 id="textMenu">ProjetoLP3</h3></a>
                <ul>
                    <li>Link</li>
                    <li>Link</li>
                    <li>Link</li>
                </ul>

                <form action="Controller" method="POST">
                    <input type="hidden" value="Userproj.login" name="command"/>
                    <label for="username"><input type="text" name="username" placeholder="username" required/></label>
                    <label for="username"><input type="password" name="password" placeholder="password" required/></label>
                    <input type="submit" value="Login"/>
                    <a href="register.jsp">Register</a> 
                </form>
            </div>
        </header>
    </c:when>


    <c:when test="${user!=null}">
        <header>
            <div class="flex-container">
                 <a href="home.jsp"><h3 id="textMenu">ProjetoLP3</h3></a>
                <ul>
                    <li>Link</li>
                    <li>Link</li>
                    <li>Link</li>
                </ul>
                <a href="Controller?command=Userproj.logout"><input type="button" value="Logout"/></a>
            </div>
        </header>
    </c:when>

</c:choose>

