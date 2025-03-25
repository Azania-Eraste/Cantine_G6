package screen;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class HomePage extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Titre
        Label lblTitre = new Label("Bienvenue dans MidiDish");
        lblTitre.setStyle("-fx-font-size: 28px; -fx-font-weight: bold;");

        // Bouton pour aller au menu
        Button btnMenu = new Button("Consulter le menu");
        btnMenu.setStyle("-fx-font-size: 16px; -fx-padding: 10px 20px;");
        btnMenu.setOnAction(e -> {
            primaryStage.close();
            new MenuPage().start(new Stage());
        });

        // Bouton pour voir l'historique
        Button btnHistorique = new Button("Historique des commandes");
        btnHistorique.setStyle("-fx-font-size: 16px; -fx-padding: 10px 20px;");
        btnHistorique.setOnAction(e -> {
            primaryStage.close();
            new OrderHistoryPage().start(new Stage());
        });

        // Bouton pour se déconnecter (retour à LoginPage)
        Button btnDeconnexion = new Button("Se deconnecter");
        btnDeconnexion.setStyle("-fx-font-size: 16px; -fx-padding: 10px 20px;");
        btnDeconnexion.setOnAction(e -> {
            primaryStage.close();
            // Remplace par LoginPage si tu en as une
            System.out.println("Déconnexion - Retour à la page de connexion");
        });

        // Mise en page
        VBox root = new VBox(30, lblTitre, btnMenu, btnHistorique, btnDeconnexion);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(50));
        root.setStyle("-fx-background-color: #f4f4f4;");

        // Scène
        Scene scene = new Scene(root);
        primaryStage.setTitle("Accueil - Cantine G6");
        primaryStage.setScene(scene);
        primaryStage.setFullScreen(true);
        primaryStage.show();
    }
}