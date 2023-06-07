package controller;

import model.DAO.UserDAO;
import model.Friendship;
import model.User;
import services.AmizadeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet( urlPatterns = {"/amizades", "/solicitar-amizade", "/atualizar-amizade", "/amizade-remover"})
public class AmizadesController  extends HttpServlet {

    public UserDAO repository = new UserDAO();
    public AmizadeService amizadeService = new AmizadeService(repository);


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getServletPath();
        HttpSession sessao = req.getSession();
        User user = (User)sessao.getAttribute("sessionUser");

        if (action.equals("/amizades")) {
            System.out.println("EEEE" + user.getEmail());
            List<User> amizades = amizadeService.buscarAmizadesAceitas(user.getEmail());
            req.setAttribute("amizades", amizades);

            List<Friendship> relatorio = amizadeService.relatorioAmizades(user.getEmail());
            req.setAttribute("relatorio", relatorio);

            req.getRequestDispatcher("amizades.jsp").forward(req, resp);
        } else {
            req.getRequestDispatcher("erroResource.html").forward(req, resp);

        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getServletPath();
        HttpSession sessao = req.getSession();
        User user = (User)sessao.getAttribute("sessionUser");


        String emailUser = user.getEmail();
        String emailAmigo = req.getParameter("amigo");
        repository.criarAmizade(emailUser, emailAmigo, "PENDENTE");
        resp.sendRedirect("/home");
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getServletPath();
        HttpSession sessao = req.getSession();
        User user = (User)sessao.getAttribute("sessionUser");


        String emailUser = user.getEmail();
        String emailAmigo = req.getParameter("friend");
        repository.removerAmizade(emailUser, emailAmigo);
        req.getRequestDispatcher("/amizades").forward(req, resp);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getServletPath();
        HttpSession sessao = req.getSession();
        User user = (User)sessao.getAttribute("sessionUser");

        String emailUser = user.getEmail();
        String emailAmigo = req.getParameter("friend");
        String status = req.getParameter("status");

        repository.atualizarStatusAmizade(emailUser, emailAmigo, status);
        req.getRequestDispatcher("/amizades").forward(req, resp);
    }
}
