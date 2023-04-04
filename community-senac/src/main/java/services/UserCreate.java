package services;

import model.DAO;
import model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
            System.out.println("parei no insert");
            System.out.println(e);
        }
    }
}



