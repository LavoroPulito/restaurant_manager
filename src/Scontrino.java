//import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.HashMap;
import java.io.*;

public class Scontrino 
{
    public Scontrino(){
    String testo = " ";
    getJSONFromFile("orders.json");
    System.out.println("orders.json".getClass());
    for(int i = 0; i<= "orders.json".length();i++)
    {
////
    }
    
    
    
    
    
    
    }
        
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
