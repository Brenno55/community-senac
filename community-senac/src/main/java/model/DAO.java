package model;

import java.sql.Connection;
import java.sql.DriverManager;

public class DAO {

    private final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private final String URL = "jdbc:mysql://127.0.0.1:3306/dbcommunity?useTimezone=true&serverTimezone=UTC";
    private final String USER = "root";
    private final String PASSWORD = "1234";

    //método de conexão:
    private Connection conectar(){
        Connection con; // =  null

        try {
            Class.forName(DRIVER);
            con = DriverManager.getConnection(URL,USER,PASSWORD);
            return con;
        } catch (Exception e){
            System.out.println(e);
            return null;
        }
    }

    // teste de conexão
    public void  testeConexao(){
        try {
            Connection con = conectar();
            System.out.println(con);
            con.close();

            System.out.println("Teste de conexão Dao ok!");
        } catch (Exception e){
            System.out.println(e);
        }
    }
}
