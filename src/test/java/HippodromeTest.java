import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

class HippodromeTest {
    List<Horse> horses = List.of(
            new Horse("Bucephalus", 2.4),
            new Horse("Ace of Spades", 2.5),
            new Horse("Zephyr", 2.6),
            new Horse("Blaze", 2.7),
            new Horse("Lobster", 2.8),
            new Horse("Pegasus", 2.9),
            new Horse("Cherry", 3),
            new Horse("Bucep", 2.1),
            new Horse("Ace of Spa", 2.3),
            new Horse("Zepha", 2.9),
            new Horse("Blazers", 2.1),
            new Horse("Lobanov", 1.5),
            new Horse("Pegas", 2.6),
            new Horse("Black Cherry", 3.2),
            new Horse("Buffer", 2.2),
            new Horse("Jumba", 2.2),
            new Horse("Zeus", 3.6),
            new Horse("Blast", 2.9),
            new Horse("Marta", 2.5),
            new Horse("Champ", 3.9),
            new Horse("Chi", 3.1),
            new Horse("Buca", 2.1),
            new Horse("Flag", 2.3),
            new Horse("Zebra", 2.6),
            new Horse("Borza", 2.7),
            new Horse("Goal", 2.8),
            new Horse("Pers", 2.9)
    );
    List<Horse> horsesDist = List.of(
            new Horse("Bucephalus", 2.4,30),
            new Horse("Ace of Spades", 2.5,40),
            new Horse("Zephyr", 2.6,50),
            new Horse("Blaze", 2.7,60),
            new Horse("Lobster", 2.8,70),
            new Horse("Pegasus", 2.9,80),
            new Horse("Cherry", 3,90),
            new Horse("Bucep", 2.1,100)
    );

    Hippodrome hippodrome=new Hippodrome(horses);

    @Test
    void getHorses() {
        assertThat(horses).isEqualTo( hippodrome.getHorses());
    }

    @Test
    void move() {
    }

    @Test
    void getWinner() {
        assertEquals(100, horsesDist.stream()
                .max(Comparator.comparing(Horse::getDistance))
                .get().getDistance());

    }
}
