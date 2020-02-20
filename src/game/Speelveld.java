package game;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Speelveld {

    private Frame frame;
    private static Player player;
    private Levels level;
    private static int huidigLevelNr;
    private static final VeldItem[][] EMPTY_ARRAY = new VeldItem[0][0];
    private static VeldItem[][] huidigLevelObj;

    /**
     * @param level is het level nummer dat moet worden aangemaakt.
     */
    public Speelveld(int level) {
        huidigLevelNr = level;
        this.level = new Levels();
        this.huidigLevelObj = new VeldItem[11][11];
        maakObjMap(this.level.getLevel(level));
        frame = new Frame();
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    /**
     * Gaat voor elke coordinaat in @param level langs en kijkt welk nummer er staat. Voor elk nummer wordt
     * respectievelijk een nieuw object aangemaakt dat overeenkomt met de afgesproken nummers (Deze zijn bovenin
     * de Levels class als commentaar weergegeven)
     * <p>
     * Voor de sleutels en barricades worden naast de objecten ook nummers weergegeven. Waar deze voor nodig
     * zijn wordt verder beschreven in de 'uitvoeren' methode in de Barricade class.
     * <p>
     * Bij het Player object moeten ook twee nummers worden weergegeven. Dit zullen de coordinaten zijn waar in
     * het level de player zal worden aangemaakt. Voor ons blijft die positie altijd hetzelfde; op (1, 1).
     *
     * @param level is een van de levels die in de class Levels staat.
     */
    public void maakObjMap(int[][] level) {
        for (int i = 0; i < level.length; i++) {
            for (int j = 0; j < level.length; j++) {
                if (level[i][j] == 0) {
                    this.huidigLevelObj[i][j] = new Empty("src/img/Background_tile.png");
                } else if (level[i][j] == 1) {
                    this.huidigLevelObj[i][j] = new Barricade("src/img/Blue_Barricade.jpg", 1);
                } else if (level[i][j] == 2) {
                    this.huidigLevelObj[i][j] = new Sleutel("src/img/Blue_Stone.png", 1);
                } else if (level[i][j] == 3) {
                    this.huidigLevelObj[i][j] = new Eindveld("src/img/Gauntlet.gif");
                } else if (level[i][j] == 4) {
                    this.huidigLevelObj[i][j] = new Barricade("src/img/Green_Barricade.png", 2);
                } else if (level[i][j] == 5) {
                    this.huidigLevelObj[i][j] = new Sleutel("src/img/Green_Stone.png", 2);
                } else if (level[i][j] == 6) {
                    this.huidigLevelObj[i][j] = player = new Player("src/img/Pepe.gif", 1, 1);
                } else if (level[i][j] == 7) {
                    this.huidigLevelObj[i][j] = new Barricade("src/img/Red_Barricade.png", 3);
                } else if (level[i][j] == 8) {
                    this.huidigLevelObj[i][j] = new Sleutel("src/img/Red_Stone.png", 3);
                } else if (level[i][j] == 9) {
                    this.huidigLevelObj[i][j] = new Muur("src/img/Wall.jpg");
                }
            }
        }
    }

    /**
     * @return het level nummer (dus 1, 2, 3 etc.)
     */
    public static int getHuidigLevelNr() {
        return huidigLevelNr;
    }

    /**
     * @return de 2d array van VeldItem waarin alle aangemaakte objecten in volgorde van positie staan.
     */
    public static VeldItem[][] getHuidigLevelObj() {
        return huidigLevelObj;
    }

    /**
     * @return huidige X locatie van de Player.
     */
    public static int huidigX() {
        return player.getLocatieX();
    }

    /**
     * @return huidige Y locatie van de Player.
     */
    public static int huidigY() {
        return player.getLocatieY();
    }

    /**
     * @param newX is de X coordinaat
     * @param newY is de Y coordinaat
     * @return welk object er staat in de 2d array 'huidigLevelObj' op de positie van (newX, newY)
     */
    public static VeldItem getVeldItem(int newX, int newY) {
        return huidigLevelObj[newX][newY];
    }

    /**
     * @return Object player
     */
    public static Player getPlayer() {
        return player;
    }

    /**
     * Bindt in de 2d array 'huidigLevelObj' aan elk object een image per coordinaat (i, j).
     *
     * @param image is de JLabel met daarop een ImageIcon (dit moet op een JLabel worden geplaatst anders geeft het errors)
     * @param i
     * @param j
     */
    public static void addLabel(JLabel image, int i, int j) {
        huidigLevelObj[i][j].setLabel(image);
    }

    /**
     * Maakt een nieuwe player image aan en plaatst deze op een tegel op het coordinaat (newX, newY)
     * Op het oude (of huidige) coordinaat wordt een nieuw Empty Object aangemaakt. Dit is gewoon een loopveld.
     *
     * @param newX is de bestemmings X coordinaat
     * @param newY is de bestemmings Y coordinaat
     */
    public static void beweegPlayerNaar(int newX, int newY) {
        int curX = player.getLocatieX();
        int curY = player.getLocatieY();
        JLabel oldLbl = player.getLabel();
        JLabel newLbl = huidigLevelObj[newY][newX].getLabel();
        maakNieuwPlayer(newLbl, newX, newY);
        maakHuidigEmpty(oldLbl, curX, curY);
    }

    /**
     * @param lbl is een image, maar dit moet als een ImageIcon op een JLabel worden geplaatst om errors te voorkomen.
     * @param x   is de bestemmings X coordinaat
     * @param y   is de bestemmings Y coordinaat
     */
    private static void maakNieuwPlayer(JLabel lbl, int x, int y) {
        lbl.setIcon(player.getLabel().getIcon());
        player.setLabel(lbl);
        player.setNieuweLocatie(x, y);
        huidigLevelObj[y][x] = player;
    }

    /**
     * @param lbl  is een image, maar dit moet als een ImageIcon op een JLabel worden geplaatst om errors te voorkomen.
     * @param curX is het huidige X coordinaat
     * @param curY is het huidige Y coordinaat
     */
    private static void maakHuidigEmpty(JLabel lbl, int curX, int curY) {
        lbl.setIcon((new ImageIcon(new ImageIcon("src/img/Background_tile.png").getImage().getScaledInstance(80, 79, Image.SCALE_DEFAULT))));
        VeldItem item = new Empty("src/img/Background_tile.png");
        item.setLabel(lbl);
        huidigLevelObj[curY][curX] = item;
    }
}