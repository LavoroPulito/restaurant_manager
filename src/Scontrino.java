import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashMap;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Scontrino {
    OrderManager ordermanager = new OrderManager();
    int numerotavolo;
    int spaceint = 35;
    int iva = 10;
    //iva del 10% nei ristoranti 
    private String titolo;


    private HashMap<Integer, ArrayList<Order>> register;

    //Data
    LocalDate data = LocalDate.now();
    DateTimeFormatter x = DateTimeFormatter.ofPattern("dd_MMMM_yyyy");
    // data.format(x);

    //Ora
    LocalTime ora = LocalTime.now();
    DateTimeFormatter y = DateTimeFormatter.ofPattern("kk:mm");
    // ora.format(y);


    public Scontrino() {

    }

    public String getScontrino(double soldi) {
        String scontrino = "";
        int resto = 0;

        if (register.containsKey(numerotavolo)) {
            double costo = 0;
            scontrino += "Scontrino tavolo " + numerotavolo + "\n" +
                    "giorno " + data.format(x) + " " + "ora" + " " + ora.format(y) + "\n";

            scontrino += "\nOrdini"+"                              "+"Iva\t\t Prezzo\n";

            scontrino += "---------------------------------------------\n";


            for (Order ordine : register.get(numerotavolo)) {

                String layout = "";
                String space = "";
                layout += ordine.getDishName(); 
                int difference = spaceint - layout.length();
                for (int o = 0;o <=difference; o++ )
                {
                    space+= " ";
                }
                scontrino += ordine.getDishName() + space +(ordine.getDishPrice())/10+"€\t "+ ordine.getDishPrice() + "€ \n";
                costo += ordine.getDishPrice();


                scontrino += "";
                layout ="";
                space = "";
            }
            scontrino += "-------------------------------------------------------\n";
            scontrino += "totale complessivo: \t " + costo + "€" + "\n" + "di cui iva \t" + costo / iva + "€" + "\n";
            scontrino += "totale pagato; \t " + soldi + "€" + "\n";
            if (soldi > costo) {
                resto += soldi - costo;
            }
            scontrino += "resto: \t" + resto + "€";
        }

        //creazione File
        titolo = "receiptTab" + numerotavolo + "_" + data.format(x) + "_" + ora.format(y);
        String path = "Scontrini";
        File Dir = new File(path);

        if (!Dir.exists()) {
            Dir.mkdir();
        }
        try {
            FileWriter writer = new FileWriter(path + "//" + titolo+ ".txt");
            writer.write(scontrino);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(scontrino);
        return scontrino;

    }


    public String preConto(int numerotavolo) {
        this.numerotavolo = numerotavolo;

        ordermanager.load();

        register = ordermanager.getRegister();


        String preconto = "";

        if (register.containsKey(numerotavolo)) {
            double costo = 0;
            preconto += "Importo da pagare del tavolo " + numerotavolo + "\n" +
                    "giorno " + data.format(x) + " " + "ora" + " " + ora.format(y) + "\n";
            preconto += "\nOrdini"+"                              "+"Iva\t\t Prezzo\n";
             
            preconto += "---------------------------------------------\n";


            for (Order ordine : register.get(numerotavolo)) {

                String layout = "";
                String space = "";
                layout += ordine.getDishName(); 
                int difference = spaceint - layout.length();
                for (int o = 0;o <=difference; o++ )
                {
                    space+= " ";
                }
                preconto += ordine.getDishName() + space +(ordine.getDishPrice())/10+"€\t "+ ordine.getDishPrice() + "€ \n";
                costo += ordine.getDishPrice();

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



