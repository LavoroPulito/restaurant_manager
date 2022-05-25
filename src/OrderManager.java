import com.google.gson.Gson;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
/*
Questa classe si occupa della gestione degli ordini
inserisce un ArrayList
 */
public class OrderManager {

    private HashMap<Integer, ArrayList<Order>> register;    //tavolo:[ordini del tavolo], tavolo1:[ordini del tavolo1]

    public  OrderManager(){
        register =  new HashMap<Integer, ArrayList<Order>>();
    }

    public void add(ArrayList<Order> orders){ //se è una nuova ordinazione le ordinazioni vengono inserite sennò concatenate
        int tav=orders.get(0).getTable();
        if (register.containsKey(tav)) {
            register.get(tav).addAll(orders);
        } else
        {

            register.put(tav, orders);

        }
    }

    public ArrayList<Integer> getTableList(){
        if (register==null){
            return null;
        }
        return new ArrayList<Integer>(register.keySet());
    }

    public HashMap<Integer, ArrayList<Order>> getRegister() {
        return register;
    }

    public void setRegister(HashMap<Integer, ArrayList<Order>> register) {
        this.register = register;
    }

    public String toString(){
        return this.toJson();
    }

    public String toJson() {
        Gson gson = new Gson();
        return gson.toJson(this, OrderManager.class);
    }

    public void cleanTable(int table){
        if( register.containsKey(table)){
            register.remove(table);
        }
    }

    public void save(){
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

    public void load(){
        String string="";
        String sCurrentLine="";
        try {
            File f = new File("orders.json");
            FileReader r = new FileReader(f);
            BufferedReader br = new BufferedReader(r);
            while ((sCurrentLine = br.readLine()) != null)
            {
            string+=sCurrentLine;
            }
            br.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }

        Gson gson= new Gson();
        if (string==""){
            register =new HashMap<Integer, ArrayList<Order>>();
        }
        else{
          register = gson.fromJson(string, OrderManager.class).getRegister();
        }
    }

}
