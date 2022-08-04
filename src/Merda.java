
import java.util.ArrayList;
import java.util.HashMap;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Merda {
    OrderManager ordermanager = new OrderManager();
    int tablenumber;
    int spaceint = 35;
    int iva = 10;
    //iva del 10% 
    private String title;


    private HashMap<Integer, ArrayList<Order>> register;

    //Data
    LocalDate data = LocalDate.now();
    DateTimeFormatter x = DateTimeFormatter.ofPattern("dd_MMMM_yyyy");
    // data.format(x);

    //Ora
    LocalTime time = LocalTime.now();
    DateTimeFormatter y = DateTimeFormatter.ofPattern("kk:mm");
    // time.format(y);


    public Merda() {

    }

    public String getReceipt(double money) {
        String receipt = "";
        int rest = 0;

        if (register.containsKey(tablenumber)) {
            double cost = 0;
            receipt += "Receipt table " + tablenumber + "\n" +
                    "day " + data.format(x) + " " + "time" + " " + time.format(y) + "\n";

            receipt += "\nOrders"+"                              "+"Vat\t\t Price\n";

            receipt += "---------------------------------------------\n";


            for (Order ordine : register.get(tablenumber)) {

                String layout = "";
                String space = "";
                layout += ordine.getDishName(); 
                int difference = spaceint - layout.length();
                for (int o = 0;o <=difference; o++ )
                {
                    space+= " ";
                }
                receipt += ordine.getDishName() + space +(ordine.getDishPrice())/10+"€\t "+ ordine.getDishPrice() + "€ \n";
                cost += ordine.getDishPrice();


                receipt += "";
                layout ="";
                space = "";
            }
            receipt += "-------------------------------------------------------\n";
            receipt += "complessive total: \t " + cost + "€" + "\n" + "of which VAT \t" + cost / iva + "€" + "\n";
            receipt += "total paid; \t " + money + "€" + "\n";
            if (money > cost) {
                rest += money - cost;
            }
            receipt += "rest: \t" + rest + "€";
        }

        //creazione File
        title = "receiptTab" + tablenumber + "_" + data.format(x) + "_" + time.format(y);
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
            precount += "Table's amount to pay " + tablenumber + "\n" +
                    "day " + data.format(x) + " " + "time" + " " + time.format(y) + "\n";
            precount += "\nOrders"+"                              "+"Vat\t\t Price\n";
             
            precount += "---------------------------------------------\n";


            for (Order ordine : register.get(tablenumber)) {

                String layout = "";
                String space = "";
                layout += ordine.getDishName(); 
                int difference = spaceint - layout.length();
                for (int o = 0;o <=difference; o++ )
                {
                    space+= " ";
                }
                precount += ordine.getDishName() + space +(ordine.getDishPrice())/10+"€\t "+ ordine.getDishPrice() + "€ \n";
                cost += ordine.getDishPrice();

                precount += "";
                layout ="";
                space = "";
            }
            precount += "-------------------------------------------------------\n";
            precount += "total to pay: \t" + cost + "€";
        } else {

        }
        System.out.println(precount);
        return precount;
    }


}



