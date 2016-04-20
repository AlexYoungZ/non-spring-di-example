package tech.ljp.diexamples.openclosed;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by jt on 4/19/16.
 */
public class TestPizza {

    @Test
    public void testPizza() throws Exception {

        Pizza meatLovers = new MeatLoversPizza();
        Pizza veggie = new VeggiePizza();

        assertTrue(meatLovers.isYummy());
        assertFalse(veggie.isYummy());

    }
}
