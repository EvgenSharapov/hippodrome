import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class HorseTest {
    Horse horse=new Horse("Ракета",30,100);
    Horse horseNullDist=new Horse("Ракета",30);


    @Test
    void getName() {
        assertEquals("Ракета", horse.getName());
    }

    @Test
    void getSpeed() {
        assertEquals(30, horse.getSpeed());
    }

    @Test
    void getDistance() {
        assertEquals(100, horse.getDistance());
        assertEquals(0, horseNullDist.getDistance());

    }

    @Test
    void move() {
    }
}