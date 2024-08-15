import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class HippodromeTest {
    @Test
    public void whenHorsesNullThenException() {
        Throwable exception = assertThrows(
                IllegalArgumentException.class,
                () -> { new Hippodrome(null);}
        );
        assertEquals("Horses cannot be null.", exception.getMessage());
    }

    @Test
    public void whenHorsesEmptyThenException() {
        Throwable exception = assertThrows(
                IllegalArgumentException.class,
                () -> { new Hippodrome(new ArrayList<>());}
        );
        assertEquals("Horses cannot be empty.", exception.getMessage());
    }

    @Test
    public void getHorses() {
        List<Horse> horses=new ArrayList<>();
        for(int i=1;i<=30;i++){
            horses.add(new Horse("Лошадь "+i,i,i));
        }
        Hippodrome hippodrome=new Hippodrome(horses);

        assertThat(horses).isEqualTo( hippodrome.getHorses());
    }

    @Test
    public void moveAllHorse() {
        List<Horse>horses=new ArrayList<>();
        for(int i=0;i<50;i++){
            horses.add(mock(Horse.class));
        }
        Hippodrome hippodrome=new Hippodrome(horses);

        hippodrome.move();

        for(Horse horse:horses){
            verify(horse).move();
        }
    }

    @Test
    public void getWinner() {
       Horse fire = new Horse("Fire",20,100);
       Horse jit = new Horse("Jit",24,90);
       Horse anna = new Horse("Anna",15,70);

       Hippodrome hippodrome = new Hippodrome(List.of(fire,jit,anna));

        assertSame(fire,hippodrome.getWinner());

    }
}
