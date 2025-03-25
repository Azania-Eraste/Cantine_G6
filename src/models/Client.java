package models;

public class Client {
    private int id;
    private String nom;
    private String prenom;
    private String numero;
    private String email;
    private String identifiant;
    private int carteMidiId;

    // Constructeurs, getters et setters
    public Client(int id1, String nom, String prenom, String numero, String email, String identifiant) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.numero = numero;
        this.email = email;
        this.identifiant = identifiant;
        this.carteMidiId = carteMidiId;
    }

    public Client(String nom, String prenom, String numero, String email, String identifiant) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    // Getters et setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public String getPrenom() { return prenom; }
    public void setPrenom(String prenom) { this.prenom = prenom; }

    public String getNumero() { return numero; }
    public void setNumero(String numero) { this.numero = numero; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getIdentifiant() { return identifiant; }
    public void setIdentifiant(String identifiant) { this.identifiant = identifiant; }

    public int getCarteMidiId() { return carteMidiId; }
    public void setCarteMidiId(int carteMidiId) { this.carteMidiId = carteMidiId; }
}
