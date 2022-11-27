package main.Code;

public class water extends  Menu{
    private  String CheckType;

    public water( String name,double price ) {
        super( name,price);
    }


    @Override
    public void setDiscount() {
        this.Discount = 0.0;
    }
}
