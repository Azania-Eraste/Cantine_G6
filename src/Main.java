import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Commande commande = new Commande();

        // Liste des repas prédéfinis
        List<Repas> repasDisponibles = Arrays.asList(
                new Repas("Attiéké Poulet", 1000),
                new Repas("Alloco Poulet", 1000),
                new Repas("Frites Poulet", 1000)
        );

        while (true) {
            System.out.println("\nOptions:");
            System.out.println("1 - Ajouter un repas");
            System.out.println("2 - Afficher la commande");
            System.out.println("3 - Quitter");
            System.out.print("Choix : ");

            int choix = scanner.nextInt();
            scanner.nextLine(); // Absorber le retour à la ligne

            switch (choix) {
                case 1:
                    System.out.println("\nChoisissez un repas :");
                    for (int i = 0; i < repasDisponibles.size(); i++) {
                        System.out.println((i + 1) + " - " + repasDisponibles.get(i).getNom());
                    }
                    System.out.print("Votre choix : ");
                    int choixRepas = scanner.nextInt();
                    scanner.nextLine();

                    if (choixRepas >= 1 && choixRepas <= repasDisponibles.size()) {
                        Repas repasChoisi = repasDisponibles.get(choixRepas - 1);
                        commande.ajouterRepas(new Repas(repasChoisi.getNom(), repasChoisi.getPrix()));
                        System.out.println("✅ Repas ajouté !");
                    } else {
                        System.out.println("❌ Choix invalide !");
                    }
                    break;

                case 2:
                    commande.afficherCommande();
                    break;

                case 3:
                    System.out.println("✅ Programme terminé.");
                    scanner.close();
                    return;

                default:
                    System.out.println("❌ Choix invalide !");
            }
        }
    }
}
