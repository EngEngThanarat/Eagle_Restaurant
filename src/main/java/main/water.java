public class water extends  Menu{
    private  String CheckType;

    public water(String detail, String list, int price, String name, String checkType) {
        super(detail, list, price, name);
        CheckType = checkType;
    }


    @Override
    public void setDiscount() {
        this.Discount = 0.0;
    }
}
