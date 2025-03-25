package dao;

import database.DatabaseConnection;
import models.Paiement;

import java.sql.*;

public class PaiementDAO {

    // Méthode pour ajouter un paiement
    public void addPaiement(Paiement paiement) {
        String sql = "INSERT INTO Paiement (mode, montant) VALUES (?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, paiement.getMode());
            stmt.setDouble(2, paiement.getMontant());
            stmt.executeUpdate();
            System.out.println("Paiement ajouté avec succès !");
        } catch (SQLException e) {
            System.err.println("Erreur lors de l'ajout du paiement : " + e.getMessage());
        }
    }
}
