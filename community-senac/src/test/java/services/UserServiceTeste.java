package services;

//import buildermaster.BuilderMaster;
//import builders.UserBuilder;
import model.DAO.UserDaoInMemory;
import model.User;
import org.junit.Before;
import org.junit.Test;

import static builders.UserBuilder.*;
//import static builders.UserBuilder.inicializarDadosPadroes;

public class UserServiceTeste {
    private UserService service;
    private UserDaoInMemory repository;
    @Before
    public void setup(){
        service = new UserService(repository);
    }

    @Test
    public void deveCriarUsuario(){
        // cenário:
         User user = umUser().agora();
        // acão:

        // verificação:

    }

    public static void main(String[] args) {
       // new BuilderMaster().gerarCodigoClasse(User.class);
    }

}
// cenário:
// acão:
// verificação:
