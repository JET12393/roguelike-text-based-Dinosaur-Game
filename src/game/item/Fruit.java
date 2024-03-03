package game.item;

import edu.monash.fit2099.engine.*;
import edu.monash.fit2099.engine.Location;

public class Fruit extends Food implements Purchaseable{
    private int turn;
    private GameMap gameMap;
    public static final int EcoPointValue = 30;

    public Fruit(GameMap map){
        super("Fruit",'f',10);
        this.turn=0;
        this.gameMap=map;
    }


    /**
     * fruit experience the joy of time
     * @param location
     */
    @Override
    public void tick(Location location){
        this.turn++;
        if (this.turn>15){
            fruitRot();
        }
    }

    /**
     * method for the fruit to rot
     */
    public void fruitRot(){
        Location location =getItemLocation(gameMap,this);
        if (location!=null){
            location.removeItem(this);
        }
    }


    @Override
    public int getEcoPointsValue() {
        return EcoPointValue;
    }
}
