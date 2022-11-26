package main;

public class MeatDish extends Menu{

        public MeatDish(String detail, String list, int price, String name) {
            super(detail, list, price, name);
        }

        @Override
        public void setDiscount() {
            this.Discount = 0.0;
        }
}
