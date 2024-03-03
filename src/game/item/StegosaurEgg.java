package game.item;

import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Item;
import edu.monash.fit2099.engine.Location;
import game.actor.Player;
import game.actor.Stegosaur;

public class StegosaurEgg extends Egg implements Purchaseable{
    private int turn=0;
    private static final int HATCH_TIME=50;
    private GameMap map;
    private final int EcoPointValue=200;

    /**
     * constructor
     * @param map  the location of the egg
     */
    public StegosaurEgg(GameMap map) {
        super('B', 10, map);
        this.map=map;
    }

    @Override
    public void tick(Location location){
        turn++;
        boolean onGround= (PortableItem.getItemLocation(map,this)!=null);
        if (turn>=HATCH_TIME && onGround) {
            location.removeItem(this);
            Stegosaur s = new Stegosaur("new baby", 0);
            s.setHitPoints(10);
            EcoPoints.addEcoPoints(100);
        }

    }

    @Override
    public int getEcoPointsValue() {
        return EcoPointValue;
    }
}
