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
<%@ page import="model.User"%>
<% User user = (User)session.getAttribute("sessionUser");%>


<container class="container" >
    <header style="background-color: #000000; position: fixed; top: 0; left: 0; width: 100%; ">

    <h1>Community Senac</h1>


    <section>
        <p> <%= user.getNome() %> </p>
        <a href="autenticador">Sair</a>

        <img src= "/view/assents/avatar_placeholder.svg" alt="">
    </section>

    </header>
    <script src="./scripts/validador.js"></script>

    <form action="/perfil" name="frmPerfil" method="post" enctype="multipart/form-data">


     <div class="texto">
        <p>Edite seu perfil</p>
     </div>

    <div class="formContainer">



       <div class="parte1">

        <label for="nome">Nome:</label>
        <input type="text" name="nome" placeholder="nome" value=<%=user.getNome()%>>
        <label for="email">Email:</label>
        <input type="text" name="email" placeholder="Email" value=<%=user.getEmail()%>>
        <label for="senha">Senha</label>
        <input type="password" name="senha" placeholder="Senha" value=<%=user.getSenha()%>>
        <label for="telefone">Celular:</label>
        <input type="tel" name="celular" maxlength="15" onkeyup="handlePhone(event)"/ value=<%=user.getCelular()%>>
        </div>

        <div class="imagem">
        <label for="imagemUsuario">

        <img id="previaDaImagem" src="/view/assents/avatar_placeholder.svg"
        value="${pageContext.request.scheme}://${pageContext.request.serverName}:${pageContext.request.serverPort}/${user.image}"
        alt="Selecione uma foto">

        <div class="camera-wrapper">
        <img id="camera" src="/view/assents/camera.svg" alt="Camera Icon">
        </div>
        </label>
        <input id="imagemUsuario" type="file" name="file" style="display: none;" accept="image/*" </div>

     <div class="parte2">

        <label for="dataNascimento">Data:</label>
        <input type="date" max="9999-12-31" name="dataNascimento" placeholder="" value=<%=user.getDataNascimento()%>>

        <label for="curso">Curso:</label>
        <select name="curso" value=<%=user.getCurso()%>>
            <option value="valorDoBD"><%=user.getCurso()%></option>
            <option value="ADS">ADS</option>
            <option value="Banco de daods">Banco de dados</option>
            <option value="Redes de computadores">Redes de computadores</option>
            <option value="Moda">Moda</option>
        </select>
        <label for="sexo">Sexo:</label>
        <select name="sexo" id="sexo">
            <option value="salvo"><%=user.getSexo()%></option>
            <option value="masculino">Masculino</option>
            <option value="feminino">Feminino</option>
        </select>

        <label for="bio">Biografia:</label>
        <input type="text" name="bio" id="bio" class="biografia" maxlength="300" placeholder="" value=<%=user.getBio()%>>
            </div>

        </div>

        <div class="button">

        <button type="submit" onclick="return validarPerfil()">Finalizar</button>

        </div>



    </form>



</container>

    <script src="./scripts/perfil.js"></script>

</body>
</html>