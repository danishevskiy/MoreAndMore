import danish.ex2.model.Service;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by denystymoshkevych on 7/24/17.
 */
public class TestGame {

    Service model;

    @Rule
    public final Timeout timeout = new Timeout(1000);

    @Before
    public void init(){
        model = new Service();
    }

    @Test
    public void testRand() {
       assertTrue(model.rand() <= 100 && model.rand() >= 0);
    }

    @Test
    public void testCastToListGetPreviousNumbers(){
        assertTrue(model.getPreviousNumbers() instanceof List);
    }

    @Test
    public void testNotNullGetPreviousNumbers(){
        assertNotNull(model.getPreviousNumbers());
    }
}
