package dao;

import database.DatabaseConnection;
import models.Commande;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CommandeDAO {

    // Méthode pour ajouter une commande
    public void addCommande(Commande commande) {
        String sql = "INSERT INTO Commande (client_id, montant_total, mode_paiement, statut) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, commande.getClientId());
            stmt.setDouble(2, commande.getMontantTotal());
            stmt.setString(3, commande.getModePaiement().toString());
            stmt.setString(4, commande.getStatut().toString());
            stmt.executeUpdate();
            System.out.println("Commande ajoutée avec succès !");
        } catch (SQLException e) {
            System.err.println("Erreur lors de l'ajout de la commande : " + e.getMessage());
        }
    }

    // Méthode pour obtenir toutes les commandes d'un client
    public List<Commande> getCommandesByClientId(int clientId) {
        String sql = "SELECT * FROM Commande WHERE client_id = ?";
        List<Commande> commandes = new ArrayList<>();
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, clientId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Commande commande = new Commande(rs.getInt("id"),
                        rs.getInt("client_id"),
                        rs.getDouble("montant_total"),
                        rs.getString("mode_paiement"),
                        rs.getString("statut"));
                commandes.add(commande);
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de la récupération des commandes : " + e.getMessage());
        }
        return commandes;
    }

    // Méthode pour supprimer une commande
    public void deleteCommande(int id) {
        String sql = "DELETE FROM Commande WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Commande supprimée avec succès !");
        } catch (SQLException e) {
            System.err.println("Erreur lors de la suppression de la commande : " + e.getMessage());
        }
    }
}
