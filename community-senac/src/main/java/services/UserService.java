package services;

import model.DAO;
import model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

// Classe criada com o intuito de separar as funcionalidades da aplicação por serviços.
public  class UserService {
    DAO dao = new DAO(); //injeção da dependência da DAO.

    public UserService() {

    }

    public User createUser(User user) {
        System.out.println("Entrei no user create");
        boolean eUsuarioExiste = procureEmail(user);
        System.out.println("passei pelo boolean");
        if (eUsuarioExiste) {
            System.out.println("Entrei no if do email");
            return null;
        }
        System.out.println("passei pelo if");
        String create = "INSERT INTO usuario (nome, email, senha) values (?, ?, ?)";

        try {
            Connection conectar = dao.conectar();
            PreparedStatement pst = conectar.prepareStatement(create);

            pst.setString(1, user.getNome());
            pst.setString(2, user.getEmail());
            pst.setString(3, user.getSenha());
            pst.executeUpdate();

            conectar.close();
            System.out.println("fiz o insert");
            return user;
        } catch (Exception e) {
            System.out.println("parei no createUser");
            System.out.println(e);
            return null;
        }
    }

    public void createUserAux(User user) {
        String create = "insert into auxUser (data_nascimento, celular, cFacul, sexo, bio) values (?, ?, ?, ?, ?)";

        try {
            // abrir conexão com o banco:
            Connection conectar = dao.conectar();

            // preparar a query para execução.
            PreparedStatement pst = conectar.prepareStatement(create);
            // Substituir os parâmetros (?) pelas variaveis

            pst.setString(1, user.getData_nascimento());
            pst.setString(2, user.getCelular());
            pst.setString(3, user.getcFacul());
            pst.setString(4, user.getSexo());
            pst.setString(5, user.getBio());

            // executar a query:
            pst.executeUpdate();
            conectar.close();
        } catch (Exception e) {
            System.out.println("parei no insert -> createUser");
            System.out.println(e);
        }
    }

    public boolean procureEmail(User user) {
        String emailExistente = "SELECT email FROM usuario WHERE email = (?) ";

        boolean x = false;


        try {
            Connection conectar = dao.conectar();
            PreparedStatement pst = conectar.prepareStatement(emailExistente);

            pst.setString(1, user.getEmail());

            ResultSet rs = pst.executeQuery();
            x = rs.next();
            conectar.close();
            return x;

        } catch (Exception e) {
            System.out.println(e);
            return x;
        }

    }

    public boolean procureCelular(User user){
        String emailExistente = "SELECT celular FROM auxUser WHERE celular = (?) ";
        try {
            Connection conectar = dao.conectar();
            PreparedStatement pst = conectar.prepareStatement(emailExistente);

            pst.setString(1, user.getCelular());

            ResultSet rs = pst.executeQuery();

            conectar.close();
            return true;
        } catch (Exception e) {
            System.out.println("parei no select -> procureEmail");
            System.out.println(e);
            return false;
        }
    }

    public boolean procureSenha(User user){
        String senha = "SELECT email, senha  FROM usuario WHERE email = (?) AND senha = (?) ";
        try {
            Connection conectar = dao.conectar();
            PreparedStatement pst = conectar.prepareStatement(senha);

            pst.setString(1, user.getEmail());
            pst.setString(2, user.getSenha());

            ResultSet rs = pst.executeQuery();
            conectar.close();
            return true;
        } catch (Exception e) {
            System.out.println("parei no select -> procureSenha");
            System.out.println(e);
            return false;
        }
    }


    public ArrayList<User> listarContatos() {
        // Criando um obj para acessar a classe User
        ArrayList<User> users = new ArrayList<>();

        String read = "SELECT * FROM usuario ORDER BY nome";

        try {
            Connection conectar = dao.conectar();
            PreparedStatement pst = conectar.prepareStatement(read);
            ResultSet rs = pst.executeQuery();

            // o laço vai ser executado enquanto tiver usuarios:

            while (rs.next()){ // next é um método dentro do objt ResultSet usado para listar os dados;

                // variaveis de apoio que recebem os dados do banco:

                String nome  = rs.getString(1);
                String email = rs.getString(2);

                // populando o array list
                users.add(new User(nome, email));

            }
            conectar.close();
            return users;
        } catch (Exception e) {
            System.out.println(e);
            return  null;
        }
    }

    public User autenticacao(User user){
        User usuRetorno = null;
        String sql = "SELECT * FROM usuario WHERE email = (?) and senha = (?) ";

        try {
            Connection conectar = dao.conectar();
            PreparedStatement pst = conectar.prepareStatement(sql);

            pst.setString(1, user.getEmail());
            pst.setString(2, user.getSenha());

            ResultSet rs = pst.executeQuery();
            // caso o usuario for existente:
            if (rs.next()) {
                //instância o obj User;
                usuRetorno = new User();
                usuRetorno.setNome(rs.getString("nome"));
                usuRetorno.setEmail(rs.getString("email"));
                usuRetorno.setSenha(rs.getString("senha"));
            }

        } catch (Exception e){
            System.out.println(e);
        }
        return usuRetorno;
    }
}



