import com.google.gson.Gson;

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


}