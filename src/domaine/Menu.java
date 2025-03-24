package domaine;

import java.util.ArrayList;
import java.util.List;


public class Menu extends Produit{
    private List<Produit> produits;

    // Constructeur par défaut, initialisant une liste vide
    public Menu() {
        this.produits = new ArrayList<>();
    }

    // Constructeur permettant d'initialiser directement avec une liste de produits
    public Menu(List<Produit> produits) {
        this.produits = produits;
    }

    // Méthode pour ajouter un produit
    public void ajouterProduit(Produit produit) {
        produits.add(produit);
    }

    // Méthode pour retirer un produit
    public boolean retirerProduit(Produit produit) {
        return produits.remove(produit);
    }

    // Getter pour la liste des produits
    public List<Produit> getProduits() {
        return produits;
    }

    // Affichage complet du menu
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Menu :\n");
        for (Produit produit : produits) {
            sb.append("- ").append(produit.getNom())
              .append(" : ").append(produit.getPrix()).append("€\n");
        }
        return sb.toString();
    }
}
