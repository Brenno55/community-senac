package Controllers;

import model.User;
import services.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet( urlPatterns = {"/user", "/user-create"})
public class UserController extends HttpServlet {
    UserService service = new UserService();
    User user = new User();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        user.setNome(req.getParameter("nome"));
        user.setEmail(req.getParameter("email"));
        user.setSenha(req.getParameter("senha"));

        User userCriado = service.createUser(user);

        if (userCriado == null) {
            System.out.println("setei o parametro 1");
            req.setAttribute("count", 1);
            req.getRequestDispatcher("cadastro.html").forward(req, resp);
            System.out.println("entrei no else");

           // setAttribute
        } else {
            req.getRequestDispatcher("perfil.html").forward(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
