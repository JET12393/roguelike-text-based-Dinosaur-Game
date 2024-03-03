package game.behaviour;

import edu.monash.fit2099.engine.*;
import game.actor.Dinosaur;
import game.ground.Tree;

public class PregnantBehaviour implements Behaviour{
    /**
     *
     * @param actor the Actor that is pregnant
     * @param map the GameMap containing the Actor
     * @return a random action
     */
    @Override
    public Action getAction(Actor actor, GameMap map) {
        Dinosaur dino= (Dinosaur) actor;
        //Stegosaur or Brachiosaur or Allosaur
        if (dino.getDisplayChar()=='S' || dino.getDisplayChar()=='B' || dino.getDisplayChar()=='A') {
            if (dino.getPregnancyTurnCount() == dino.getPREGNANCY_TURN()) {
                dino.setPregnancyTurnCount(0);
                Location dinosaurGround = map.locationOf(actor);
                dinosaurGround.addItem(dino.layEgg(map));
            }
        }
        //Pterodactyls
        else{
            if (dino.getPregnancyTurnCount() == dino.getPREGNANCY_TURN() && map.locationOf(dino)==Tree.getTreeLocation()) {
                dino.setPregnancyTurnCount(0);
                Location dinosaurGround = map.locationOf(actor);
                dinosaurGround.addItem(dino.layEgg(map));
            }
        }
        return new DoNothingAction();
    }
}
