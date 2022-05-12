import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

public class Dish {

    private final String name;
    private double price;
    private String category;
    private String description = "";
    private boolean availability = true;


    public Dish(String name, double price, String description, String category ) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.description = description;
    }
    public String toJson(){
        Gson gson = new Gson();
        Type fooType = new TypeToken<Dish>() {}.getType();
        String json = gson.toJson(this,fooType);
        return json;
    }
    public void setAvailability(boolean availability) {
        this.availability = availability;
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
        return "Dish{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", category='" + category + '\'' +
                ", description='" + description + '\'' +
                ", availability=" + availability +
                '}';
    }
}
