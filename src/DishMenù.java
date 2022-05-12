import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class DishMenù {
    private ArrayList<Dish> menù = new ArrayList<Dish>();

    public DishMenù() {

    }

    public ArrayList<Dish> getMenù() {
        return menù;
    }


    public void addDish(Dish e) {
        menù.add(e);
    }

    public String toJson() {
        Gson gson = new Gson();
        return gson.toJson(this, DishMenù.class);
    }

    public void saveMenu() {

    }

}
