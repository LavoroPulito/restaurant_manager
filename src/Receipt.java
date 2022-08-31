import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

// TODO aggiustare la grafica che così fa proprio cacare

/**
 * This class creates and manages a receipt
 * @author Armando Coppola
 * @author Niccolò Di Santo
 * @author Francesco Daprile
 * @version 1.0
 *
 */
public class Receipt {
    /**
     * the table where the products were consumed
     */
    private int table;

    /**
     * total sum of the products in the receipt
     */
    private double total;

    /**
     * the amount received by the customer
     */
    private double amount;

    /**
     * the text that is print on the receipt
     */
    private String receiptText;

    /**
     * the list of orders
     */
    private ArrayList<Order> orders;

    /**
     * iva calculated on each product
     */
    private final double IVA = 10;

    /**
     * the predefinite string to use in casse the title file doesn't exist
     */
    private final String predefiniteTitle =  "             Pippo Pizza              ";

    /**
     * length of each line, i.e. the width of the receipt text
     */
    private static int stringLenght = 32;

    /**
     * title of the receipt containing the merchant's data
     */
    private String title;

    /**
     * directory where receipts are saved
     */
    private String receiptsPath;

    /**
     * directory where the title of the receipt is read and written
     */
    private String titlePath;

    /**
     * receipt data and format
     */
    private LocalDate data = LocalDate.now();
    private DateTimeFormatter x = DateTimeFormatter.ofPattern("dd_MMMM_yyyy");

    /**
     * receipt time and format
     */
    private LocalTime time = LocalTime.now();
    private DateTimeFormatter y = DateTimeFormatter.ofPattern("kk:mm");

    /**
     * create an empty receipt by initializing
     * date, time, total, order list, amount, receiptsPath, titlePath, receipt Text
     * and upload the title.
     */
    public Receipt() {
        total = 0;
        orders = new ArrayList<>();
        amount = 0;
        receiptsPath = "Receipts";
        titlePath = "title.txt";
        loadTitle();
        receiptText = title;

    }

    /**
     * write the new title in the file and reload it
     * @param title
     */
    public void setTitle(@NotNull String title) {
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

    /**
     * load the title from the file, if it does not exist, set the title with a predefined string
     */
    private void loadTitle() {
        try {
            File file = new File(titlePath);

            title = "";
            Scanner in = new Scanner(file);
            while (in.hasNextLine()) {
                title += in.nextLine()+'\n';

            }

        } catch (IOException e) {
            title = predefiniteTitle;
        }
    }

    /**
     * return total
     * @return total
     */
    public double getTotal() {
        return total;
    }

    /**
     * adds a list of orders to the receipt
     * @param orders
     */
    public void addOrders(ArrayList<Order> orders) {
        this.orders.addAll(orders);
        table = orders.get(0).getTable();
        receiptText += "\nTab " + table + "\n";
        for (Order order : orders) {
            total += order.getDishPrice();
        }
    }

    /**
     * set the amount received by the customer
     * @param amount
     */
    public void enterAmount(double amount) {
        this.amount = amount;
    }

    /**
     * return the difference between amount and total
     * @return change
     *
     */
    public double giveChange() {
        return amount - total;
    }

    /**
     * write on receiptText the name of the products with the price on the right
     * at the end add the total on receiptText
     */
    public void writeRecipt() {

        for (Order o : orders) {
            String price = "" + o.getDishPrice();
            String name = o.getDishName();
            receiptText += name + " ".repeat(stringLenght - price.length() - name.length()) + price + '\n';
        }
        receiptText += "\nTOTALE: " + total + "€  di cui iva: " + total * IVA / 100 + "€";

    }

    /**
     * write the end of Receipt with the amount, the change and the date
     */
    public void writeEndReceipt() {
        if (amount > 0) {
            receiptText += "\n";
            receiptText += "PAGATO: " + amount + "€\n";
            receiptText += "resto: " + (giveChange()) + "€\n";
            receiptText += "date: " + data.format(x) + "_" + time.format(y);
            receiptText += "\nARIVEDERCI";
        }

    }

    /**
     * return a String with the text of the receipt
     * @return receiptText
     */
    public String getReciptText() {
        return receiptText;
    }

    /**
     * save the receipt in a text file in the directory path
     */
    public void save() {
        String filename = "receiptTab" + table + "_" + data.format(x) + "_" + time.format(y);
        File Dir = new File(receiptsPath);

        if (!Dir.exists()) {
            Dir.mkdir();
        }
        try {
            FileWriter writer = new FileWriter(receiptsPath + "//" + filename + ".txt");
            writer.write(receiptText);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
