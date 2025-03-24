package cantine;

public class Main {
    public static void main(String[] args) {
        // Création de produits
        Produit produit1 = new Produit(1, "Pommes", "Pommes bio, sucrées et juteuses", 1.5, "Fruits");
        Produit produit2 = new Produit(2, "Carottes", "Carottes fraîches", 0.8, "Légumes");
        Produit produit3 = new Produit(3, "Pain", "Pain de campagne", 2.0, "Boulangerie");

        // Création de l'objet stock
        Stock stock = new Stock();

        // Ajout de produits au stock
        stock.ajouterProduit(produit1, 50);
        stock.ajouterProduit(produit2, 30);
        stock.ajouterProduit(produit3, 20);

        // Affichage du stock
        System.out.println("Stock initial:");
        stock.afficherStock();

        // Recherche par nom
        System.out.println("\nRecherche par nom (Pommes):");
        stock.rechercherParNom("Pommes");

        // Recherche par catégorie
        System.out.println("\nRecherche par catégorie (Fruits):");
        stock.rechercherParCategorie("Fruits");

        // Retirer des produits du stock
        System.out.println("\nRetrait de produits:");
        stock.retirerProduit(1, 10);  // Retirer 10 pommes
        stock.retirerProduit(2, 5);   // Retirer 5 carottes
        stock.retirerProduit(3, 20);  // Retirer tout le pain

        // Affichage du stock après retrait
        System.out.println("\nStock après retrait:");
        stock.afficherStock();
    }
}
