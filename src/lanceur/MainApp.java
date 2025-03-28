package lanceur;

import javafx.application.Application;
import screen.*;

public class MainApp {
    public static void main(String[] args) {
        // Lancer l'application JavaFX en appelant LoginPage
        System.out.println("Lancement de LoginPage depuis MainApp");
        Application.launch(LoginPage.class, args);
    }
}