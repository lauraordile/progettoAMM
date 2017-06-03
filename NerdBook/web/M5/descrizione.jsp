<%-- 
    Document   : descrizione
    Created on : 4-mag-2017, 22.52.21
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
        <c:set var="page" value="descrizione" scope="request"/>
        <jsp:include page="header.jsp"/>
        <jsp:include page="nav.jsp"/>
        
        
      <div class="divBody"> <!-- contiene tutto il contenuto della pagina-->
             <h2> Descrizione social network:</h2> 
             <div id ="rivolto">
                  <h3> A chi è rivolto Nerdbook:</h3> 
                  <p>Nerdbook è un social network rivolto ad utenti che desiderano stringere 
                      amicizie e creare e gestire dei gruppi di persone in maniera virtuale.</p>
            </div>
            <div id="iscriversi">
                <h3>Come iscriversi a Nerdbook</h3>
                    <p> Un utente che intende registrarsi deve inserire nome, cognome, data 
                        di nascita. Inoltre deve inserire ha una frase di presentazione 
                        ,una immagine del profilo e una password. </p>
                    
            </div>
             <div id="gratuito">
                <h3>Nerdbook e' gratuito o a pagamento? </h3>
                    <p> Nerdbook è un social network gratuito.</p>
                    
                </div>
        </div>
    </body>
</html>