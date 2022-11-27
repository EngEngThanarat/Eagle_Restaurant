package main.Code;

public class Dessert extends  Menu{


    public Dessert(String name,double price) {
        super( name,price);
    }

    @Override
    public void setDiscount() {
        this.Discount = 0.1;
    }
}
