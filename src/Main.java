public class Main {
    public static void main(String[] args) {
        StatutCommande statut = StatutCommande.EN_COURS;

        System.out.println("Statut initial : " + statut);

        // Changer le statut
        statut = StatutCommande.changerStatut(statut, StatutCommande.TERMINEE);

        System.out.println("Statut après changement : " + statut);
    }
}
