package game.item;

import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Location;

/**
 * class for Egg
 */
public abstract class Egg extends Food {

    private int turn=0;
    private final int hatchTime=50;
    private final GameMap map;

    /**
     * @param displayChar     display char of food
     * @param energyReplenish amount of energy replenish after eating the food
     * @param map the location of the egg
     */
    public Egg(char displayChar,int energyReplenish,GameMap map) {
        super("Egg", displayChar, energyReplenish);
        this.map=map;
    }

    @Override
    public void tick(Location location){
        turn++;
    }
}
