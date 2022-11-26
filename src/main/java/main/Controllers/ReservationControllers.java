package main.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

import java.io.IOException;

public class ReservationControllers {

        @FXML
        private Button CancelReservation;

        @FXML
        private Button EditReservation;

        @FXML
        private TextField InputLabel;

        @FXML
        private Button NewReservation;

        @FXML
        private Button Search;

        @FXML
        void CancelClicked(MouseEvent event) {

        }

        @FXML
        void EditClicked(MouseEvent event) {

        }

        @FXML
        void NewClicked(MouseEvent event) {
                Parent root = NewReservation.getParent().getParent().getParent().getParent();
                System.out.println(root);

                try {
                        BorderPane bp = (BorderPane) root;
                        bp.setCenter(FXMLLoader.load(getClass().getResource("MakeReservation.fxml")));
                }catch (IOException e){
                        e.printStackTrace();
                }
        }

        @FXML
        void SearchClicked(MouseEvent event) {

        }
    }
