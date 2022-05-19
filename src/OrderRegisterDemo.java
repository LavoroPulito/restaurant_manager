import java.io.*;
import java.util.ArrayList;

public class OrderRegisterDemo {


    public static void main(String[] args) {
        // creo dei dish per fare gli ordini
        Dish dish1 = new Dish("pasta con tonno", 8.0, "pasta con tonno", "Primo");
        Dish dish2 = new Dish("pasta al pesto", 10.0, "pasta con basilico e parmigiano", "Primo");
        Dish dish3 = new Dish("sorbetto al limone", 9.0, "tipo gelato", "Dolce");
        Dish dish4 = new Dish("calamari", 23.4, "calamari fritti", "Secondo");
        Dish dish5 = new Dish("patate", 13, "patate lesse", "Secondo");
        Dish dish6 = new Dish("pasta al sugo", 10, "pasta col pomodoro", "Primo");
        Dish dish7 = new Dish("tiramisù", 15, "mascarpone e caffè", "Dolce");

        // creo un nuovo registro
        OrderRegister orderRegister = new OrderRegister();

        //aggungo al registro gli ordini
        ArrayList<Order> orders = new ArrayList<Order>();

        orders.add(new Order(dish1, 1, " "));
        orders.add(new Order(dish2, 1, " "));
        orders.add(new Order(dish3, 2, " "));
        orders.add(new Order(dish4, 2, " "));
        orders.add(new Order(dish5, 2, " "));        
        orders.add(new Order(dish6, 3, " "));
        orders.add(new Order(dish6, 3, " "));
        orders.add(new Order(dish7, 4, " "));

        orderRegister.add(orders);

        //creo la stringa json e la stampo
        String jsonOrderRegister = orderRegister.toString();
        System.out.println(jsonOrderRegister);

        //carico il json dentro l'oggetto
        orderRegister.load();

        //salvo il json come file
        
        orderRegister.save();
        

        //salvo il file usando il metodo
        orderRegister.save();
        System.out.println("ripreso: ##################");
        OrderRegister secondoRegistro = new OrderRegister();
        secondoRegistro.load();
        System.out.println(secondoRegistro.getRegister());
    }
}
