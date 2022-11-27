package main.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LineItemControl2 extends HBox implements Initializable {

    @FXML
    private Label Cost;

    @FXML
    private Label NameItem;

    @FXML
    private Label Quantity;

    public LineItemControl2(){

        FXMLLoader loader = new FXMLLoader(getClass().getResource("LineItem2.fxml"));
        loader.setRoot(this);
        loader.setController(this);
        try {
            loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void setNameItem(String name){
        NameItem.setText(name);
    }

    public void setQuantity(int n){
        Quantity.setText(String.valueOf(n));
    }

    public void setCost(double n){
        Cost.setText(String.valueOf(n));
    }
}
