

<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <title>Community Senac</title>
    <link rel="stylesheet"  href="./view/pages/index.css" media="screen" />
    <link rel="stylesheet" href="./view/pages/perfil/perfil.css" media="screen"/>
</head>
<body>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="model.User"%>
<% User user = (User)session.getAttribute("sessionUser");%>


<container class="container" >
    <h1>Edite seu perfil</h1>

    <form action="/perfil" name="frmContato" method="post">

    <div class="formContainer">
       <div class="parte1">

        <label for="nome">Nome:</label>
        <input type="text" name="nome" placeholder="nome" value=<%=user.getNome()%>>
        <label for="email">Email:</label>
        <input type="text" name="email" placeholder="Email" value=<%=user.getEmail()%>>
        <label for="senha">Data</label>
        <input type="password" name="senha" placeholder="Senha" value=<%=user.getSenha()%>>
        <label for="celular">Celular:</label>
        <input type="int"  name="celular" maxlength="11" minlength="11 placeholder="Celular">
        </div>


     <div class="parte2">

        <label for="data_nascimento">Data:</label>
        <input type="date" max="9999-12-31" name="data_nascimento" placeholder="">
        <label for="curso">Curso:</label>
        <select name="curso">
            <option value="null">Curso</option>
            <option value="analise">ADS</option>
            <option value="analise">Administração</option>
            <option value="analise">Redes de computadores</option>
            <option value="analise">Nutrição</option>
        </select>
        <label for="sexo">Sexo:</label>
        <select name="sexo">
            <option value="null">sexo</option>
            <option value="masculino">Masculino</option>
            <option value="feminino">Feminino</option>
        </select>
        <label for="bio">Biografia:</label>
        <input type="text" name="bio" maxlength="10" minlength="10" placeholder="">

            </div>
        </div>
        <button onclick="validarPerfil()">Finalizar</button>
        <script src="./scripts/validador.js"></script>
    </form>



</container>
</body>
</html>