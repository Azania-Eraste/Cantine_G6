package screen;

import domaine.Commande;
import domaine.Produit; // Importation ajoutée
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class OrderHistoryPage extends Application {

    private static List<Commande> historiqueCommandes = new ArrayList<>();

    public static void ajouterCommande(Commande commande) {
        historiqueCommandes.add(commande);
    }

    @Override
    public void start(Stage primaryStage) {
        Label lblTitre = new Label("Historique des commandes");
        lblTitre.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;");

        TableView<Commande> tableHistorique = new TableView<>();
        tableHistorique.setPlaceholder(new Label("Aucune commande enregistrée"));
        tableHistorique.setPrefWidth(800);

        TableColumn<Commande, LocalDateTime> colDate = new TableColumn<>("Date");
        colDate.setCellValueFactory(new PropertyValueFactory<>("date"));
        colDate.setPrefWidth(200);

        TableColumn<Commande, String> colProduits = new TableColumn<>("Produits");
        colProduits.setCellValueFactory(data -> {
            StringBuilder produitsStr = new StringBuilder();
            for (Produit p : data.getValue().getProduits()) {
                produitsStr.append(p.getNom()).append(", ");
            }
            return new javafx.beans.property.SimpleStringProperty(produitsStr.toString().replaceAll(", $", ""));
        });
        colProduits.setPrefWidth(300);

        TableColumn<Commande, String> colPaiement = new TableColumn<>("Mode de paiement");
        colPaiement.setCellValueFactory(new PropertyValueFactory<>("modePaiement"));
        colPaiement.setPrefWidth(150);

        TableColumn<Commande, Double> colTotal = new TableColumn<>("Total (€)");
        colTotal.setCellValueFactory(new PropertyValueFactory<>("total"));
        colTotal.setPrefWidth(150);

        tableHistorique.getColumns().addAll(colDate, colProduits, colPaiement, colTotal);
        tableHistorique.getItems().addAll(historiqueCommandes);

        Button btnRetour = new Button("Retour au menu");
        btnRetour.setStyle("-fx-font-size: 14px; -fx-padding: 10px 20px;");
        btnRetour.setOnAction(e -> {
            primaryStage.close();
            new MenuPage().start(new Stage());
        });

        VBox root = new VBox(20, lblTitre, tableHistorique, btnRetour);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(30));
        root.setStyle("-fx-background-color: #f4f4f4;");

        Scene scene = new Scene(root);
        primaryStage.setTitle("Historique des commandes - Cantine G6");
        primaryStage.setScene(scene);
        primaryStage.setFullScreen(true);
        primaryStage.show();
    }
}