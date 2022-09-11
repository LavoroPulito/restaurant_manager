package app.backend;

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
     * creates a new dish using the parameters provided
     * @param name name of the dish
     * @param price price of the dish (with IVA)
     * @param description description of the dish
     * @param category category of the dish
     * @param available if the dish is available or is not
     */
    public Dish(String name, double price, String description, String category,boolean available) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.description = description;
        this.available = available;
    }

    /**
     * creates a new dish using the parameters provided
     * @param name name of the dish
     * @param price price of the dish (with IVA)
     * @param description description of the dish
     * @param category category of the dish
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
     * @param name new name of the dish
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * sets dish available
     * @param available true if is available, false if it is not
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
     * @param description new description of the dish
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * sets dish price
     * @param price new price of the dish
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * sets dish category
     * @param category new category of the dish
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * represents the object using only the dish name
     * @return name
     */
    @Override
    public String toString() {
        return name ;
    }



}
