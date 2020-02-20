package game;

public class Muur extends VeldItem{

    private String message;

    /**
     * @param imageURL uitgelegd in de superclass.
     */
    public Muur(String imageURL){
        super(imageURL);
    }

    /**
     * Return altijd false omdat de speler nooit door muren of op muren hoort te lopen
     *
     * @param player
     * @return false
     */
    @Override
    public boolean isBeloopbaar(Player player){
        System.out.println("Muren zijn niet beloopbaar");
        return false;
    }

    @Override
    public String getMessage(Player player) {
        return "Muren zijn niet beloopbaar";
    }
}
