package controller;

import model.DAO.UserDAO;
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
    public UserDAO repository = new UserDAO();
    public UserService userService = new UserService(repository);
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
            HttpSession sessao = req.getSession();
            sessao.setAttribute("sessionUser", user);
            req.getRequestDispatcher("perfil.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String senha = req.getParameter("senha");

        boolean usuarioAutenticado = userService.autenticarUsuario(email, senha);

        User user = userService.buscarUsuarioPorEmail(email);

        System.out.println("Informações do user logado -> ");
        System.out.println(user.getNome());
        System.out.println(user.getSenha());

        if(usuarioAutenticado){
            HttpSession sessao = req.getSession();
            sessao.setAttribute("sessionUser", user);
            resp.sendRedirect("/home");
        } else {
            resp.sendRedirect("erroLogin.html");
        }
    }
}

