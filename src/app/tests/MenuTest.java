package app.tests;
/*
classe demo per testare la classe MenuDish e la classe app.backend.Dish
 */

import app.backend.Dish;
import app.backend.DishMenu;

public class MenuTest {
    public static boolean test() {
        boolean passed=true;
        System.out.println("Manage menu test\n");
        
        DishMenu menu = new DishMenu();
        menu.load();
        //System.out.println(menu.getMenu());

        //sif(! MenuTest.addDish()){passed=false;}
        //if(! MenuTest.removeDish()){passed=false;}


    return passed;
    }

    private static boolean addDish(){
        System.out.print("Add dish test: ");

        DishMenu menu = new DishMenu();
        menu.load();
        
        menu.add(new Dish("Test", 8.0, "","Second"));

        menu.save();


        DishMenu menu1 = new DishMenu();
        menu1.load();
        if (menu1.getDish("Test").equals(null)){
            System.out.println(" The program doesn't add dish to menu\n");
            return false;
        }
        System.out.println(" Test passed\n");
        return true;
    }

    private static boolean removeDish(){
        System.out.print("Remove dish test: ");

        DishMenu menu = new DishMenu();
        menu.load();
        menu.removeDish(new Dish("Test", 8.0, "","Second"));
        menu.save();


        if (menu.getDish("Test").equals(null)){
            System.out.println(" Test passed\n");
            return true;
        }
        System.out.println(" The program doesn't remove dish to menu\n");
        return false;
    }
}
