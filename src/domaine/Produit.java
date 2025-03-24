package domaine;

public class Produit {
    private int idProduit;
    private String nom;
    private String description;
    private double prix;
    private String categorie;

    // Constructeur
    public Produit(int idProduit, String nom, String description, double prix, String categorie) {
        this.idProduit = idProduit;
        this.nom = nom;
        this.description = description;
        this.prix = prix;
        this.categorie = categorie;
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

    public String getCategorie() {
        return categorie;
    }

    // Affichage des détails du produit
    public void afficherDetails() {
        System.out.println(nom + " - " + description + " | Prix: " + prix + "€ | Catégorie: " + categorie);
    }
}
