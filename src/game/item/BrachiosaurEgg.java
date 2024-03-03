package game.item;

import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Location;
import game.actor.Brachiosaur;

public class BrachiosaurEgg extends Egg implements Purchaseable{
    private int turn=0;
    private static final int HATCH_TIME=50;
    private GameMap map;
    private final int EcoPointValue=500;

    /**
     * constructor
     * @param map  the location of the egg
     */
    public BrachiosaurEgg(GameMap map) {
        super('b',10, map);
        this.map=map;
    }

    @Override
    public void tick(Location location){
        turn++;
        boolean onGround= (PortableItem.getItemLocation(map,this)!=null);
        if (turn>=HATCH_TIME && onGround){
            location.removeItem(this);
            Brachiosaur b= new Brachiosaur("baby dino",0);
            b.setHitPoints(10);
            EcoPoints.addEcoPoints(1000);
        }
    }

    @Override
    public int getEcoPointsValue() {
        return EcoPointValue;
    }
}