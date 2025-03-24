package Cantine_G6;

import java.util.ArrayList;
import java.util.Scanner;

public class BoissonApp {
    private static ArrayList<Boisson> listeBoissons = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choix;
        do {
            afficherMenu();
            while (!scanner.hasNextInt()) {
                System.out.println("Veuillez entrer un nombre valide !");
                scanner.next();
            }
            choix = scanner.nextInt();
            scanner.nextLine(); // Absorber le retour à la ligne

            switch (choix) {
                case 1 -> ajouterBoisson();
                case 2 -> voirListeBoissons();
                case 3 -> System.out.println("Au revoir !");
                default -> System.out.println("Choix invalide !");
            }
        } while (choix != 3);
    }

    private static void afficherMenu() {
        System.out.println("\n--- Menu ---");
        System.out.println("1. Ajouter une boisson");
        System.out.println("2. Voir liste de boissons");
        System.out.println("3. Quitter");
        System.out.print("Votre choix: ");
    }

    private static void ajouterBoisson() {
        System.out.print("Nom de la boisson: ");
        String nom = scanner.nextLine();
        System.out.print("Description de la boisson: ");
        String description = scanner.nextLine();
        System.out.print("Stock disponible: ");

        while (!scanner.hasNextInt()) {
            System.out.println("Veuillez entrer un nombre valide !");
            scanner.next();
        }
        int stock = scanner.nextInt();
        scanner.nextLine(); // Absorber le retour à la ligne

        Boisson boisson = new Boisson(nom, description, stock);
        listeBoissons.add(boisson);
        System.out.println("Boisson ajoutée !");
    }

    private static void voirListeBoissons() {
        if (listeBoissons.isEmpty()) {
            System.out.println("Aucune boisson enregistrée.");
        } else {
            System.out.println("\n--- Liste des boissons ---");
            for (int i = 0; i < listeBoissons.size(); i++) {
                System.out.println((i + 1) + ". " + listeBoissons.get(i).getNom());
            }
            System.out.print("Sélectionnez une boisson pour voir les détails (0 pour revenir au menu): ");

            while (!scanner.hasNextInt()) {
                System.out.println("Veuillez entrer un nombre valide !");
                scanner.next();
            }
            int choix = scanner.nextInt();
            scanner.nextLine(); // Absorber le retour à la ligne

            if (choix > 0 && choix <= listeBoissons.size()) {
                Boisson boisson = listeBoissons.get(choix - 1);
                System.out.println("\n--- Détails de la boisson ---");
                System.out.println("Nom: " + boisson.getNom());
                System.out.println("Description: " + boisson.getDescription());
                System.out.println("Stock disponible: " + boisson.getStock());
            } else if (choix != 0) {
                System.out.println("Choix invalide !");
            }
        }
    }
}
