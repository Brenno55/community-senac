package controller;

import model.User;
import services.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet( urlPatterns = {"/perfil"})

public class PerfilController extends HttpServlet {
    private final UserService userService = new UserService();
    private  User user = new User();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       //user = (User)session.getAttribute("sessionUser");
       resp.sendRedirect("/perfil.jsp");

        System.out.println(user.getEmail() + "email do usuario ao entrar no perfil");
    }

    //qunado é clicado para fazer insert
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        user.setData_nascimento(req.getParameter("data_nascimento"));
        user.setSexo(req.getParameter("sexo"));
        user.setBio(req.getParameter("bio"));
        user.setCelular(req.getParameter("celular"));
        user.setCurso(req.getParameter("curso"));
        user.setEmail(req.getParameter("email"));
        user.setNome(req.getParameter("nome"));

        boolean atualizado = userService.atulizandoUsuario(user);

        if (!atualizado) {
            System.out.println("****Erro****");
        } else {
            System.out.println("Atualizado!!!!");
            resp.sendRedirect("/home");
        }
    }
}
