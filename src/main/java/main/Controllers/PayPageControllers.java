package main.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class PayPageControllers {

        @FXML
        private Button Pay;

        @FXML
        void PayClick(MouseEvent event) throws IOException {
                Parent root = null;

                root = FXMLLoader.load(getClass().getResource("Receipt.fxml"));
                Scene scene = new Scene(root);

                Stage stage = new Stage();
                stage.initStyle(StageStyle.TRANSPARENT);
                stage.setScene(scene);
                stage.show();
        }
}
