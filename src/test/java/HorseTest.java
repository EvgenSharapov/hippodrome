import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Stream;

import static java.nio.file.Files.move;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class HorseTest {

    @Test
    public void whenNameNullThenException() {
        Throwable exception = assertThrows(
                IllegalArgumentException.class,
                () -> { new Horse(null,30);}
        );
        assertEquals("Name cannot be null.", exception.getMessage());
    }
    @ParameterizedTest
    @ValueSource(strings= {"", "  ", "\t", "\n"})
    public void whenNameIncorrectThenException(String name) {
        Throwable exception = assertThrows(
                IllegalArgumentException.class,
                () -> { new Horse(name,30);}
        );
        assertEquals("Name cannot be blank.", exception.getMessage());
    }

    @Test
    public void whenSpeedNegativeThenException() {
        Throwable exception = assertThrows(
                IllegalArgumentException.class,
                () -> {new Horse("Fire",-30);}
        );
        assertEquals("Speed cannot be negative.", exception.getMessage());
    }
    @Test
    public void whenDistanceNegativeThenException() {
        Throwable exception = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    new Horse("Fire",30,-30);
                }
        );
        assertEquals("Distance cannot be negative.", exception.getMessage());
    }
    @Test

    public void getName() {
        Horse horse=new Horse("Ракета",30,100);
        assertEquals("Ракета", horse.getName());
    }

    @Test

    public void getSpeed() {
        Horse horse=new Horse("Ракета",30,100);
        assertEquals(30, horse.getSpeed());
    }

    @Test
    public void getDistance() {
        Horse horse=new Horse("Ракета",30,100);
        assertEquals(100, horse.getDistance());

    }
    @Test
    public void getDistanceByDefault() {
        Horse horseNullDist=new Horse("Ракета",30);
        assertEquals(0, horseNullDist.getDistance());

    }
    @Test
    public void moveRunGetRandom(){
        try(MockedStatic<Horse>horseMockedStatic=Mockito.mockStatic(Horse.class)){
            new Horse("Fire",20,100).move();
            horseMockedStatic.verify(()->Horse.getRandomDouble(0.2,0.9));
        }
    }
    @ParameterizedTest
    @MethodSource("argsForMove")
    public void whenMoveThenChangeDistance(double speed,double random,double distance) {
        try(MockedStatic<Horse>horseMockedStatic=Mockito.mockStatic(Horse.class)){
            horseMockedStatic.when(()-> Horse.getRandomDouble(0.2,0.9)).thenReturn(random);
            Horse horse= new Horse("Fire",speed,0.0);
            horse.move();
            assertEquals(distance,horse.getDistance(),0.02);
        }
    }
    static Stream<Double[]> argsForMove() {
        return Stream.of(
                new Double[]{20.0, 0.4, 8.0},
                new Double[]{24.0, 0.5, 12.0},
                new Double[]{16.0, 0.4, 6.4}
        );
    }
}