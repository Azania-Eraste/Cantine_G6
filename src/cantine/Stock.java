package cantine;

import java.util.HashMap;
import java.util.Map;

public class Stock {
    private Map<Integer, StockItem> produits;

    public Stock() {
        produits = new HashMap<>();
    }

    // Classe interne pour gérer le produit et sa quantité
    private class StockItem {
        Produit produit;
        int quantite;

        StockItem(Produit produit, int quantite) {
            this.produit = produit;
            this.quantite = quantite;
        }
    }

    // Ajouter un produit au stock
    public void ajouterProduit(Produit produit, int quantite) {
        if (produits.containsKey(produit.getIdProduit())) {
            produits.get(produit.getIdProduit()).quantite += quantite;
        } else {
            produits.put(produit.getIdProduit(), new StockItem(produit, quantite));
        }
    }

    // Retirer un produit du stock
    public boolean retirerProduit(int idProduit, int quantite) {
        if (produits.containsKey(idProduit)) {
            StockItem item = produits.get(idProduit);
            if (item.quantite >= quantite) {
                item.quantite -= quantite;
                if (item.quantite == 0) {
                    produits.remove(idProduit);
                }
                return true;
            } else {
                System.out.println("Stock insuffisant pour le produit: " + item.produit.getNom());
                return false;
            }
        } else {
            System.out.println("Produit non trouvé");
            return false;
        }
    }

    // Afficher les produits en stock
    public void afficherStock() {
        if (produits.isEmpty()) {
            System.out.println("Le stock est vide.");
        } else {
            for (StockItem item : produits.values()) {
                item.produit.afficherDetails();
                System.out.println("Quantité en stock: " + item.quantite);
                System.out.println("-----------------------------");
            }
        }
    }

    // Recherche par nom
    public void rechercherParNom(String nomRecherche) {
        boolean trouve = false;
        for (StockItem item : produits.values()) {
            if (item.produit.getNom().equalsIgnoreCase(nomRecherche)) {
                item.produit.afficherDetails();
                System.out.println("Quantité en stock: " + item.quantite);
                trouve = true;
            }
        }
        if (!trouve) {
            System.out.println("Aucun produit trouvé avec le nom : " + nomRecherche);
        }
    }

    // Recherche par catégorie
    public void rechercherParCategorie(String categorieRecherche) {
        boolean trouve = false;
        for (StockItem item : produits.values()) {
            if (item.produit.getCategorie().equalsIgnoreCase(categorieRecherche)) {
                item.produit.afficherDetails();
                System.out.println("Quantité en stock: " + item.quantite);
                trouve = true;
            }
        }
        if (!trouve) {
            System.out.println("Aucun produit trouvé dans la catégorie : " + categorieRecherche);
        }
    }
}
