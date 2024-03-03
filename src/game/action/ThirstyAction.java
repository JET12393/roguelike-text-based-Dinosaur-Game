package game.action;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import game.actor.Dinosaur;

public class ThirstyAction extends Action {
    /**
     *
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return string describing the action
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        return menuDescription(actor);
    }

    /**
     *
     * @param actor The actor performing the action.
     * @return string
     */
    @Override
    public String menuDescription(Actor actor) {
        Dinosaur dino=(Dinosaur) actor;
        return actor +" is getting thirsty!";
    }
}
