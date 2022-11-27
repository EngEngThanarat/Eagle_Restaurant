package main.Code;

import java.util.UUID;

public abstract class Menu {
    private  int ID;
    private Double price;

    private String Name;

    double Discount = 0.0;


    public Menu(String name, double price) {
        this.price = price;
        this.Name = name;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }



    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    public double getDiscount() {
        return Discount;
    }

    abstract public void setDiscount();

}
