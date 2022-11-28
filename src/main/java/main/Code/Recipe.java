package main.Code;

import java.time.LocalDate;
import java.util.Date;

public class Recipe extends invoice {

    private LocalDate date;
    private LineItem item[];

    private double Money;

    private double change;

    public Recipe(Date date, LineItem item[], LocalDate Date, double Total , double Money){
        super(date);
        this.item = item;
        this.date = Date;
        this.Money = Money;

        double subTotal = 0;
        for (int i = 0; i < item.length; i++) {
            subTotal += item[i].getSubtotal();
        }

        setSubTotal(subTotal);
        double c = getMoney();
        change = c - subTotal;
        this.change = change;
    }

    public LineItem[] getItem() {
        return item;
    }

    public void setItem(LineItem[] item) {
        this.item = item;
    }

    public LocalDate getDate(){
        return date;
    }

    public double getMoney(){
        return Money;
    }

    public double getChange(){
        return change;
    }
}