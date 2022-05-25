import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.HashMap;
import java.io.*;

public class Scontrino 

{
    OrderManager ordermanager = new OrderManager();

    private HashMap<Integer, ArrayList<Order>> register;
        //tavolo:[ordini del tavolo], tavolo1:[ordini del tavolo1]
    public Scontrino(double amount)
    {
        ordermanager.load();
        ordermanager.getRegister();
        System.out.println(register);
        for (int i = 0; i< register.length(); )


        

        



        
    }
    public String Preconto()
    {
        
    }

    

    //add(ArrayList<Order> orders); SE VA IN ERRORE VA COMMENTATO
  
}
  


/*
prendo dalla lista con un for, prendo il nome dello piatto, e prendo il costo
a capo, 

*/
