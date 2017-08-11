<%-- 
    Document   : newmusica
    Created on : Apr 26, 2016, 2:36:25 PM
    Author     : jose
--%>

<%@page import="java.util.Collection"%>
<%@page import="dados.modelos.Artista"%>
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
                <form action="/albums/new" method="POST" style="padding: 20px">
                    <div class="form-group">
                        <label>Nome do Album</label>
                        <input class="form-control" name="nome"/>
                    </div>
                    <div class="form-group">
                        <label>Ano</label>
                        <input class="form-control" name="ano"/>
                    </div>
                    <select class="form-control" name="artista">
                        <% for (Artista a : artistas) {%>
                        <option value="<%= a.getORMID()%>"> <%= a.getNome()%></option>
                        <% }%>
                    </select>
                    <button style="margin-top: 2%" type="submit" class="btn btn-default">Submit</button>
                </form>
            </div>
        </div>
    </body>
</html>
