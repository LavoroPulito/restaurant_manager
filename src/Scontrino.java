import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.HashMap;
import java.io.*;

public class Scontrino

{
    OrderManager ordermanager = new OrderManager();
    

    private HashMap<Integer, ArrayList<Order>> register;
        //tavolo:[ordini del tavolo], tavolo1:[ordini del tavolo1]
    public Scontrino()
    {

    }



    public String preconto(int numerotavolo)
      {
          ordermanager.load();
          register=ordermanager.getRegister();

          HashMap<Integer, ArrayList<Order>> reg = ordermanager.getRegister();
          System.out.print(reg);
          
          String preconto = "";
          
        if (register.containsKey(numerotavolo))
        {
            for (Order ordine : register.get(numerotavolo))
            {
                preconto += "";
            }
        }
        else
        {

        }





String stringadelcazzo = " ";
return stringadelcazzo;
    


}

    //add(ArrayList<Order> orders); SE VA IN ERRORE VA COMMENTATO dio porco


}




/*
prendo dalla lista con un for, prendo il nome dello piatto, e prendo il costo
a capo,

*/
