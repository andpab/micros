package de.saxsys;

import de.saxsys.model.ClientPasta;
import de.saxsys.service.PastaService;
import javafx.collections.FXCollections;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MainView {

    private BorderPane rootPane;

    @Autowired
    private PastaService pastaService;

    private void initUI() {
        TableView<ClientPasta> pastaTableView = createTableView();
        Label placeholderMessageLabel = new Label("");
        pastaTableView.setPlaceholder(placeholderMessageLabel);
        ProgressIndicator progressIndicator = new ProgressIndicator();
        progressIndicator.setMaxSize(100, 100);

        PastaRetrievalService asyncPastaRetrievalService = new PastaRetrievalService();
        configureService(asyncPastaRetrievalService, pastaTableView, placeholderMessageLabel);
        progressIndicator.visibleProperty().bind(asyncPastaRetrievalService.runningProperty());

        Button button = new Button("Get pasta!");
        button.setOnAction(event -> {
            pastaTableView.getItems().clear();
            placeholderMessageLabel.setText("");
            asyncPastaRetrievalService.restart();
        });

        rootPane = new BorderPane();
        rootPane.setTop(button);
        rootPane.setCenter(new StackPane(pastaTableView, progressIndicator));
    }

    private TableView<ClientPasta> createTableView() {
        TableView<ClientPasta> pastaTableView = new TableView<>();
        TableColumn<ClientPasta, Boolean> alDente = createTableColumn("alDente");
        TableColumn<ClientPasta, String> shape = createTableColumn("shape");
        //noinspection unchecked
        pastaTableView.getColumns().addAll(alDente, shape);
        return pastaTableView;
    }

    private static <T> TableColumn<ClientPasta, T> createTableColumn(String alDente) {
        TableColumn<ClientPasta, T> tableColumn = new TableColumn<>(alDente);
        tableColumn.setCellValueFactory(new PropertyValueFactory<>(alDente));
        return tableColumn;
    }

    @SuppressWarnings("ThrowableResultOfMethodCallIgnored")
    private void configureService(PastaRetrievalService pastaRetrievalService,
                                  TableView<ClientPasta> pastaTableView,
                                  Label placeholderMessageLabel) {
        pastaRetrievalService.setOnSucceeded(
                event -> pastaTableView.setItems(FXCollections.observableArrayList(pastaRetrievalService.getValue())));
        pastaRetrievalService.setOnFailed(
                event -> placeholderMessageLabel.setText(pastaRetrievalService.getException().getMessage()));
    }

    private class PastaRetrievalService extends Service<ClientPasta> {
        @Override
        protected Task<ClientPasta> createTask() {
            return new Task<ClientPasta>() {
                @Override
                protected ClientPasta call() throws Exception {
                    return pastaService.getPasta();
                }
            };
        }
    }

    Pane getRootPane() {
        if (rootPane == null) {
            initUI();
        }
        return rootPane;
    }
}
