import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HorseTest {
    Horse horse=new Horse("Ракета",30,100);
    Horse horseNullDist=new Horse("Ракета",30);

    @Test
    void testExpectedExceptionWithNull() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Horse(null,30);
        });
    }
    @Test
    void whenAssertingExceptionNullFirst() {
        Throwable exception = assertThrows(
                IllegalArgumentException.class,
                () -> { new Horse(null,30);}
        );
        assertEquals("Name cannot be null.", exception.getMessage());
    }
    @Test
    void testExpectedExceptionWithNegativeSecond() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Horse("Null",-30);
        });
    }
    @Test
    void whenAssertingExceptionNegativeSecond() {
        Throwable exception = assertThrows(
                IllegalArgumentException.class,
                () -> {new Horse("Null",-30);}
        );
        assertEquals("Speed cannot be negative.", exception.getMessage());
    }
    @Test
    void testExpectedExceptionWithNegativeThird() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Horse("Null",30,-30);
        });
    }
    @Test
    void whenAssertingExceptionNegativeThird() {
        Throwable exception = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    new Horse("Null",30,-30);
                }
        );
        assertEquals("Distance cannot be negative.", exception.getMessage());
    }
    @Test
    void getNameHorse() {
        assertEquals("Ракета", horse.getName());
    }

    @Test
    void getSpeedHorse() {
        assertEquals(30, horse.getSpeed());
    }

    @Test
    void getDistanceHorse() {
        assertEquals(100, horse.getDistance());
        assertEquals(0, horseNullDist.getDistance());

    }
    @ExtendWith(MockitoExtension.class)
    @Test
    void moveHorse() {
        MockedStatic<Horse> mock = Mockito.mockStatic(Horse.class);



    }
}