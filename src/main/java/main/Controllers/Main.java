package main.Controllers;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {

    private double x, y;

    @Override
    public void start(Stage stage) throws Exception {

        try{
            Parent root = FXMLLoader.load(getClass().getResource("Sample.fxml"));
            stage.setScene(new Scene(root));
            //set stage borderless
            stage.initStyle(StageStyle.UNDECORATED);

            //drag it here
            root.setOnMousePressed(event -> {
                x = event.getSceneX();
                y = event.getSceneY();
            });
            root.setOnMouseDragged(event -> {
                stage.setX(event.getScreenX() - x);
                stage.setY(event.getScreenY() - y);
            });
            stage.show();
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        launch();
    }
}