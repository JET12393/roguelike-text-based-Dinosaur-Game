package game.action;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Item;
import game.actor.Player;
import game.item.EcoPoints;
import game.item.Purchaseable;

/**
 * this class is for player to purchase the item from vending machine
 */
public class PurchaseItemAction extends Action {
    Purchaseable item;

    /**
     * constructor
     * @param purchaseable the item to be purchased from vending machine
     */
    public PurchaseItemAction(Purchaseable purchaseable) {
        this.item=purchaseable;
    }


    /**
     *
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return string to show if the action is done
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        Player player=(Player)actor;
        if (item!=null){
            player.addItemToInventory((Item)item);
            EcoPoints.subtractEcoPoints(item.getEcoPointsValue());
        }
        return menuDescription(actor);
    }

    @Override
    public String menuDescription(Actor actor) {
        String ret="";
        return ret+= actor + " successfully bought: "+ item.toString();
    }
}
