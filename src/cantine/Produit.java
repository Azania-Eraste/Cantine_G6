package cantine;

public class Produit {
    private String nom;
    private double prix;

    // Constructeur
    public Produit(String nom, double prix) {
        this.nom = nom;
        this.prix = prix;
    }

    // Getter pour nom
    public String getNom() {
        return nom;
    }

    // Setter pour nom
    public void setNom(String nom) {
        this.nom = nom;
    }

    // Getter pour prix
    public double getPrix() {
        return prix;
    }

    // Setter pour prix
    public void setPrix(double prix) {
        this.prix = prix;
    }

    @Override
    public String toString() {
        return "Produit{" +
                "nom='" + nom + '\'' +
                ", prix=" + prix +
                '}';
    }
}
