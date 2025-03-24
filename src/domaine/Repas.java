package domaine;

import java.util.ArrayList;


class Repas {
    private String nom;
    private String description;
    private int stock;
    private ArrayList<String> accompagnements;

    public Repas(String nom, String description, int stock) {
        this.nom = nom;
        this.description = description;
        this.stock = stock;
        this.accompagnements = new ArrayList<>();
    }

    public String getNom() { return nom; }
    public String getDescription() { return description; }
    public int getStock() { return stock; }
    public ArrayList<String> getAccompagnements() { return accompagnements; }

    public void ajouterAccompagnement(String accompagnement) {
        accompagnements.add(accompagnement);
    }

    @Override
    public String toString() {
        return "Repas{" +
                "nom='" + nom + '\'' +
                ", description='" + description + '\'' +
                ", stock=" + stock +
                ", accompagnements=" + accompagnements +
                '}';
    }
}
