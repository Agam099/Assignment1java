package src.com.example.sales;




import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.util.ArrayList;

public class MainController {
    @FXML
    private TextField inputField;
    @FXML
    private ListView<String> listView;
    @FXML
    private Button addButton;

    // In-memory data structure to store entries
    private ArrayList<String> entries = new ArrayList<>();

    @FXML
    private void handleAddButtonAction() {
        String inputText = inputField.getText();
        if (!inputText.isEmpty()) {
            entries.add(inputText); // Store in memory
            listView.getItems().add(inputText); // Update ListView
            inputField.clear(); // Clear the input field
        }
    }
}
