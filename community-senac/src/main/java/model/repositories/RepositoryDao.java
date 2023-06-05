package model.repositories;

import model.Friendship;
import model.User;
import java.util.ArrayList;

public interface RepositoryDao {
    public ArrayList<User> buscarTodos(String meuEmail);
    public ArrayList<User> buscarPorCurso(String meuEmail, String curso);
    public ArrayList<User> buscarPorNome(String meuEmail, String nome);
    public boolean buscarPorEmailSenha(String email, String senha);
    public User buscarUsuarioPorEmail(String email);

    boolean ExcluindoUsuario(String email);

    public boolean buscarPorEmail(String email);
    public boolean inserirDetalhesDoUsuario(User user);
    public boolean inserirUsuario(User user);

    public void criarAmizade(String userEmail, String amigoEmail, String status );
    public void removerAmizade(String userEmail, String amigoEmail );
    public void atualizarStatusAmizade(String userEmail, String amigoEmail, String status );
    public ArrayList<User> buscarAmizadesAceitas(String email);





}
