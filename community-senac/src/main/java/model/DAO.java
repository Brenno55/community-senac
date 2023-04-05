package model;

import java.sql.Connection;
import java.sql.DriverManager;

public class DAO {

    private final String DRIVER = "org.h2.Driver";
    private final String URL = "jdbc:h2:~/test";
    private final String USER = "sa";
    private final String PASSWORD = "sa";

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
