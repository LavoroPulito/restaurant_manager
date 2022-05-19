import com.google.gson.Gson;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/*
classe demo per testare la classe MenuDish e la classe Dish
 */

public class MenuDemo {
    public static void main(String[] args) {

        //creo un menù e aggiungo dei piatti
        DishMenu carta = new DishMenu();
        carta.addDish(new Dish("pasta con tonno", 8.0, "pasta con tonno", "Primo"));
        carta.addDish(new Dish("pasta al pesto", 10.0, "pasta con basilico e parmigiano", "Primo"));
        carta.addDish(new Dish("sorbetto al limone", 9.0, "tipo gelato", "Dolce"));
        carta.addDish(new Dish("calamari", 23.4, "calamari fritti", "Secondo"));
        carta.addDish(new Dish("patate", 13, "patate lesse", "Secondo"));
        carta.addDish(new Dish("pasta al sugo", 10, "pasta col pomodoro", "Primo"));
        carta.addDish(new Dish("tiramisù", 15, "mascarpone e caffè", "Dolce"));

        //stampo il menù in un dizionario ordinato per portate
        System.out.println("dizionrio per portate:");
        System.out.println(carta.toDict());
        System.out.println(" ");

        //stampo un menu come lista di soli nomi dei piatti:
        System.out.println("in array:");
        System.out.println(carta.toArrayList());
        System.out.println(" ");

        //stampo ogni piatto nel menù come stringa json
        for (Dish e :
                carta.getMenu()) {
            System.out.println(e.toJson());

        }

        //creo un file Json di tutto il menù e lo stampo
        String jsonMenu = carta.toJson();
        System.out.println(jsonMenu);

        //salvo il json come file
        
        try {
            FileWriter w = new FileWriter(new File("test_menu.json"));
            BufferedWriter writer = new BufferedWriter(w);
            writer.write(jsonMenu);
            writer.close();
            w.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        

        //ricreo un nuovo menù partendo dal file json salvato
        Gson gson = new Gson();
        DishMenu carta2 = gson.fromJson(jsonMenu, DishMenu.class);

        //recupero un piatto tramite getDish passando una stringa e lo stampo
        Dish next_del = carta2.getDish("patate");
        System.out.println(next_del);

        //elimino il piatto recuperato
        carta2.removeDish(next_del);

        //stampo il menù modificato modificato
        System.out.println("al ritorno:");
        System.out.println(carta2.getMenu().toString());
    }
}
