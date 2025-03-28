package domaine;



public class Supplement extends Produit{

    public Supplement(int idProduit, String nom, String description, double prix, int stock) {
        super(idProduit, nom, description, prix, stock); // Appel au constructeur de Produit
    }

}
