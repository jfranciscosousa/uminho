<%-- 
    Document   : newmusica
    Created on : Apr 26, 2016, 2:36:25 PM
    Author     : jose
--%>

<%@page import="dados.modelos.Album"%>
<%@page import="java.util.Collection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% Collection<Album> albums = (Collection<Album>) request.getAttribute("albums"); %>
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
                <form action="/musicas/new" method="POST" style="padding: 20px">
                    <div class="form-group">
                        <label>Título</label>
                        <input class="form-control" name="titulo"/>
                    </div>
                    <div class="form-group">
                        <label>Duracao</label>
                        <input class="form-control" name="duracao"/>
                    </div>
                    <select class="form-control" name="album">
                        <% for (Album a : albums) {%>
                        <option value="<%= a.getORMID()%>"> <%= a.getNome()%></option>
                        <% }%>
                    </select>
                    <button style="margin-top: 2%" type="submit" class="btn btn-default">Submit</button>
                </form>
            </div>
        </div>
    </body>
</html>
