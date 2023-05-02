

<!DOCTYPE html>
<html lang="pt-br">
<head>

    <meta charset="UTF-8">
    <title>Community Senac</title>
    <link rel="stylesheet"  href="./view/pages/index.css" media="screen" />
    <link rel="stylesheet" href="./view/pages/perfil/perfil.css" media="screen"/>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.16/jquery.mask.min.js"></script>


</head>
<body>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="model.User"%>
<% User user = (User)session.getAttribute("sessionUser");%>

<container class="container" >
    <h1>Edite seu perfil</h1>

    <form action="/perfil" name="frmPerfil" method="post">
    <hr size="3" width="100%" color="black">

    <div class="formContainer">
       <div class="parte1">

        <label for="nome">Nome:</label>
        <input type="text" name="nome" placeholder="nome" value=<%=user.getNome()%>>
        <label for="email">Email:</label>
        <input type="text" name="email" placeholder="Email" value=<%=user.getEmail()%>>
        <label for="senha">Senha</label>
        <input type="password" name="senha" placeholder="Senha" value=<%=user.getSenha()%>>
        <label for="telefone">Celular:</label>
        <input type="tel" maxlength="15" onkeyup="handlePhone(event)" />
        </div>

        <div class="imagem">
        <label for="imagemUsuario">
        <img id="previaDaImagem" src="/view/assents/avatar_placeholder.svg" alt="Selecione uma foto" id="imagemSVG">
        </label>
        <input id="imagemUsuario" type="file" style="display: none;"  accept="image/*">
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
        <input type="text" name="bio" maxlength="300" placeholder="">

            </div>
        </div>

        <div class="button">
        <button onclick="validarPerfil()">Finalizar</button>
        <script src="./scripts/validador.js"></script>
        </div>

    <script src="./scripts/perfil.js"></script>
    </form>



</container>
</body>
</html>