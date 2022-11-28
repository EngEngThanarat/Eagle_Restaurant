package main.Controllers;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import main.Code.LineItem;
import main.Code.payReceipt;

import java.net.URL;
import java.util.ResourceBundle;

public class ReceiptControllers implements Initializable {


    @FXML
    private Label Bill;

    @FXML
    private Label Cash;

    @FXML
    private Label Change;

    @FXML
    private Label Date;

    @FXML
    private ListView<HBox> ListOrder;

    @FXML
    private Label SubTotal;

    @FXML
    private Label Table;

    @FXML
    private Button close;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Bill.setText(payReceipt.Bill);
        Cash.setText(payReceipt.Cash);
        Change.setText(payReceipt.Change);
        Date.setText(payReceipt.Date);
        SubTotal.setText(payReceipt.SubTotal);
        Table.setText(payReceipt.Table);
        ObservableList<LineItem> lineItems = payReceipt.lineItems;
        for (LineItem item: lineItems) {
            LineItemControl2 ln = new LineItemControl2();
            ln.setNameItem(item.getMenu());
            ln.setQuantity(item.getQuantity());
            ln.setCost(item.getPrice());
            ListOrder.getItems().add(ln);
        }

    }

    @FXML
    void closeClick(MouseEvent event) {
        Stage stage = (Stage) close.getScene().getWindow();
        stage.close();
    }

}
