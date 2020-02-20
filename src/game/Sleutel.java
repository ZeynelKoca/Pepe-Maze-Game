package game;

public class Sleutel extends VeldItem {

    private int sleutelNr;

    /**
     * @param imageURL uitgelegd in de superclass.
     * @param n int nummer. Deze moet het zelfde zijn als de barricade die bij deze sleutel hoort.
     */
    public Sleutel(String imageURL, int n) {
        super(imageURL);
        this.sleutelNr = n;
    }

    /**
     * @return de nummer 'n' die in de constructor is aangegeven.
     */
    public int getSleutelNr() {
        return sleutelNr;
    }

    /**
     * Wanneer de player op dit object loopt, wordt deze methode uitgevoerd en wordt dit Sleutel Object
     * in de player class gezet zodat de player weet welke sleutel hij bezit.
     *
     * @param player
     */
    public void uitvoeren(Player player) {
        player.pakSleutel(this);
    }
}
