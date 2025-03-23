public class Supplement {
    private String nom;
    private double prix;

    public Supplement(String nom, double prix) {
        this.nom = nom;
        this.prix = prix;
    }

    public String getNom() {
        return nom;
    }

    public double getPrix() {
        return prix;
    }

    @Override
    public String toString() {
        return nom + " (" + prix + " FCFA)";
    }
}
