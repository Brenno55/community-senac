package services;
import model.DAO.UserDAO;
import model.User;
import java.util.ArrayList;

//TODO CLASSE RESPONSÁVEL POR CRIAR REGRA DE NEGÓCIO E CHAMAR >>> A CLASSE DAO
public  class UserService {
    private final UserDAO userDAO = new UserDAO();

    public boolean criarUsuario(User user) {
        boolean contaExiste = userDAO.buscarPorEmail(user.getEmail());
        if (contaExiste) {
            return userDAO.inserirUsuario(user);
        }
        return false;

    }

    public boolean atulizandoUsuario(User user){
        return userDAO.inserirDetalhesDoUsuario(user);
    }
    public boolean autenticarUsuario(String email, String senha){
        return userDAO.buscarPorEmailSenha(email, senha);
    }
    public ArrayList<User> listarTodosUsuarios(){
        return userDAO.buscarTodos();
    }
    public ArrayList<User> listarUsuariosPorNome(String nome){
        return userDAO.buscarPorNome(nome);
    }
    public ArrayList<User> listaUsuariosPorCurso(String curso) {
        return userDAO.buscarPorCurso(curso);
    }
    public User buscarUsuarioLogado(String email){
        return userDAO.buscarUsuarioLogado(email);
    }
}



