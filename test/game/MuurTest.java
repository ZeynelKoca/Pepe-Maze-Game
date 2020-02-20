package game;

import org.junit.Test;

import static org.junit.Assert.*;

public class MuurTest {

    @Test
    public void testBeloopbaarheid() {
        Player player = new Player("src/img/Pepe.gif", 1, 1);
        Muur muur = new Muur("src/img/Wall.jpg");
        assertFalse(muur.isBeloopbaar(player));
    }
}
