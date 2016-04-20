package tech.ljp.diexamples.openclosed;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jt on 4/19/16.
 */
public class MeatLoversPizza extends Pizza {

    public MeatLoversPizza() {
        super("Meat Lovers", getToppings() );

    }

    public Boolean isYummy() {
        return true;
    }

    private static List<String> getToppings(){
        List<String> toppings = new ArrayList<String>();
        toppings.add("Cheese");
        toppings.add("Pepporoini");
        toppings.add("Bacon");
        toppings.add("Sausage");
        return toppings;
    }
}
