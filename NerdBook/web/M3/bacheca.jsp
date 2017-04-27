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
       <c:set var="page" value="bacheca" scope="request"/>
       <jsp:include page="header.jsp"/>
           <div class="divBody">
               <div id="posts">
                   <c:forEach var="singp" items="${posts}">
                       <div class="singp">
                            <div class="imge">
                                <img title="fotoProfilo" alt="Foto del Profilo" src="${singp.user.urlProfilo}">
                            </div>
                            <h2>${singp.user.nome} ${singp.user.cognome}</h2>
                            <div class="post">
                                <p>${singp.contenutoTesto}</p>
                                <c:if test="${singp.postType == 'IMAGE'}">
                                    <img alt="Post con foto" src="${singp.contenutoImm}">
                                    <p>${singp.contenutoTesto}</p>
                                </c:if>
                                <c:if test="${singp.postType == 'LINK'}">
                                    <a href="${singp.contenutoLink}" target="_blank">${singp.contenutoLink}</a> 
                                    <p>${singp.contenutoTesto}</p>
                                </c:if>
                            </div>
                       </div>
                    </c:forEach>  
                </div>     
            </div>
    </body>
</html>
