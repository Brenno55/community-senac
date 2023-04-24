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
//TODO CLASSE RESPONSÁVEL POR TODAS AS FUNÇÕES DE REQUISIÇÕES WEB, QUE CHAMARÁ >>> A CLASSE SERVICE
@WebServlet( urlPatterns = {"/user"})
public class UserController extends HttpServlet {
    private final UserService userService = new UserService();
    private final User user = new User();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        user.setNome(req.getParameter("nome"));
        user.setEmail(req.getParameter("email"));
        user.setSenha(req.getParameter("senha"));

        boolean userCriado = userService.criarUsuario(user);

        if (!userCriado) {
            req.setAttribute("countV", 1);
            String count = req.getAttribute("countV").toString();
            System.out.println(count + " ->>>>");
            req.getRequestDispatcher("cadastro.jsp").forward(req, resp);
        } else {
            req.getRequestDispatcher("perfil.html").forward(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String senha = req.getParameter("senha");

        boolean usuarioAutenticado = userService.autenticarUsuario(email, senha);

        if(usuarioAutenticado){
            HttpSession sessao = req.getSession();
            sessao.setAttribute("usuarioAutenticado", usuarioAutenticado);

            resp.sendRedirect("/home");
        } else {
            resp.sendRedirect("erroLogin.html");
        }
    }
}

