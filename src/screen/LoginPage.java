package screen;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LoginPage extends Application {

    @Override
    public void start(Stage primaryStage) {
        Label lblTitre = new Label("Connexion a la Cantine");
        lblTitre.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");

        TextField champUtilisateur = new TextField();
        champUtilisateur.setPromptText("Nom d'utilisateur");
        champUtilisateur.setMaxWidth(250);

        PasswordField champMotDePasse = new PasswordField();
        champMotDePasse.setPromptText("Mot de passe");
        champMotDePasse.setMaxWidth(250);

        Button btnConnexion = new Button("Se connecter");
        btnConnexion.setStyle("-fx-font-size: 14px; -fx-padding: 10px 20px;");
        btnConnexion.setOnAction(e -> {
            String utilisateur = champUtilisateur.getText();
            String motDePasse = champMotDePasse.getText();
            if (utilisateur.equals("admin") && motDePasse.equals("1234")) {
                System.out.println("Connexion réussie pour : " + utilisateur);
                primaryStage.close();
                new HomePage().start(primaryStage); // Ouvre MenuPage
            } else if (utilisateur.isEmpty() || motDePasse.isEmpty()) {
                System.out.println("Veuillez remplir tous les champs !");
            } else {
                System.out.println("Identifiants incorrects !");
            }
        });

        VBox root = new VBox(20, lblTitre, champUtilisateur, champMotDePasse, btnConnexion);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(30));
        root.setStyle("-fx-background-color: #f4f4f4;");

        Scene scene = new Scene(root, 400, 300);
        primaryStage.setTitle("Connexion - Cantine G6");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}