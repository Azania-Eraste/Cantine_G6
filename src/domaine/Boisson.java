package domaine;

public class Boisson {
    private String nom;
    private String description;
    private int stock;

    public Boisson(String nom, String description, int stock) {
        this.nom = nom;
        this.description = description;
        this.stock = stock;
    }

    public String getNom() {
        return nom;
    }

    public String getDescription() {
        return description;
    }

    public int getStock() {
        return stock;
    }
}
