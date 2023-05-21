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
        <p> fulano </p>
        <a href="autenticador">Sair</a>

        <img src= "/view/assents/avatar_placeholder.svg" alt="">
    </section>

</header>
<main>

    <div class="containerLeft">
        <h2>Nome da pessoa</h2>

        <img src="/view/assents/avatar_placeholder.svg" alt="">

        <section>
            <ul>
                <li>Data de nascimento: </li>
                <li>Sexo: </li>
                <li>Curso: </li>
                <li>Celular: </li>
            </ul>
        </section>
    </div>

    <div class="containerRight">
        <h2>Biografia</h2>
        <p>
            Meu nome e fulano, eu tenho 18 anos e meu instagram é @pessoa 123 Além de Cooper, a tripulação da Endurance
            é formada pela bióloga Amelia, filha de Brand; o cientista Romilly, o físico planetário Doyle, além dos robôs
            TARS e CASE. Eles entram no buraco de minhoca e se dirigem a Miller, porém descobrem que o planeta possui enorme
            dilatação gravitacional temporal por estar tão perto de Gargântua: cada hora na superfície equivale a sete anos
            na Terra. Eles entram em Miller e descobrem que é inóspito já que é coberto por um oceano raso e agitado por
            ondas enormes. Uma onda atinge a tripulação enquanto Amelia tenta recuperar os dados de Miller, matando Doyle
            e atrasando a partida. Ao voltarem para a Endurance, Cooper e Amelia descobrem que 23 anos se passaram.
        </p>
    </div>


</main>

</body>
</html>