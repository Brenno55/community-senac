package controller;

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
    public UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getServletPath();
        System.out.println("1 - chamada na rota: " + action);

        if (action.equals("/home")) {
            List<User> lista = userService.listarTodosUsuarios();
            req.setAttribute("users", lista);
            req.getRequestDispatcher("home.jsp").forward(req,resp);

        } else if (action.equals("/home-header")){
            String nome = req.getParameter("search-header");

            List<User> lista = userService.listarUsuariosPorNome(nome);
            req.setAttribute("users", lista);
            req.getRequestDispatcher("home.jsp").forward(req,resp);
        } else if (action.equals("/home-filter")){
            String curso = req.getParameter("/home-filter");

            List<User> lista = userService.listaUsuariosPorCurso(curso);
            req.setAttribute("users", lista);
            req.getRequestDispatcher("home.jsp").forward(req,resp);
        }else {
            resp.sendRedirect("erroResource.html");
        }
    }
}
