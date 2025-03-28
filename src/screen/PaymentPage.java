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
import javafx.animation.PauseTransition;
import javafx.util.Duration;

import java.util.List;
import java.util.regex.Pattern;

public class PaymentPage extends Application {

    private List<Produit> produitsReserves;

    public PaymentPage(List<Produit> produitsReserves) {
        this.produitsReserves = produitsReserves;
    }

    @Override
    public void start(Stage primaryStage) {
        // Titre
        Label lblTitre = new Label("Paiement");
        lblTitre.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;");

        // Calcul du total
        double total = produitsReserves.stream().mapToDouble(Produit::getPrix).sum();
        Label lblTotal = new Label("Montant à payer : " + String.format("%.2f", total) + "€");
        lblTotal.setStyle("-fx-font-size: 18px;");

        // Choix du mode de paiement
        Label lblPaiement = new Label("Mode de paiement :");
        lblPaiement.setStyle("-fx-font-size: 14px;");
        ComboBox<ModePaiement> comboPaiement = new ComboBox<>();
        comboPaiement.getItems().addAll(ModePaiement.values());
        comboPaiement.setPromptText("Sélectionnez un mode de paiement");
        comboPaiement.setPrefWidth(250);

        // Champ pour les détails du paiement
        TextField txtDetails = new TextField();
        txtDetails.setPromptText("Entrez les détails (ex. numéro de téléphone)");
        txtDetails.setPrefWidth(250);
        txtDetails.setVisible(false);

        // Label pour afficher l'état du paiement
        Label lblStatut = new Label("");
        lblStatut.setStyle("-fx-font-size: 14px; -fx-text-fill: green;");

        // Afficher/masquer et ajuster le champ selon le mode choisi
        comboPaiement.setOnAction(e -> {
            ModePaiement mode = comboPaiement.getValue();
            if (mode == ModePaiement.WAVE || mode == ModePaiement.ORANGE_MONEY) {
                txtDetails.setVisible(true);
                txtDetails.setPromptText("Entrez votre numéro de téléphone (10 chiffres)");
            } else if (mode == ModePaiement.CARTE_MIDI) {
                txtDetails.setVisible(true);
                txtDetails.setPromptText("Entrez votre numéro de carte (16 chiffres)");
            } else {
                txtDetails.setVisible(false);
            }
            lblStatut.setText(""); // Réinitialiser le statut
        });

        // Bouton pour confirmer le paiement
        Button btnPayer = new Button("Payer");
        btnPayer.setStyle("-fx-font-size: 14px; -fx-padding: 10px 20px;");
        btnPayer.setOnAction(e -> {
            ModePaiement modePaiement = comboPaiement.getValue();
            String details = txtDetails.getText().trim();

            if (modePaiement == null) {
                showAlert("Erreur", "Veuillez sélectionner un mode de paiement !");
                return;
            }

            // Validation des détails
            if (modePaiement == ModePaiement.WAVE || modePaiement == ModePaiement.ORANGE_MONEY) {
                if (!isValidPhoneNumber(details)) {
                    showAlert("Erreur", "Le numéro de téléphone doit contenir exactement 10 chiffres !");
                    return;
                }
            } else if (modePaiement == ModePaiement.CARTE_MIDI) {
                if (!isValidCardNumber(details)) {
                    showAlert("Erreur", "Le numéro de carte doit contenir exactement 16 chiffres !");
                    return;
                }
            }

            // Désactiver le bouton pendant la simulation
            btnPayer.setDisable(true);
            lblStatut.setText("Traitement du paiement en cours...");

            // Simulation de paiement avec un délai de 2 secondes
            PauseTransition pause = new PauseTransition(Duration.seconds(2));
            pause.setOnFinished(event -> {
                lblStatut.setText("Paiement réussi !");
                primaryStage.close();
                new ConfirmationPage(produitsReserves, modePaiement).start(new Stage());
            });
            pause.play();
        });

        // Bouton pour annuler
        Button btnAnnuler = new Button("Annuler");
        btnAnnuler.setStyle("-fx-font-size: 14px; -fx-padding: 10px 20px;");
        btnAnnuler.setOnAction(e -> primaryStage.close());

        // Mise en page
        VBox root = new VBox(20, lblTitre, lblTotal, lblPaiement, comboPaiement, txtDetails, btnPayer, btnAnnuler, lblStatut);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(30));
        root.setStyle("-fx-background-color: #f4f4f4;");

        // Scène
        Scene scene = new Scene(root);
        primaryStage.setTitle("Paiement - Cantine G6");
        primaryStage.setScene(scene);
        primaryStage.setFullScreen(true);
        primaryStage.show();
    }

    // Validation du numéro de téléphone (10 chiffres)
    private boolean isValidPhoneNumber(String phone) {
        return Pattern.matches("\\d{10}", phone); // Regex : exactement 10 chiffres
    }

    // Validation du numéro de carte (16 chiffres)
    private boolean isValidCardNumber(String card) {
        return Pattern.matches("\\d{16}", card); // Regex : exactement 16 chiffres
    }

    // Méthode utilitaire pour afficher une alerte
    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}