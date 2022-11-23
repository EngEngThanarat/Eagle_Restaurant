
import java.util.Date;
import java.util.UUID;

public class Reservation {
    private Menu menu[];
    private  Customer customer;
    private  Table table;
    private Date reserveDate;

    private  int ReservationID;
    private  Date checkinDate;

    private String waterType;

    public Menu[] getMenu() {
        return menu;
    }

    public void setMenu(Menu[] menu) {
        this.menu = menu;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Table getTable() {
        return table;
    }

    public void setTable(Table table) {
        this.table = table;
    }

    public Date getReserveDate() {
        return reserveDate;
    }

    public void setReserveDate(Date reserveDate) {
        this.reserveDate = reserveDate;
    }

    public int getReservationID() {
        return ReservationID;
    }

    public void setReservationID(int reservation) {
        ReservationID = reservation;
    }

    public Date getCheckinDate() {
        return checkinDate;
    }

    public void setCheckinDate(Date checkinDate) {
        this.checkinDate = checkinDate;
    }


    public Reservation(Customer customer, Table table, Date reserveDate, String waterType) {
        this.customer = customer;
        this.table = table;
        this.reserveDate = reserveDate;
        this.waterType = waterType;
        this.ReservationID = UUID.randomUUID().hashCode();
        this.waterType = waterType;
    }

    public void orderMenu(Menu[] menu) {
        this.menu = menu;
    }

    public void checkIn() {
        this.checkinDate = new Date();
    }

    public String getWaterType() {
        return waterType;
    }

    public void setWaterType(String waterType) {
        this.waterType = waterType;
    }
}
