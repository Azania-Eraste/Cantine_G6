class Repas {
    private String nom;
    private double prix;

    public Repas(String nom, double prix) {
        this.nom = nom;
        this.prix = prix;
    }

    public String getNom() {
        return nom;
    }

    public double getPrix() {
        return prix;
    }

    public void afficherRepas() {
        System.out.println(nom + " : " + prix + " FCFA");
    }
}