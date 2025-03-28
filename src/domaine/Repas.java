package domaine;

import java.util.ArrayList;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;

public class Repas extends Produit {
    
    private ArrayList<Supplement> accompagnements;
    public transient BooleanProperty selectedProperty; // Propriété pour la sélection

    public Repas(int idProduit, String nom, String description, double prix, int stock) {
        super(idProduit, nom, description, prix, stock);
        this.accompagnements = new ArrayList<>();
        this.selectedProperty = new SimpleBooleanProperty(false); // Initialisé à false
    }

    public ArrayList<Supplement> getAccompagnements() {
        return accompagnements;
    }

    public void ajouterAccompagnement(Supplement accompagnement) {
        accompagnements.add(accompagnement);
    }

    @Override
    public void afficherDetails() {
        super.afficherDetails();
        System.out.println("Stock : " + getStock() + " | Accompagnements : " + accompagnements);
    }

    @Override
    public String toString() {
        return "Repas{" +
                "idProduit=" + getIdProduit() +
                ", nom='" + getNom() + '\'' +
                ", description='" + getDescription() + '\'' +
                ", prix=" + getPrix() +
                ", stock=" + getStock() +
                ", accompagnements=" + accompagnements +
                '}';
    }

    @Override
    public int getStock() {
        return super.getStock();
    }

    @Override
    public void setStock(int stock) {
        super.setStock(stock);
    }

    // Getter pour la propriété selectedProperty
    public BooleanProperty selectedProperty() {
        return selectedProperty;
    }
}