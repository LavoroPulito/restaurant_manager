import java.util.ArrayList;

public class Cassa {
    public Cassa(){}

    //filtra la lista di ordinazioni e prende solo quelle di un certo tavolo 
    public static void generaScontrino(ArrayList <Order>allOrders, int table){
        ArrayList <Order> ordersTable= new ArrayList<Order>();
        for(int i=0; i<allOrders.size(); i++){
            if( allOrders.get(i).getTable() == table ){
                ordersTable.add(allOrders.get(i));
            }
        } 

        double sum = 0;
        
        //calcola il totale del costo dei piatti
        for(int i=0; i<allOrders.size(); i++){
            sum+=allOrders.get(i).getDishPrice();
        }


    }
}
