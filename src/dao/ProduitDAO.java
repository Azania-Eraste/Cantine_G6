package dao;

import database.DatabaseConnection;
import models.Produit;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProduitDAO {

    // Méthode pour ajouter un produit
    public void addProduit(Produit produit) {
        String sql = "INSERT INTO Produit (nom, prix) VALUES (?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, produit.getNom());
            stmt.setDouble(2, produit.getPrix());
            stmt.executeUpdate();
            System.out.println("Produit ajouté avec succès !");
        } catch (SQLException e) {
            System.err.println("Erreur lors de l'ajout du produit : " + e.getMessage());
        }
    }

    // Méthode pour récupérer tous les produits
    public List<Produit> getAllProduits() {
        String sql = "SELECT * FROM Produit";
        List<Produit> produits = new ArrayList<>();
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Produit produit = new Produit(rs.getInt("id"),
                        rs.getString("nom"),
                        rs.getDouble("prix"));
                produits.add(produit);
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de la récupération des produits : " + e.getMessage());
        }
        return produits;
    }
}
