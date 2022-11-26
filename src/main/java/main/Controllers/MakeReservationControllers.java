package main.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

import java.io.IOException;

public class MakeReservationControllers {
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
    void ConfirmClick(MouseEvent event) {

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

