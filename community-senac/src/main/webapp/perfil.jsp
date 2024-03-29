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

    <a href="/home"><h1>Community Senac</h1></a>

    <section>
        <p> <%= user.getNome() %> </p>
        <a href="autenticador">Sair</a>
        <img src=<%=user.getImage()%> alt="">
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
        <input type="text" name="email" placeholder="Email" value=<%=user.getEmail()%> readonly>
        <label for="senha">Senha</label>
        <input type="password" name="senha" placeholder="Senha" value=<%=user.getSenha()%>>
        <label for="telefone">Celular:</label>
        <input type="tel" name="celular" maxlength="11" value=<%=user.getCelular()%>>
        </div>

        <div class="imagem">
        <label for="imagemUsuario">

        <img id="previaDaImagem" src=<%=user.getImage()%>
        value="${pageContext.request.scheme}://${pageContext.request.serverName}:${pageContext.request.serverPort}/${user.image}"
        alt="Selecione uma foto">

        <div class="camera-wrapper">
        <img id="camera" src="/view/assents/camera.svg" alt="Camera Icon">
        </div>
        </label>
        <input id="imagemUsuario" type="file" name="file" style="display: none;" accept="image/*" </div>
</div>
     <div class="parte2">

        <label for="dataNascimento">Data:</label>
        <input type="date" max="2004-12-31" min="1900-12-31" name="dataNascimento" placeholder="" value=<%=user.getDataNascimento()%>>

        <label for="curso">Curso:</label>
        <select name="curso">
            <option value="valorDoBD"><%=user.getCurso()%></option>
            <option value="Analise e Desenvolvimento de Sistemas">Analise e Desenvolvimento de Sistemas</option>
            <option value="Redes de Computadores">Redes de Computadores</option>
            <option value="Moda">Moda</option>
            <option value="Gastronomia">Gastronomia</option>
            <option value="Recursos Humanos">Recursos Humanos</option>
            <option value="Contabilidade">Contabilidade</option>
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

    <div class ="botaoExcluir">
            </form>
            <form action="/delete-user" method="post">
            <input type="hidden" id="excluirPorEmail" name="excluirPorEmail" value=<%=user.getEmail()%>>
            <button class="button" type="submit">Delete</button>
            </form>
            </div>

</container>

    <script src="./scripts/perfil.js"></script>

</body>
</html>