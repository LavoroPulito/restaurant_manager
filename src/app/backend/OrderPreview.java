package app.backend;

/**
 * this class extends the Order class by adding the quantity attribute to be able to count the same orders
 * @author Armando Coppola
 * @author Niccolò Di Santo
 * @author Francesco Daprile
 * @version 1.0
 *
 */
public class OrderPreview extends Order {
    /**
     * the quantity of the order
     */
    private int quantity;

    /**
     * creates a new OrderPreview using the parameters provided and set the quantity to 1
     *
     * @param dish name of the dish
     * @param table table of order
     * @param note note of order
     */
    public OrderPreview(Dish dish, int table, String note) {
        super(dish, table, note);
        quantity = 1;
    }

    /**
     * sets the quantity to the supplied value
     *
     * @param quantity new quantity
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * increases the quantity by one unit
     */
    public void increment() {
        this.quantity += 1;
    }

    /**
     * returns a new order created using the attributes of this order preview
     *
     * @return new Order
     */
    public Order toOrder() {
        return new Order(super.getDishName(), super.getDishPrice(), super.getTable(), super.getNote());
    }

    /**
     * decreases the quantity by one unit
     */
    public void decrement() {
        this.quantity -= 1;
    }

    /**
     * returns the quantity of this OrderPreview
     *
     * @return quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * returns the String that represent this OrderPreview
     *
     * @return format "DishName #quantity :Note" of this OrderPreview
     */
    @Override
    public String toString() {
        return super.getDishName() + " #" + quantity + " : " + super.getNote();
    }


}
