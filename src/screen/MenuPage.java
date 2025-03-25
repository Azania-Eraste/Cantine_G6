package screen;

import domaine.Boisson;
import domaine.Menu;
import domaine.Produit;
import domaine.Repas;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MenuPage extends Application {

    private Menu menu;
    private List<Boisson> boissonsSelectionnees;

    public MenuPage() {
        this.menu = new Menu();
        this.boissonsSelectionnees = new ArrayList<>();
        menu.ajouterRepas(new Repas(1, "Poulet braise avec riz", "Poulet grillé et riz", 5.50, 10));
        menu.ajouterRepas(new Repas(2, "Riz au gras", "Riz cuit avec sauce", 4.00, 15));
        menu.ajouterRepas(new Repas(3, "Spaghetti bolognaise", "Pâtes avec sauce viande", 6.00, 8));
        menu.ajouterRepas(new Repas(4, "Salade de fruits", "Mélange de fruits frais", 3.50, 20));
    }

    @Override
    public void start(Stage primaryStage) {
        // Bouton Historique en haut à gauche
        Button btnHistorique = new Button("Historique");
        btnHistorique.setStyle("-fx-font-size: 12px; -fx-padding: 5px 10px;");
        btnHistorique.setOnAction(e -> {
            primaryStage.close();
            new OrderHistoryPage().start(new Stage());
        });

        // Titre
        Label lblTitre = new Label("Menu du jour");
        lblTitre.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");

        // TableView des plats
        TableView<Repas> tablePlats = new TableView<>();
        tablePlats.setPlaceholder(new Label("Aucun plat disponible"));
        tablePlats.setPrefWidth(700);

        TableColumn<Repas, Boolean> colSelection = new TableColumn<>("Selectionner");
        colSelection.setCellValueFactory(data -> data.getValue().selectedProperty());
        colSelection.setCellFactory(CheckBoxTableCell.forTableColumn(colSelection));
        colSelection.setPrefWidth(100);
        colSelection.setMinWidth(80);
        colSelection.setMaxWidth(150);
        colSelection.setEditable(true);

        TableColumn<Repas, String> colNom = new TableColumn<>("Nom");
        colNom.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getNom()));
        colNom.setPrefWidth(300);
        colNom.setMinWidth(200);
        colNom.setMaxWidth(400);

        TableColumn<Repas, Number> colPrix = new TableColumn<>("Prix (€)");
        colPrix.setCellValueFactory(data -> new SimpleDoubleProperty(data.getValue().getPrix()));
        colPrix.setPrefWidth(150);
        colPrix.setMinWidth(80);
        colPrix.setMaxWidth(200);

        TableColumn<Repas, Number> colStock = new TableColumn<>("Stock");
        colStock.setCellValueFactory(data -> new SimpleIntegerProperty(data.getValue().getStock()));
        colStock.setPrefWidth(150);
        colStock.setMinWidth(80);
        colStock.setMaxWidth(200);

        tablePlats.getColumns().addAll(Arrays.asList(colSelection, colNom, colPrix, colStock));
        tablePlats.setEditable(true);
        tablePlats.getItems().addAll(menu.getRepas());

        // Boutons Ajouter une boisson et Réserver
        Button btnAjouterBoisson = new Button("Ajouter une boisson");
        btnAjouterBoisson.setStyle("-fx-font-size: 14px; -fx-padding: 10px 20px;");
        btnAjouterBoisson.setOnAction(e -> {
            BoissonPage boissonPage = new BoissonPage(boissonsSelectionnees);
            boissonPage.start(new Stage());
        });

        Button btnReserver = new Button("Reserver");
        btnReserver.setStyle("-fx-font-size: 14px; -fx-padding: 10px 20px;");
        btnReserver.setOnAction(e -> {
            List<Repas> platsSelectionnes = new ArrayList<>();
            for (Repas repas : tablePlats.getItems()) {
                if (repas.selectedProperty().get()) {
                    platsSelectionnes.add(repas);
                }
            }
            List<Produit> produitsReserves = new ArrayList<>(platsSelectionnes);
            produitsReserves.addAll(boissonsSelectionnees);

            if (!produitsReserves.isEmpty()) {
                new ReservationPage(produitsReserves).start(new Stage());
            } else {
                System.out.println("Veuillez sélectionner au moins un plat ou une boisson !");
            }
        });

        HBox boutons = new HBox(20, btnAjouterBoisson, btnReserver);
        boutons.setAlignment(Pos.CENTER);

        // Contenu central
        VBox contenuCentral = new VBox(20, lblTitre, tablePlats, boutons);
        contenuCentral.setAlignment(Pos.CENTER);
        contenuCentral.setPadding(new Insets(30));

        // BorderPane pour organiser la mise en page
        BorderPane root = new BorderPane();
        root.setTop(btnHistorique);
        BorderPane.setAlignment(btnHistorique, Pos.TOP_LEFT);
        BorderPane.setMargin(btnHistorique, new Insets(10)); // Marge autour du bouton
        root.setCenter(contenuCentral);
        root.setStyle("-fx-background-color: #f4f4f4;");

        // Scène
        Scene scene = new Scene(root);
        primaryStage.setTitle("Menu - Cantine G6");
        primaryStage.setScene(scene);
        primaryStage.setFullScreen(true);
        primaryStage.show();
    }
}