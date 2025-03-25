package domaine;

import java.time.LocalDateTime;
import java.util.List;

public class Commande {
    private List<Produit> produits;
    private ModePaiement modePaiement;
    private double total;
    private LocalDateTime date;

    // Constructeur avec List<Produit> et ModePaiement
    public Commande(List<Produit> produits, ModePaiement modePaiement) {
        this.produits = produits;
        this.modePaiement = modePaiement;
        this.total = produits.stream().mapToDouble(Produit::getPrix).sum();
        this.date = LocalDateTime.now();
    }

    public List<Produit> getProduits() {
        return produits;
    }

    public ModePaiement getModePaiement() {
        return modePaiement;
    }

    public double getTotal() {
        return total;
    }

    public LocalDateTime getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Commande du " + date + " - Total: " + total + "€ via " + modePaiement;
    }
}