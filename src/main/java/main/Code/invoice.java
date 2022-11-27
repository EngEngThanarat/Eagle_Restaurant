package main.Code;

import main.Sql.DB_Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class invoice {
    private String invoiceID;
    private Date date;
    private double subTotal;

    public invoice (Date date) {
        this.date = date;
        invoiceID = getIdFromDatabase();
    }

    public String getInvoiceID() {
        return invoiceID;
    }

    public void setInvoiceID(String invoiceID) {
        this.invoiceID = invoiceID;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subtotal) {
        this.subTotal = subTotal;
    }

    public String getDateWithFormat() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        return formatter.format(date);
    }

    private String getIdFromDatabase() {
        int lastId = 0;
        String sql = "SELECT Bill_id FROM receive ORDER BY Bill_id DESC LIMIT 1";
        try {
            ResultSet rs = new DB_Connection().getResultSet(sql);
            if(rs.next()){
                lastId = rs.getInt("Bill_id");
            }else {
                lastId = 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            lastId = -1;
        }
        if (lastId == -1) {
            return null;
        }
        lastId++;
        return String.format("%05d", lastId);
    }

}
