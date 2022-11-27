package main.Code;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class booking extends invoice {

    private String customer_name;
    private LocalDate date;
    private  String telephone;
    private LineItem item[];

    public booking(Date date, LineItem item[], String customer_name, String telephone, LocalDate Date){
        super(date);
        this.item = item;
        this.customer_name = customer_name;
        this.telephone = telephone;
        this.date = Date;
        double subTotal = 0;
        for (int i = 0; i < item.length; i++) {
            subTotal += item[i].getSubtotal();
        }

        setSubTotal(subTotal);
    }

    public LineItem[] getItem() {
        return item;
    }

    public void setItem(LineItem[] item) {
        this.item = item;
    }

    public String getCustomerName(){
        return this.customer_name;
    }

    public String getTelephone() {
        return telephone;
    }

    public LocalDate getDate(){
        return date;
    }
}




