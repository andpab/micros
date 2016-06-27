package de.saxsys;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;

@Component
public class JavaFxApplication implements CommandLineRunner {
    @Override
    public void run(String... strings) throws Exception {
        new JFXPanel();
        CompletableFuture.runAsync(() -> {
            Stage stage = new Stage();
            stage.setTitle("JavaFX App");
            stage.setScene(new Scene(new Pane(), 800, 600));
            stage.showAndWait();
        }, Platform::runLater).join();
    }
}
