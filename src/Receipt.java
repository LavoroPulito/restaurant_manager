import java.util.ArrayList;

// TODO aggiustare la grafica che così fa proprio cacare

public class Receipt {
    private int table;
    private double total;
    private double amount;
    private String reciptText;
    private ArrayList<Order> orders;
    private final double IVA = 10;
    private static int stringLenght = 40;
    private final String DIRECTORY = "Receipts";
    //                     H--------------------------------------H
    private String title = "             Pippo Pizza              ";

    public Receipt() {
        total = 0;
        orders = new ArrayList<>();
        reciptText = "";
        amount = 0;

    }

    public void addOrders(ArrayList<Order> orders) {
        this.orders.addAll(orders);
        table = orders.get(0).getTable();
        for (Order order : orders) {
            total += order.getDishPrice();
        }
    }

    public void enterAmount(double amount) {
        this.amount = amount;
    }

    public double giveChange() {
        return amount - total;
    }

    public void writeEndRecipit() {
        if (amount > 0) {
            reciptText += "\n";
            reciptText += "PAGATO: " + amount + "€\n";
            reciptText += "resto: " + (giveChange()) + "€\n";
            reciptText += "\nARIVEDERCI";
        }

    }

    public void writeRecipt() {
        for (Order o : orders) {
            String price = "" + o.getDishPrice();
            String name = o.getDishName();
            reciptText += name + " ".repeat(stringLenght - price.length() - name.length()) + price + '\n';
        }
        reciptText += "\nTOTALE: " + total + "€  di cui iva: " + total * IVA / 100 + "€";

    }

    public String getReciptText() {
        return reciptText;
    }
}
