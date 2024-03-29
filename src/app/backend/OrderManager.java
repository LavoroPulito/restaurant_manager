package app.backend;

import com.google.gson.Gson;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * This class manages the orders inserts an ArrayList
 *
 * @author Armando Coppola
 * @author Niccolò Di Santo
 * @author Francesco Daprile
 * @version 1.0
 */
public class OrderManager {
    /**
     * this attribute collects all the orders divided by table
     */
    private HashMap<Integer, ArrayList<Order>> register;    //table:[table's orders], table1:[table1's orders]

    /**
     * path where the order register is saved and loaded
     */
    private String filePath = "./Saves";

    /**
     * Inizializes a new orderManager
     */
    public OrderManager() {
        register = new HashMap<Integer, ArrayList<Order>>();
    }

    /**
     * This method add orders to the collection of orders. If the table isn't there, it is created, instead the orders are concatenated at the table's array
     *
     * @param orders
     */
    public void add(ArrayList<Order> orders) {
        int tav = orders.get(0).getTable();
        if (register.containsKey(tav)) {
            register.get(tav).addAll(orders);
        } else {

            register.put(tav, orders);

        }
    }

    /**
     * This method adds an order to the collection of orders. If the table isn't there, it is created instead the order is concatenated at the table's array
     *
     * @param order
     */
    public void add(Order order) {
        if (register.containsKey(order.getTable())) {
            register.get(order.getTable()).add(order);
        } else {
            ArrayList<Order> orders = new ArrayList<>();
            orders.add(order);
            register.put(order.getTable(), orders);
        }
    }


    /**
     * Returns an arrayList with all the array's numbers
     *
     * @return array table
     */
    public ArrayList<Integer> getTableList() {
        if (register == null) {
            return null;
        }
        return new ArrayList<Integer>(register.keySet());
    }

    /**
     * Returns an arrayList with all the array's numbers that has at least an order with a specific state
     *
     * @param state
     * @return array table
     */
    public ArrayList<Integer> getTableList(String state) {
        if (register == null) {
            return null;
        }
        ArrayList<Integer> tb = new ArrayList<Integer>();

        for (int i : register.keySet()) {
            for (Order ord : register.get(i)) {
                if (ord.getState() == state) {
                    tb.add(i);
                    break;
                }
            }
        }
        return tb;
    }

    /**
     * Returns an arrayList of orders that have to deliver (state 1)
     *
     * @return orders to deliver
     */
    public ArrayList<Order> getOrdersToDeliver() {
        ArrayList<Order> toDeliver = new ArrayList<>();
        for (Integer k :
                getTableList()) {
            for (Order o :
                    register.get(k)) {
                if ("ready".equals(o.getState())) {
                    toDeliver.add(o);
                }
            }
        }
        return toDeliver;
    }

    /**
     * Sets the next state of an order
     *
     * @param order
     */
    public void setNextState(Order order) {
        register.get(order.getTable()).remove(order);
        order.setNextState();
        add(order);
    }

    /**
     * Returns the collection of orders
     *
     * @return register
     */
    public HashMap<Integer, ArrayList<Order>> getRegister() {
        return register;
    }

    /**
     * Sets the register
     *
     * @param register
     */
    public void setRegister(HashMap<Integer, ArrayList<Order>> register) {
        this.register = register;
    }

    /**
     * Writes the collection's informations in a Json String
     *
     * @return Json string
     */
    public String toJson() {
        Gson gson = new Gson();
        return gson.toJson(this, OrderManager.class);
    }

    /**
     * Clears the table and removes it from collection
     */
    public void cleanTable(int table) {
        if (register.containsKey(table)) {
            register.remove(table);
        }
    }

    /**
     * Writes the register's Json in a file called orders.json
     */
    public void save() {
        File Dir = new File(filePath);

        if (!Dir.exists()) {
            Dir.mkdir();
        }
        try {
            FileWriter writer = new FileWriter(filePath + "/order.json");
            writer.write(this.toJson());
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Loads the information from a file json and puts them in the object
     */
    public void load() {
        String string = "";
        String sCurrentLine = "";
        try {
            File f = new File(filePath + "/order.json");
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
            register = new HashMap<>();
        } else {
            Gson gson = new Gson();
            register = gson.fromJson(string, OrderManager.class).getRegister();
        }
    }

}