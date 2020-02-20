package game;

import org.junit.Test;

import static org.junit.Assert.*;

public class BarricadeTest {

    @Test
    public void testLoopbaarheid() {
        Barricade b1 = new Barricade("src/img/Blue_Barricade.jpg", 1);
        Sleutel s1 = new Sleutel("src/img/Blue_Stone.png", 1);
        Sleutel s2 = new Sleutel("src/img/Red_Stone.png", 2);
        Player player = new Player("src/img/Pepe.gif", 1, 1);

        player.pakSleutel(s1);
        assertTrue(b1.isBeloopbaar(player));

        player.pakSleutel(s2);
        assertFalse(b1.isBeloopbaar(player));
    }
}