<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="model.User"%>
<%@ page import="java.util.ArrayList"%>

<%
   User usuAutenticado = (User)session.getAttribute("usuAutenticado");
   ArrayList<User> lista = (ArrayList<User>)request.getAttribute("users");

   String avatar;
   String altText = "Imagem da pessoa";

    //tratamento nome do usuario
    String nomeUsuario= usuAutenticado.getNome();
    String[] vet = nomeUsuario.split(" ");
    String firstName = vet[0];
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

<header>

    <h1>Community Senac</h1>

    <form action="">
        <input type="text"  placeholder="Pesquisar pelo nome da pessoa">

        <button>
             Pesquisar
        </button>
    </form>

    <section>
         <p> <%= firstName %> </p>
         <a href="autenticador">Sair</a>

        <img src= "/view/assents/avatar_placeholder.svg" alt="">
    </section>



</header>


 <div class="container">

    <div class="block">
        <h1>Possiveis conexões</h1>

        <button><span>+</span>Adicionar Filtro</button>
    </div>

    <main>
        <% for (int i = 0; i < lista.size() ; i++) {

                   String nomeUsuario1 = lista.get(i).getNome();
                   String[] vet1 = nomeUsuario.split(" ");
                   String firstName1 = vet[0];
                %>
                <div class="card">
                    <img
                        src= "/view/assents/avatar_placeholder.svg"
                         alt="foto do usuario"
                    >
                    <ul>

                     <li> <%= firstName1 %> </li>
                        <li>instagram</li>
                        <li><a href="/details">Ver mais</a></li>
                     </ul>
                </div>

        <% } %>
    </main>
 </div>



</body>