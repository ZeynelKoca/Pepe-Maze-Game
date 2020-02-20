package game;

public class Barricade extends VeldItem {

    private int barricadeNr;
    private String message;

    /**
     * @param imageURL uitgelegd in de superclass.
     * @param n        int nummer. Deze moet het zelfde zijn als de sleutel die bij deze barricade hoort.
     */
    public Barricade(String imageURL, int n) {
        super(imageURL);
        this.barricadeNr = n;
    }

    /**
     * Kijkt eerst of de player een sleutel bezit in zijn zak, zoja; dan kijkt het of de nummer 'n' van de
     * sleutel het zelfde is als de nummer 'n' van de barricade. Als deze het zelfde zijn, return true.
     * Als de player geen sleutel heeft of de verkeerde sleutel heeft, komt er respectievelijk een melding in de
     * terminal en ook return false.
     *
     * @param player
     * @return true of false
     */
    @Override
    public boolean isBeloopbaar(Player player) {
        if (player.getSleutel() != null && player.getSleutel().getSleutelNr() == barricadeNr) {
            return true;
        } else if (player.getSleutel() == null) {
            System.out.println("Je hebt geen sleutel");
            return false;
        } else {
            System.out.println("Verkeerde sleutel");
            return false;
        }
    }

    public String getMessage(Player player) {
        if (player.getSleutel() == null) {
            return "Je hebt geen sleutel";
        }
        if (player.getSleutel().getSleutelNr() != barricadeNr) {
            return "Verkeerde sleutel";
        }
        return " ";
    }
}