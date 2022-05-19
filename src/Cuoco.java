public class Cuoco {
    public Cuoco(){}

    public static void changeState(int indexOrder, int table){
        OrderRegister or = new OrderRegister();
        or.load();  //carica tutto il dizionario dal json
        or.getRegister().get(table).get(indexOrder).setNextState(); //Spacchettamento del HashMap e cambio lo stato dell'ordine
        or.save();  //Aggiornamento nel json
    }
}
