package screen;

import domaine.Boisson;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BoissonPage extends Application {

    private List<Boisson> boissonsDisponibles;
    private List<Boisson> boissonsSelectionnees;

    public BoissonPage(List<Boisson> boissonsSelectionnees) {
        this.boissonsSelectionnees = boissonsSelectionnees;
        this.boissonsDisponibles = new ArrayList<>();
        boissonsDisponibles.add(new Boisson(5, "Coca-Cola", "Boisson gazeuse", 2.00, 20));
        boissonsDisponibles.add(new Boisson(6, "Jus d'orange", "Jus naturel", 2.50, 15));
        boissonsDisponibles.add(new Boisson(7, "Eau minérale", "Eau pure", 1.00, 30));
    }

    @Override
    public void start(Stage primaryStage) {
        Label lblTitre = new Label("Sélectionner des boissons");
        lblTitre.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");

        TableView<Boisson> tableBoissons = new TableView<>();
        tableBoissons.setPlaceholder(new Label("Aucune boisson disponible"));
        tableBoissons.setPrefWidth(700);

        TableColumn<Boisson, Boolean> colSelection = new TableColumn<>("Sélectionner");
        colSelection.setCellValueFactory(data -> data.getValue().selectedProperty());
        colSelection.setCellFactory(CheckBoxTableCell.forTableColumn(colSelection));
        colSelection.setPrefWidth(100);
        colSelection.setMinWidth(80);
        colSelection.setMaxWidth(150);
        colSelection.setEditable(true);

        TableColumn<Boisson, String> colNom = new TableColumn<>("Nom");
        colNom.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getNom()));
        colNom.setPrefWidth(300);
        colNom.setMinWidth(200);
        colNom.setMaxWidth(400);

        TableColumn<Boisson, Number> colPrix = new TableColumn<>("Prix (€)");
        colPrix.setCellValueFactory(data -> new SimpleDoubleProperty(data.getValue().getPrix()));
        colPrix.setPrefWidth(150);
        colPrix.setMinWidth(80);
        colPrix.setMaxWidth(200);

        TableColumn<Boisson, Number> colStock = new TableColumn<>("Stock");
        colStock.setCellValueFactory(data -> new SimpleIntegerProperty(data.getValue().getStock()));
        colStock.setPrefWidth(150);
        colStock.setMinWidth(80);
        colStock.setMaxWidth(200);

        // Ajout des colonnes avec une liste typée
        tableBoissons.getColumns().addAll(Arrays.asList(colSelection, colNom, colPrix, colStock));

        tableBoissons.setEditable(true);
        tableBoissons.getItems().addAll(boissonsDisponibles);

        Button btnValider = new Button("Valider");
        btnValider.setStyle("-fx-font-size: 14px; -fx-padding: 10px 20px;");
        btnValider.setOnAction(e -> {
            boissonsSelectionnees.clear();
            for (Boisson boisson : tableBoissons.getItems()) {
                if (boisson.selectedProperty().get()) {
                    boissonsSelectionnees.add(boisson);
                }
            }
            primaryStage.close();
        });

        VBox root = new VBox(20, lblTitre, tableBoissons, btnValider);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(30));
        root.setStyle("-fx-background-color: #f4f4f4;");

        Scene scene = new Scene(root);
        primaryStage.setTitle("Ajouter une boisson - Cantine G6");
        primaryStage.setScene(scene);
        primaryStage.setFullScreen(true);
        primaryStage.show();
    }
}