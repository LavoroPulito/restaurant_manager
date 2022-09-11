package app.tests;


import app.backend.Dish;
import app.backend.DishMenu;
/**
 * this class tests the proper functioning of the class app.backend.Dish  and app.backend.DishMenu
 * @author Armando Coppola
 * @author Niccolò Di Santo
 * @author Francesco Daprile
 * @version 1.0
 */
public class MenuTest {
    /**
     * dish example
     */
    static Dish d = new Dish("Test", 8.0, "","Second");

    /**
     * creates a new menu and launches the add and remove Dish tests
     * @return true if all tests passed successfully, otherwise false
     */
    public static boolean test(){
        boolean passed=true;
        System.out.println("Manage menu test\n");
        
        DishMenu menu = new DishMenu();
        menu.load();
        //System.out.println(menu.getMenu());

        if(! MenuTest.addDish()){passed=false;}
        if(! MenuTest.removeDish()){passed=false;}


    return passed;
    }

    /**
     * check the correct addition of the dish to the menu
     * @return false if the loaded dish is not found in the menu otherwise true
     */
    private static boolean addDish(){
        System.out.print("Add dish test: ");

        DishMenu menu = new DishMenu();
        menu.load();
        
        menu.add(d);

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

    /**
     * check the correct removal of the dish to the menu
     * @return true if the dish was successfully removed, otherwise false
     */
    private static boolean removeDish(){
        System.out.print("Remove dish test: ");

        DishMenu menu = new DishMenu();
        menu.load();
        


        if (menu.removeDish(menu.getDish("Test"))){
            System.out.println(" Test passed\n");
            menu.save();
            return true;
        }
        System.out.println(" The program doesn't remove dish to menu\n");
        menu.save();
        return false;
    }
}
