import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

// TODO aggiustare la grafica che così fa proprio cacare

public class Receipt {
    private int table;
    private double total;
    private double amount;
    private String reciptText;
    private ArrayList<Order> orders;
    private final double IVA = 10;
    private static int stringLenght = 40;
    private String receiptsPath;
    private String titlePath;

    //Data
    LocalDate data = LocalDate.now();
    DateTimeFormatter x = DateTimeFormatter.ofPattern("dd_MMMM_yyyy");
    // data.format(x);

    //Ora
    LocalTime time = LocalTime.now();
    DateTimeFormatter y = DateTimeFormatter.ofPattern("kk:mm");
    private String title;

    public Receipt() {
        total = 0;
        orders = new ArrayList<>();
        amount = 0;
        receiptsPath = "Receipts";
        titlePath = "title.txt";
        loadTitle();
        reciptText = title;

    }

    public void setTitle(String title) {
        try {
            File file = new File(titlePath);
            FileWriter fw = new FileWriter(file);
            String[] lines = title.split("/n");
            for (String line: lines){
                System.out.println(line);
                fw.write(line+'\n');
            }
            fw.flush();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        loadTitle();
    }


    private void loadTitle() {
        try {
            File file = new File(titlePath);

            title = "";
            Scanner in = new Scanner(file);
            while (in.hasNextLine()) {
                title += in.nextLine()+'\n';

            }

        } catch (IOException e) {
            title = "             Pippo Pizza              ";
        }
    }

    public double getTotal() {
        return total;
    }

    public void addOrders(ArrayList<Order> orders) {
        this.orders.addAll(orders);
        table = orders.get(0).getTable();
        reciptText += "\nTab " + table + "\n";
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
            reciptText += "date: " + data.format(x) + "_" + time.format(y);
            reciptText += "\nARIVEDERCI";
        }

    }

    public String getReciptText() {
        return reciptText;
    }

    public void save() {
        String filename = "receiptTab" + table + "_" + data.format(x) + "_" + time.format(y);
        File Dir = new File(receiptsPath);

        if (!Dir.exists()) {
            Dir.mkdir();
        }
        try {
            FileWriter writer = new FileWriter(receiptsPath + "//" + filename + ".txt");
            writer.write(reciptText);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
