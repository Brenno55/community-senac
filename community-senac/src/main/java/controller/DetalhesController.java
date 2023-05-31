package controller;

import model.DAO.UserDAO;
import model.User;
import services.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet( urlPatterns = {"/detalhes?email", "/detalhes"})

public class DetalhesController extends HttpServlet {
    public UserDAO repository = new UserDAO();
    public UserService userService = new UserService(repository);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        User user = userService.buscarUsuarioPorEmail(email);

        req.setAttribute("nome", user.getNome());
        req.setAttribute("bio", user.getBio());
        req.setAttribute("dataNascimento", user.getDataNascimento());
        req.setAttribute("sexo", user.getSexo());
        req.setAttribute("curso", user.getCurso());
        req.setAttribute("celular", user.getCelular());
        req.setAttribute("image", user.getImage());

        RequestDispatcher rd = req.getRequestDispatcher("detalhes.jsp");
        rd.forward(req, resp);

    }
}
