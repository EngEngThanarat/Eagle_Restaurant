package main.Controllers;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.ResourceBundle;

public class DashboardControllers implements Initializable {

    @FXML
    private Label Day;

    @FXML
    private Button ShowReport;

    @FXML
    private Label Time;

    private int minute;
    private int hour;
    private int second;

    private volatile boolean stop;

    @FXML
    void showReport(MouseEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        DateNow();
        TimeNow();
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
