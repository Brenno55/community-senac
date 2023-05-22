package services;
import model.User;
import model.repositories.RepositoryDao;

import java.util.ArrayList;

//TODO CLASSE RESPONSÁVEL POR CRIAR REGRA DE NEGÓCIO E CHAMAR >>> A CLASSE DAO
public  class UserService {
    private final RepositoryDao repository;

    public UserService(RepositoryDao repository) {
        this.repository = repository;
    }
    public boolean criarUsuario(User user) {
        boolean contaExiste = repository.buscarPorEmail(user.getEmail());
        if (contaExiste) {
            return repository.inserirUsuario(user);
        }
        return false;

    }
    public boolean atulizandoUsuario(User user){
        return repository.inserirDetalhesDoUsuario(user);
    }
    public boolean autenticarUsuario(String email, String senha){
        return repository.buscarPorEmailSenha(email, senha);
    }
    public ArrayList<User> listarTodosUsuarios(){
        return repository.buscarTodos();
    }
    public ArrayList<User> listarUsuariosPorNome(String nome){
        return repository.buscarPorNome(nome);
    }
    public ArrayList<User> listaUsuariosPorCurso(String curso) {
        return repository.buscarPorCurso(curso);
    }
    public User buscarUsuarioPorEmail(String email){
        return repository.buscarUsuarioPorEmail(email);
    }
}



