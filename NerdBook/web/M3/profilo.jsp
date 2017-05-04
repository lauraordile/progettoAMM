<%-- 
    Document   : profilo
    Created on : 27-apr-2017, 15.28.25
    Author     : Laura
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
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
       <c:set var="page" value="profilo" scope="request"/>
       <jsp:include page="header.jsp"/>
        <!--per mettere possword usare la post-->
        <div class="divBodyp">
            <form action="servlet.java" method="post">
                <div id="profile">
                    <img alt="Foto Profilo" src="immagini/Paperina.png">
                    <div id="prof"> 
                    
                    
                    <label for="nome">Nome :</label>
                    <input type="text" name="nome" id="nome">
                    <label for="cognome">Cognome:</label>
                    <input type="text" name="cognome" id="cognome">
                    <label for="data">Data di nascita :</label>
                    <input type="date" name="data" id ="data">
                    <label for ="urlImg"> URL immagine del profilo:</label>
                    <input type="url" name="url" id="urlImg">
                    <label for ="textArea">Frase di presentazione:</label>
                    <textarea name="textPost" id="textArea" > Scrivi qua...</textarea>
                    
                    <label for="password">Password :</label>
                    <input type="password" name="password" id ="password">
                    <label for="cpassword">Conferm password :</label>
                    <input type="password" name="cpassword" id ="cpassword">
                    </div>
                
                <div id="butp">
                <button type="submit">Invia</button> 
                </div>
                </div>
            </form>
        </div>
       </body>
</html>
