package model.DAO;

import model.User;
import model.repositories.RepositoryDao;

import java.util.ArrayList;

public class UserDaoInMemory implements RepositoryDao {
    @Override
    public ArrayList<User> buscarTodos() {
        return null;
    }

    @Override
    public ArrayList<User> buscarPorCurso(String curso) {
        return null;
    }

    @Override
    public ArrayList<User> buscarPorNome(String nome) {
        return null;
    }

    @Override
    public boolean buscarPorEmailSenha(String email, String senha) {
        return false;
    }

    @Override
    public User buscarUsuarioLogado(String email) {
        return null;
    }

    @Override
    public boolean buscarPorEmail(String email) {
        return false;
    }

    @Override
    public boolean inserirDetalhesDoUsuario(User user) {
        return false;
    }

    @Override
    public boolean inserirUsuario(User user) {
        return false;
    }
}
