import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

public class Dish {

    private final String name;
    private double price;
    private String category;
    private String description;
    private boolean available;


    public Dish(String name, double price, String description, String category) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.description = description;
        this.available = true;
    }

    public String toJson() {
        Gson gson = new Gson();
        Type fooType = new TypeToken<Dish>() {}.getType();
        String json = gson.toJson(this, fooType);
        return json;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }

    public String getDescription() {
        return description;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return name ; //+ PROVVISORIO
                /*
                ", price=" + price +
                ", category='" + category + '\'' +
                ", description='" + description + '\'' +
                ", availability=" + available +
                '}';

                 */
    }
}
