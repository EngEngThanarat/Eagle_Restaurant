package main.Code;

public class Dessert extends  Menu{


    public Dessert(String detail, String list, int price, String name) {
        super(detail, list, price, name);
    }

    @Override
    public void setDiscount() {
        this.Discount = 0.1;
    }
}
