import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Commande commande = new Commande();

        // Liste des repas prédéfinis
        List<Repas> repasDisponibles = Arrays.asList(
                new Repas("Attiéké Poulet : 1000FCFA", 1000),
                new Repas("Alloco Poulet : 1000FCFA", 1000),
                new Repas("Frites Poulet : 1000FCFA", 1000)
        );

        // Liste des suppléments prédéfinis
        List<Supplement> supplementsDisponibles = Arrays.asList(
                new Supplement("Attiéké : 100FCFA", 100),
                new Supplement("Alloco : 500FCFA", 500),
                new Supplement("Frites : 500FCFA", 500)
        );

        while (true) {
            System.out.println("\nOptions:");
            System.out.println("1 - Ajouter un repas");
            System.out.println("2 - Ajouter un supplément à un repas");
            System.out.println("3 - Afficher la commande");
            System.out.println("4 - Quitter");
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
                        commande.ajouterRepas(new Repas(repasChoisi.getNom(), repasChoisi.calculerPrixTotal()));
                        System.out.println("✅ Repas ajouté !");
                    } else {
                        System.out.println("❌ Choix invalide !");
                    }
                    break;

                case 2:
                    System.out.println("\nChoisissez un repas à modifier :");
                    List<Repas> repasDansCommande = commande.getRepasList();
                    if (repasDansCommande.isEmpty()) {
                        System.out.println("❌ Aucun repas dans la commande !");
                        break;
                    }
                    for (int i = 0; i < repasDansCommande.size(); i++) {
                        System.out.println((i + 1) + " - " + repasDansCommande.get(i).getNom());
                    }
                    System.out.print("Votre choix : ");
                    int choixRepasSup = scanner.nextInt();
                    scanner.nextLine();

                    if (choixRepasSup < 1 || choixRepasSup > repasDansCommande.size()) {
                        System.out.println("❌ Choix invalide !");
                        break;
                    }

                    Repas repasModifie = repasDansCommande.get(choixRepasSup - 1);

                    System.out.println("\nChoisissez un supplément :");
                    for (int i = 0; i < supplementsDisponibles.size(); i++) {
                        System.out.println((i + 1) + " - " + supplementsDisponibles.get(i).getNom());
                    }
                    System.out.print("Votre choix : ");
                    int choixSupplement = scanner.nextInt();
                    scanner.nextLine();

                    if (choixSupplement >= 1 && choixSupplement <= supplementsDisponibles.size()) {
                        Supplement suppChoisi = supplementsDisponibles.get(choixSupplement - 1);
                        repasModifie.ajouterSupplement(suppChoisi);
                        System.out.println("✅ Supplément ajouté !");
                    } else {
                        System.out.println("❌ Choix invalide !");
                    }
                    break;

                case 3:
                    commande.afficherCommande();
                    break;

                case 4:
                    System.out.println("✅ Programme terminé.");
                    scanner.close();
                    return;

                default:
                    System.out.println("❌ Choix invalide !");
            }
        }
    }
}
