package screen;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LoginPage extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Titre
        Label lblTitre = new Label("Connexion");
        lblTitre.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;");

        // Champ pour le nom d'utilisateur
        Label lblUsername = new Label("Nom d'utilisateur :");
        lblUsername.setStyle("-fx-font-size: 14px;");
        TextField txtUsername = new TextField();
        txtUsername.setPromptText("Entrez votre nom d'utilisateur");
        txtUsername.setPrefWidth(250);

        // Champ pour le mot de passe
        Label lblPassword = new Label("Mot de passe :");
        lblPassword.setStyle("-fx-font-size: 14px;");
        PasswordField txtPassword = new PasswordField();
        txtPassword.setPromptText("Entrez votre mot de passe");
        txtPassword.setPrefWidth(250);

        // Bouton pour se connecter
        Button btnLogin = new Button("Se connecter");
        btnLogin.setStyle("-fx-font-size: 14px; -fx-padding: 10px 20px;");
        btnLogin.setOnAction(e -> {
            String username = txtUsername.getText().trim();
            String password = txtPassword.getText();

            // Validation simple (à remplacer par une vraie vérification)
            if (username.isEmpty() || password.isEmpty()) {
                showAlert("Erreur", "Veuillez remplir tous les champs !");
            } else {
                System.out.println("Connexion réussie pour : " + username);
                primaryStage.close();
                new HomePage().start(new Stage());
            }
        });

        // Bouton pour s'inscrire
        Button btnSignUp = new Button("Pas de compte ? S'inscrire");
        btnSignUp.setStyle("-fx-font-size: 14px; -fx-padding: 10px 20px; -fx-background-color: transparent; -fx-text-fill: blue;");
        btnSignUp.setOnAction(e -> {
            primaryStage.close();
            new SignUpPage().start(new Stage());
        });

        // Mise en page
        VBox root = new VBox(20, lblTitre, lblUsername, txtUsername, lblPassword, txtPassword, btnLogin, btnSignUp);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(30));
        root.setStyle("-fx-background-color: #f4f4f4;");

        // Scène
        Scene scene = new Scene(root);
        primaryStage.setTitle("Connexion - Cantine G6");
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