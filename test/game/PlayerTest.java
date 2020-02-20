package game;

import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerTest {

    @Test
    public void testLocatie() {
        Player player = new Player("src/img/Pepe.gif", 1, 1);
        assertEquals(1, player.getLocatieX());
        assertEquals(1, player.getLocatieY());

        player.setNieuweLocatie(2,2);
        assertEquals(2, player.getLocatieX());
        assertEquals(2, player.getLocatieY());
    }

    @Test
    public void pakSleutelTest() {
        Sleutel sleutel = new Sleutel("src/img/Red_Stone.png", 3);
        Player player = new Player("src/img/Pepe.gif", 1, 1);
        player.pakSleutel(sleutel);
        assertEquals(sleutel.getSleutelNr(), player.getSleutel().getSleutelNr());
    }
}
