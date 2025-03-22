package domaine;

import java.sql.Date;

public class Client {
    private String nom;
    private String prenom;
    private String numero;
    private String email;
    private Date date_naissance;

    public Client(String nom, String prenom, String numero, String email, Date date_naissance) {
        this.nom = nom;
        this.prenom = prenom;
        this.numero = numero;
        this.email = email;
        this.date_naissance = date_naissance;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getPrenom() {
        return prenom;
    }
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    public String getNumero() {
        return numero;
    }
    public void setNumero(String numero) {
        this.numero = numero;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public Date getDate_naissance() {
        return date_naissance;
    }
    public void setDate_naissance(Date date_naissance) {
        this.date_naissance = date_naissance;
    }


}
