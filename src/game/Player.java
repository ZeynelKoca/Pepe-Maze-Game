package game;

public class Player extends VeldItem{

    private Sleutel sleutel;
    private int huidigX;
    private int huidigY;

    /**
     * @param imageURL uitgelegd in de superclass.
     * @param x is de X coordinaat waar de Player in het level moet spawnen.
     * @param y is de Y coordinaat waar de Player in het level moet spawnen.
     */
    public Player(String imageURL, int x, int y) {
        super(imageURL);
        huidigX = x;
        huidigY = y;
    }

    /**
     * @return welk Sleutel object de player bezit.
     */
    public Sleutel getSleutel() {
        return sleutel;
    }

    /**
     * @return huidige X locatie van player.
     */
    public int getLocatieX(){
        return huidigX;
    }

    /**
     * @return huidige Y locatie van player
     */
    public int getLocatieY(){
        return huidigY;
    }

    /**
     * Pakt een sleutel op en plaatst deze in het Sleutel object bovenin. Dit wordt telkens overriden waardoor
     * een player niet twee sleutels tegelijk kan hebben.
     *
     * @param sleutel
     */
    public void pakSleutel(Sleutel sleutel) {
        this.sleutel = sleutel;
    }

    /**
     * Verandert de locatie van player. Dit wordt gebruikt wanneer een nieuwe Player wordt aangemaakt
     *
     * @param newX is de bestemmings X coordinaat
     * @param newY is de bestemmings Y coordinaat
     */
    public void setNieuweLocatie(int newX, int newY) {
        this.huidigX = newX;
        this.huidigY = newY;
    }
}
