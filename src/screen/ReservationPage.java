package screen;

import domaine.ModePaiement;
import domaine.Produit;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.SimpleDoubleProperty;

import java.util.Arrays;
import java.util.List;

public class ReservationPage extends Application {

    private List<Produit> produitsReserves;

    public ReservationPage(List<Produit> produitsReserves) {
        this.produitsReserves = produitsReserves;
    }

    @Override
    public void start(Stage primaryStage) {
        Label lblTitre = new Label("Réservations");
        lblTitre.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");

        TableView<Produit> tableReservations = new TableView<>();
        tableReservations.setPlaceholder(new Label("Aucune réservation"));
        tableReservations.setPrefWidth(600);

        TableColumn<Produit, String> colNom = new TableColumn<>("Nom");
        colNom.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getNom()));
        colNom.setPrefWidth(400);
        colNom.setMinWidth(300);
        colNom.setMaxWidth(500);

        TableColumn<Produit, Number> colPrix = new TableColumn<>("Prix (€)");
        colPrix.setCellValueFactory(data -> new SimpleDoubleProperty(data.getValue().getPrix()));
        colPrix.setPrefWidth(200);
        colPrix.setMinWidth(100);
        colPrix.setMaxWidth(300);

        tableReservations.getColumns().addAll(Arrays.asList(colNom, colPrix));
        tableReservations.getItems().addAll(produitsReserves);

        Label lblPaiement = new Label("Mode de paiement :");
        lblPaiement.setStyle("-fx-font-size: 14px;");
        ComboBox<ModePaiement> comboPaiement = new ComboBox<>();
        comboPaiement.getItems().addAll(ModePaiement.values());
        comboPaiement.setPromptText("Sélectionnez un mode de paiement");
        comboPaiement.setPrefWidth(250);

        Button btnConfirmer = new Button("Confirmer");
        btnConfirmer.setStyle("-fx-font-size: 14px; -fx-padding: 10px 20px;");
        btnConfirmer.setOnAction(e -> {
            ModePaiement modePaiement = comboPaiement.getValue();
            if (modePaiement != null) {
                primaryStage.close();
                new PaymentPage(produitsReserves).start(new Stage()); // Ouvre PaymentPage
            } else {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Erreur");
                alert.setHeaderText(null);
                alert.setContentText("Veuillez sélectionner un mode de paiement !");
                alert.showAndWait();
            }
        });

        Button btnFermer = new Button("Fermer");
        btnFermer.setStyle("-fx-font-size: 14px; -fx-padding: 10px 20px;");
        btnFermer.setOnAction(e -> primaryStage.close());

        VBox root = new VBox(20, lblTitre, tableReservations, lblPaiement, comboPaiement, btnConfirmer, btnFermer);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(30));
        root.setStyle("-fx-background-color: #f4f4f4;");

        Scene scene = new Scene(root);
        primaryStage.setTitle("Réservations - Cantine G6");
        primaryStage.setScene(scene);
        primaryStage.setFullScreen(true);
        primaryStage.show();
    }
}