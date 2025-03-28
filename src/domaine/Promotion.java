package domaine;

public class Promotion {
    private String description;
    private double tauxReduction;

    // Constructeur
    public Promotion(String description, double tauxReduction) {
        this.description = description;
        this.tauxReduction = tauxReduction;
    }

    // Getter pour description
    public String getDescription() {
        return description;
    }

    // Setter pour description
    public void setDescription(String description) {
        this.description = description;
    }

    // Getter pour tauxReduction
    public double getTauxReduction() {
        return tauxReduction;
    }

    // Setter pour tauxReduction
    public void setTauxReduction(double tauxReduction) {
        this.tauxReduction = tauxReduction;
    }

    // Méthode appliquerReduction
    public double appliquerReduction(double montant) {
        return montant - (montant * tauxReduction);
    }

    // Facultatif : méthode toString pour faciliter l'affichage
    @Override
    public String toString() {
        return "Promotion{" +
                "description='" + description + '\'' +
                ", tauxReduction=" + tauxReduction +
                '}';
    }
}
