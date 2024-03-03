package game.item;

/**
 * Class for Food
 */
public abstract class Food extends PortableItem {
    protected int energyReplenish;

    /**
     *
     * @param name name of food
     * @param displayChar display char of food
     * @param energyReplenish amount of energy replenish after eating the food
     */
    public Food(String name, char displayChar,int energyReplenish) {
        super(name, displayChar);
        setEnergyReplenish(energyReplenish);
    }


    /**
     * sets the energy replenish of the food
     * @param energyReplenish amount of energy replenish after eating the food
     */
    public void setEnergyReplenish(int energyReplenish){
        this.energyReplenish=energyReplenish;
    }

    /**
     * gets the amount of energy replenish by the food
     * @return amount of energy replenish
     */
    public int getEnergyReplenish(){
        return energyReplenish;
    }
}
