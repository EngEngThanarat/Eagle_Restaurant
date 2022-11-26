package main.Code;

import main.Controllers.Reservation;

import java.util.Date;

public class Recipe {
private  int ReceiveID;
private Reservation reservation;
private  int totalPrice;
private Date Receive_Date;



    public int getReceive() {
        return ReceiveID;
    }

    public void setReceive(int receive) {
        ReceiveID = receive;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Date getReceive_Date() {
        return Receive_Date;
    }

    public void setReceive_Date(Date receive_Date) {
        this.Receive_Date = receive_Date;
    }

    public Recipe(int receive, Reservation reservation, int totalPrice, Date receive_Date) {
        ReceiveID = receive;
        this.reservation = reservation;
        this.totalPrice = totalPrice;
        this.Receive_Date = receive_Date;
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "ReceiveID=" + ReceiveID +
                ", reservation=" + reservation +
                ", totalPrice=" + totalPrice +
                ", Receive_Date=" + Receive_Date +
                '}';
    }

    public void printRecipe() {
        System.out.println("Recipe{" +
                "ReceiveID=" + ReceiveID +
                ", reservation=" + reservation +
                ", totalPrice=" + totalPrice +
                ", Receive_Date=" + Receive_Date +
                '}');
    }
}
