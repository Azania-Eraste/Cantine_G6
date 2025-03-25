package models;

public class Paiement {
    private int id;
    private String mode;
    private double montant;

    // Constructeur
    public Paiement(int id, String mode, double montant) {
        this.id = id;
        this.mode = mode;
        this.montant = montant;
    }

    // Getters et setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }
}
