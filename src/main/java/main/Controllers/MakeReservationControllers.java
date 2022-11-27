package main.Controllers;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import main.Code.*;
import main.Code.Menu;

import java.io.IOException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class MakeReservationControllers {

    @FXML
    private Label subTotal;
    int subTotalValue = 0;
    @FXML
    private ListView<HBox> ListOrder;
    @FXML
    private DatePicker ChooseDate;
    @FXML
    private Button Confirm;

    @FXML
    private TextField CustomerNumber;

    @FXML
    private Tab Dessert;

    @FXML
    private Tab MainDish;

    @FXML
    private Button ManageMenu;

    @FXML
    private TextField Name;

    @FXML
    private TabPane TabPaneMenu;

    @FXML
    private TextField Telephone;

    @FXML
    private Tab Water;

    @FXML
    private Button orderDessert1;

    @FXML
    private Button orderDessert2;

    @FXML
    private Button orderDessert3;

    @FXML
    private Button orderMain1;

    @FXML
    private Button orderMain2;

    @FXML
    private Button orderMain3;

    @FXML
    private Button orderWater1;

    @FXML
    private Button orderWater2;

    @FXML
    private Button orderWater3;
    @FXML
    void ConfirmClick(MouseEvent event) throws IOException {

        // Check Date
        LocalDate date = ChooseDate.getValue();
        LocalDate now = LocalDate.now();

        long sub = ChronoUnit.DAYS.between(now,date);

        System.out.println(sub);
        if(sub < 3)
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Missing Date");
            alert.setHeaderText(null);
            alert.setContentText(" Please choose date again ! ");
            alert.showAndWait();
        }
        // Check TextField
        else if (Name.getText() == null){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Input Customer name");
            alert.setHeaderText(null);
            alert.setContentText(" Please Input Customer name");
            alert.showAndWait();
        }else if (Telephone.getText() == null){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Input Customer name");
            alert.setHeaderText(null);
            alert.setContentText(" Please Input telephone number");
            alert.showAndWait();
        }else if (CustomerNumber.getText() == null){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Input Customer name");
            alert.setHeaderText(null);
            alert.setContentText(" Please Input Customer number");
            alert.showAndWait();
        }

        // create array of LineItem from menuList
        ObservableList<HBox> listOrder = ListOrder.getItems();
        LineItem lineItems[] = new LineItem[listOrder.size()];
        for (int i = 0; i < listOrder.size(); i++) {
            HBox line = listOrder.get(i);
            LineItemControl ln = (LineItemControl) line;
            String menuName = ((Label) line.getChildren().get(0)).getText();
            double price = Double.parseDouble(((Label) line.getChildren().get(1)).getText());
            int amount = ((Spinner<Integer>) line.getChildren().get(2)).getValue();
            switch (ln.getType()){
                case "Main" ->{
                    Menu menu = new MeatDish(menuName,price);
                }
                case "Dessert" -> {
                    Menu menu = new Dessert(menuName,price);
                }
                case "Drink" ->{
                    Menu menu = new water(menuName,price);
                }
            }
            Spinner<Integer> menuSpinner = (Spinner<Integer>) line.getChildren().get(2);
            int menuAmount = menuSpinner.getValue();
            lineItems[i] = new LineItem(menuName, menuAmount, price);
        }

        booking in = new booking( new Date(), lineItems,Name.getText(),Telephone.getText(),date);
        // load next page
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Booking.fxml"));
        BookingReceipt br = new BookingReceipt(in);
        loader.setController(br);
        Scene scene = new Scene(loader.load());
        Stage popup = new Stage();
        popup.initStyle(StageStyle.TRANSPARENT);
        popup.setScene(scene);
        popup.show();

        // clear menuList
        ListOrder.getItems().clear();
        Name.clear();
        Telephone.clear();
        CustomerNumber.clear();


    }

    @FXML
    void ManageMenuClick(MouseEvent event) {

        Parent root = ManageMenu.getParent().getParent().getParent();

        try {
            BorderPane bp = (BorderPane) root;
            bp.setCenter(FXMLLoader.load(getClass().getResource("ManageMenu.fxml")));
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @FXML
    void orderDessert1click(MouseEvent event) {
        setMenu("croissant",150.00,"Dessert");
    }

    @FXML
    void orderDessert2click(MouseEvent event) {
        setMenu("Panna Cotta Syrup", 300.00,"Dessert");
    }

    @FXML
    void orderDessert3(MouseEvent event) {
        setMenu("Pancake with Salad", 100.00,"Dessert");
    }

    @FXML
    void orderMain1click(MouseEvent event) {
        setMenu("Fish with Sauce",200.00,"Main");
    }

    @FXML
    void orderMain2click(MouseEvent event) {
        setMenu("Mashed Potato", 150.00,"Main");
    }

    @FXML
    void orderMain3click(MouseEvent event) {
        setMenu("Scallop Roll", 250.00 ,"Main");
    }

    @FXML
    void orderWater1click(MouseEvent event) {
        setMenu("Refill Soft Drink", 49.00,"Drink");
    }

    @FXML
    void orderWater2click(MouseEvent event) {
        setMenu("WHISKEY SOUR",139.00,"Drink");
    }

    @FXML
    void orderWater3click(MouseEvent event) {
        setMenu("BLUE MARGARITA",169.00, "Drink");
    }

    private void updateSubtotal(){
        ObservableList<HBox> list = ListOrder.getItems();
        subTotalValue = 0;
        for (HBox item : list){
            LineItemControl ln = (LineItemControl) item;
            double price = Double.parseDouble(((Label) item.getChildren().get(1)).getText());
            int amount = ((Spinner<Integer>) item.getChildren().get(2)).getValue();
            if(ln.getType().equalsIgnoreCase("Dessert")){
                subTotalValue += (price-(price*0.1))*amount;
            }else{
                subTotalValue += price*amount;
            }
        }

        subTotal.setText(String.valueOf(subTotalValue));
    }

    public void setMenu(String Name, Double price, String type){

        ObservableList<HBox> items =  ListOrder.getItems();
        for(HBox item : items){
            LineItemControl ln = (LineItemControl) item;
            if (item.getChildren().get(0).toString().contains(Name)) {
                items.remove(item);
                updateSubtotal();
                System.out.println(ln.getType());
                return ;
            }
        }
        LineItemControl lc = new LineItemControl();
        lc.setNameItem(Name);
        lc.setCostItem(price);
        Spinner<Integer> quantity = lc.getQuantityItem();
        quantity.valueProperty().addListener((observableValue, oldValue, newValue) -> {
            subTotalValue += (newValue - oldValue) * price;
            subTotal.setText(String.valueOf(subTotalValue));
        });
        lc.setType(type);
        ListOrder.getItems().add(lc);

        updateSubtotal();
    }
}


