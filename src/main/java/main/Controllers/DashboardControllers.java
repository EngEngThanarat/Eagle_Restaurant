package main.Controllers;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import main.Code.Report;
import main.Sql.DB_Connection;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.ResourceBundle;

public class DashboardControllers implements Initializable {

    @FXML
    private Label Day;

    @FXML
    private Button ShowReport;

    @FXML
    private Label Time;

    @FXML
    private TableColumn<Report, String> colDate;

    @FXML
    private TableColumn<Report, String> colName;

    @FXML
    private TableColumn<Report, String> colPrice;

    @FXML
    private TableView<Report> table;

    @FXML
    private ComboBox<String> combo;

    private volatile boolean stop;

    @FXML
    void showReport(MouseEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        DateNow();
        TimeNow();

        // initialize combo box
        ObservableList<String> monthList = FXCollections.observableArrayList();
        monthList.add("01");
        monthList.add("02");
        monthList.add("03");
        monthList.add("04");
        monthList.add("05");
        monthList.add("06");
        monthList.add("07");
        monthList.add("08");
        monthList.add("09");
        monthList.add("10");
        monthList.add("11");
        monthList.add("12");

        combo.setItems(monthList);


        // load data from database
        String sql = "SELECT * FROM `receive` INNER JOIN `lineitem` ON receive.bill_id = lineitem.bill_id";
        DB_Connection db = new DB_Connection();

        // set data to table
        colDate.setCellValueFactory(cellData -> cellData.getValue().DateProperty());
        colName.setCellValueFactory(cellData -> cellData.getValue().NameProperty());
        colPrice.setCellValueFactory(cellData -> cellData.getValue().TotalProperty());

        ObservableList<Report> list = FXCollections.observableArrayList();
        try {
            ResultSet rs = db.getResultSet(sql);

            while (rs.next()) list.add(new Report(rs.getString("Date"), rs.getString(12), rs.getString("totalprice")));

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        table.setItems(list);

        // combo box select listener
        combo.getSelectionModel().selectedItemProperty().addListener((observableValue, s, t1) -> {
            String sql2 = "SELECT * FROM `receive` INNER JOIN `lineitem` ON receive.bill_id = lineitem.bill_id WHERE Date LIKE '%"+t1+"%'";
            DB_Connection db2 = new DB_Connection();

            // set data to table
            colDate.setCellValueFactory(cellData -> cellData.getValue().DateProperty());
            colName.setCellValueFactory(cellData -> cellData.getValue().NameProperty());
            colPrice.setCellValueFactory(cellData -> cellData.getValue().TotalProperty());

            ObservableList<Report> list2 = FXCollections.observableArrayList();
            try {
                ResultSet rs2 = db2.getResultSet(sql2);

                while (rs2.next()) list2.add(new Report(rs2.getString("Date"), rs2.getString(12), rs2.getString("totalprice")));

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            table.setItems(list2);
        });


    }

    public void DateNow(){
        LocalDate now = LocalDate.now();
        Day.setText(String.valueOf(now));
    }

   public void TimeNow(){
        Thread thread = new Thread(() ->{
            SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
            while (!stop){
                try {
                    Thread.sleep(1000);
                }catch (Exception e){
                    System.out.println(e);
                }
                final String timenow = sdf.format(new Date());
                Platform.runLater(()->{
                    Time.setText(timenow);
                });
            }
        });
        thread.start();
   }
}
