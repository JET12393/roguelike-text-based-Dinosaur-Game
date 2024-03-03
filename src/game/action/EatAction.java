package game.action;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Location;
import game.item.Food;
import game.item.PortableItem;

public class EatAction extends Action {
    private Food food;

    public EatAction(Food food){
        this.food=food;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        Location location= PortableItem.getItemLocation(map,this.food);
        if (location!=null){
            location.removeItem(food);
            actor.heal(food.getEnergyReplenish());
        }
        return menuDescription(actor);
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " eats "+ food;
    }
}
