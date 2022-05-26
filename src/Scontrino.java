import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.HashMap;
import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
public class Scontrino

{
    OrderManager ordermanager = new OrderManager();
    int numerotavolo;
    
    
    

    private HashMap<Integer, ArrayList<Order>> register;

    //Data
    LocalDate data = LocalDate.now();
    DateTimeFormatter x = DateTimeFormatter.ofPattern("dd MMMM yyyy, ");
    // data.format(x);

    //Ora
    LocalTime ora = LocalTime.now();
    DateTimeFormatter y = DateTimeFormatter.ofPattern("hh:mm");
    // ora.format(y);



    public Scontrino()
    {

    }

    public String getScontrino(double soldi)
    {
        String scontrino = "";
        int resto = 0;

        if (register.containsKey(numerotavolo))
        {
            double costo = 0;
            scontrino += "Scontrino tavolo "+ numerotavolo + "\n"+ 
                            "giorno " + data.format(x) + " " + "ora" +" " + ora.format(y)+ "\n" ;
            scontrino+= "---------------------------------------------\n";



            for (Order ordine : register.get(numerotavolo))
            {
                scontrino += ordine.getDishName() + "\t " + ordine.getDishPrice() + "€ \n";

                costo +=ordine.getDishPrice();

            }
            scontrino+= "---------------------------------------------\n";
            scontrino += "totale complessivo: \t " + costo + "€"+ "\n" + "di cui iva \t" + costo/10 + "€"+ "\n";
            scontrino += "totale pagato; \t " + soldi+ "€" + "\n";
            if (soldi > costo)
            {
                resto += soldi - costo;
            }
            scontrino += "resto: \t" + resto + "€";
        }
        

        

        System.out.println(scontrino);
        return scontrino;

    }

    


    public String preConto(int numerotavolo)

      {
        this.numerotavolo = numerotavolo;

        ordermanager.load();

          register=ordermanager.getRegister();

          
          
           String preconto = "";
          
        if (register.containsKey(numerotavolo))
        {
            double costo = 0;
            preconto += "Importo da pagare del tavolo "+ numerotavolo + "\n"+ 
                            "giorno " + data.format(x) + " " + "ora" +" " + ora.format(y)+ "\n" ;
            preconto+= "---------------------------------------------\n";



            for (Order ordine : register.get(numerotavolo))
            {

                preconto += ordine.getDishName() + "\t " + ordine.getDishPrice() + "€ \n";

                costo +=ordine.getDishPrice();

                preconto += "";
            }
            preconto+= "---------------------------------------------\n";
            preconto += "totale da pagare: \t" + costo + "€" ;
        }
        else
        {

        }
        System.out.println(preconto);
        return preconto;
        }

    //add(ArrayList<Order> orders); SE VA IN ERRORE VA COMMENTATO dio porco


}




/*
prendo dalla lista con un for, prendo il nome dello piatto, e prendo il costo
a capo,

*/
