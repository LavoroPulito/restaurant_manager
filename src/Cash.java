import java.util.ArrayList;

public class Cash {
    public Cash(){}

    //filtra la lista di ordinazioni e prende solo quelle di un certo tavolo 
    public static void generaScontrino(ArrayList<Order> allOrders){ 
        double sum = 0;
        
        //calcola il totale del costo dei piatti
        for(int i=0; i<allOrders.size(); i++){
            sum+=allOrders.get(i).getDishPrice();
        }


    }
}
