package model.DAO;

import model.Friendship;
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
    public void criarAmizade(String userEmail, String amigoEmail, String status) {

    }

    @Override
    public void removerAmizade(String userEmail, String amigoEmail) {

    }

    @Override
    public void atualizarStatusAmizade(String userEmail, String amigoEmail, String status) {

    }

    @Override
    public ArrayList<User> buscarAmizadesAceitas(String email) {
        return null;
    }

    @Override
    public ArrayList<Friendship> relatorioAmizades(String email) {
        return null;
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
    public ArrayList<User> buscarTodos(String meuEmail) {
        return null;
    }

    @Override
    public ArrayList<User> buscarPorCurso(String meuEmail, String curso) {
        return null;
    }

    @Override
    public ArrayList<User> buscarPorNome(String meuEmail, String nome) {
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

    @Override
    public boolean ExcluindoUsuario(String email) {
        return false;
    }
}
