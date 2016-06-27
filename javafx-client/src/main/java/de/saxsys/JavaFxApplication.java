package de.saxsys;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;

@Component
public class JavaFxApplication implements CommandLineRunner {

    @Autowired
    private MainView mainView;

    @Override
    public void run(String... strings) throws Exception {
        new JFXPanel();
        CompletableFuture.runAsync(() -> {
            Stage stage = new Stage();
            stage.setTitle("JavaFX App");
            stage.setScene(new Scene(mainView.getRootPane(), 800, 600));
            stage.showAndWait();
        }, Platform::runLater).join();
    }
}
