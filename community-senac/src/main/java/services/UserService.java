package services;
import model.DAO.UserDAO;
import model.User;
import java.util.ArrayList;

//TODO CLASSE RESPONSÁVEL POR CRIAR REGRA DE NEGÓCIO E CHAMAR >>> A CLASSE DAO
public  class UserService {
    private final UserDAO userDAO = new UserDAO();

    //Verifica se o usuario ja existe pelo email, se não cria uma nova conta
    public boolean criarUsuario(User user) {
        boolean contaExiste = userDAO.buscarPorEmail(user.getEmail());
        if (contaExiste) {
            return false;
        }
        return userDAO.inserirUsuario(user);
    }
    //Verifica se a senha e o email estão certos, LOGIN
    public boolean autenticarUsuario(String email, String senha){
        return userDAO.buscarPorEmailSenha(email, senha);
    }
    public ArrayList<User> listarTodosUsuarios(){
        return userDAO.buscarTodos();
    }
    public ArrayList<User> listarUsuariosPorNome(String nome){
        return userDAO.buscarPorNome(nome);
    }
    public ArrayList<User> listarUsuariosPorCruso(String curso) {
        return userDAO.buscarPorCurso(curso);
    }
}



