package domaine;

public class Boisson extends Produit{


    public Boisson(int idProduit,String nom, int prix,String description, int stock) {
        super(idProduit,nom, description, prix, stock); // Appel au constructeur de Produit
    }

}
