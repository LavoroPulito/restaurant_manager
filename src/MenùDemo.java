import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class MenùDemo {
    public static void main(String[] args) {
        DishMenù carta = new DishMenù();
        carta.addDish(new Dish("calamari",23.4,"calamari fritti","Secondo"));
        carta.addDish(new Dish("patate",13,"patate lesse","Secondo"));
        carta.addDish(new Dish("pasta al sugo",10,"pasta col pomodoro","primo"));
        carta.addDish(new Dish("tiramisù",15,"mascarpone e caffè","Dolce"));
        for (Dish e:
             carta.getMenù()) {
            System.out.println(e.toJson());
        }
        String jsonMenu = carta.toJson();
        System.out.println(jsonMenu);
        System.out.println("==============");
        {
            try {
                FileWriter w = new FileWriter(new File("test_menu.json"));
                BufferedWriter writer = new BufferedWriter(w);
                writer.write(jsonMenu);
                writer.close();
                w.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        Gson gson = new Gson();
        DishMenù carta2 = gson.fromJson(jsonMenu, DishMenù.class);
        System.out.println("al ritorno:");
        System.out.println(carta2.getMenù().toString());
    }
}
