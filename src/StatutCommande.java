// Enum pour les statuts de la commande
public enum StatutCommande {
    EN_COURS("En cours"),
    TERMINEE("Terminée"),
    ANNULEE("Annulée");

    private final String description;

    // Constructeur de l'enum
    StatutCommande(String description) {
        this.description = description;
    }

    // Getter pour la description
    public String getDescription() {
        return description;
    }

    // Méthode pour changer de statut
    public static StatutCommande changerStatut(StatutCommande actuel, StatutCommande nouveauStatut) {
        // Logique ou validation supplémentaire peut être ajoutée ici
        return nouveauStatut;
    }

    @Override
    public String toString() {
        return description;
    }
}
