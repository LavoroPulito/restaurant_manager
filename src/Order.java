public class Order {
    private String dishName;
    private double dishPrice;
    private int state;
    private int table;
    private String note;
    private final String[] states = {"in preparazione","pronto","consegnato"};
    
    public Order(Dish dish, int table, String note){
        this.dishName = dish.getName();
        this.dishPrice = dish.getPrice();
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
    public void setNextState(){
        int nextState= state+1;
        if (nextState<states.length){
            setState(state+1);
        }else{
            state=0;
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
        return "Order{" +
                "dishName='" + dishName + '\'' +
                ", table=" + table +
                ", note='" + note + '\'' +
                '}';
    }
}
