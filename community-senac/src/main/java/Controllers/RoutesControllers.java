package Controllers;

import model.DAO;
import model.User;
import services.UserCreate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
    @WebServlet( urlPatterns = {"/Controller", "/insert", "/login", "/sobre", "/index"})
    public class RoutesControllers extends HttpServlet {

        DAO dao = new DAO();
        User user = new User();
        public RoutesControllers(){
            super();
        }

        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            String action = req.getServletPath();
            System.out.println("1 - chamada na rota: " + action);

            if(action.equals("/insert")){
                System.out.println("2 - Redirecionei para a o metodo que faz o cadastro");
                handleCadastro(req,resp);
            } else if (action.equals("/login")) {
                RequestDispatcher rd = req.getRequestDispatcher("/view/pages/sobre/sobre.html");
                rd.forward(req, resp);
            } else if (action.equals("/sobre")) {
                RequestDispatcher rd = req.getRequestDispatcher("/view/pages/sobre/sobre.html");
                rd.forward(req, resp);
            } else if (action.equals("/index")) {
                RequestDispatcher rd = req.getRequestDispatcher("/view/pages/index/index.jsp");
                rd.forward(req, resp);
            } else {
                RequestDispatcher rd = req.getRequestDispatcher("index.html");
                rd.forward(req, resp);
            }

        }

        protected void handleCadastro(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            System.out.println("3- Entrei na funcão handleCadastro");
            dao.testeConexao();

            // setar as variaveis do usuario
            user.setNome(req.getParameter("nome"));
            user.setEmail(req.getParameter("email"));
            user.setSenha(req.getParameter("senha"));
            System.out.println("4- Setei as variaveis");
            // Invocar o método createUser passando o objt user:
            UserCreate create = new UserCreate();

            create.createUser(user); // insert no banco.
            System.out.println("5-  Rota controller: INSERT OK!");

            resp.sendRedirect("/view/pages/login/login.html");
        }

    }
