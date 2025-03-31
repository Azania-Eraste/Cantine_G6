package domaine;

import java.time.LocalDateTime;
import java.util.List;

public class Commande {
    private Client client;
    private List<Produit> produits;
    private ModePaiement modePaiement;
    private double total;
    private LocalDateTime date;

    public Commande(Client client, List<Produit> produits, ModePaiement modePaiement) {
        this.client = client;
        this.produits = produits;
        this.modePaiement = modePaiement;
        this.total = produits.stream().mapToDouble(Produit::getPrix).sum();
        this.date = LocalDateTime.now();
    }

    public Client getClient() {
        return client;
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
        return "Commande du " + date + " par " + client.getNom() + " " + client.getPrenom() + " - Total: " + total + "€ via " + modePaiement;
    }
}