package main;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

import java.io.IOException;

public class ListCheckBillControllers {

    @FXML
    private Button CheckOut;

    @FXML
    void CheckOutClicked(MouseEvent event) {
        Parent root = CheckOut.getParent().getParent().getParent();

        try {
            BorderPane bp = (BorderPane) root;
            bp.setCenter(FXMLLoader.load(getClass().getResource("PayPage.fxml")));
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}

