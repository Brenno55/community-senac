package Controllers;

import model.User;
import services.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet( urlPatterns = {"/user"})
public class UserController extends HttpServlet {
    UserService service = new UserService();
    User user = new User();

    //login e cadastro.
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getServletPath();
        System.out.println(action);

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

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getServletPath();
        System.out.println(action);

        String semail = req.getParameter("email");
        String ssenha = req.getParameter("senha");

        User usu = new User();
        usu.setEmail(semail);
        usu.setSenha(ssenha);

        User usuAutenticado = service.autenticacao(usu);

        if(usuAutenticado != null){
            HttpSession sessao = req.getSession();
            sessao.setAttribute("usuAutenticado", usuAutenticado);

            System.out.println("usuario authenticado");
            resp.sendRedirect("/home");
            // Não mandar para tela de perfil pois
        } else {
            resp.sendRedirect("erroLogin.html");
        }
    }
}

