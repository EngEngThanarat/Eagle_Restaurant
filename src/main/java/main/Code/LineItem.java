package main.Code;

public class LineItem {
    private String menu;
    private int quantity;
    private int price;
    private int subtotal;

    public LineItem(String menu, int quantity, double price) {
        this.menu = menu;
        this.quantity = quantity;
        this.price = (int) price;
        this.subtotal = (int) (price * quantity);
    }

    public String getMenu () {
        return menu;
    }

    public void setMenu (String menu) {
        this.menu = menu;
    }

    public int getQuantity () {
        return quantity;
    }

    public void setQuantity (int quantity) {
        this.quantity = quantity;
    }

    public double getPrice () {
        return price;
    }

    public void setPrice (int price) {
        this.price = price;
    }

    public int getSubtotal () {
        return subtotal;
    }

    public void setSubtotal (int total) {
        this.subtotal = total;
    }
}
