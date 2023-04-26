package model;

public class User {
    private String nome;
    private String data_nascimento;
    private String sexo;
    private String bio;
    private String celular;
    private String curso;
    private String email;
    private String senha;


    public User() {
    }
    //USANDO ESSE CONSTRUTOR NA HOME
    public User(String nome, String data_nascimento, String curso ) {
        this.nome = nome;
        this.data_nascimento = data_nascimento;
        this.curso = curso;
    }
    public User(String nome, String data_nascimento, String sexo, String bio, String celular, String curso, String email, String senha) {
        this.nome = nome;
        this.data_nascimento = data_nascimento;
        this.sexo = sexo;
        this.bio = bio;
        this.celular = celular;
        this.curso = curso;
        this.email = email;
        this.senha = senha;
    }


    public String getNome() {
        return nome.toLowerCase();
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getData_nascimento() {return data_nascimento;}

    public void setData_nascimento(String data_nascimento) {this.data_nascimento = data_nascimento;}

    public String getCelular() {return celular;}

    public void setCelular(String celular) {this.celular = celular;}

    public String getCurso() {return curso;}

    public void setCurso(String cFacul) {this.curso = curso;}

    public String getSexo() {return sexo;}

    public void setSexo(String sexo) {this.sexo = sexo;}

    public String getBio() {return bio;}

    public void setBio(String bio) {this.bio = bio;}
}
