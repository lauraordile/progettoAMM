<%-- 
    Document   : nav
    Created on : 26-apr-2017, 14.41.13
    Author     : Laura
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<nav>
    <ol>
        <c:choose>
            <c:when test="${page=='profilo'|| page=='bacheca'}">
                <p>Daisy Duck</p>
                <ul id="log">
                    <li><a href ="descrizione.html">Logout</a></li>
                </ul>
                <c:when test="${page=='profilo'}">
                    <li class="active"><a href="profilo.html" >Profilo</a></li>   
                    <li><a href ="bacheca.html">Bacheca</a></li>
                    
                </c:when>
                <c:when test="${page=='bacheca'}">
                    <li ><a href="profilo.html" >Profilo</a></li>   
                    <li class="active"><a href ="bacheca.html">Bacheca</a></li>
                </c:when>
                <c:when test="${page=='descrizione'}"> 
                    <li><a href="descrizione.html">Descrizione</a></li>
                    <li class="active"><a href="login.html" >Login</a></li>
                </c:when>
            </c:when>
        </c:choose>
    </ol>
            
</nav>
