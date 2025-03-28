package domaine;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private List<Repas> repas;

    // Constructeur par défaut, initialisant une liste vide
    public Menu() {
        this.repas = new ArrayList<>();
    }

    // Constructeur permettant d'initialiser directement avec une liste de Repas
    public Menu(List<Repas> Repas) {
        this.repas = Repas;
    }

    // Méthode pour ajouter un Repas
    public void ajouterRepas(Repas Repas) {
        repas.add(Repas);
    }

    // Méthode pour retirer un Repas
    public boolean retirerRepas(Repas Repas) {
        return repas.remove(Repas);
    }

    // Getter pour la liste des Repas
    public List<Repas> getRepas() {
        return repas;
    }

    // Affichage complet du menu
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Menu :\n");
        for (Repas Repas : repas) {
            sb.append("- ").append(Repas.getNom())
              .append(" : ").append(Repas.getPrix()).append("€\n");
        }
        return sb.toString();
    }
}
