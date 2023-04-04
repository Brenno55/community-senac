package model;

import java.sql.Connection;
import java.sql.DriverManager;

public class DAO {

    private final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private final String URL = "jdbc:mysql://127.0.0.1:3306/dbcommunity?useTimezone=true&serverTimezone=UTC";
    private final String USER = "root";
    private final String PASSWORD = "1234";

    public Connection conectar(){
        Connection con; // =  null

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
    public void  testeConexao(){
        try {
            Connection con = this.conectar();
            System.out.println(con);
            con.close();

            System.out.println("Teste de conexão Dao ok!");
        } catch (Exception e){
            System.out.println(e);
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
