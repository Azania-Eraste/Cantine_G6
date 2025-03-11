package Abdel;
import java.util.ArrayList;
import java.util.Scanner;

public class GestionEleves {
    private ArrayList<Eleve> listeEleves = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public void afficherMenu() {
        System.out.println("1. Ajouter un élève");
        System.out.println("2. Modifier un élève");
        System.out.println("3. Supprimer un élève");
        System.out.println("4. Lister les élèves");
        System.out.println("5. Dernier élève ajouté");
        System.out.println("6. Quitter");
    }

    public void ajouterEleve() {
        System.out.println("Nom: ");
        String nom = scanner.nextLine();
        System.out.print("Âge: ");
        int age = scanner.nextInt();
        scanner.nextLine(); // Absorber le retour à la ligne
        System.out.print("Matricule: ");
        String matricule = scanner.nextLine();
        Eleve eleve = new Eleve(nom, age, matricule);
        listeEleves.add(eleve);
        System.out.println("Élève ajouté !");
    }

    public void modifierEleve() {
        System.out.print("Matricule de l'élève à modifier: ");
        String matricule = scanner.nextLine();
        for (Eleve e : listeEleves) {
            if (e.getMatricule().equals(matricule)) {
                System.out.print("Nouveau nom: ");
                String nom = scanner.nextLine();
                System.out.print("Nouvel âge: ");
                int age = scanner.nextInt();
                scanner.nextLine();
                listeEleves.remove(e);
                listeEleves.add(new Eleve(nom, age, matricule));
                System.out.println("Élève modifié !");
                return;
            }
        }
        System.out.println("Élève non trouvé.");
    }

    public void supprimerEleve() {
        System.out.print("Matricule de l'élève à supprimer: ");
        String matricule = scanner.nextLine();
        listeEleves.removeIf(e -> e.getMatricule().equals(matricule));
        System.out.println("Élève supprimé !");
    }

    public void listerEleves() {
        if (listeEleves.isEmpty()) {
            System.out.println("Aucun élève enregistré.");
        } else {
            for (Eleve e : listeEleves) {
                System.out.println(e);
            }
        }
    }

    public void dernierEleveAjoute() {
        if (!listeEleves.isEmpty()) {
            System.out.println("Dernier élève ajouté : " + listeEleves.get(listeEleves.size() - 1));
        } else {
            System.out.println("Aucun élève ajouté.");
        }
    }

    public static void main(String[] args) {
        GestionEleves gestion = new GestionEleves();
        Scanner scanner = new Scanner(System.in);
        int choix;
        do {
            gestion.afficherMenu();
            System.out.print("Votre choix: ");
            choix = scanner.nextInt();
            scanner.nextLine(); // Absorber le retour à la ligne

            switch (choix) {
                case 1 -> gestion.ajouterEleve();
                case 2 -> gestion.modifierEleve();
                case 3 -> gestion.supprimerEleve();
                case 4 -> gestion.listerEleves();
                case 5 -> gestion.dernierEleveAjoute();
                case 6 -> System.out.println("Au revoir !");
                default -> System.out.println("Choix invalide !");
            }
        } while (choix != 6);
    }
}
