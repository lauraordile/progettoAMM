<%-- 
    Document   : header
    Created on : 26-apr-2017, 14.31.25
    Author     : Laura
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page session="true" %>

<!DOCTYPE html>

<div class="header">
    <c:if test="${page=='login'}">
         <div id="titlel">
            <img alt="Foto Profilo" src="M4/immagini/NerdBook.png">
            <h1>Nerdbook</h1>
         </div>
    </c:if>
    <c:if test="${page!='login'}">
        <div id="title">
            <h1>Nerdbook</h1> 
            <jsp:include page="nav.jsp"/>
        </div>
       
    </c:if>       
    <c:if test ="${page=='bacheca'|| page=='profilo'}">
        <div class="persone">
            <h2>Persone</h2>
            <ul>
                <li><a href="bacheca.jsp">Donald Fauntleroy Duck</a></li>
                <li><a href="bacheca.jsp">Mickey Mouse</a></li>
                <li><a href="bacheca.jsp">Minerva Mouse</a></li>
            </ul>
        
        </div>
        <div class="gruppi">     
            <h2>Gruppi</h2>
            <ul>
                <li><a href="bacheca.jsp">Paperini</a></li>
                <li><a href="bacheca.jsp">Topolini</a></li>
            </ul>
        </div>
    </c:if>
</div>
