package model.DAO;

import model.User;
import model.repositories.RepositoryDao;

import java.util.ArrayList;

public class UserDaoInMemory implements RepositoryDao {
    public ArrayList<User> list = new ArrayList<>();
    @Override
    public boolean inserirUsuario(User user) {
        try {
            list.add(user);
            return true;
        } catch (Exception e){
            System.out.println(e);
            return false;
        }
    }
    @Override
    public boolean inserirDetalhesDoUsuario(User user) {
        boolean encontrou = false;
        for (User u : list) {
            if (u.getEmail() == user.getEmail()) {
                // mesmo identificador, então atualiza os valores
                u.setNome(user.getNome());
                u.setEmail(user.getEmail());
                u.setSenha(user.getSenha());
                u.setCurso(user.getCurso());
                u.setCelular(user.getCelular());
                u.setDataNascimento(user.getDataNascimento());
                u.setSexo(user.getSexo());
                u.setBio(user.getBio());

                encontrou = true;
                break;
            }
        }
        return encontrou;
    }
    @Override
    public boolean buscarPorEmail(String email) {
        boolean filtroEmail = (email.trim().isEmpty());
        for (User u: list){
            if (u.getEmail().contains(email.trim()) || filtroEmail){
                return true;
            }

        }
        return false;
    }
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
    public User buscarUsuarioPorEmail(String email) {
        return null;
    }
}
