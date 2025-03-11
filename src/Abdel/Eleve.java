package Abdel;

public class Eleve {
    private String nom;
    private int age;
    private String matricule;

    // Constructeur
    public Eleve(String nom, int age, String matricule) {
        this.nom = nom;
        this.age = age;
        this.matricule = matricule;
    }

    // Getters
    public String getNom() {
        return nom;
    }

    public int getAge() {
        return age;
    }

    public String getMatricule() {
        return matricule;
    }

    // Setters (optionnels)
    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    // Méthode toString pour afficher les informations de l'élève
    @Override
    public String toString() {
        return "Nom: " + nom + ", Âge: " + age + ", Matricule: " + matricule;
    }
}