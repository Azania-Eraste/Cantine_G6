package domaine;

import java.util.ArrayList;

public class Repas extends Produit {
    
    private ArrayList<String> accompagnements; // Liste des accompagnements

    // Constructeur corrigé
    public Repas(int idProduit, String nom, String description, double prix, int stock) {
        super(idProduit, nom, description, prix, stock); // Appel au constructeur de Produit
        this.accompagnements = new ArrayList<>(); // Initialisation de la liste
    }

    // Getter pour accompagnements
    public ArrayList<String> getAccompagnements() {
        return accompagnements;
    }

    // Ajouter un accompagnement
    public void ajouterAccompagnement(String accompagnement) {
        accompagnements.add(accompagnement);
    }

    // Redéfinition de afficherDetails pour inclure les accompagnements et le stock
    @Override
    public void afficherDetails() {
        super.afficherDetails(); // Appel à la méthode de Produit
        System.out.println("Stock : " + getStock() + " | Accompagnements : " + accompagnements);
    }

    // Redéfinition de toString pour un affichage complet
    @Override
    public String toString() {
        return "Repas{" +
                "idProduit=" + getIdProduit() +
                ", nom='" + getNom() + '\'' +
                ", description='" + getDescription() + '\'' +
                ", prix=" + getPrix() +
                ", categorie='" + '\'' +
                ", stock=" + getStock() +
                ", accompagnements=" + accompagnements +
                '}';
    }



    @Override
    public int getStock() {
        // TODO Auto-generated method stub
        return super.getStock();
    }



    @Override
    public void setStock(int stock) {
        // TODO Auto-generated method stub
        super.setStock(stock);
    }
}