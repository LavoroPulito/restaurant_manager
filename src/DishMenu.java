import com.google.gson.Gson;

import java.util.*;
import java.io.*;

public class DishMenu {

    private HashMap<String, ArrayList<Dish>> menu;

    public DishMenu() {
        menu =  new HashMap<String, ArrayList<Dish>>();
    }

    public HashMap<String, ArrayList<Dish>> getMenu() {
        return menu;
    }


    public void add(Dish dish){
        String key = dish.getCategory();
        if (menu.containsKey(key)) { //se la categoria esiste già aggiunge il dish alla lista
            menu.get(key).add(dish);
        } else { // altrimenti crea una nuova lista con dentro il dish e la inserisce nella nuova categoria
            ArrayList <Dish> lis= new ArrayList<>();
            lis.add(dish);
            menu.put(key, lis);
        }
    }

    public void removeDish(Dish e) {
        menu.get(e.getCategory()).remove(e);  // DA TESTARE
    }

    public Dish getDish(String name, String category) {
        for (Dish e:
                menu.get(category)) {
            if (name.equals(e.getName())){
                return e;
            }
            }
    return null;
    }

    public Dish getDish(String name) {
        for (String key:
                menu.keySet()) {
            for (Dish e:
                    menu.get(key)) {
                if (name.equals(e.getName())){
                    return e;
                }
            }
        }
        return null;
    }

    public ArrayList<Dish> toArrayList() {
        ArrayList <Dish> total = new ArrayList<>();
        for (String key:
        menu.keySet()) {
            total.addAll(menu.get(key));
        }
        return total;
    }

    public String toJson() {
        Gson gson = new Gson();
        return gson.toJson(this, DishMenu.class);
    }


    public void save(){

        String jsonMenu = this.toJson();

        try {
            File f = new File("menu.json");
            FileWriter w = new FileWriter(f);
            BufferedWriter writer = new BufferedWriter(w);
            writer.write(jsonMenu);
            writer.close();
            w.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void load(){
        String string="";
        String sCurrentLine="";
        try {
            File f = new File("menu.json");
            FileReader r = new FileReader(f);
            BufferedReader br = new BufferedReader(r);
            while ((sCurrentLine = br.readLine()) != null)
            {
            string+=sCurrentLine;
            }
            br.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }

        Gson gson= new Gson();
        menu = gson.fromJson(string, DishMenu.class).getMenu();
    }

}
