<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="model.User"%>
<%@ page import="java.util.ArrayList"%>
<% ArrayList<User> lista = (ArrayList<User>)request.getAttribute("users");
 User userS = (User)session.getAttribute("sessionUser");
%>

<!DOCTYPE html>
<html lang="pt-br">
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
        <input type="text" placeholder="Pesquisar pelo nome da pessoa"
        name="search-header" id="search-header"
        >

        <button adicionar type="submit">
             Pesquisar
        </button>
    </form>

    <section>
         <a href="/perfil.jsp"><p><%= userS.getNome() %></p></a>
         <a href="autenticador">Sair</a>

        <a href="/detalhes.jsp"><img src= "/view/assents/avatar_placeholder.svg" alt=""></a>
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
					    <img
                        src= "/view/assents/avatar_placeholder.svg"
                        alt="foto do usuario">
					</a>
                    <ul>
                        <li><%= lista.get(i).getNome() %> </li>
                        <li><%= lista.get(i).getCurso() %> </li>
                        <li><%= lista.get(i).getDataNascimento() %> anos</li>
                    </ul>
                    </div>
                <% } %>
    </main>
 </div>
</body>