package main.Code;

import javafx.beans.property.SimpleStringProperty;

public class Report {
    private SimpleStringProperty Date;
    private SimpleStringProperty Name;
    private SimpleStringProperty Total;

    public Report(String Date, String Name, String Total) {
        this.Date = new SimpleStringProperty(Date);
        this.Name = new SimpleStringProperty(Name);
        this.Total = new SimpleStringProperty(Total);
    }

    public String getDate() {
        return Date.get();
    }

    public String getName() {
        return Name.get();
    }

    public String getTotal() {
        return Total.get();
    }

    public void setDate(String Date) {
        this.Date.set(Date);
    }

    public void setName(String Name) {
        this.Name.set(Name);
    }

    public void setTotal(String Total) {
        this.Total.set(Total);
    }

    public SimpleStringProperty DateProperty() {
        return Date;
    }

    public SimpleStringProperty NameProperty() {
        return Name;
    }

    public SimpleStringProperty TotalProperty() {
        return Total;
    }
}
