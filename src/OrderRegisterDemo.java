import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

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
        orderRegister.addOrder(new Order(dish1, 1, " "));
        orderRegister.addOrder(new Order(dish2, 1, " "));
        orderRegister.addOrder(new Order(dish3, 2, " "));
        orderRegister.addOrder(new Order(dish4, 2, " "));
        orderRegister.addOrder(new Order(dish6, 3, " "));
        orderRegister.addOrder(new Order(dish6, 3, " "));
        orderRegister.addOrder(new Order(dish7, 4, " "));

        //creo la stringa json e la stampo
        String jsonOrderRegister = orderRegister.toJson();
        System.out.println(jsonOrderRegister);

        //salvo il json come file
        {
            try {
                FileWriter w = new FileWriter(new File("test_OrderRegister.json"));
                BufferedWriter writer = new BufferedWriter(w);
                writer.write(jsonOrderRegister);
                writer.close();
                w.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
