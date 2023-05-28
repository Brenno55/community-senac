<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="model.User"%>

<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <title>Community Senac</title>

    <link rel="stylesheet"  href="./view/pages/index.css" media="screen" />
    <link rel="stylesheet" href="./view/pages/cadastro/cadastro.css" media="screen"/>

</head>
<body>

<%
    //String count = req.getAttribute("countV").toString();
   // User count =(User)request.getAttribute("countV");
   // usar uma validação de sessão, se ele não estiver, ai lancar uma variavel qualquer
   //int x = 0;
%>

<header style="background-color: #000000; position: fixed; top: 0; left: 0; width: 100%; ">

        <h1> <a href="/index.html">Community Senac</a></h1>

        <section>
            <a href="/login.html">Login</a>
            <a href="/sobre.html">Sobre</a>


        </section>

    </header>

<container class="container" >

    <h1>Community Senac</h1>
    <h2>Crie sua conta</h2>

    <form action="/user" name="frmContato" method="post">
        <svg></svg>
        <input type="text" name="nome" placeholder="Nome" />
        <svg></svg>
        <input type="email" name="email" placeholder="E-mail"/>
        <svg></svg>
        <input type="password" name="senha" placeholder="Senha"/>

        <input type="number" name="count" placeholder="" hidden="hidden" value={0}/>
        <button onclick="return validarCadastro()" >Cadastrar</button>
    </form>

    <script src="./scripts/validador.js"></script>
</container>
</body>
</html>