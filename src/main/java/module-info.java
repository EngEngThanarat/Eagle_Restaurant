module main.eagle_restaurant {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens main.Controllers to javafx.fxml;

    opens main.Code to javafx.fxml;
    opens main.Sql to javafx.fxml;
    exports main.Controllers;
    exports main.Code;
    exports main.Sql;
    



}