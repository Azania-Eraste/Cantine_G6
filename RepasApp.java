package Cantine_G6;

import java.util.ArrayList;
import java.util.Scanner;

class Repas {
    private String nom;
    private String description;
    private int stock;
    private ArrayList<String> accompagnements;

    public Repas(String nom, String description, int stock) {
        this.nom = nom;
        this.description = description;
        this.stock = stock;
        this.accompagnements = new ArrayList<>();
    }

    public String getNom() { return nom; }
    public String getDescription() { return description; }
    public int getStock() { return stock; }
    public ArrayList<String> getAccompagnements() { return accompagnements; }

    public void ajouterAccompagnement(String accompagnement) {
        accompagnements.add(accompagnement);
    }

    @Override
    public String toString() {
        return "Repas{" +
                "nom='" + nom + '\'' +
                ", description='" + description + '\'' +
                ", stock=" + stock +
                ", accompagnements=" + accompagnements +
                '}';
    }
}

// **Correction ici : renommer la classe repas en RepasApp**
public class RepasApp {
    private static ArrayList<Repas> listeRepas = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choix;
        do {
            afficherMenu();
            choix = scanner.nextInt();
            scanner.nextLine(); // Absorber le retour à la ligne

            switch (choix) {
                case 1 -> ajouterRepas();
                case 2 -> voirListeRepas();
                case 3 -> System.out.println("Au revoir !");
                default -> System.out.println("Choix invalide !");
            }
        } while (choix != 3);
    }

    private static void afficherMenu() {
        System.out.println("1. Ajouter un repas");
        System.out.println("2. Voir liste de repas");
        System.out.println("3. Quitter");
        System.out.print("Votre choix: ");
    }

    private static void ajouterRepas() {
        System.out.print("Nom du repas: ");
        String nom = scanner.nextLine();
        System.out.print("Description du repas: ");
        String description = scanner.nextLine();
        System.out.print("Stock disponible: ");
        int stock = scanner.nextInt();
        scanner.nextLine(); // Absorber le retour à la ligne

        Repas repas = new Repas(nom, description, stock);

        System.out.print("Voulez-vous ajouter des accompagnements ? (oui/non): ");
        String reponse = scanner.nextLine();
        while (reponse.equalsIgnoreCase("oui")) {
            System.out.print("Nom de l'accompagnement: ");
            String accompagnement = scanner.nextLine();
            repas.ajouterAccompagnement(accompagnement);
            System.out.print("Voulez-vous ajouter un autre accompagnement ? (oui/non): ");
            reponse = scanner.nextLine();
        }

        listeRepas.add(repas);
        System.out.println("Repas ajouté !");
    }

    private static void voirListeRepas() {
        if (listeRepas.isEmpty()) {
            System.out.println("Aucun repas enregistré.");
        } else {
            for (int i = 0; i < listeRepas.size(); i++) {
                System.out.println((i + 1) + ". " + listeRepas.get(i).getNom());
            }
            System.out.print("Sélectionnez un repas pour voir les détails (0 pour revenir au menu): ");
            int choix = scanner.nextInt();
            scanner.nextLine(); // Absorber le retour à la ligne

            if (choix > 0 && choix <= listeRepas.size()) {
                Repas repas = listeRepas.get(choix - 1);
                System.out.println("Nom: " + repas.getNom());
                System.out.println("Description: " + repas.getDescription());
                System.out.println("Stock disponible: " + repas.getStock());
                System.out.println("Accompagnements: " + repas.getAccompagnements());
            } else if (choix != 0) {
                System.out.println("Choix invalide !");
            }
        }
    }
}
