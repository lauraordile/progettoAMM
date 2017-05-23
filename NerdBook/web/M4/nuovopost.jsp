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
        <link rel="stylesheet" type="text/css" href="M4/style.css" media="screen">
    </head>

    <body>
        <!--header contenente in titolo della pagina-->
        <c:set var="title" value="Nuovo Post" scope="request"/>
        <jsp:include page="header.jsp"/>

        <!--Barra di navigazione tra le pagine del sito-->
        <c:set var="page" value="nuovopost" scope="request"/>
        <jsp:include page="nav.jsp"/>

            <div id="formNewPost">
                <form action="servlet.java" method="post">
                    <div id="postContent">
                        <div>
                            <textarea name="textPost" id="textPost"> Inserisci qui il testo del tuo post....</textarea>
                        </div>
                        <div>
                            <label for="urlPost">Url:</label>
                            <input type="url" name="urlPost" id="urlPost">
                        </div>
                    </div>
                    <div id="urlType">
                        <div>
                            <label for="urlimmagine">Immagine</label>
                            <input type="radio" name="urlType" value="urlimmagine" id="urlimmagine">
                        </div>
                        <div>
                            <label for="urllink">Link</label>
                            <input type="radio" name="urlType" value="urllink" id="urllink">
                        </div>
                    </div>
                    
                    <button type="submit">Invia</button>
                </form>
            </div>
        <!--Contenuti della pagina-->
        <div id="divBody">
            <c:choose>
                <c:when test="${empty newpost}">
                    <div id="formNewPost">
                        <form action="NuovoPost" method="post">
                            <div id="postContent">
                        <div>
                            <textarea name="textPost" id="textPost"> Inserisci qui il testo del tuo post....</textarea>
                        </div>
                        <div>
                            <label for="urlPost">Url:</label>
                            <input type="url" name="urlPost" id="urlPost">
                        </div>
                    </div>
                    <div id="urlType">
                        <div>
                            <label for="urlimmagine">Immagine</label>
                            <input type="radio" name="urlType" value="urlimmagine" id="urlimmagine">
                        </div>
                        <div>
                            <label for="urllink">Link</label>
                            <input type="radio" name="urlType" value="urllink" id="urllink">
                        </div>
                    </div>
                            <button type="submit" name="thereIsPost" value="needConfirm">Invia</button>
                        </form>     
                    </div>
                </c:when>
                <c:otherwise>
                    <div id="formNewPost">
                        <form action="NuovoPost" method="post">
                            <c:if test="${typeUrl == 'textType'}">
                                <p>${content}</p>
                            </c:if>
                            <c:if test="${typeUrl == 'imgType'}">
                                <img src="${content}" alt="downloadedImage">
                            </c:if>
                            <input type="text" hidden name="textPost" value="${content}">
                            <input type="text" hidden name="postType" value="${typePost}">
                            <button type="submit" name="thereIsPost" value="Confirmed">Conferma</button>
                        </form>
                    </div>
                </c:otherwise>
            </c:choose>
        </div>
    </body>
</html>
