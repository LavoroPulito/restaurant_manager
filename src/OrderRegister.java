import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
/*
Questa classe si occupa della gestione degli ordini
inserisce un ArrayList
 */
public class OrderRegister {
    private HashMap<Integer, ArrayList<Order>> register;

    public  OrderRegister(){
        register =  new HashMap<Integer, ArrayList<Order>>();
    }
    
    public void add(ArrayList orders, int tav){ //se è una nuova ordinazione le ordinazioni vengono inserite sennò concatenate
        if (register.containsKey(tav)) {
            register.get(tav).addAll(orders);
        } else {
            register.put(tav, orders);
        }
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

    private String toJson() {
        Gson gson = new Gson();
        return gson.toJson(this, OrderRegister.class);
    }

    public void cleanTable(int table){
        if( register.containsKey(table)){
            register.remove(table);
        }
    }

    public void save(){
        try {
            FileWriter w = new FileWriter(new File("orders.json"));
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
            FileReader r = new FileReader(new File("orders.json"));
            BufferedReader br = new BufferedReader(r);
            while ((sCurrentLine = br.readLine()) != null)
            {
            string+=sCurrentLine;
            }
            }
        catch(Exception e){
            //crea File ordinazioni
        }
        Gson gson= new Gson();
        register = gson.fromJson(string, HashMap.class);
    }

}