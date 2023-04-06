<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="model.User"%>
<%@ page import="java.util.ArrayList"%>

<% ArrayList<User> lista = (ArrayList<User>)request.getAttribute("users");
   String avatar;
   String altText = "Imagem da pessoa";
%>

<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <title>Community Senac</title>
    <link  type="text/css" rel="stylesheet" href="/view/pages/home/style.css">
    <link type="text/css" rel="stylesheet" href="/view/pages/index.css">
</head>

<body>

 <div class="container">

    <div class="block">
        <h1>Possiveis conexões</h1>

        <button><span>+</span>Adicionar Filtro</button>
    </div>

    <main>
        <% for (int i = 0; i < lista.size() ; i++) {  %>

            <div class="card">
                <img
                    src= "/view/assents/avatar_placeholder.svg"
                     alt="foto do usuario"
                >
                <ul>

                 <li> <%= lista.get(i).getNome() %> </li>
                    <li>instagram</li>
                    <li><a href="/details">Ver main</a></li>
                 </ul>
            </div>

        <% } %>
    </main>
 </div>



</body>