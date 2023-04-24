<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="model.User"%>


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

<%  User userAutenticado = (User)session.getAttribute("usuAutenticado");  %>


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
         <p> <%= userAutenticado.getNome() %> </p>
         <a href="autenticador">Sair</a>

        <img src= "/view/assents/avatar_placeholder.svg" alt="">
    </section>

</header>

 <div class="container">

    <div class="block">
        <h1>Possiveis conexões</h1>

        <div class="filtros" hide>
                <input type="checkbox" class="estados" id="acre" name="estado" value="AC">
                <label for="acre">Acre</label><br>

                <input type="checkbox" class="estados" id="goias" name="estado" value="GO">
                <label for="goias">Goiás</label><br>
            <button><span>+</span>Adicionar Filtro</button>
        </div>
    </div>

    <main>
     <c:forEach var="user" items="${users}" >
                <div class="card">
                    <img
                        src= "/view/assents/avatar_placeholder.svg"
                         alt=${user.nome}
                    >
                    <ul>
                        <li>${user.getNome()}</li>
                        <li>${user.getData_nascimento()}</li>
                        <li>${user.getcFacul()}</li>
                        <li><a href="/details:${user.id}">Ver mais</a></li>
                     </ul>
                </div>
        </c:forEach>
    </main>
 </div>
</body>