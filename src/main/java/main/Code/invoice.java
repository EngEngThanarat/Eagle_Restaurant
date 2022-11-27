package main.Code;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class invoice {
    private String invoiceID;
    private Date date;
    private double subTotal;

    public invoice (Date date) {
        this.date = date;
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

    public invoice(String invoiceID, Date date, double subTotal) {
        this.invoiceID = invoiceID;
        this.date = date;

    }
    public String getDateWithFormat() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        return formatter.format(date);
    }



}
