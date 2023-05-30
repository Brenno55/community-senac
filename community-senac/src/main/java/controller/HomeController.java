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
import java.util.List;

@WebServlet( urlPatterns = {"/home", "/home-header", "/home-filter"})
public class HomeController extends HttpServlet {

    public UserDAO repository = new UserDAO();
    public UserService userService = new UserService(repository);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getServletPath();
        System.out.println("1 - chamada na rota: " + action);

        if (action.equals("/home")) {
            HttpSession sessao = req.getSession();
            User user = (User)sessao.getAttribute("sessionUser");
            List<User> lista = userService.listarTodosUsuarios(user.getEmail());
            req.setAttribute("users", lista);
            req.getRequestDispatcher("home.jsp").forward(req,resp);

        } else if (action.equals("/home-header")){
            String filtro = req.getParameter("search-header");
            HttpSession sessao = req.getSession();
            User user = (User)sessao.getAttribute("sessionUser");

            List<User> lista = userService.listarUsuariosComFiltro(user.getEmail(), filtro);
            req.setAttribute("users", lista);
            req.getRequestDispatcher("home.jsp").forward(req,resp);
        }else if(action.equals("/detalhes")){
            String email = req.getParameter("email");
            User user = userService.buscarUsuarioPorEmail(email);
            req.setAttribute("user", user);
            req.getRequestDispatcher("detalhes.jsp").forward(req,resp);
        }else {
            resp.sendRedirect("erroResource.html");
        }
    }
}
