import java.util.ArrayList;
import java.util.List;

public class Repas {
    private String nom;
    private double prix;
    private List<Supplement> supplements;

    public Repas(String nom, double prix) {
        this.nom = nom;
        this.prix = prix;
        this.supplements = new ArrayList<>();
    }

    public String getNom() {
        return nom;
    }

    public void ajouterSupplement(Supplement supplement) {
        supplements.add(supplement);
    }

    public double calculerPrixTotal() {
        double total = prix;
        for (Supplement supp : supplements) {
            total += supp.getPrix();
        }
        return total;
    }

    public void afficherRepas() {
        System.out.print(nom + " : " + prix + " FCFA");
        if (!supplements.isEmpty()) {
            System.out.print(" avec suppléments : ");
            for (Supplement supp : supplements) {
                System.out.print(supp + " ");
            }
        }
        System.out.println("\nTotal : " + calculerPrixTotal() + " FCFA");
    }
}
