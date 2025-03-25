package controllers;

import models.Produit;
import dao.ProduitDAO;

public class ProduitController {
    private ProduitDAO produitDAO;

    public ProduitController() {
        this.produitDAO = new ProduitDAO();
    }

    // Créer un nouveau produit
    public void createProduit(String nom, double prix) {
        Produit produit = new Produit(nom, prix);
        produitDAO.addProduit(produit);
    }

    // Lire un produit par ID
    public Produit getProduitById(int id) {
        return produitDAO.getProduitById(id);
    }

    // Mettre à jour un produit
    public void updateProduit(int id, String nom, double prix) {
        Produit produit = new Produit(id, nom, prix);
        produitDAO.updateProduit(produit);
    }

    // Supprimer un produit
    public void deleteProduit(int id) {
        produitDAO.deleteProduit(id);
    }
}
