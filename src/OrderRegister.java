import com.google.gson.Gson;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;

public class OrderRegister {
    private HashMap<Integer, ArrayList<Order>> register;

    public  OrderRegister(){
        register =  new HashMap<Integer, ArrayList<Order>>();
}
    public void addOrder(Order order){
        Integer tav = (Integer) order.getTable();
        if (register.containsKey(tav)) {
            register.get(tav).add(order);
            //System.out.println("si: " + dictionary.get(e));
        } else {
            ArrayList<Order> lis = new ArrayList<>();
            lis.add(order);
            //System.out.println("si");
            register.put(tav, lis);
        }
    }

    public HashMap<Integer, ArrayList<Order>> getRegister() {
        return register;
    }

    public void setRegister(HashMap<Integer, ArrayList<Order>> register) {
        this.register = register;
    }

    public String toJson() {
        Gson gson = new Gson();
        return gson.toJson(this, OrderRegister.class);
    }

    public void cleanTable(int table){
        if( register.containsKey(table)){
            register.remove(table);
        }
    }

    public void writeOrder(){
        try {
            FileWriter w = new FileWriter(new File("orders.json"));
            BufferedWriter writer = new BufferedWriter(w);
            writer.write(this.toJson()); //??? non so che cazzo ho fatto
            writer.close();
            w.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}