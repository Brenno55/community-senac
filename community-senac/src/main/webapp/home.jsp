<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <title>Community Senac</title>
    <link  type="text/css" rel="stylesheet" href="/view/css/home.css">
    <link type="text/css" rel="stylesheet" href="/view/pages/index.css">

</head>

<body>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="model.User"%>
<% User userS = (User)session.getAttribute("sessionUser"); %>

<header>

    <h1>Community Senac</h1>

    <form action="/home-header">
        <input type="text" placeholder="Pesquisar pelo nome da pessoa"
        name="search-header" id="search-header"
        >

        <button adicionar type="submit">
             Pesquisar
        </button>
    </form>

    <section>
         <p> <%= userS.getNome() %> </p>
         <a href="autenticador">Sair</a>

        <a href="/detalhes.html"><img src= "/view/assents/avatar_placeholder.svg" alt=""></a>
    </section>

</header>

 <div class="container">

    <div class="block">
        <h1>Possiveis conexões</h1>

        <div class="filtros"  >
                <input hidden type="checkbox" class="estados" id="acre" name="estado" value="AC">
                <label hidden for="acre">Acre</label><br>
            <button type="submit"><span>+</span>Adicionar Filtro</button>
        </div>
    </div>

    <main>
     <c:forEach var="user" items="${users}" >
                <div class="card">
                    <a href="/detalhes.html"><img src= "/view/assents/avatar_placeholder.svg"alt=${user.nome}></a>
                    <ul>
                        <li>${user.getNome()}</li>
                        <li>${user.getData_nascimento()} anos</li>
                        <li>${user.getCurso()}</li>
                        <li><a href="/details:${user.getEmail()}">Ver mais</a></li>
                     </ul>
                </div>
        </c:forEach>
    </main>
 </div>
</body>