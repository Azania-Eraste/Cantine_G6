package domaine;

public class Produit {
    

    private int idProduit;
    private String nom;
    private String description;
    private double prix;
    private int stock; // Attribut spécifique à Repas

    // Constructeur
    public Produit(int idProduit, String nom, String description, double prix, int stock) {
        this.idProduit = idProduit;
        this.nom = nom;
        this.description = description;
        this.prix = prix;      
        this.stock = stock;
    }

    public void setIdProduit(int idProduit) {
        this.idProduit = idProduit;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    // Getters
    public int getIdProduit() {
        return idProduit;
    }

    public String getNom() {
        return nom;
    }

    public String getDescription() {
        return description;
    }

    public double getPrix() {
        return prix;
    }

    // Affichage des détails du produit
    public void afficherDetails() {
        System.out.println(nom + " - " + description + " | Prix: " + prix + "€ ");
    }
}
