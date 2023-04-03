package Controllers;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
    @WebServlet( urlPatterns = {"/Controller", "/cadastro", "/login", "/sobre"})
    public class RoutesControllers extends HttpServlet {
        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            String action = req.getServletPath();
            System.out.println("chamada na rota: " + action);

            if (action.equals("/cadastro")){
                RequestDispatcher rd = req.getRequestDispatcher("/view/pages/cadastro/cadastro.html");
                rd.forward(req, resp);
            } else if (action.equals("/login")) {
                RequestDispatcher rd = req.getRequestDispatcher("/view/pages/login/login.html");
                rd.forward(req, resp);
            } else if (action.equals("/sobre")) {
                RequestDispatcher rd = req.getRequestDispatcher("/view/pages/sobre/sobre.html");
                rd.forward(req, resp);
            } else {
                RequestDispatcher rd = req.getRequestDispatcher("index.html");
                rd.forward(req, resp);
            }

        }

    }
