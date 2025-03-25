package dao;

import database.DatabaseConnection;
import models.Client;

import java.sql.*;

public class ClientDAO {

    // Méthode pour ajouter un client à la base de données
    public void addClient(Client client) {
        String sql = "INSERT INTO Client (nom, prenom, numero, email, identifiant) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, client.getNom());
            stmt.setString(2, client.getPrenom());
            stmt.setString(3, client.getNumero());
            stmt.setString(4, client.getEmail());
            stmt.setString(5, client.getIdentifiant());
            stmt.executeUpdate();
            System.out.println("Client ajouté avec succès !");
        } catch (SQLException e) {
            System.err.println("Erreur lors de l'ajout du client : " + e.getMessage());
        }
    }

    // Méthode pour obtenir un client par son identifiant
    public Client getClientById(int id) {
        String sql = "SELECT * FROM Client WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Client(rs.getInt("id"),
                                  rs.getString("nom"),
                                  rs.getString("prenom"),
                                  rs.getString("numero"),
                                  rs.getString("email"),
                                  rs.getString("identifiant"));
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de la récupération du client : " + e.getMessage());
        }
        return null;
    }

    // Méthode pour mettre à jour un client
    public void updateClient(Client client) {
        String sql = "UPDATE Client SET nom = ?, prenom = ?, numero = ?, email = ?, identifiant = ? WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, client.getNom());
            stmt.setString(2, client.getPrenom());
            stmt.setString(3, client.getNumero());
            stmt.setString(4, client.getEmail());
            stmt.setString(5, client.getIdentifiant());
            stmt.setInt(6, client.getId());
            stmt.executeUpdate();
            System.out.println("Client mis à jour avec succès !");
        } catch (SQLException e) {
            System.err.println("Erreur lors de la mise à jour du client : " + e.getMessage());
        }
    }

    // Méthode pour supprimer un client par son identifiant
    public void deleteClient(int id) {
        String sql = "DELETE FROM Client WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Client supprimé avec succès !");
        } catch (SQLException e) {
            System.err.println("Erreur lors de la suppression du client : " + e.getMessage());
        }
    }
}
