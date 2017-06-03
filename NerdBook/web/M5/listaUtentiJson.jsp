<%-- 
    Document   : listaUtentiRegistratiJson
    Created on : 29-mag-2017, 9.52.12
    Author     : Laura
--%>

<%@page contentType="application/json" pageEncoding="UTF-8"%>
<json:array>
    <c:forEach var="utente" items="${listaUtenti}">
        <json:object>
            <json:property name="nome" value="${user.nome}"/>
               <json:property name="cognome" value="${user.cognome}"/>
               <json:property name="id" value="${user.id}"/>
               <json:property name="dataNascita" value="${user.dataNascita}"/>
               <json:property name="urlProfilo" value="${user.urlProfilo}"/>
               <json:property name="frase" value="${user.frase}"/>
               <json:property name="email" value="${user.email}"/>
               <json:property name="password" value="${user.password}"/>
        </json:object>
    </c:forEach>
</json:array>
        
        