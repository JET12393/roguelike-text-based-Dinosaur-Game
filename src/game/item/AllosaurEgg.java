package game.item;

import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Location;
import game.actor.Allosaur;


public class AllosaurEgg extends Egg implements Purchaseable{
    private int turn=0;
    private static final int HATCH_TIME=50;
    private GameMap map;
    private final int EcoPointValue=1000;

    /**
     * constructor
     * @param map  the location of the egg
     */
    public AllosaurEgg(GameMap map) {
        super('a',10, map);
        this.map=map;
    }

    @Override
    public void tick(Location location){
        turn++;
        boolean onGround= (PortableItem.getItemLocation(map,this)!=null);
        if (turn>=HATCH_TIME && onGround){
            location.removeItem(this);
            Allosaur a= new Allosaur("baby",0);
            a.setHitPoints(20);
            EcoPoints.setEcoPoints(1000);
        }

    }

    @Override
    public int getEcoPointsValue() {
        return EcoPointValue;
    }
}