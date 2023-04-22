package Controllers;

import model.User;
import services.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet( urlPatterns = {"/user"})
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
            req.setAttribute("countV", 1);
            String count = req.getAttribute("countV").toString();
            System.out.println(count + " ->>>>");
            req.getRequestDispatcher("cadastro.jsp").forward(req, resp);
           // setAttribute
        } else {
            req.getRequestDispatcher("perfil.html").forward(req, resp);
        }
    }




}
