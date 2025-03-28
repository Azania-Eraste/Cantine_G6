package domaine;

public class Paiement {
    private ModePaiement mode;
    private double montant;

    // Constructeur
    public Paiement(ModePaiement mode, double montant) {
        this.mode = mode;
        this.montant = montant;
    }

    // Getters et Setters
    public ModePaiement getMode() {
        return mode;
    }

    public void setMode(ModePaiement mode) {
        this.mode = mode;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    // Méthode effectuerPaiement()
    public boolean effectuerPaiement() {
        // Ici, tu peux implémenter la logique réelle de paiement.
        // Pour l'instant, une implémentation simplifiée :

        if (montant <= 0) {
            System.out.println("Le montant doit être positif !");
            return false;
        }

        // Exemple basique d'affichage
        System.out.println("Paiement de " + montant + "€ effectué par : " + mode);
        return true; // supposant que tout est bon
    }

    // Pour affichage clair des paiements
    @Override
    public String toString() {
        return "Paiement{" +
                "mode=" + mode +
                ", montant=" + montant +
                '}';
    }
}
