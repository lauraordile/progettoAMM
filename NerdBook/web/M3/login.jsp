<%-- 
    Document   : login
    Created on : 4-mag-2017, 22.13.49
    Author     : Laura
--%>

<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html>
    <head>
        <title>Nerdbook: trova il tuoi nerdfriends</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="author" content="Laura Ordile">
        <meta name="keywords" content="Social network ,Nerdbook, amicizie e tanto altro">
        <link rel="stylesheet" type="text/css" href="style.css" media="screen">
   </head>
    <body>
        <c:set var="page" value="login" scope="request"/>
        <jsp:include page="header.jsp"/>
	
        <!--Contenuti della pagina-->
        <div class="divBodyy">
            <form action="servlet.java" method="post">
                <div class="nome">
                <label for="nome">Nome Utente </label>
                <input type="text" name="nome" id="nomeutente">
                </div>
                <div id="pasw">
                <label for="password">Password </label>
                <input type="password" name="password" id ="password">
                </div>
                <!--<div id="button">-->
                <button type="submit">Accedi</button> 
                
            </form>
        </div>
    </body>
</html>
