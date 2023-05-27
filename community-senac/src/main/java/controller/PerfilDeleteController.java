package controller;

import model.DAO.UserDAO;
import model.User;
import services.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet( urlPatterns = {"/delete-user"})
public class PerfilDeleteController extends HttpServlet {

    public UserDAO repository = new UserDAO();
    public UserService userService = new UserService(repository);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        String usuarioExcluido = req.getParameter("excluirPorEmail");

        boolean excluindoUsuario = userService.excluindoUsuario(usuarioExcluido);

        if (!excluindoUsuario) {
            System.out.println("****Erro****");
        } else {
            resp.sendRedirect("/");
        }

    }
}
