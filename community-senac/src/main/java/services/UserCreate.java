package services;

import model.DAO;
import model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

// Classe criada com o intuito de separar as funcionalidades da aplicação por serviços.
public  class UserCreate  {
    DAO dao = new DAO();

    public void createUser(User user){
        String create = "INSERT INTO usuario (nome, email, senha) values (?, ?, ?)";

        try {
            // abrir conexão com o banco:
            Connection conectar = dao.conectar();

            // preparar a query para execução.
            PreparedStatement pst = conectar.prepareStatement(create);
            // Substituir os parâmetros (?) pelas variaveis

            pst.setString(1, user.getNome());
            pst.setString(2, user.getEmail());
            pst.setString(3, user.getSenha());

            // executar a query:
            pst.executeUpdate();
            conectar.close();
        } catch (Exception e) {
            System.out.println("parei no insert -> createUser");
            System.out.println(e);
        }
    }

    public boolean procureEmail(User user){
        String emailExistente = "SELECT email FROM usuario WHERE email = (?) ";
        try {
            Connection conectar = dao.conectar();
            PreparedStatement pst = conectar.prepareStatement(emailExistente);

            pst.setString(1, user.getEmail());

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


}



