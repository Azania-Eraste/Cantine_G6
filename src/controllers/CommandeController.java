package controllers;

import models.Commande;
import dao.CommandeDAO;

public class CommandeController {
    private CommandeDAO commandeDAO;

    public CommandeController() {
        this.commandeDAO = new CommandeDAO();
    }

    // Créer une nouvelle commande
    public void createCommande(int clientId, double montantTotal, String modePaiement, String statut) {
        Commande commande = new Commande(clientId, montantTotal, modePaiement, statut);
        commandeDAO.addCommande(commande);
    }

    // Lire une commande par ID
    public Commande getCommandeById(int id) {
        return commandeDAO.getCommandeById(id);
    }

    // Mettre à jour une commande
    public void updateCommande(int id, int clientId, double montantTotal, String modePaiement, String statut) {
        Commande commande = new Commande(id, clientId, montantTotal, modePaiement, statut);
        commandeDAO.updateCommande(commande);
    }

    // Supprimer une commande
    public void deleteCommande(int id) {
        commandeDAO.deleteCommande(id);
    }
}
