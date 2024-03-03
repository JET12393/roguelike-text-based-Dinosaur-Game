package game.action;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import game.actor.Dinosaur;
import game.behaviour.PregnantBehaviour;

public class MatingAction extends Action {
    private Dinosaur target;

    public MatingAction(Dinosaur target){
        this.target=target;
    }

    /**
     *
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return string describing the action
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        if (!((Dinosaur)actor).isMale()){
            ((Dinosaur)actor).setBehaviour(new PregnantBehaviour());
        }
        else{
            target.setBehaviour(new PregnantBehaviour());
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
        return actor + " breeds with "+ target;
    }
}
