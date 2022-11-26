module main.eagle_restaurant {
    requires javafx.controls;
    requires javafx.fxml;


    opens main.Controllers to javafx.fxml;
    exports main.Controllers;
}