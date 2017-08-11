<%-- 
    Document   : artistas
    Created on : Apr 26, 2016, 11:08:28 AM
    Author     : jose
--%>

<%@page import="dados.modelos.Musica"%>
<%@page import="java.util.Collection"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% Collection<Musica> musicas = (Collection<Musica>) request.getAttribute("musicas"); %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet" type="text/css">
        <title>Spotixico - Músicas</title>
    </head>
    <body>
        <div style="padding:50px; width: 60%; margin: 0 auto;">
            <div class="panel panel-default">
                <table class="table table-bordered">
                    <thead>
                        <tr>
                            <th>Titulo</th>
                            <th>Duração</th>
                            <th>Album</th>
                            <th>Artista</th>
                        </tr>
                    </thead>
                    <tbody>
                        <% for (Musica m : musicas) {%>
                        <tr>
                            <td><%= m.getTitulo()%></td>
                            <td><%= m.getDuracao()%></td>
                            <td><%= m.getAlbum().getNome()%></td>
                            <td><%= m.getAlbum().getArtista().getNome() %></td>
                        </tr>
                        <% }%>
                    </tbody>
                </table>
            </div>
            <a href="/musicas/new">Criar Musicas</a><br/>
            <a href="/">Voltar ao ínicio</a>            
        </div>
    </body>
</html>
