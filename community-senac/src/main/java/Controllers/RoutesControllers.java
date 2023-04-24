package Controllers;

import model.DAO;
import model.User;
import services.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
    @WebServlet( urlPatterns = {"/sobre", "/autenticador", "/erroLogin"})
    public class RoutesControllers extends HttpServlet {

        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            String action = req.getServletPath();
            System.out.println("1 - chamada na rota: " + action);

            if (action.equals("/autenticador")) {
                HttpSession sessao = req.getSession(false);
                if(sessao!=null){
                    sessao.invalidate();
                }
                System.out.println("sessão falsa");
                resp.sendRedirect("login.html");
            } else if (action.equals("/sobre")) {
                RequestDispatcher rd = req.getRequestDispatcher("/view/pages/sobre/sobre.html");
                rd.forward(req, resp);
            } else  if (action.equals("/erroLogin")) {
                resp.sendRedirect("erroLogin.html");
            } else   {
                resp.sendRedirect("/erroResource.html.html");
            }
        }
    }
