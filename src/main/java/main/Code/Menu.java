package main.Code;

import java.util.UUID;

public abstract class Menu {
    private  int ID;
    private  String Detail;
    private  String List;
    private int price;

    private String Name;


    double Discount = 0.0;


    public Menu(String detail, String list, int price, String name) {
        this.ID = UUID.randomUUID().hashCode();
        Detail = detail;
        List = list;
        this.price = price;
        Name = name;
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

    public String getDetail() {
        return Detail;
    }

    public void setDetail(String detail) {
        Detail = detail;
    }

    public String getList() {
        return List;
    }

    public void setList(String list) {
        List = list;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }


    public double getDiscount() {
        return Discount;
    }

    abstract public void setDiscount();

}
