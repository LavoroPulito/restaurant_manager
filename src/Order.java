public class Order {
    private String dishName;
    private double dishPrice;
    private String category;
    private int table;
    private String note;
    
    public Order(Dish dish, int table, String note){
        this.dishName = dish.getName();
        this.dishPrice = dish.getPrice();
        this.category = dish.getCategory();
        this.table = table;
        this.note = note;
    }

    public double getDishPrice() {
        return dishPrice;
    }

    public int getTable() {
        return table;
    }

    public String getDishName() {
        return dishName;
    }

    public String getNote() {
        return note;
    }

    public String getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return "Order{" +
                "dishName='" + dishName + '\'' +
                ", table=" + table +
                ", note='" + note + '\'' +
                '}';
    }
}
