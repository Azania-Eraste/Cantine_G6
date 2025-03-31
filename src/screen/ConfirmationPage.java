package screen;

import domaine.Client;
import domaine.Commande;
import domaine.ModePaiement;
import domaine.Produit;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.SimpleDoubleProperty;

import java.util.Arrays;
import java.util.List;

public class ConfirmationPage extends Application {

    private List<Produit> produitsReserves;
    private ModePaiement modePaiement;
    private String paymentDetails;

    public ConfirmationPage(List<Produit> produitsReserves, ModePaiement modePaiement, String paymentDetails) {
        this.produitsReserves = produitsReserves;
        this.modePaiement = modePaiement;
        this.paymentDetails = paymentDetails;
        // Simulation d'un client temporaire (à remplacer par un vrai client passé en paramètre)
        Client client = new Client("NomTest", "PrenomTest", "1234567890", "test@example.com", new java.sql.Date(System.currentTimeMillis()));
        OrderHistoryPage.ajouterCommande(new Commande(client, produitsReserves, modePaiement));
    }

    @Override
    public void start(Stage primaryStage) {
        Label lblTitre = new Label("Reservation confirmee");
        lblTitre.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;");

        TableView<Produit> tableReservations = new TableView<>();
        tableReservations.setPlaceholder(new Label("Aucune réservation"));
        tableReservations.setPrefWidth(600);

        TableColumn<Produit, String> colNom = new TableColumn<>("Nom");
        colNom.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getNom()));
        colNom.setPrefWidth(400);

        TableColumn<Produit, Number> colPrix = new TableColumn<>("Prix (Franc CFA)");
        colPrix.setCellValueFactory(data -> new SimpleDoubleProperty(data.getValue().getPrix()));
        colPrix.setPrefWidth(200);

        tableReservations.getColumns().addAll(Arrays.asList(colNom, colPrix));
        tableReservations.getItems().addAll(produitsReserves);

        double total = produitsReserves.stream().mapToDouble(Produit::getPrix).sum();
        Label lblTotal = new Label("Total : " + String.format("%.2f", total) + "Franc CFA");
        lblTotal.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");

        String paiementText = "Payé via : " + modePaiement.toString();
        if (paymentDetails != null && !paymentDetails.isEmpty()) {
            paiementText += " (" + paymentDetails + ")";
        }
        Label lblPaiement = new Label(paiementText);
        lblPaiement.setStyle("-fx-font-size: 16px;");

        Button btnRetour = new Button("Retour au menu");
        btnRetour.setStyle("-fx-font-size: 14px; -fx-padding: 10px 20px;");
        btnRetour.setOnAction(e -> {
            primaryStage.close();
            new MenuPage().start(new Stage());
        });

        Button btnHistorique = new Button("Voir l'historique");
        btnHistorique.setStyle("-fx-font-size: 14px; -fx-padding: 10px 20px;");
        btnHistorique.setOnAction(e -> {
            primaryStage.close();
            new OrderHistoryPage().start(new Stage());
        });

        HBox boutons = new HBox(20, btnRetour, btnHistorique);
        boutons.setAlignment(Pos.CENTER);

        VBox root = new VBox(20, lblTitre, tableReservations, lblTotal, lblPaiement, boutons);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(30));
        root.setStyle("-fx-background-color: #f4f4f4;");

        Scene scene = new Scene(root);
        primaryStage.setTitle("Confirmation - Cantine G6");
        primaryStage.setScene(scene);
        primaryStage.setFullScreen(true);
        primaryStage.show();
    }
}