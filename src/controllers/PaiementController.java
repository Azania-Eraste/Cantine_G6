package controllers;

import models.Paiement;
import dao.PaiementDAO;

public class PaiementController {
    private PaiementDAO paiementDAO;

    public PaiementController() {
        this.paiementDAO = new PaiementDAO();
    }

    // Créer un paiement
    public void createPaiement(int id, String mode, double montant) {
        Paiement paiement = new Paiement(id, mode, montant);
        paiementDAO.addPaiement(paiement);
    }

    // Lire un paiement par ID
    public Paiement getPaiementById(int id) {
        return paiementDAO.getPaiementById(id);
    }

    // Mettre à jour un paiement
    public void updatePaiement(int id, String mode, double montant) {
        Paiement paiement = new Paiement(id, mode, montant);
        paiementDAO.updatePaiement(paiement);
    }

    // Supprimer un paiement
    public void deletePaiement(int id) {
        paiementDAO.deletePaiement(id);
    }
}
