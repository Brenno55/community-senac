<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="model.User"%>
<%@ page import="java.util.ArrayList"%>
<% ArrayList<User> amizades  = (ArrayList<User>)request.getAttribute("amizades");
 User userS = (User)session.getAttribute("sessionUser");
%>

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

    <main>
           <% for (int i = 0; i < amizades.size() ; i++) {  %>
                <div class="card">
                    <a href="detalhes?email=<%=lista.get(i).getEmail()%>">
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