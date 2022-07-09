
public class OrderPreview extends Order {

    private int quantity;

    public OrderPreview(Dish dish, int table, String note) {
        super(dish, table, note);
        quantity = 1;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void increment(){
        this.quantity+=1;
    }
    /*
    public Order toOrder(){
        return new Order(super());
    }
    
     */

    public void decrement(){
        this.quantity-=1;
    }

    public int getQuantity(){
        return quantity;
    }

    @Override
    public String toString() {
        return super.getDishName()+ " #" + quantity +" : " + super.getNote();
    }


}
