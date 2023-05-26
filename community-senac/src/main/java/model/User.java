package model;

public class User {
    private String nome;
    private String dataNascimento;
    private String sexo;
    private String bio;
    private String celular;
    private String curso;
    private String email;
    private String senha;
    private String image;


    public User() {
    }
    //USANDO ESSE CONSTRUTOR NA HOME

    public User(String nome, String dataNascimento, String curso, String email) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.curso = curso;
        this.email = email;
    }
    public User(String nome, String dataNascimento, String sexo, String bio, String celular, String curso, String email, String senha, String image) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.sexo = sexo;
        this.bio = bio;
        this.celular = celular;
        this.curso = curso;
        this.email = email;
        this.senha = senha;
        this.image = image;
    }


    public String getNome() {
        return nome;
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

    public String getDataNascimento() {return dataNascimento;}

    public void setDataNascimento(String dataNascimento) {this.dataNascimento = dataNascimento;}

    public String getCelular() {return celular;}

    public void setCelular(String celular) {this.celular = celular;}

    public String getCurso() {return curso;}

    public void setCurso(String curso) {this.curso = curso;}

    public String getSexo() {return sexo;}

    public void setSexo(String sexo) {this.sexo = sexo;}

    public String getBio() {return bio;}

    public void setBio(String bio) {this.bio = bio;}

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

}
