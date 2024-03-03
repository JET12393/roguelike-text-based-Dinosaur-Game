package game.ground;

import edu.monash.fit2099.engine.Ground;
import edu.monash.fit2099.engine.Location;
import game.item.Fruit;

/**
 * class for Bush that grows from Dirt
 */
public class Bush extends Ground {
    private int numFruit=0;
    public Bush() {
        super('b');
    }


    /**
     * this method will get chance from random number generator and compare it with the actual chance to
     * instantiate a ripe fruit
     * @param location The location of the bush
     */
    @Override
    public void tick(Location location){
        super.tick(location);
        double fruitProduceChance= 0.1;
        double chance=Math.random();
        if (chance<=fruitProduceChance){
            Fruit fruit= new Fruit(location.map());
            numFruit++;
        }
    }

    public int getNumFruit(){
        return numFruit;
    }
}
