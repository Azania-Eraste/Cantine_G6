package screen;

import domaine.Client;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.sql.Date;

public class SignUpPage extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Titre
        Label lblTitre = new Label("Inscription");
        lblTitre.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;");

        // Champ pour le nom
        Label lblNom = new Label("Nom :");
        lblNom.setStyle("-fx-font-size: 14px;");
        TextField txtNom = new TextField();
        txtNom.setPromptText("Entrez votre nom");
        txtNom.setPrefWidth(250);

        // Champ pour le prénom
        Label lblPrenom = new Label("Prénom :");
        lblPrenom.setStyle("-fx-font-size: 14px;");
        TextField txtPrenom = new TextField();
        txtPrenom.setPromptText("Entrez votre prénom");
        txtPrenom.setPrefWidth(250);

        // Champ pour le numéro de téléphone
        Label lblNumero = new Label("Numéro de téléphone :");
        lblNumero.setStyle("-fx-font-size: 14px;");
        TextField txtNumero = new TextField();
        txtNumero.setPromptText("Entrez votre numéro (10 chiffres)");
        txtNumero.setPrefWidth(250);

        // Champ pour l'email
        Label lblEmail = new Label("Email :");
        lblEmail.setStyle("-fx-font-size: 14px;");
        TextField txtEmail = new TextField();
        txtEmail.setPromptText("Entrez votre email");
        txtEmail.setPrefWidth(250);

        // Champ pour la date de naissance
        Label lblDateNaissance = new Label("Date de naissance :");
        lblDateNaissance.setStyle("-fx-font-size: 14px;");
        DatePicker datePicker = new DatePicker();
        datePicker.setPromptText("Sélectionnez votre date de naissance");
        datePicker.setPrefWidth(250);

        // Bouton pour s'inscrire
        Button btnSignUp = new Button("S'inscrire");
        btnSignUp.setStyle("-fx-font-size: 14px; -fx-padding: 10px 20px;");
        btnSignUp.setOnAction(e -> {
            String nom = txtNom.getText().trim();
            String prenom = txtPrenom.getText().trim();
            String numero = txtNumero.getText().trim();
            String email = txtEmail.getText().trim();
            java.time.LocalDate localDate = datePicker.getValue();

            // Validation
            if (nom.isEmpty() || prenom.isEmpty() || numero.isEmpty() || email.isEmpty() || localDate == null) {
                showAlert("Erreur", "Tous les champs doivent être remplis !");
            } else if (!numero.matches("\\d{10}")) {
                showAlert("Erreur", "Le numéro de téléphone doit contenir exactement 10 chiffres !");
            } else if (!email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
                showAlert("Erreur", "L'email n'est pas valide !");
            } else {
                // Conversion de LocalDate en java.sql.Date
                Date dateNaissance = Date.valueOf(localDate);

                // Création du client
                Client client = new Client(nom, prenom, numero, email, dateNaissance);

                // Simulation d'inscription (affichage dans la console)
                System.out.println("Inscription réussie :");
                System.out.println("Client : " + client.getNom() + " " + client.getPrenom());
                System.out.println("Numéro : " + client.getNumero());
                System.out.println("Email : " + client.getEmail());
                System.out.println("Date de naissance : " + client.getDate_naissance());

                // Passer à HomePage avec le client (pour l'instant, juste HomePage)
                primaryStage.close();
                new HomePage().start(new Stage());
            }
        });

        // Bouton pour annuler
        Button btnCancel = new Button("Annuler");
        btnCancel.setStyle("-fx-font-size: 14px; -fx-padding: 10px 20px;");
        btnCancel.setOnAction(e -> primaryStage.close());

        // Mise en page
        VBox root = new VBox(20, lblTitre, lblNom, txtNom, lblPrenom, txtPrenom, lblNumero, txtNumero,
                            lblEmail, txtEmail, lblDateNaissance, datePicker, btnSignUp, btnCancel);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(30));
        root.setStyle("-fx-background-color: #f4f4f4;");

        // Scène
        Scene scene = new Scene(root);
        primaryStage.setTitle("Inscription - Cantine G6");
        primaryStage.setScene(scene);
        primaryStage.show();
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