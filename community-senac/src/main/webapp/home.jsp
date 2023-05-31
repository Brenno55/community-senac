<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="model.User"%>
<%@ page import="java.util.ArrayList"%>
<% ArrayList<User> lista = (ArrayList<User>)request.getAttribute("users");
 User userS = (User)session.getAttribute("sessionUser");
%>

<!DOCTYPE html>
<html lang="pt-br">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<head>
    <meta charset="UTF-8">
    <title>Community Senac</title>
    <link  type="text/css" rel="stylesheet" href="/view/css/home.css">
    <link type="text/css" rel="stylesheet" href="/view/pages/index.css">

</head>
<body>
<header style="background-color: #000000">

    <a href="/home"><h1>Community Senac</h1></a>

    <form action="/home-header">
        <input type="text" placeholder="Pesquisar por nome ou curso"
        name="search-header" id="search-header"
        >

        <button adicionar type="submit">
             Pesquisar
        </button>
    </form>

    <section>
         <p style="margin-right: 10px;"><%= userS.getNome() %> </p>
         <img name="avatar" id="avatar" src=<%= userS.getImage()%> alt="">
         <ul id="menu" class="menu">
           <li><a href="perfil.jsp">Editar Perfil</a></li>
           <li><a href="autenticador">Sair</a></li>
         </ul>
    </section>

</header>

 <div class="container">

    <div class="block">
        <h1>Possiveis conexões</h1>


    </div>

    <main>
           <% for (int i = 0; i < lista.size() ; i++) {  %>
                <div class="card">
                    <a href="detalhes?email=<%=lista.get(i).getEmail()%>">
                     <img style="width: 140px; margin-top:10px; border-radius: 140px;" src=<%= lista.get(i).getImage()%> alt="...">
                          <ul id="menu" class="menu" style="display: none;">
                          <li><a type="submit" href="detalhes.jsp" onclick="return validarPerfilParaDetalhes(event)">Visualizar Perfil</a></li>
                          <li><a href="autenticador">Sair</a></li>
                          </ul>
					</a>
                    <ul>
                        <li><%= lista.get(i).getNome() %> </li>
                        <li><%= lista.get(i).getCurso() %> </li>
                        <li><%= lista.get(i).getDataNascimento() %> anos</li>
                    </ul>
                    </div>
                <% } %>
    </main>
    <script src="./scripts/index.js"></script>
 </div>
</body>