
import java.util.ArrayList;
import java.util.HashMap;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Bill {
    OrderManager ordermanager = new OrderManager();
    int tableInt;
    int spaceint = 35;
    int iva = 10;
    //iva del 10% nei ristoranti 
    private String titolo;


    private HashMap<Integer, ArrayList<Order>> register;

    //Data
    LocalDate data = LocalDate.now();
    DateTimeFormatter x = DateTimeFormatter.ofPattern("dd_MMMM_yyyy");
    // data.format(x);

    //hour
    LocalTime hour = LocalTime.now();
    DateTimeFormatter y = DateTimeFormatter.ofPattern("kk:mm");
    // hour.format(y);


    public Bill() {

    }

    public String getBill(double money) {
        String bill = "";
        int change = 0;

        if (register.containsKey(tableInt)) {
            double costo = 0;
            bill += "scontrino tavolo " + tableInt + "\n" +
                    "giorno " + data.format(x) + " " + "ora" + " " + hour.format(y) + "\n";

            bill += "\nOrdini"+"                              "+"Iva\t\t Prezzo\n";

            bill += "---------------------------------------------\n";


            for (Order order : register.get(tableInt)) {

                String layout = "";
                String space = "";
                layout += order.getDishName(); 
                int difference = spaceint - layout.length();
                for (int o = 0;o <=difference; o++ )
                {
                    space+= " ";
                }
                bill += order.getDishName() + space +(order.getDishPrice())/10+"€\t "+ order.getDishPrice() + "€ \n";
                costo += order.getDishPrice();


                bill += "";
                layout ="";
                space = "";
            }
            bill += "-------------------------------------------------------\n";
            bill += "totale complessivo: \t " + costo + "€" + "\n" + "di cui iva \t" + costo / iva + "€" + "\n";
            bill += "totale pagato; \t " + money + "€" + "\n";
            if (money > costo) {
                change += money - costo;
            }
            bill += "change: \t" + change + "€";
        }

        //creazione File
        titolo = "receiptTab" + tableInt + "_" + data.format(x) + "_" + hour.format(y);
        String path = "Scontrini";
        File Dir = new File(path);

        if (!Dir.exists()) {
            Dir.mkdir();
        }
        try {
            FileWriter writer = new FileWriter(path + "//" + titolo+ ".txt");
            writer.write(bill);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(bill);
        return bill;

    }


    public String preConto(int tableInt) {
        this.tableInt = tableInt;

        ordermanager.load();

        register = ordermanager.getRegister();


        String preconto = "";

        if (register.containsKey(tableInt)) {
            double costo = 0;
            preconto += "Importo da pagare del tavolo " + tableInt + "\n" +
                    "giorno " + data.format(x) + " " + "ora" + " " + hour.format(y) + "\n";
            preconto += "\nOrdini"+"                              "+"Iva\t\t Prezzo\n";
             
            preconto += "---------------------------------------------\n";


            for (Order order : register.get(tableInt)) {

                String layout = "";
                String space = "";
                layout += order.getDishName(); 
                int difference = spaceint - layout.length();
                for (int o = 0;o <=difference; o++ )
                {
                    space+= " ";
                }
                preconto += order.getDishName() + space +(order.getDishPrice())/10+"€\t "+ order.getDishPrice() + "€ \n";
                costo += order.getDishPrice();

                preconto += "";
                layout ="";
                space = "";
            }
            preconto += "-------------------------------------------------------\n";
            preconto += "totale da pagare: \t" + costo + "€";
        } else {

        }
        System.out.println(preconto);
        return preconto;
    }


}



