package game.behaviour;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import game.action.DeathAction;
import game.action.StarvingAction;
import game.actor.Dinosaur;

public class UnconsciousBehaviour implements Behaviour{
    @Override
    public Action getAction(Actor actor, GameMap map) {
        Dinosaur dino= (Dinosaur) actor;
        if (dino.getDeathTurn()>=dino.getUnconsciousLimit()){
            return new DeathAction();
        }
        else{
            return new StarvingAction();
        }
    }
}
