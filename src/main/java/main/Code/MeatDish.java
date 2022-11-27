package main.Code;

public class MeatDish extends Menu{

        public MeatDish( String name,double price ) {
            super( name,price);
        }

        @Override
        public void setDiscount() {
            this.Discount = 0.0;
        }
}
