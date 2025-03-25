package domaine;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;

public class Boisson extends Produit {

    public transient BooleanProperty selectedProperty; // Propriété pour la sélection (comme dans Repas)

    public Boisson(int idProduit, String nom, String description, double prix, int stock) {
        super(idProduit, nom, description, prix, stock);
        this.selectedProperty = new SimpleBooleanProperty(false); // Initialisé à false
    }

    // Getter pour selectedProperty (nécessaire pour les CheckBox)
    public BooleanProperty selectedProperty() {
        return selectedProperty;
    }
}