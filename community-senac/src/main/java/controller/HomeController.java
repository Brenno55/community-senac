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
            List<User> lista = userService.listarTodosUsuarios();
            req.setAttribute("users", lista);
            req.getRequestDispatcher("home.jsp").forward(req,resp);

        } else if (action.equals("/home-header")){
            String filtro = req.getParameter("search-header");

            List<User> lista = userService.listarUsuariosComFiltro(filtro);
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
