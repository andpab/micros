package de.saxsys;

import de.saxsys.model.ClientPasta;
import de.saxsys.service.PastaService;
import javafx.collections.FXCollections;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MainView {

    private BorderPane rootPane;

    @Autowired
    private PastaService pastaService;

    private void initUI() {
        TableView<ClientPasta> pastaTableView = createTableView();

        Button button = new Button("Get pasta!");
        button.setOnAction(event -> {
            pastaTableView.getItems().clear();
            // this should actually be done in a background thread of course
            ClientPasta pasta = pastaService.getPasta();
            pastaTableView.setItems(FXCollections.observableArrayList(pasta));
        });

        rootPane = new BorderPane();
        rootPane.setTop(button);
        rootPane.setCenter(pastaTableView);
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

    Pane getRootPane() {
        if (rootPane == null) {
            initUI();
        }
        return rootPane;
    }
}
