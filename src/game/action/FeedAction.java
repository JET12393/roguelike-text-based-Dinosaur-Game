package game.action;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import game.actor.Dinosaur;
import game.item.EcoPoints;
import game.item.Food;
import game.item.Fruit;

public class FeedAction extends Action {
    private Dinosaur target;
    private Food food;
    public FeedAction(Dinosaur target, Food food){
        this.target=target;
        this.food=food;
    }

    /**
     *
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return string describing the action
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        actor.removeItemFromInventory(this.food);
        target.heal(food.getEnergyReplenish());
        if (food instanceof Fruit){
            EcoPoints.addEcoPoints(10);
        }
        return menuDescription(actor);
    }

    /**
     *
     * @param actor The actor performing the action.
     * @return string
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor +" feeds " +target;
    }
}
