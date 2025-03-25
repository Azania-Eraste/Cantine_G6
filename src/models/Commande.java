package models;

public class Commande {
    private int id;
    private int clientId;
    private double montantTotal;
    private String modePaiement;
    private String statut;

    // Constructeurs, getters et setters
    public Commande(int id, int clientId, double montantTotal, String modePaiement, String statut) {
        this.id = id;
        this.clientId = clientId;
        this.montantTotal = montantTotal;
        this.modePaiement = modePaiement;
        this.statut = statut;
    }

    // Getters et setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getClientId() { return clientId; }
    public void setClientId(int clientId) { this.clientId = clientId; }

    public double getMontantTotal() { return montantTotal; }
    public void setMontantTotal(double montantTotal) { this.montantTotal = montantTotal; }

    public String getModePaiement() { return modePaiement; }
    public void setModePaiement(String modePaiement) { this.modePaiement = modePaiement; }

    public String getStatut() { return statut; }
    public void setStatut(String statut) { this.statut = statut; }
}
