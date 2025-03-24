package domaine;

import java.util.List;

public class Commande {

 
    private Client client;
    private double montant;
    private boolean estPrecommande;
    private List<Repas> repas;
    private List<Boisson> boissons;
    private Paiement paiement;

    // Constructeur corrigé (sans valeur par défaut dans les paramètres)
    public Commande(Client client, double montant, boolean estPrecommande) {
        this.client = client;
        this.montant = montant;
        this.estPrecommande = estPrecommande;
    }

    public List<Repas> getRepas() {
        return repas;
    }

    public void setRepas(List<Repas> repas) {
        this.repas = repas;
    }

    public List<Boisson> getBoissons() {
        return boissons;
    }

    public void setBoissons(List<Boisson> boissons) {
        this.boissons = boissons;
    }

    public Paiement getPaiement() {
        return paiement;
    }

    public void setPaiement(Paiement paiement) {
        this.paiement = paiement;
    }

    // Option alternative : Constructeur avec valeur par défaut pour estPrecommande
    public Commande(Client client, double montant) {
        this(client, montant, false); // Appelle l'autre constructeur avec false par défaut
    }

    // Getters et Setters
    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public boolean isEstPrecommande() {
        return estPrecommande;
    }

    public void setEstPrecommande(boolean estPrecommande) {
        this.estPrecommande = estPrecommande;
    }
}