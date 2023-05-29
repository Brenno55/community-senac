<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <title>Community Senac</title>

    <link rel="stylesheet"  href="./view/pages/index.css" media="screen" />
    <link rel="stylesheet" href="./view/css/detalhes.css" media="screen"/>

</head>
<body>

<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="model.User"%>
<% User user = (User)session.getAttribute("sessionUser"); %>

<header style="background-color: #000000;">

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
        <p> fulano </p>
        <a href="autenticador">Sair</a>

        <img src="/view/assents/avatar_placeholder.svg" alt="">
    </section>

</header>
<main>

    <div class="containerLeft">
        <h2> <%out.print(request.getAttribute("nome"));%> </h2>

        <img src="/view/assents/avatar_placeholder.svg" alt="">

        <section>
            <ul>
                <li>Data de Nascimento: <%out.print(request.getAttribute("dataNascimento"));%> </li>
                <li>Sexo: <%out.print(request.getAttribute("sexo"));%> </li>
                <li>Curso: <%out.print(request.getAttribute("curso"));%> </li>
                <li>Celular: <%out.print(request.getAttribute("celular"));%> </li>
            </ul>
        </section>
    </div>

    <div class="containerRight">
        <h2>Biografia</h2>
        <p>  <%out.print(request.getAttribute("bio"));%> </p>
    </div>


</main>

</body>
</html>