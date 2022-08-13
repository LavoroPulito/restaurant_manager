import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
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
    private String path;


    //Data
    LocalDate data = LocalDate.now();
    DateTimeFormatter x = DateTimeFormatter.ofPattern("dd_MMMM_yyyy");
    // data.format(x);

    //Ora
    LocalTime time = LocalTime.now();
    DateTimeFormatter y = DateTimeFormatter.ofPattern("kk:mm");
    //                     H--------------------------------------H
    private String title = "             Pippo Pizza              ";

    public Receipt() {
        total = 0;
        orders = new ArrayList<>();
        reciptText = title;
        amount = 0;
        path = "Receipts";


    }

    public void addOrders(ArrayList<Order> orders) {
        this.orders.addAll(orders);
        table = orders.get(0).getTable();
        reciptText+= "\nTab "+table+"\n";
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

    public void writeRecipt() {

        for (Order o : orders) {
            String price = "" + o.getDishPrice();
            String name = o.getDishName();
            reciptText += name + " ".repeat(stringLenght - price.length() - name.length()) + price + '\n';
        }
        reciptText += "\nTOTALE: " + total + "€  di cui iva: " + total * IVA / 100 + "€";

    }
    public void writeEndRecipit() {
        if (amount > 0) {
            reciptText += "\n";
            reciptText += "PAGATO: " + amount + "€\n";
            reciptText += "resto: " + (giveChange()) + "€\n";
            reciptText += "date: "+ data.format(x)+"_"+time.format(y);
            reciptText += "\nARIVEDERCI";
        }

    }
    public String getReciptText() {
        return reciptText;
    }

    public void save(){
        String filename = "receiptTab" + table + "_" + data.format(x) + "_" + time.format(y);
        File Dir = new File(path);

        if (!Dir.exists()) {
            Dir.mkdir();
        }
        try {
            FileWriter writer = new FileWriter(path + "//" + filename+ ".txt");
            writer.write(reciptText);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
