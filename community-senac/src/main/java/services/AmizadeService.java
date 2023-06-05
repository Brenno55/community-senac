package services;

import model.User;
import model.repositories.RepositoryDao;

import java.util.ArrayList;

public class AmizadeService {

    private final RepositoryDao repository;
    public AmizadeService(RepositoryDao repository) {
        this.repository = repository;
    }

    public void criarAmizade(String userEmail, String amigoEmail, String status ){
        repository.criarAmizade(userEmail, amigoEmail, status);
    }
    public void removerAmizade(String userEmail, String amigoEmail ){
        repository.removerAmizade(userEmail,amigoEmail);

    }
    public void atualizarStatusAmizade(String userEmail, String amigoEmail, String status ){
        repository.atualizarStatusAmizade(userEmail, amigoEmail, status);
    }
    public ArrayList<User> buscarAmizadesAceitas(String email){
        return repository.buscarAmizadesAceitas(email);
    }
}
