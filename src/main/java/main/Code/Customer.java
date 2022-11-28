package main.Code;

import javafx.beans.property.SimpleStringProperty;

public class Customer {
    private SimpleStringProperty name;
    private SimpleStringProperty tel;
    private SimpleStringProperty date;

    public Customer(String name, String tel, String date) {
        this.name = new SimpleStringProperty(name);
        this.tel = new SimpleStringProperty(tel);
        this.date = new SimpleStringProperty(date);
    }

    public String getName() {
        return name.get();
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getTel() {
        return tel.get();
    }

    public void setTel(String tel) {
        this.tel.set(tel);
    }

    public String getDate() {
        return date.get();
    }

    public void setDate(String date) {
        this.date.set(date);
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public SimpleStringProperty telProperty() {
        return tel;
    }

    public SimpleStringProperty dateProperty() {
        return date;
    }
}
