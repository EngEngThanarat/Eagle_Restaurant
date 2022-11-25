package main;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainControllers implements Initializable {

    @FXML
    private BorderPane bpMain;

    @FXML
    private Button About;

    @FXML
    private Button Check_Out;

    @FXML
    private Button Dashboard;

    @FXML
    private Button Exit;

    @FXML
    private Button Reservation;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Parent parent = null;
        try {
            parent = FXMLLoader.load(getClass().getResource("DashboardPage.fxml"));
        }catch (IOException e){

        }
        bpMain.setCenter(parent);
    }

    @FXML
    void DachBoardClick(MouseEvent event) {
        loadPage("DashboardPage");
    }

    @FXML
    void ReservationClicked(MouseEvent event) {
        loadPage("ReservationPage");
    }

    @FXML
    void CheckOutClick(MouseEvent event) {
        loadPage("CheckOutPage");
    }

    @FXML
    void AboutClicked(MouseEvent event) {
        loadPage("AboutPage");
    }

    public void loadPage(String page){
        Parent root = null;

        try {
            root = FXMLLoader.load(getClass().getResource(page+".fxml"));
        } catch (IOException e) {

        }
        bpMain.setCenter(root);
    }

    @FXML
    void ExitClicked(MouseEvent event) {
        System.exit(0);
    }
}


