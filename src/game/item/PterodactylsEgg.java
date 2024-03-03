package game.item;

import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Location;
import game.actor.Pterodactyls;
import game.actor.Stegosaur;

public class PterodactylsEgg extends Egg implements Purchaseable{
    private int turn=0;
    private static final int HATCH_TIME=50;
    private GameMap map;
    private final int EcoPointValue=200;

    /**
     * @param map map the location of the egg
     */
    public PterodactylsEgg(GameMap map) {
        super('p',10, map);
    }

    @Override
    public void tick(Location location){
        turn++;
        boolean onGround = (PortableItem.getItemLocation(map,this)!=null);
        if (turn>=HATCH_TIME && onGround){
            location.removeItem(this);
            Pterodactyls p = new Pterodactyls("new baby",0);
            p.setHitPoints(10);
        }
    }

    @Override
    public int getEcoPointsValue() {
        return EcoPointValue;
    }
}
