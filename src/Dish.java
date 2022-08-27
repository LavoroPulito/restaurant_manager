/*import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;*/
/**
 * This class creates and manages a dish
 * @author Armando Coppola
 * @author Niccolò Di Santo
 * @author Francesco Daprile
 * @version 1.0
 *
 */
public class Dish {
    /**
     * name of the dish
     */
    private String name;

    /**
     * price of the dish
     */
    private double price;

    /**
     * category of the dish
     */
    private String category;

    /**
     * description of the dish
     */
    private String description;

    /**
     *  the availability of the dish
     */
    private boolean available;

    /**
     * create a new dish using the parameters provided
     * @param name
     * @param price
     * @param description
     * @param category
     * @param available
     */
    public Dish(String name, double price, String description, String category,boolean available) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.description = description;
        this.available = available;
    }

    /**
     * create a new dish using the parameters provided
     * @param name
     * @param price
     * @param description
     * @param category
     */
    public Dish(String name, double price, String description, String category) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.description = description;
        this.available = true;
    }

    /**
     * gets dish name
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * gets dish price
     * @return price
     */
    public double getPrice() {
        return price;
    }

    /**
     * gets dish category
     * @return category
     */
    public String getCategory() {
        return category;
    }

    /**
     * gets dish description
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * gets the availability of the dish
     * @return available
     */
    public boolean isAvailable() {
        return available;
    }

    /**
     * sets dish name
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * sets dish available
     * @param available
     */
    public void setAvailable(boolean available) {
        this.available = available;
    }

    /**
     * switch the availability of the dish
     */
    public void switchAvailable(){
        available = !available;
    }

    /**
     * sets dish description
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * sets dish price
     * @param price
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * sets dish category
     * @param category
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * represent the object using only the dish name
     * @return name
     */
    @Override
    public String toString() {
        return name ;
    }
}
