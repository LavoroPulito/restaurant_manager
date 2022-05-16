import com.google.gson.Gson;

import java.util.ArrayList;

public class DishMenu {
    private ArrayList<Dish> menù;

    public DishMenu() {
        menù = new ArrayList<Dish>();
    }

    public ArrayList<Dish> getMenu() {
        return menù;
    }


    public void addDish(Dish e) {
        menù.add(e);
    }

    public String toJson() {
        Gson gson = new Gson();
        return gson.toJson(this, DishMenu.class);
    }

    public void saveMenu() {

    }

}
