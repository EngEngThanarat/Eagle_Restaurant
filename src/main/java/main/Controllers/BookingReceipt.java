package main.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import main.Code.LineItem;
import main.Code.booking;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.jar.Attributes;

public class BookingReceipt implements Initializable {

    @FXML
    private Label BillNumber;

    @FXML
    private Label DateNumber;

    @FXML
    private Label NameCustomer;

    @FXML
    private Label TableNumber;

    @FXML
    private Label TelephoneNumber;

    @FXML
    private Label CustomerName;

    @FXML
    private Button close;

    @FXML
    private Label CustomerTel;

    @FXML
    private ListView<HBox> list;

    private booking bk;

    public BookingReceipt(booking in) {
        this.bk = in;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.CustomerName.setText(bk.getCustomerName());
        this.CustomerTel.setText(bk.getTelephone());
        this.DateNumber.setText(String.valueOf(bk.getDate()));
        for (LineItem item: bk.getItem()) {
            LineItemControl2 ln = new LineItemControl2();
            ln.setNameItem(item.getMenu());
            ln.setQuantity(item.getQuantity());
            ln.setCost(item.getPrice());
            list.getItems().add(ln);
        }
        this.BillNumber.setText(bk.getInvoiceID());
    }

    public Label getBillNumber() {
        return BillNumber;
    }

    public void setBillNumber(Label billNumber) {
        BillNumber = billNumber;
    }

    public Label getDateNumber() {
        return DateNumber;
    }

    public void setDateNumber(Label dateNumber) {
        DateNumber = dateNumber;
    }

    public Label getNameCustomer() {
        return NameCustomer;
    }

    public void setNameCustomer(Label nameCustomer) {
        NameCustomer = nameCustomer;
    }

    public Label getTableNumber() {
        return TableNumber;
    }

    public void setTableNumber(Label tableNumber) {
        TableNumber = tableNumber;
    }

    public Label getTelephoneNumber() {
        return TelephoneNumber;
    }

    public void setTelephoneNumber(Label telephoneNumber) {
        TelephoneNumber = telephoneNumber;
    }

    @FXML
    void closeClick(MouseEvent event) {
        Stage stage = (Stage) close.getScene().getWindow();
        stage.close();
    }


}
