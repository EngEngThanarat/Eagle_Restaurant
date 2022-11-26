package main.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

public class MakeReservationControllers {

    BookingReceipt br = new BookingReceipt();
    @FXML
    private DatePicker ChooseDate;
    @FXML
    private Button Confirm;

    @FXML
    private TextField CustomerNumber;

    @FXML
    private Tab Dessert;

    @FXML
    private Tab MainDish;

    @FXML
    private Button ManageMenu;

    @FXML
    private TextField Name;

    @FXML
    private TabPane TabPaneMenu;

    @FXML
    private TextField Telephone;

    @FXML
    private Tab Water;

    @FXML
    private Button orderDessert1;

    @FXML
    private Button orderDessert2;

    @FXML
    private Button orderDessert3;

    @FXML
    private Button orderMain1;

    @FXML
    private Button orderMain2;

    @FXML
    private Button orderMain3;

    @FXML
    private Button orderWater1;

    @FXML
    private Button orderWater2;

    @FXML
    private Button orderWater3;

    @FXML
    void ConfirmClick(MouseEvent event) throws IOException {
    /*    ChooseDate.getValue();
        LocalDate date = ChooseDate.getValue();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        String showDate = dateFormat.format(date);

        String name = Name.getText();
        String number = Telephone.getText();
        String HowMany = CustomerNumber.getText();

        br.CustomerName.setText(name);
        br.DateNumber.setText(showDate);
        br.TableNumber.setText(HowMany);
        br.TableNumber.setText(number); */

        Parent root = null;

        root = FXMLLoader.load(getClass().getResource("Booking.fxml"));
        Scene scene = new Scene(root);

        Stage stage = new Stage();
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void ManageMenuClick(MouseEvent event) {
        Parent root = ManageMenu.getParent().getParent().getParent();

        try {
            BorderPane bp = (BorderPane) root;
            bp.setCenter(FXMLLoader.load(getClass().getResource("ManageMenu.fxml")));
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @FXML
    void orderDessert1click(MouseEvent event) {

    }

    @FXML
    void orderDessert2click(MouseEvent event) {

    }

    @FXML
    void orderDessert3(MouseEvent event) {

    }

    @FXML
    void orderMain1click(MouseEvent event) {

    }

    @FXML
    void orderMain2click(MouseEvent event) {

    }

    @FXML
    void orderMain3click(MouseEvent event) {

    }

    @FXML
    void orderWater1click(MouseEvent event) {

    }

    @FXML
    void orderWater2click(MouseEvent event) {

    }

    @FXML
    void orderWater3click(MouseEvent event) {

    }

}

