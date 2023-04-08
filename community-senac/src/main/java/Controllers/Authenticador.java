package Controllers;

import model.User;
import services.UserCreate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

    @WebServlet("/authenticador")
    public class Authenticador extends HttpServlet {
        private static final long serialVersionUID = 1L;

        public Authenticador(){
            super();
        }

        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
           HttpSession sessao = req.getSession(false); // se a sessao existir ela vai passar a ser falsa.
            if (sessao != null){
                sessao.invalidate();
            }
            resp.sendRedirect("login.html");
        }

        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            String semail = req.getParameter("email");
            String ssenha = req.getParameter("senha");

            User usu = new User();
            usu.setEmail(semail);
            usu.setSenha(ssenha);

            UserCreate usuCre = new UserCreate();
            User usuAuthenticado = usuCre.autenticacao(usu);

            if (usuAuthenticado != null){
                HttpSession sessao = req.getSession();
                sessao.setAttribute("usuAutenticado", usuAuthenticado);
                //sessao.setMaxInactiveInterval(600000);//tempo de intervalo da sessão

                //req.getRequestDispatcher("/index").forward(req,resp);

                resp.sendRedirect("/index");

            }else {
                resp.sendRedirect("erroLogin.jsp");
            }
        }
    }
