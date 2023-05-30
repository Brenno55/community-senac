package model.DAO;

import model.User;
import model.repositories.RepositoryDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class UserDAO implements RepositoryDao {
    private final String DRIVER = "org.h2.Driver";
    private final String URL = "jdbc:h2:~/test";
    private final String USER = "sa";
    private final String PASSWORD = "sa";

    //TODO CLASSE RESPONSÁVEL POR TODAS AS FUNÇÕES PARA MANIPULAR O BANCO DE DADOS (TABELA USUÁRIO)!
    @Override
    public boolean inserirUsuario(User user){
        String SQL = "INSERT INTO usuario (nome, email, senha) VALUES (?, ?, ?)";
        System.out.println("entra no insert do usuario");
        try {
            Connection conectar = conectar();
            PreparedStatement pst = conectar.prepareStatement(SQL);
            System.out.println("ele conecta o prepare");

            pst.setString(1, user.getNome());
            System.out.println("ele seta  o nome");
            pst.setString(2, user.getEmail());
            System.out.println(" ele seta o email");
            pst.setString(3, user.getSenha());
            System.out.println("ele seta a senha");
            pst.executeUpdate();

            conectar.close();
            System.out.println("ele insere o usuario");
            return true;
        } catch (Exception e) {
            System.out.println("entra na exceção do insert");
            return false;
        }
    }
    @Override
    public boolean inserirDetalhesDoUsuario(User user){
        String SQL = "UPDATE usuario SET data_nascimento = ?, celular = ?, curso = ?, sexo = ?, bio = ?, image = ? WHERE email = ?";
        System.out.println("Entrar no UPDATE do usuario");

        try {
            Connection conectar = conectar();
            PreparedStatement pst = conectar.prepareStatement(SQL);
            System.out.println("conecta o prepare");

            pst.setString(1, user.getDataNascimento());
            pst.setString(2, user.getCelular());
            pst.setString(3, user.getCurso());
            pst.setString(4, user.getSexo());
            pst.setString(5, user.getBio());
            pst.setString(6, user.getImage());
            pst.setString(7, user.getEmail());
            pst.executeUpdate();

            System.out.println("Atualizou!!");

            conectar.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean ExcluindoUsuario(String email) {

        String SQL = "DELETE USUARIO WHERE email = ?";
        System.out.println("Entrar no Delete do usuario");

        try {
            Connection conectar = conectar();
            PreparedStatement pst = conectar.prepareStatement(SQL);
            System.out.println("conecta o prepare");

            pst.setString(1, email);
            pst.execute();

            System.out.println("excluido!!");

            conectar.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean buscarPorEmail(String email) {
        String SQL = "SELECT * FROM usuario WHERE email = ?";
        try {
            Connection conectar = conectar();
            PreparedStatement pst = conectar.prepareStatement(SQL);
            pst.setString(1, email);
            ResultSet rs = pst.executeQuery();
            conectar.close();

            return rs != null;

        } catch (Exception e) {
            return true;
        }
    }
    @Override
    public User buscarUsuarioPorEmail(String email){
        String SQL = "SELECT * FROM usuario WHERE email = (?)";
        User user = new User();
        try {
            Connection conectar = conectar();
            PreparedStatement pst = conectar.prepareStatement(SQL);
            pst.setString(1, email);
            ResultSet rs = pst.executeQuery();

            while (rs.next()){
                user.setNome(rs.getString("nome"));
                user.setEmail(rs.getString("email"));
                user.setSenha(rs.getString("senha"));
                user.setDataNascimento(rs.getString("data_nascimento"));
                user.setCelular(rs.getString("celular"));
                user.setCurso(rs.getString("curso"));
                user.setSexo(rs.getString("sexo"));
                user.setBio(rs.getString("bio"));
            }
            conectar.close();
            return user;

        } catch (Exception e) {
            System.out.println("buscarUsuarioLogado não passou");
            return null;
        }
    }
    public boolean buscarPorEmailSenha(String email, String senha){
        String SQL = "SELECT * FROM usuario WHERE email = (?) AND senha = (?)";

        try {
            Connection conectar = conectar();

            PreparedStatement pst = conectar.prepareStatement(SQL);
            pst.setString(1, email);
            pst.setString(2, senha);

            ResultSet rs = pst.executeQuery();

            if(rs.next()){
                return rs.getString("email").equals(email)
                    && rs.getString("senha").equals(senha);
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }
    @Override
    public ArrayList<User> buscarPorNome(String nome){
        String read = "SELECT nome, timestampdiff(year, data_nascimento, now()) as idade, curso, email FROM USUARIO WHERE nome LIKE (?) ORDER BY nome";
        String pesquisaAux = '%'  +nome+ '%';
        ArrayList<User> users = new ArrayList<>();

        try {
            Connection conectar = conectar();
            PreparedStatement pst = conectar.prepareStatement(read);
            pst.setString(1, pesquisaAux);
            ResultSet rs = pst.executeQuery();

            while (rs.next()){
                String nomeR = rs.getString("nome");
                String data_nascimento = rs.getString("idade");
                String cursoR = rs.getString("curso");
                String emailR = rs.getString("email");

                users.add(new User(nomeR, data_nascimento, cursoR, emailR));
            }
            conectar.close();

            return users;
        } catch (Exception e) {
            System.out.println(e + "Falha na conexão com bd index.");
            return null;
        }
    }
    @Override
    public ArrayList<User> buscarPorCurso(String curso){
        String SQL = "SELECT nome, timestampdiff(year, data_nascimento, now()) as idade, curso, email FROM USUARIO WHERE curso LIKE (?) ";
        String pesquisaAux = '%' +curso+ '%';
        ArrayList<User> users = new ArrayList<>();

        try {
            Connection conectar = conectar();
            PreparedStatement pst = conectar.prepareStatement(SQL);
            pst.setString(1, pesquisaAux);
            ResultSet rs = pst.executeQuery();

            while (rs.next()){
                String nome = rs.getString("nome");
                String data_nascimento = rs.getString("idade");
                String cursoR = rs.getString("curso");
                String emailR = rs.getString("email");

                users.add(new User(nome, data_nascimento, cursoR, emailR));
            }
            conectar.close();
            return users;
        } catch (Exception e) {
            System.out.println(e + "Falha na conexão com bd index do curso.");
            return null;
        }
    }
    @Override
    public ArrayList<User> buscarTodos(){
        String SQL = "select nome, timestampdiff(year, data_nascimento, now()) as idade, curso, email from usuario order by nome;";
        ArrayList<User> users = new ArrayList<>();

        try {
            Connection conectar = conectar();
            PreparedStatement pst = conectar.prepareStatement(SQL);
            ResultSet rs = pst.executeQuery();

            while (rs.next()){
                String nome  = rs.getString("nome");
                String data_nascimento  = rs.getString("idade");
                String curso  = rs.getString("curso");
                String email  = rs.getString("email");

                users.add(new User(nome, data_nascimento, curso, email));
            }
            conectar.close();
            return users;
        } catch (Exception e) {
            return null;
        }
    }

    public Connection conectar(){
        Connection con;
        try {
            Class.forName(DRIVER);
            con = DriverManager.getConnection(URL,USER,PASSWORD);
            System.out.println("Teste de conexão  dentro da dao ok");
            return con;
        } catch (Exception e){
            System.out.println(e);
            return null;
        }
    }

    public String getDRIVER() {
        return DRIVER;
    }
    public String getURL() {
        return URL;
    }
    public String getUSER() {
        return USER;
    }
    public String getPASSWORD() {
        return PASSWORD;
    }
}
