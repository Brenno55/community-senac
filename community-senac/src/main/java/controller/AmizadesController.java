package controller;

import model.DAO.UserDAO;
import model.User;
import services.AmizadeService;
import services.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet( urlPatterns = {"/amizades?email"})
public class AmizadesController  extends HttpServlet {

    public UserDAO repository = new UserDAO();
    public AmizadeService amizadeService = new AmizadeService(repository);


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getServletPath();
        HttpSession sessao = req.getSession();
        User user = (User)sessao.getAttribute("sessionUser");


        if (action.equals("/amizades?email")) {

            List<User> amizades = amizadeService.buscarAmizadesAceitas(user.getEmail());

            req.setAttribute("amizades", amizades);
            req.getRequestDispatcher("amizades.jsp").forward(req,resp);

        } else {
            resp.sendRedirect("erroResource.html");
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
