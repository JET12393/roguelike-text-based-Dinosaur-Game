package game.behaviour;

import edu.monash.fit2099.engine.*;
import game.action.AttackAction;
import game.action.EatAction;
import game.actor.Stegosaur;
import game.item.Food;

import java.util.ArrayList;
import java.util.Random;

public class FierceBehaviour extends WanderBehaviour{

    /**
     * method to check if there's stegosaur for allosaur to attack
     * @param actor the allosaur to execute attack
     * @param map the map that allosaur is on
     * @return stegosaur that can be attacked
     */
    public Actor getAttackable(Actor actor,GameMap map){
        for (Exit exit: map.locationOf(actor).getExits()){
            Location target=exit.getDestination();
            if (target.containsAnActor() && target.getActor() instanceof Stegosaur){
                return target.getActor();
            }
        }
        return null;
    }

    /**
     *
     * @param actor the allosaur acting
     * @param map the GameMap containing the Actor
     * @return
     */
    @Override
    public Action getAction(Actor actor, GameMap map) {
        Actor target=getAttackable(actor,map);
        Food food = getFoodInTile(actor, map);
        if (food != null) {
            return new EatAction(food);
        }
        else if (target!=null){
            return new AttackAction(target);
        }
        else {
            //copy from wander behaviour to wander to a random location if possible
            Random random = new Random();
            ArrayList<Action> actions = new ArrayList<Action>();

            for (Exit exit : map.locationOf(actor).getExits()) {
                Location destination = exit.getDestination();
                if (destination.canActorEnter(actor)) {
                    actions.add(exit.getDestination().getMoveAction(actor, "around", exit.getHotKey()));
                }
            }

            if (!actions.isEmpty()) {
                return actions.get(random.nextInt(actions.size()));
            } else {
                return null;
            }
        }

    }


}
