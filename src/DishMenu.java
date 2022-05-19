import com.google.gson.Gson;

import java.util.*;
import java.io.*;

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

    public void removeDish(Dish e) {
        menu.remove(e);
    }

    public Dish getDish(String name) {
        for (Dish e :
                menu) {
            if (e.getName().equals(name)) {
                return e;
            }
        }
        return null;
    }

    public Map<String, ArrayList<Dish>> toDict() {
        String category;
        Map<String, ArrayList<Dish>> dictionary = new HashMap<String, ArrayList<Dish>>();
        for (Dish e :
                menu) {
            category = e.getCategory();
            if (dictionary.containsKey(category)) {
                dictionary.get(category).add(e);
                //System.out.println("si: " + dictionary.get(e));
            } else {
                ArrayList<Dish> lis = new ArrayList<Dish>();
                lis.add(e);
                //System.out.println("si");
                dictionary.put(category, lis);
            }
        }
        return dictionary;
    }

    public ArrayList<String> toArrayList() {
        //TO ADD: sorter per gli elementi del menù in base alla categoriaw
        ArrayList<String> strings = new ArrayList<>();

        for (Dish e :
                menu) {
            strings.add(e.getName());
        }
        return strings;
    }

    public String toJson() {
        Gson gson = new Gson();
        return gson.toJson(this, DishMenu.class);
    }

    public ArrayList<String> getCategoryList(){
        ArrayList<String> ar = new ArrayList<String>();

        for (Dish d : menu){
            if (ar.indexOf (d.getCategory()) == -1){    //se non c'è nella lista di categorie la aggiunge
                ar.add(d.getCategory());
            }
        }
        return ar;
    }

    public void save(){

        String jsonMenu = this.toJson();

        try {
            File f = new File("test_menu.json");
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
            File f = new File("menu");
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
        menu = gson.fromJson(string, ArrayList.class);
    }

}
