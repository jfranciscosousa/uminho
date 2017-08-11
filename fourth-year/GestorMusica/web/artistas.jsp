<%-- 
    Document   : artistas
    Created on : Apr 26, 2016, 11:08:28 AM
    Author     : jose
--%>

<%@page import="dados.modelos.Artista"%>
<%@page import="java.util.Collection"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% Collection<Artista> artistas = (Collection<Artista>) request.getAttribute("artistas"); %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet" type="text/css">
        <title>JSP Page</title>
    </head>
    <body>
        <div style="padding:50px; width: 60%; margin: 0 auto;">
            <div class="panel panel-default">
                <table class="table table-bordered">
                    <thead>
                        <tr>
                            <th>Nome</th>
                            <th>Morada</th>
                        </tr>
                    </thead>
                    <tbody>
                        <% for (Artista a : artistas) {%>
                        <tr>
                            <td><%= a.getNome()%></td>
                            <td><%= a.getMorada()%></td>
                        </tr>
                        <% }%>
                    </tbody>
                </table>
            </div>
            <a href="/artistas/new">Criar Artista</a><br/>
            <a href="/">Voltar ao ínicio</a>            
        </div>
    </body>
</html>
