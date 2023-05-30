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
    public boolean excluindoUsuario(String usuarioExcluido){
        return repository.ExcluindoUsuario(usuarioExcluido);
    }

    public boolean autenticarUsuario(String email, String senha){
        return repository.buscarPorEmailSenha(email, senha);
    }
    public ArrayList<User> listarTodosUsuarios(){
        return repository.buscarTodos();
    }
    public ArrayList<User> listarUsuariosComFiltro(String filtro){
        ArrayList<User> users = repository.buscarPorNome(filtro);
        if(users.size() == 0){
            System.out.println("retorna a busca por curso");
            return repository.buscarPorCurso(filtro);
        }else{
            System.out.println("retorna nada, porq ele so busca por nomes");
            return users;
        }
    }
    public User buscarUsuarioPorEmail(String email){
        return repository.buscarUsuarioPorEmail(email);
    }
}



