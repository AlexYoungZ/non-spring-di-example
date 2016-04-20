package tech.ljp.diexamples.openclosed;

import java.util.List;

/**
 * Created by jt on 4/19/16.
 */
public abstract class Pizza {

    private String description;
    private List<String> toppings;

    public Pizza(String description, List<String> toppings) {
        this.description = description;
        this.toppings = toppings;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public abstract Boolean isYummy();
}
