import java.util.ArrayList;

public class OrderManagerDemo {


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
        OrderManager orderRegister = new OrderManager();

        //aggungo al registro gli ordini
        ArrayList<Order> orders = new ArrayList<Order>();
        ArrayList<Order> orders1 = new ArrayList<Order>();
        orders.add(new Order(dish1, 1, ""));
        orders.add(new Order(dish2, 1, ""));
        orders.add(new Order(dish3, 1, ""));
        orders.add(new Order(dish4, 1, ""));
        orders1.add(new Order(dish5, 2, ""));        
        orders1.add(new Order(dish6, 2, ""));
        orders1.add(new Order(dish6, 2, ""));
        orders1.add(new Order(dish7, 2, ""));

        orderRegister.add(orders);
        orderRegister.add(orders1);

        //salvo il json come file
        
        orderRegister.save();

        //creo la stringa json e la stampo
        String jsonOrderRegister = orderRegister.toString();
        System.out.println(jsonOrderRegister);

        //carico il json dentro l'oggetto
        orderRegister.load();

        Order order1 = new Order(dish7, 2, "");
        Order order2 = new Order(dish3, 2, "");
        Order order3 = new Order(dish2, 2, "");

        //creo una nuova anteprima degli ordini
        PreviewsRegister previewsRegister = new PreviewsRegister();

        previewsRegister.addOrder(new OrderPreview(dish1, 2,""));
        previewsRegister.addOrder(new OrderPreview(dish1, 2,""));
        previewsRegister.addOrder(new OrderPreview(dish2, 2,""));
        previewsRegister.addOrder(new OrderPreview(dish2, 2,""));
        previewsRegister.addOrder(new OrderPreview(dish2, 2,""));
        previewsRegister.addOrder(new OrderPreview(dish3, 2,""));
        System.out.println(previewsRegister.getPreviews());
        previewsRegister.decrement(new OrderPreview(dish3, 2,""));
        System.out.println(previewsRegister.getPreviews());

        System.out.println("###### prove previews ##########################");




        //salvo il file usando il metodo
        orderRegister.save();
        System.out.println("ripreso: ##################");
        OrderManager secondoRegistro = new OrderManager();
        secondoRegistro.load();
        System.out.println(secondoRegistro.getRegister());
    }
}
