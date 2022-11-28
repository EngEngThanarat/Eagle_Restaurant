package main.Controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import main.Code.Customer;
import main.Sql.DB_Connection;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.util.ResourceBundle;

public class ReservationControllers implements Initializable {

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
        private TableView<Customer> table;

        @FXML
        private TableColumn<Customer, String> colDate;

        @FXML
        private TableColumn<Customer, String> colName;

        @FXML
        private TableColumn<Customer, String> colTel;

        @Override
        public void initialize(URL url, ResourceBundle resourceBundle) {

                colDate.setCellValueFactory(cellData -> cellData.getValue().dateProperty());
                colName.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
                colTel.setCellValueFactory(cellData -> cellData.getValue().telProperty());

                // select data from database
                String sql = "SELECT * FROM receive";
                DB_Connection db = new DB_Connection();
                ResultSet rs ;

                ObservableList<Customer> list = FXCollections.observableArrayList();
                try{
                        rs = db.getResultSet(sql);
                        while (rs.next()){
                                list.add(new Customer(rs.getString("Name"),rs.getString("Tel_Num"),rs.getString("Date")));
                        }
                        table.setItems(list);
                        table.setVisible(true);
                }
                catch (Exception e){
                        e.printStackTrace();
                }

        }

        @FXML
        void CancelClicked(MouseEvent event) {

                // delete data from database
                String dateSelected = table.getSelectionModel().getSelectedItem().getDate();
                String nameSelected = table.getSelectionModel().getSelectedItem().getName();


                // select id from database
                String sql = "SELECT * FROM receive WHERE Date = '" + dateSelected + "' AND Name = '" + nameSelected + "'";


                DB_Connection db = new DB_Connection();

                try{
                        ResultSet rs = db.getResultSet(sql);
                        int id = 0;
                        while (rs.next()){
                                id = rs.getInt("Bill_ID");
                        }

                        // delete data from database
                        sql = String.format("Delete from lineitem where Bill_ID = %d", id);
                        db.execute(sql);
                        sql = String.format("Delete from receive where Bill_ID = %d", id);
                        db.execute(sql);
                        System.out.println("Delete Success");

                        // refresh table
                        sql = "SELECT * FROM receive";
                        rs = db.getResultSet(sql);
                        ObservableList<Customer> list = FXCollections.observableArrayList();
                        while (rs.next()){
                                list.add(new Customer(rs.getString("Name"),rs.getString("Tel_Num"),rs.getString("Date")));
                        }
                        table.setItems(list);
                }
                catch (Exception e){
                        e.printStackTrace();
                }


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


    }
