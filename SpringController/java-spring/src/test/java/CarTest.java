import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.Car1;
import com.example.Car2;
import com.example.Car3;

public class CarTest {

    private Car1 car1;
    private Car2 car2;
    private Car3 car3;

    @BeforeEach
    public void setUp() {
        car1 = new Car1("Toyota", 20000);
        car2 = new Car2("Honda");
        car3 = new Car3("Ford", 25000);
    }

    @Test
    public void testCar1() {
        assertEquals("Toyota", car1.getModel());
        assertEquals(20000, car1.getPrice());

        car1.setPrice(22000);
        assertEquals(22000, car1.getPrice());

        assertEquals("Car1(model=Toyota, price=22000.0)", car1.toString());
    }

    @Test
    public void testCar2() {
        assertEquals("Honda", car2.getModel());
        assertEquals(0, car2.getPrice()); // Default price should be 0

        car2.setPrice(18000);
        assertEquals(18000, car2.getPrice());

        assertEquals("Car2(model=Honda, price=18000.0)", car2.toString());
    }

    @Test
    public void testCar3() {
        assertEquals("Ford", car3.getModel());
        assertEquals(25000, car3.getPrice());

        car3.setPrice(26000);
        assertEquals(26000, car3.getPrice());

        assertEquals("Car3(model=Ford, price=26000.0)", car3.toString());
    }

    @Test
    public void testCar3Equality() {
        Car3 anotherCar3 = new Car3("Ford", 26000);
        assertFalse(car3.equals(anotherCar3));
        assertNotEquals(car3.hashCode(), anotherCar3.hashCode());

        anotherCar3.setPrice(25000);
        assertTrue(car3.equals(anotherCar3));
    }
}
