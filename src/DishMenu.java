import com.google.gson.Gson;

import java.util.ArrayList;

public class DishMenu {
    private ArrayList<Dish> menu;

    public DishMenu() {
        menu = new ArrayList<Dish>();
    }

    public ArrayList<Dish> getMenu() {
        return menu;
    }


    public void addDish(Dish e) {
        menu.add(e);
    }
    public void removeDish(Dish e){
        menu.remove(e);
    }
    public Dish getDish(String name){
        for (Dish e:
             menu) {
            if (e.getName().equals(name)){
                return e;
            }
        }
        return null;
    }

    public String toJson() {
        Gson gson = new Gson();
        return gson.toJson(this, DishMenu.class);
    }

}
