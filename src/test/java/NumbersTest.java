import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Julia on 28.10.2020.
 */
public class NumbersTest {
    @Test
    public void sum() throws Exception {
        Numbers numbers = new Numbers();
        int act = numbers.sum(10,2);
        int expected=12;
        assertEquals(expected,act);
    }

}