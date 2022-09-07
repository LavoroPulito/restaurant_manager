package app.backend;

import java.util.ArrayList;

/**
 * this class manages an OrderPreview ArrayList to count the same orders, increment or decrement them
 */
public class PreviewsRegister {
    /**
     * the OrderPreview ArrayList
     */
    private ArrayList<OrderPreview> previews;

    /**
     * creates a new empty ArrayList
     */
    public PreviewsRegister() {
        previews = new ArrayList<>();
    }

    /**
     * increases the quantity of the supplied OrderPreview
     *
     * @param orderPreview orderPreview to increase
     */
    public void increment(OrderPreview orderPreview) {
        int i = previews.indexOf(orderPreview);
        previews.get(i).increment();

    }

    /**
     * decreases the quantity of the supplied OrderPreview:
     * if the quantity become 0 the OrderPreview is removed from the list
     *
     * @param orderPreview orderPreview to decrease
     */
    public void decrement(OrderPreview orderPreview) {
        int i = previews.indexOf(orderPreview);
        previews.get(i).decrement();
        if (previews.get(i).getQuantity() == 0) {
            previews.remove(i);
        }
    }

    /**
     * adds a new order to the list, if the order is the same as an existing one, it increases the quantity of the one already present
     *
     * @param orderPreview orderPreview to import
     */
    public void addOrder(OrderPreview orderPreview) {
        if (previews.contains(orderPreview)) {
            increment(orderPreview);
        } else {
            previews.add(orderPreview);
        }
    }

    /**
     * clear the OrderPreview ArrayList
     */
    public void clear() {
        previews.clear();
    }

    /**
     * return the ArrayList that contain all the OrderPreviews
     *
     * @return previews ArrayList
     */
    public ArrayList<OrderPreview> getPreviews() {
        return previews;
    }

    /**
     * returns an Arraylist in which previews are converted to Order. orders repeat based on the quantity of their previews
     *
     * @return Order ArrayList
     */
    public ArrayList<Order> toOrders() {
        ArrayList<Order> orders = new ArrayList<>();
        for (OrderPreview p :
                previews) {
            for (int i = 0; i < p.getQuantity(); i++) {
                orders.add(p.toOrder());
            }
        }
        return orders;
    }
}
