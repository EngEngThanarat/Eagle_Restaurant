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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import main.Code.Customer;
import main.Code.LineItem;
import main.Code.payReceipt;
import main.Code.temp;
import main.Sql.DB_Connection;

import java.net.URL;
import java.sql.ResultSet;
import java.util.ResourceBundle;

public class ListCheckBillControllers implements Initializable {

    @FXML
    private Button CheckOut;

    @FXML
    private TableView<Customer> table;

    @FXML
    private TableColumn<Customer, String> colName;
    @FXML
    private TableColumn<Customer, String > colTel;


    @FXML
    private TableColumn<Customer, String > colDate;

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

        CheckOut.setDisable(true);

        // add table view select listener
        table.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {

                CheckOut.setDisable(false);
            }else CheckOut.setDisable(true);
        });




    }

    @FXML
    void CheckOutClicked(MouseEvent event) {

        // get selected item from database
        Customer customer = table.getSelectionModel().getSelectedItem();
        String sql = "SELECT * FROM receive WHERE Name = '"+ customer.getName()+"' AND Tel_Num = '"+ customer.getTel()+"' AND Date = '"+ customer.getDate()+"'";
        DB_Connection db = new DB_Connection();
        ResultSet rs ;
        int id = 0;
        String Date = "";
        String Table = "";
        try{
            rs = db.getResultSet(sql);
            while (rs.next()){
                id = rs.getInt("bill_id");
                Date = rs.getString("Date");
                Table = rs.getString("Table");
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        temp.selectedID = String.valueOf(id);
        temp.date = Date;
        temp.selectedTable = Table;

        // select lineitem from database
        sql = String.format("select * from lineitem where bill_id='%s'",temp.selectedID);
        ObservableList<LineItem> list = FXCollections.observableArrayList();
        try{
            rs = db.getResultSet(sql);
            while (rs.next()){
                list.add(new LineItem(rs.getString("name"),rs.getInt("qty"),rs.getDouble("price")));
            }
        }catch (Exception e){

        }

        payReceipt.lineItems = list;

        Parent root = CheckOut.getParent().getParent().getParent();

        try {
            BorderPane bp = (BorderPane) root;
            bp.setCenter(FXMLLoader.load(getClass().getResource("PayPage.fxml")));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

