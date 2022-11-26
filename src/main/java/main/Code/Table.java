package main.Code;

public class Table {
    private int tableID;
    private boolean tableStatus;
    private int MaxCapacity;

    public int getTableID() {
        return tableID;
    }

    public void setTableID(int tableID) {
        this.tableID = tableID;
    }

    public boolean isTableStatus() {
        return tableStatus;
    }

    public void setTableStatus(boolean tableStatus) {
        this.tableStatus = tableStatus;
    }

    public int getMaxCapacity() {
        return MaxCapacity;
    }

    public void setMaxCapacity(int maxCapacity) {
        MaxCapacity = maxCapacity;
    }

    @Override
    public String toString() {
        return "Table{" +
                "tableID=" + tableID +
                ", tableStatus=" + tableStatus +
                ", MaxCapacity=" + MaxCapacity +
                '}';
    }

    public Table(int tableID, boolean tableStatus, int maxCapacity) {
        this.tableID = tableID;
        this.tableStatus = tableStatus;
        MaxCapacity = maxCapacity;
    }

    public boolean isAvailable() {
        return tableStatus;
    }

    public void setAvailable(boolean b) {
        this.tableStatus = b;
    }
}
