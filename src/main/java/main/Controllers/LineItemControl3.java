package main.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class LineItemControl3 extends HBox {

    @FXML
    private Label Cost;

    @FXML
    private Label NameItem;

    @FXML
    private Label Quantity;

    public LineItemControl3()  {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("LineItem3.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public void setName(String name){
        NameItem.setText(name);
    }

    public void setQuantity(String quantity){
        Quantity.setText(quantity);
    }

    public void setCost(String cost){
        Cost.setText(cost);
    }

}
