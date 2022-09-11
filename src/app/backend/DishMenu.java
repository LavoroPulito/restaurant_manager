package app.backend;

import com.google.gson.Gson;

import java.util.*;
import java.io.*;

/**
 * this class creates and manages an ArrayList of dishes as if it were a menu
 *
 * @author Armando Coppola
 * @author Niccolò Di Santo
 * @author Francesco Daprile
 * @version 1.0
 */
public class DishMenu {
    /**
     * the HashMap that contain the menu divided by category
     */
    private HashMap<String, ArrayList<Dish>> menu;

    /**
     * path where the menu is saved and loaded
     */
    private final String filePath = "./Saves";

    /**
     * Initializes the DishMenu
     */
    public DishMenu() {
        menu = new HashMap<>();

    }

    /**
     * Returns the menu
     *
     * @return HashMap menu
     */
    public HashMap<String, ArrayList<Dish>> getMenu() {
        return menu;
    }

    /**
     * this method add a dish in the HashMap menu in the right category if it exists or creates a new one
     *
     * @param dish to add
     */
    public void add(Dish dish) {
        String key = dish.getCategory();
        if (menu.containsKey(key)) {
            menu.get(key).add(dish);
        } else {
            ArrayList<Dish> lis = new ArrayList<>();
            lis.add(dish);
            menu.put(key, lis);
        }

    }

    /**
     * removes a dish from the HashMap, if the key to which "dish" belonged remains empty, it also deletes the key
     *
     * @param dish to remove
     * @return if the removal was successful
     */
    public boolean removeDish(Dish dish) {
        boolean t;
        try {
            t = menu.get(dish.getCategory()).remove(dish);
        } catch (Exception ex) {
            return false;
        }
        if (menu.get(dish.getCategory()).isEmpty()) {
            menu.remove(dish.getCategory());
        }
        return t;
    }

    /**
     * it returns the plate corresponding to the supplied parameters if it exists in the menu otherwise it returns null
     *
     * @param name     of the dish
     * @param category of the dish
     * @return dish or null
     */
    public Dish getDish(String name, String category) {
        for (Dish e :
                menu.get(category)) {
            if (name.equals(e.getName())) {
                return e;
            }
        }
        return null;
    }

    /**
     * it returns the plate corresponding to the supplied parameters if it exists in the menu otherwise it returns null
     *
     * @param name of the dish
     * @return dish or null
     */
    public Dish getDish(String name) {
        for (String key :
                menu.keySet()) {
            for (Dish e :
                    menu.get(key)) {
                if (name.equals(e.getName())) {
                    return e;
                }
            }
        }
        return null;
    }

    /**
     * creates an ArrayList with all the dish in menu
     *
     * @return ArrayList menu
     */
    public ArrayList<Dish> toArrayList() {
        ArrayList<Dish> total = new ArrayList<>();
        for (String key :
                menu.keySet()) {
            total.addAll(menu.get(key));
        }
        return total;
    }

    /**
     * creates a Json string with the HashMap menu, to save
     *
     * @return Json string
     */
    public String toJson() {
        Gson gson = new Gson();
        return gson.toJson(this, DishMenu.class);
    }


    /**
     * saves in a file the json String
     */
    public void save() {
        File Dir = new File(filePath);

        if (!Dir.exists()) {
            Dir.mkdir();
        }
        try {
            FileWriter writer = new FileWriter(filePath+"/menu.json");
            writer.write(this.toJson());
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * loads from the file the json String and loads the data into the menu
     */
    public void load() {
        String string = "";
        String sCurrentLine = "";
        try {
            File f = new File(filePath+"/menu.json");
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
            menu = new HashMap<>();
        } else {
            Gson gson = new Gson();
            menu = gson.fromJson(string, DishMenu.class).getMenu();
        }
    }


}
