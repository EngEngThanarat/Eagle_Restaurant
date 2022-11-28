package main.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import main.Code.payReceipt;
import main.Code.temp;
import main.Sql.DB_Connection;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.util.ResourceBundle;

public class PayPageControllers extends Node implements Initializable {


        @FXML
        private TextField Money;

        @FXML
        private Label Name;

        @FXML
        private Button Pay;

        @FXML
        private Label Table;

        @FXML
        private Label Tel;

        @FXML
        private Label Total;

        @FXML
        private ListView<LineItemControl3> list;






        @FXML
        void PayClick(MouseEvent event) throws IOException {

                int amount = Integer.parseInt(Money.getText());
                int total = Integer.parseInt(Total.getText());

                if (amount >= total) {

                        payReceipt.Bill = temp.selectedID;
                        payReceipt.Cash  = String.valueOf(amount);
                        payReceipt.Change = String.valueOf(amount - total);
                        payReceipt.Date = temp.date;
                        payReceipt.SubTotal = String.valueOf(total);
                        payReceipt.Table = temp.selectedTable;

                        Parent root = null;
                        root = FXMLLoader.load(getClass().getResource("Receipt.fxml"));
                        Scene scene = new Scene(root);
                        Stage stage = new Stage();
                        stage.initStyle(StageStyle.TRANSPARENT);
                        stage.setScene(scene);
                        stage.show();
                }else{
                        System.out.println("Not enough money");
                }


        }

        @Override
        public void initialize(URL url, ResourceBundle resourceBundle) {

                String sql = String.format("SELECT `Table`,`Name`,`Tel_Num`,`totalprice` FROM receive where bill_id='%s'", temp.selectedID),Table,Name,Tel,Total;
                System.out.println(sql);
                DB_Connection db = new DB_Connection();
                try {
                        ResultSet rs = db.getResultSet(sql);
                        if (!rs.next())return;
                        Table = rs.getString("Table");
                        Name = rs.getString("Name");
                        Tel = rs.getString("Tel_Num");
                        Total = rs.getString("totalprice");

                        this.Table.setText(Table);
                        this.Name.setText(Name);
                        this.Tel.setText(Tel);
                        this.Total.setText(Total);


                        sql = String.format("select * from lineitem where bill_id='%s'",temp.selectedID);
                        rs = db.getResultSet(sql);
                        while (rs.next()){
                                LineItemControl3 ln = new LineItemControl3();
                                ln.setName(rs.getString("name"));
                                ln.setCost(rs.getString("price"));
                                ln.setQuantity(rs.getString("qty"));
                                list.getItems().add(ln);
                        }


                }catch (Exception e){
                        e.printStackTrace();
                }

        }

        @Override
        public Node getStyleableNode() {
                return super.getStyleableNode();
        }
}
