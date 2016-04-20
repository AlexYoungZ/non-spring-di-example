package tech.ljp.diexamples.openclosed;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jt on 4/19/16.
 */
public class VeggiePizza extends Pizza {
    public VeggiePizza() {
        super("Veggie", getToppings() );

    }

    public Boolean isYummy() {
        return false;
    }

    private static List<String> getToppings(){
        List<String> toppings = new ArrayList<String>();
        toppings.add("Cheese");
        toppings.add("Tomato");
        toppings.add("Olives");
        toppings.add("Broccoli");
        return toppings;
    }
}
