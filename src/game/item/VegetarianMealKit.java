package game.item;

/**
 * Class for VegetarianMealKit
 */
public class VegetarianMealKit extends Food implements Purchaseable{
    private final int EcoPointValue=100;

    /**
     * constructor for VegetarianMealKit
     *
     */
    public VegetarianMealKit() {
        super("Vegetarian Meal Kit",'v',100);

    }


    @Override
    public int getEcoPointsValue() {
        return EcoPointValue;
    }
}
