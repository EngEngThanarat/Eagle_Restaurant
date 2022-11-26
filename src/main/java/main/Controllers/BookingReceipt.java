package main.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class BookingReceipt {

    @FXML
    private Label BillNumber;

    @FXML
    private Label CustomerName;

    @FXML
    private Label DateNumber;

    @FXML
    private Label TableNumber;

    @FXML
    private Label TelephoneNumber;

    @FXML
    private Button close;

    @FXML
    void closeClick(MouseEvent event) {
        Stage stage = (Stage) close.getScene().getWindow();
        stage.close();
    }

}