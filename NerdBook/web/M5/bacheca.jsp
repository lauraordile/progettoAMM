<%-- 
    Document   : bacheca
    Created on : 26-apr-2017, 14.41.13
    Author     : Laura
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page session="true" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Nerdbook: trova il tuoi nerdfriends</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="author" content="Laura Ordile">
        <meta name="keywords" content="Social network ,Nerdbook, amicizie e tanto altro">
        <link rel="stylesheet" type="text/css" href="style.css" media="screen">

        <script src="js/jquery-3.2.1.min.js"></script>
        <script src="js/javascript.js"></script>
    </head>
    <body>
       <c:set var="page" value="bacheca" scope="request"/>
       <jsp:include page="header.jsp"/>
       
       <div id="divBody">
            <div id="searchUtente">
                <input id="searchField" type="text" placeholder="search User!" value="">
                <button id="searchYourUser">Serch friend...</button>
            </div>
            <div id="usersList">
                <c:forEach var="utente" items="${utenti}">
                    <div class="user">
                        <div class="profilePic">
                            <img alt="Foto Profilo" src="${user.urlProfilo}">
                        </div>
                        <div class="userData">
                            <h2>${user.nome} ${user.cognome}</h2>
                            <a href="Bacheca?user=${user.id}">Link al profilo</a>
                        </div>
                    </div>
                </c:forEach>
</div>

        </div>
       <jsp:include page ="nuovopost.jsp"/>
       
       
               <div id="posts">
                    <div id="newPost">
                        <form action="nuovopost.jsp" method="POST">
                             <input type="hidden" name="tipoBacheca" value="${tipoBacheca}"/>  
                              <c:choose>
                                    <c:when test="${tipoBacheca == 'user'}">
                                          <input type="hidden" name="dest" value="${user.id}"/>                        
                                    </c:when>

                                    <c:when test="${tipoBacheca == 'group'}">
                                        <input type="hidden" name="dest" value="${gruppo.id}"/>                        
                                    </c:when>
                             </c:choose>
                  
                        </form>
                    </div>
                   <c:forEach var="post" items="${listaPost}">
                       <div class="singp">
                            <div class="imge">
                                <img title="fotoProfilo" alt="Foto del Profilo" src="${post.user.urlProfilo}">
                            </div>
                            <h2>${post.user.nome} ${post.user.cognome}</h2>
                            <div class="post">
                                <p>${post.contenutoTesto}</p>
                                <c:if test="${post.urlType == 'IMAGE'}">
                                    <img alt="Post con foto" src="${post.url}">
                                    <p>${post.contenutoTesto}</p>
                                </c:if>
                                <c:if test="${post.urlType == 'LINK'}">
                                    <a href="${post.url}" target="_blank">${post.url}</a> 
                                    <p>${post.contenutoTesto}</p>
                                </c:if>
                            </div>
                       </div>
                    </c:forEach>  
                </div>     
    </body>
</html>
