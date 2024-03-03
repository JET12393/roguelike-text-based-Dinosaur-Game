package game.item;

/**
 * class for CarnivoreMealKit
 */
public class CarnivoreMealKit extends Food implements Purchaseable{
    private final int EcoPointValue=500;
    /**
     * Constructor for CarnivoreMealKit
     *
     *
     */
    public CarnivoreMealKit() {
        super("Carnivore Meal Kit", 'c',100);

    }

    @Override
    public int getEcoPointsValue() {
        return EcoPointValue;
    }
}
