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
                <c:when test="${page=='profilo'}">
                    <p>Daisy Duck</p>
                    <ul class="log">
                        <li><a href ="descrizione.jsp">Logout</a></li>
                    </ul>
                    <li class="activ"><a href="profilo.jsp" >Profilo</a></li>   
                    <li><a href ="bacheca.jsp">Bacheca</a></li>
                    
                </c:when>
                <c:when test="${page=='bacheca'}">
                    <p>Daisy Duck</p>
                    <ul class="log">
                        <li><a href ="descrizione.jsp">Logout</a></li>
                    </ul>
                    <li ><a href="profilo.jsp" >Profilo</a></li>   
                    <li class="activ"><a href ="bacheca.jsp">Bacheca</a></li>
                </c:when>
           
                    
            <c:when test="${page=='descrizione'}"> 
                <li class="activ"><a href="descrizione.jsp">Descrizione</a></li>
                <li ><a href="login.jsp" >Login</a></li>
            </c:when>
                
                
        </c:choose>
    </ol>
            
</nav>
