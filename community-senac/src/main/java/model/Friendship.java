package model;
public class Friendship {
    private int id;
    private String userEmail;
    private String amigoEmail;
    private String status;
    // Outros campos relevantes para a amizade, se necessário

    public Friendship(int id, String userEmail, String amigoEmail, String status) {
        this.id = id;
        this.userEmail = userEmail;
        this.amigoEmail = amigoEmail;
        this.status = status;
    }
    // Getters e setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getAmigoEmail() {
        return amigoEmail;
    }

    public void setAmigoEmail(String amigoEmail) {
        this.amigoEmail = amigoEmail;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}