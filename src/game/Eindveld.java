package game;

public class Eindveld extends VeldItem {

    public static boolean eindeBereikt = false;

    /**
     * @param imageURL uitgelegd in de superclass.
     */
    public Eindveld(String imageURL) {
        super(imageURL);
    }

    /**
     * @return true of false
     */
    public static boolean isEindeBereikt() {
        return eindeBereikt;
    }

    /**
     * Wanneer de player op dit object loopt, wordt deze methode uitgevoerd en wordt de variabele eindeBereikt op true gezet.
     *
     * @param player
     */
    @Override
    public void uitvoeren(Player player) {
        eindeBereikt = true;
    }
}
