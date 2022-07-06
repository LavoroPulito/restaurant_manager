import java.util.ArrayList;
import java.util.HashMap;

public class OrderPreviews {
    private ArrayList<Order> orders;
    private HashMap<Order, Integer> quantityOrder;

    public OrderPreviews() {
        quantityOrder = new HashMap<Order, Integer>();
        orders = new ArrayList<>();
    }

    public void addNew(Order order, int n) {
        quantityOrder.put(order, n);
    }

    public void more(Order order) {
        quantityOrder.put(order, quantityOrder.get(order) + 1);
    }

    public void less(Order order) {
        quantityOrder.replace(order, quantityOrder.get(order) - 1);
        if (quantityOrder.get(order) == 0) {
            quantityOrder.remove(order);
        }
    }

    public HashMap<Order, Integer> getQuantityOrder() {
        return quantityOrder;
    }

    public String[] toStringsArray() {
        String[] array = new String[quantityOrder.size()];
        int i = 0;
        for (Order o :
                quantityOrder.keySet()) {
            array[i] = o.getDishName() + " - " + quantityOrder.get(o);
        }
        return array;
    }

    public ArrayList<Order> toArraylist() {

        for (Order order :
                quantityOrder.keySet()) {
            for (int i = 0; i <= quantityOrder.get(order); i++) {
                orders.add(order);
            }
        }
        return orders;
    }

    @Override
    public String toString() {
        return "" + orders + " " + quantityOrder;
    }
}
