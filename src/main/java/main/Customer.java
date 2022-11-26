package main;

import java.util.Date;
import java.util.UUID;
public class Customer {
private int Telephone;
private String name;
private Reservation reservation;

    public int getTelephone() {
        return Telephone;
    }

    public void setTelephone(int telephone) {
        Telephone = telephone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    public Customer(int telephone, String name) {
        Telephone = telephone;
        this.name = name;


    }
    // Customer create a reservation
    public boolean createReservation(Table table, Date reserveDate, String waterType){

        // Check reservation date must more than three days
        if(Math.abs(reserveDate.getTime() - new Date().getTime()) > 3*24*60*60*1000){
            if (table.isAvailable()){
                this.reservation = new Reservation( this, table, reserveDate, waterType);
                table.setAvailable(false);
                // Eng Add To GUI
                return true;
            }else {
                System.out.println("Table is not available");
                // Eng Add To GUI
                return false;
            }
        }else {
            System.out.println("Reservation date must more than three days");
            // Eng Add To GUI
            return false;
        }


    }

    // Customer cancel a reservation
    public void cancelReservation(){
        this.reservation = null;
    }

    // Customer order a menu
    public void orderMenu(Menu[] menu){
        this.reservation.orderMenu(menu);
    }

    // Customer check in
    public void checkIn(){
        this.reservation.checkIn();
    }

    // Customer print the reservation
    public void printReservation(){
        // Statement
    }

    // Customer print the bill
    public void printBill(){
        // Statement
    }
   // customer print recipe
    public Recipe printRecipe(){
        // calculate total price
        int totalPrice = 0;
        for (Menu menu : this.reservation.getMenu()) {
            switch (menu.getClass().getSimpleName()){
                case "Dessert":
                    totalPrice += ((Dessert) menu).getPrice()-((Dessert) menu).getPrice()*((Dessert) menu).getDiscount();
                    break;
                case "water":
                    if (this.reservation.getWaterType().equals("refill")){
                        totalPrice += 35;
                    }else {
                        totalPrice += ((water) menu).getPrice();
                    }
                    break;
                case "MainDish":
                    totalPrice += ((MeatDish) menu).getPrice()-((MeatDish) menu).getPrice()*((MeatDish) menu).getDiscount();
                    break;
                default:
                    totalPrice += menu.getPrice();
                    break;
            }
        }
        Recipe recipe = new Recipe(UUID.randomUUID().hashCode(),this.reservation,totalPrice,new Date());
        recipe.printRecipe();
        this.reservation.getTable().setAvailable(true);
        return recipe;
        // Eng Add To GUI
    }


}
