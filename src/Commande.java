import java.util.ArrayList;
import java.util.List;

class Commande {
    private List<Repas> repasList;
    private StatutCommande statut;

    public Commande() {
        this.repasList = new ArrayList<>();
        this.statut = StatutCommande.EN_COURS;
    }

    public void ajouterRepas(Repas repas) {
        repasList.add(repas);
    }

    public List<Repas> getRepasList() {
        return repasList;
    }

    public void afficherCommande() {
        System.out.println("\n=== Détail de la Commande ===");
        for (Repas repas : repasList) {
            repas.afficherRepas();
        }
        System.out.println("Statut : " + statut);
    }
}