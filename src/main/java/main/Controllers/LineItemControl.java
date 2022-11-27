package main.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.layout.HBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LineItemControl extends HBox implements Initializable {

    @FXML
    private Label CostItem;

    @FXML
    private Label NameItem;

    @FXML
    private Spinner<Integer> QuantityItem;

    public String type;

    LineItemControl(){

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("LineItem.fxml"));
        System.out.println(fxmlLoader.getLocation());
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory( 1, 10, 1 );
        QuantityItem.setValueFactory( valueFactory );
    }

    public void setCostItem(double CostItem){
        this.CostItem.setText(String.valueOf(CostItem));
    }

    public  void setNameItem(String NameItem){
        this.NameItem.setText(NameItem);
    }

    public Spinner<Integer> getQuantityItem() {
        return QuantityItem;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
