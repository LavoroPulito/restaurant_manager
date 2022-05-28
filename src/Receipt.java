import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashMap;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Receipt {
    OrderManager ordermanager = new OrderManager();
    int tablenumber;
    private String title;


    private HashMap<Integer, ArrayList<Order>> register;

    //date
    LocalDate date = LocalDate.now();
    DateTimeFormatter x = DateTimeFormatter.ofPattern("dd_MMMM_yyyy");
    // date.format(x);

    //time
    LocalTime time = LocalTime.now();
    DateTimeFormatter y = DateTimeFormatter.ofPattern("kk:mm");
    // time.format(y);


    public Receipt() {

    }

    public String getReceipt(double money) {
        String receipt = "";
        int rest = 0;

        if (register.containsKey(tablenumber)) {
            double cost = 0;
            receipt += "receipt table " + tablenumber + "\n" +
                    "date " + date.format(x) + " " + "time" + " " + time.format(y) + "\n";
            receipt += "---------------------------------------------\n";


            for (Order order : register.get(tablenumber)) {
                receipt += order.getDishName() + "\t " + order.getDishPrice() + "€ \n";

                cost += order.getDishPrice();

            }
            receipt += "---------------------------------------------\n";
            receipt += "complessive total: \t " + cost + "€" + "\n" + "of which VAT \t" + cost / 10 + "€" + "\n";
            receipt += "total paid; \t " + money + "€" + "\n";
            if (money > cost) {
                rest += money - cost;
            }
            receipt += "rest: \t" + rest + "€";
        }

        //creazione File
        title = "receiptTab" + tablenumber + "_" + date.format(x) + "_" + time.format(y);
        String path = "Receipts";
        File Dir = new File(path);

        if (!Dir.exists()) {
            Dir.mkdir();
        }
        try {
            FileWriter writer = new FileWriter(path + "//" + title+ ".txt");
            writer.write(receipt);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(receipt);
        return receipt;

    }


    public String preCount(int tablenumber) {
        this.tablenumber = tablenumber;

        ordermanager.load();

        register = ordermanager.getRegister();


        String precount = "";

        if (register.containsKey(tablenumber)) {
            double cost = 0;
            precount += "Amount to be paid for the table " + tablenumber + "\n" +
                    "day " + date.format(x) + " " + "time" + " " + time.format(y) + "\n";
            precount += "---------------------------------------------\n";


            for (Order order : register.get(tablenumber)) {

                precount += order.getDishName() + "\t " + order.getDishPrice() + "€ \n";

                cost += order.getDishPrice();

                precount += "";
            }
            precount += "---------------------------------------------\n";
            precount += "total to pay: \t" + cost + "€";
        } else {

        }
        System.out.println(precount);
        return precount;
    }


}



