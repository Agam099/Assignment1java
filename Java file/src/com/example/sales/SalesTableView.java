// SalesViewTable.java
package src.com.example.sales;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import java.time.LocalDate;
import java.sql.ResultSet;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SalesTableView implements Initializable {
    @FXML
    private TableView<Sale> salesTable;

    @FXML
    private TableColumn<Sale, Integer> saleIdColumn;

    @FXML
    private TableColumn<Sale, LocalDate> saleDateColumn;

    @FXML
    private TableColumn<Sale, String> customerNameColumn;

    @FXML
    private TableColumn<Sale, Double> totalAmountColumn;

    private ObservableList<Sale> salesData = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Initialize table columns
        saleIdColumn.setCellValueFactory(new PropertyValueFactory<>("saleId"));
        saleDateColumn.setCellValueFactory(new PropertyValueFactory<>("saleDate"));
        customerNameColumn.setCellValueFactory(new PropertyValueFactory<>("customerName"));
        totalAmountColumn.setCellValueFactory(new PropertyValueFactory<>("totalAmount"));

        // Load sales data from database
        try (ResultSet resultSet = DBUtility.executeQueryWithResults("SELECT * FROM sales")) {
            while (resultSet.next()) {
                Sale sale = new Sale(resultSet.getInt("sale_id"), resultSet.getDate("sale_date").toLocalDate(),
                        resultSet.getString("customer_name"), resultSet.getDouble("total_amount"));
                salesData.add(sale);
            }
        } catch (SQLException e) {
            System.err.println("Error loading sales data: " + e.getMessage());
        }

        // Set sales data to table
        salesTable.setItems(salesData);
    }
}
