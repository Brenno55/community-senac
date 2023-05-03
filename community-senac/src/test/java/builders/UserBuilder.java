package builders;

import java.util.Arrays;
import java.lang.String;
import model.User;

public class UserBuilder {
    private User elemento;
    private UserBuilder(){}

    public static UserBuilder umUser() {
        UserBuilder builder = new UserBuilder();
        inicializarDadosPadroes(builder);
        return builder;
    }

    public static void inicializarDadosPadroes(UserBuilder builder) {
        builder.elemento = new User();
        User elemento = builder.elemento;


        elemento.setNome("Teste");
        elemento.setData_nascimento("31/20/2003");
        elemento.setSexo("Masculino");
        elemento.setBio("Oi eu sou um usuário de teste");
        elemento.setCelular("11963486641");
        elemento.setCurso("Análise e Desenvolvimente de Sistemas");
        elemento.setEmail("teste123@teste123");
        elemento.setSenha("123");
    }

    public UserBuilder comNome(String param) {
        elemento.setNome(param);
        return this;
    }

    public UserBuilder comData_nascimento(String param) {
        elemento.setData_nascimento(param);
        return this;
    }

    public UserBuilder comSexo(String param) {
        elemento.setSexo(param);
        return this;
    }

    public UserBuilder comBio(String param) {
        elemento.setBio(param);
        return this;
    }

    public UserBuilder comCelular(String param) {
        elemento.setCelular(param);
        return this;
    }

    public UserBuilder comCurso(String param) {
        elemento.setCurso(param);
        return this;
    }

    public UserBuilder comEmail(String param) {
        elemento.setEmail(param);
        return this;
    }

    public UserBuilder comSenha(String param) {
        elemento.setSenha(param);
        return this;
    }

    public User agora() {
        return elemento;
    }
}