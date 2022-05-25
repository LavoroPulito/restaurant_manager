import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.HashMap;
import java.io.*;

public class Scontrino extends OrderManager
{
    private HashMap<Integer, ArrayList<Order>> preconto;
        //tavolo:[ordini del tavolo], tavolo1:[ordini del tavolo1]
    public Scontrino()
    {
        
    }

    //add(ArrayList<Order> orders); SE VA IN ERRORE VA COMMENTATO




    
    
    
    

        
        public static  String getJSONFromFile (String filename) {
            String jsonText = "";
            try{
            BufferedReader bufferedReader =  new BufferedReader (new FileReader (filename));
            String line;
            while ((line = bufferedReader. readLine() ) != null)
            {
            jsonText += line + "\n";
            }
            bufferedReader.close();
        
            }catch (Exception e)
            {
            e.printStackTrace () ;
            }
            System.out.println(jsonText);
            return jsonText;
        }
    
}
    
            

        

    

        
    
    
    

    /*public boolean pagato()
    {

        if (pagato == true)
        {
            return true ;
            //facciamo in modo che la classe OrderRegister ripuliusca il tavolo
        }
        else
        {
            System.out.println("pagamento non riuscito");
         return false ;
        }
    }

*/

/*
prendo dalla lista con un for, prendo il nome dello piatto, e prendo il costo
a capo, 

*/
