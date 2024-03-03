package game.action;

import edu.monash.fit2099.engine.*;
import game.actor.Allosaur;
import game.actor.Brachiosaur;
import game.actor.Pterodactyls;
import game.actor.Stegosaur;


public class DeathAction extends Action {


    /**
     *
     * @param actor The actor performing the action, the dinosaur dies
     * @param map The map the actor is on.
     * @return
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        Location location = map.locationOf(actor);
        map.removeActor(actor);

        return menuDescription(actor);


    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + "is dead!!! ";
    }
}
