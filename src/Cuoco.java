import java.util.*;


public class Cuoco {

    private OrderManager orderList;
    private ArrayList<Integer> tables;

    public Cuoco(){
        this.orderList=new OrderManager();
        this.orderList.load();
        this.tables=this.orderList.getTableList();
    }

    public void changeState(int indexOrder, int table){

        orderList.getRegister().get(table).get(indexOrder).setNextState(); //Spacchettamento del HashMap e cambio lo stato dell'ordine
        orderList.save();  //Aggiornamento nel json
    }
}
