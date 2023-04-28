package services;

import buildermaster.BuilderMaster;
import builders.UserBuilder;
import model.User;
import org.junit.Before;
import org.junit.Test;

import static builders.UserBuilder.*;
import static builders.UserBuilder.inicializarDadosPadroes;

public class UserServiceTeste {
    private UserService service;

    @Before
    public void setup(){
        service = new UserService();
    }

    @Test
    public void deveCriarUsuario(){
        // cenário:
         User user = umUser().agora();
        // acão:

        // verificação:

    }

    public static void main(String[] args) {
        new BuilderMaster().gerarCodigoClasse(User.class);
    }

}
// cenário:
// acão:
// verificação:
