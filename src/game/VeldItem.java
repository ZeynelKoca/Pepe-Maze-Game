package game;

import javax.swing.*;

public abstract class VeldItem {

    private String message;
    private String imageURL;
    private JLabel label;

    /**
     * @param imageURL is de locatie van het gewenste image (bijv: "src/img/Imagefile.png")
     */
    public VeldItem(String imageURL){
        this.imageURL = imageURL;
        this.message = " ";
    }

    public boolean isBeloopbaar(Player player){
        return true;
    }

    public String getImageURL() {
        return imageURL;
    }

    /**
     * Voert een actie uit wanneer de player op een object wilt gaan staan, of op staat. Deze acties verschillen per
     * object, lees hier meer over in de subclasses waar deze methode wordt @Overridden.
     *
     * @param player
     */
    public void uitvoeren(Player player){
    }

    public JLabel getLabel() {
        return label;
    }

    /**
     * Melding wanneer de speler een beweging maakt die kan worden uitgevoerd.
     * Deze wordt overschreven in 'Muur' en in 'Barricade'.
     * @param player
     * @return
     */
    public String getMessage(Player player) {
        return message;
    }

    /**
     * Bindt een image label aan een VeldItem object
     *
     * @param image is een JLabel die gevuld is met een ImageIcon
     */
    public void setLabel(JLabel image) {
        this.label = image;
    }
}
