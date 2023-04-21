package Controllers;

import model.User;
import services.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user")
public class UserController extends HttpServlet {
    UserService service = new UserService();
    User user = new User();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("entrei no post");
        user.setNome(req.getParameter("nome"));
        user.setEmail(req.getParameter("email"));
        user.setSenha(req.getParameter("senha"));
        System.out.println("setei os parametros");
        User userCriado = service.createUser(user);
        System.out.println("instanciei o user");
        if (userCriado == null) {
            req.getRequestDispatcher("cadastro.html").forward(req, resp);
            System.out.println("entrei no if");
           // setAttribute
        } else {
            req.getRequestDispatcher("perfil.html").forward(req, resp);
            System.out.println("entrei no else");
        }

    }



}
