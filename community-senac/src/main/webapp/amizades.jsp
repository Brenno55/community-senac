<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="model.User"%>
<%@ page import="model.Friendship"%>

<%@ page import="java.util.ArrayList"%>
<% ArrayList<User> amizades  = (ArrayList<User>)request.getAttribute("amizades");%>
<% ArrayList<Friendship> relatorio  = (ArrayList<Friendship>) request.getAttribute("relatorio"); %>
<%User userS = (User)session.getAttribute("sessionUser");%>


<!DOCTYPE html>
<html lang="pt-br">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<head>
    <meta charset="UTF-8">
    <title>Community Senac</title>
    <link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@400;700&display=swap" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
    <link  type="text/css" rel="stylesheet" href="/view/css/home.css">
    <link type="text/css" rel="stylesheet" href="/view/pages/index.css">

</head>
<body>

<h2>Relatorio das amizades</h2>

<table class="table table-striped">
    <thead>
        <tr>
            <th>ID</th>
            <th>Amigo</th>
            <th>Status</th>
            <th>Ações</th>
        </tr>
    </thead>
    <tbody>
        <% for (Friendship amizade  : relatorio) { %>
        <tr>
            <td><%= amizade.getId() %></td>
            <td><%= amizade.getAmigoEmail() %></td>
            <td><%= amizade.getStatus() %></td>
            <td>
                 <form action="/amizade-remover" method="post" style="display: inline;">
                     <input type="hidden" name="action" value="DELETE">
                     <input type="hidden" name="id" value="<%= amizade.getId() %>">
                     <button type="submit" class="btn btn-danger">Deletar Amizade</button>
                 </form>
                 <form action="/atualizar-amizade" method="post" style="display: inline;">
                     <input type="hidden" name="action" value="PUT">
                     <input type="hidden" name="amigo" value="<%= amizade.getAmigoEmail() %>">
                     <input type="hidden" name="status" value="BLOQUEADO">
                     <button type="submit" class="btn btn-warning">Bloquear</button>
                 </form>
                 <form action="/atualizar-amizade" method="post" style="display: inline;">
                     <input type="hidden" name="action" value="PUT">
                     <input type="hidden" name="amigo" value="<%= amizade.getAmigoEmail() %>">
                     <input type="hidden" name="status" value="ACEITO">
                     <button type="submit" class="btn btn-success">Aceitar</button>
                 </form>
             </td>
        </tr>
        <% } %>
    </tbody>
</table>



<h2>Minhas amizades</h2>
    <main>
           <% for (int i = 0; i < amizades.size() ; i++) {  %>
                <div class="card">
                    <a href="detalhes?email=<%=amizades.get(i).getEmail()%>">
                     <img  src=<%= amizades.get(i).getImage()%> alt="...">
                          <ul id="menu" class="menu" style="display: none;">
                          <li><a type="submit" href="detalhes.jsp" onclick="return validarPerfilParaDetalhes(event)">Visualizar Perfil</a></li>
                          <li><a href="autenticador">Sair</a></li>
                          </ul>
					</a>
                    <ul>
                        <li><%= amizades.get(i).getNome() %> </li>
                        <li><%= amizades.get(i).getCurso() %> </li>
                        <li><%= amizades.get(i).getDataNascimento() %> anos</li>
                    </ul>
                    </div>
                <% } %>
    </main>
    <script src="./scripts/index.js"></script>
 </div>
</body>