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

<header>

    <a href="/home.jsp"><h1>Community Senac</h1></a>

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
        <h2>Nome da pessoa</h2>

        <img src="/view/assents/avatar_placeholder.svg" alt="">

        <section>
            <ul>
                <li>Data de nascimento: ${user.getDataNascimento()}</li>
                <li>Sexo: ${user.getSexo()}</li>
                <li>Curso: ${user.getCurso()}</li>
                <li>Celular: ${user.getCelular()}</li>
            </ul>
        </section>
    </div>

    <div class="containerRight">
        <h2>Biografia</h2>
        <p>${user.getBio()}</p>
    </div>


</main>

</body>
</html>