import com.google.gson.Gson;

public class Scontrino {
    String preconto = "";
    boolean pagato;
    int numeroTavoli;

    public  Scontrino(){

        
        

    }

    public boolean pagato()
    {

        if (pagato == true)
        {
            return true ;
            //facciamo in modo che la classe OrderManager ripuliusca il tavolo
        }
        else
        {
            System.out.println("pagamento non riuscito");
         return false ;
        }
    }


}
/*
prendo dalla lista con un for, prendo il nome del piatto, e prendo il costo
a capo, e poi 

*/
