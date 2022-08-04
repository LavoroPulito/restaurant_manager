import java.util.Objects;

public class Order {
    private String dishName;
    private double dishPrice;
    private int state;
    private int table;
    private String note;
    private static String[] states = {"preparation", "ready", "delivered"};

    public Order(Dish dish, int table, String note) {
        this.dishName = dish.getName();
        this.dishPrice = dish.getPrice();
        this.table = table;
        this.note = note;
        state = 0;
    }

    public Order(String dishName, double dishPrice, int table, String note) {
        this.dishName = dishName;
        this.dishPrice = dishPrice;
        this.table = table;
        this.note = note;
        state = 0;
    }

    public double getDishPrice() {
        return dishPrice;
    }

    public int getTable() {
        return table;
    }

    public void setState(int state) {
        this.state = state;
    }

    //imposta automaticamente il prossimo stato, dopo l'ultimo stato ricomincia da capo
    public void setNextState() {
        int nextState = state + 1;
        if (nextState < states.length) {
            setState(state + 1);
        } else {
            state = 0;
        }

    }

    public String getDishName() {
        return dishName;
    }

    public String getNote() {
        return note;
    }

    public String getState() {
        return states[this.state];
    }

    @Override
    public String toString() {
        return table+", "+dishName+": "+note;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return state == order.state && table == order.table && Objects.equals(dishName, order.dishName) && Objects.equals(note, order.note);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dishName, state, table, note);
    }
}
