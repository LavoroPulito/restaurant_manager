import java.util.*;

public class Cuoco {

    private OrderManager orderList;
    private ArrayList<Integer> tables;

    public Cuoco(){
        this.orderList=new OrderManager();
        this.tables=orderList.getTableList();
    }

    public static void changeState(int indexOrder, int table){
        OrderManager or = new OrderManager();
        or.load();  //carica tutto il dizionario dal json
        or.getRegister().get(table).get(indexOrder).setNextState(); //Spacchettamento del HashMap e cambio lo stato dell'ordine
        or.save();  //Aggiornamento nel json
    }
}
