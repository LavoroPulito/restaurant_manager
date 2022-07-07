import com.google.gson.Gson;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

/*

This class deals with order management
Inserts an ArrayList
 */
public class OrderManager {

    private HashMap<Integer, ArrayList<Order>> register;    //table:[table's orders], table1:[table1's orders]
    public OrderManager() {
        register = new HashMap<Integer, ArrayList<Order>>();
    }

    public void add(ArrayList<Order> orders) {  //if it is a new order, the orders are inserted otherwise concatenated 
        int tav = orders.get(0).getTable();
        if (register.containsKey(tav)) {
            register.get(tav).addAll(orders);
        } else {

            register.put(tav, orders);

        }
    }

    public ArrayList<Integer> getTableList() {
        if (register == null) {
            return null;
        }
        return new ArrayList<Integer>(register.keySet());
    }
    
    public ArrayList<Integer>getTableList(String state){
        if (register == null) {
            return null;
        }
        ArrayList<Integer> tb=new ArrayList<Integer>();

        for (int i: register.keySet()){
            for(Order ord: register.get(i)){
                if (ord.getState()==state){
                    tb.add(i);
                    break;
                }
            }
        }
        return tb;
    }
    public ArrayList<Order> getOrdersToDeliver(){
        ArrayList<Order> toDeliver = new ArrayList<>();
        for (Integer k:
             getTableList()) {
            for (Order o:
                 register.get(k)) {
                if ("ready".equals(o.getState())){
                    toDeliver.add(o);
                }
            }
        }
        return toDeliver;
    }


    public HashMap<Integer, ArrayList<Order>> getRegister() {
        return register;
    }

    public void setRegister(HashMap<Integer, ArrayList<Order>> register) {
        this.register = register;
    }

    public String toString() {
        return this.toJson();
    }

    public String toJson() {
        Gson gson = new Gson();
        return gson.toJson(this, OrderManager.class);
    }

    public void cleanTable(int table) {
        if (register.containsKey(table)) {
            register.remove(table);
        }
    }

    public void save() {
        try {
            File f = new File("orders.json");
            FileWriter w = new FileWriter(f);
            BufferedWriter writer = new BufferedWriter(w);
            writer.write(this.toJson());
            writer.close();
            w.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void load() {
        String string = "";
        String sCurrentLine = "";
        try {
            File f = new File("orders.json");
            FileReader r = new FileReader(f);
            BufferedReader br = new BufferedReader(r);
            while ((sCurrentLine = br.readLine()) != null) {
                string += sCurrentLine;
            }
            br.close();
        } catch (Exception e) {
            string = "";
        }


        if (string == "") {
            register = new HashMap<Integer, ArrayList<Order>>();
        } else {

            Gson gson = new Gson();
            register = gson.fromJson(string, OrderManager.class).getRegister();


        }
    }

}