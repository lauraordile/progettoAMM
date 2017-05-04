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
    <div id="title">
        <h1>Nerdbook</h1>
    </div>
    <c:if test="${page!='login'}">
        <jsp:include page="nav.jsp"/>
    </c:if>       
    <c:if test ="${page=='bacheca'|| page=='profilo'}">
        <div class="persone">
            <h2>Persone</h2>
            <ul>
                <li><a href="bacheca.html">Donald Fauntleroy Duck</a></li>
                <li><a href="bacheca.html">Mickey Mouse</a></li>
                <li><a href="bacheca.html">Minerva Mouse</a></li>
            </ul>
        
        </div>
        <div class="gruppi">     
            <h2>Gruppi</h2>
            <ul>
                <li><a href="bacheca.html">Paperini</a></li>
                <li><a href="bacheca.html">Topolini</a></li>
            </ul>
        </div>
    </c:if>
</div>
