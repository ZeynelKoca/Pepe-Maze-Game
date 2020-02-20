
package game;

import org.junit.Test;

import static org.junit.Assert.*;

public class SpeelveldTest {

    @Test
    public void pakVeldImageURL() {
        new Speelveld(1);
        assertEquals("src/img/Pepe.gif", Speelveld.getVeldItem(1, 1).getImageURL());
        assertEquals("src/img/Gauntlet.gif", Speelveld.getVeldItem(9, 9).getImageURL());
        assertEquals(1, Speelveld.getPlayer().getLocatieX());
        assertEquals(1, Speelveld.getPlayer().getLocatieY());
    }

    @Test
    public void beweegSpelerTest() {
        new Speelveld(1);
        int curY = Speelveld.getPlayer().getLocatieY();
        int newX = Speelveld.huidigX()+1;
        Speelveld.beweegPlayerNaar(newX, curY);
        assertEquals(2, Speelveld.getPlayer().getLocatieX());
    }

    @Test
    public void maakEmptyTest() {
        new Speelveld(1);
        Speelveld.beweegPlayerNaar(2, 1);
        assertEquals("src/img/Background_tile.png", Speelveld.getVeldItem(1, 1).getImageURL());
    }
}