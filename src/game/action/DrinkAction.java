package game.action;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Location;
import game.actor.Allosaur;
import game.actor.Brachiosaur;
import game.actor.Dinosaur;
import game.actor.Stegosaur;
import game.ground.Lake;
import game.item.PortableItem;

public class DrinkAction extends Action {

    @Override
    public String execute(Actor actor, GameMap map){
        Location location = Lake.getLakeLocation();

        if (location!=null){
            if (actor instanceof Brachiosaur) {
                if ((((Brachiosaur) actor).getWaterLevel())+80 <= 200) {
                    ((Brachiosaur) actor).setWaterLevel(((Brachiosaur) actor).getWaterLevel() + 80);
                }
                else{
                    ((Brachiosaur) actor).setWaterLevel(200);
                }
            }
            else if (actor instanceof Allosaur || actor instanceof Stegosaur){
                if ((((Dinosaur) actor).getWaterLevel())+30 <= 200) {
                    ((Brachiosaur) actor).setWaterLevel(((Brachiosaur) actor).getWaterLevel() + 30);
                }
                else{
                    ((Brachiosaur) actor).setWaterLevel(200);
                }
            }
        }
        return menuDescription(actor);
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " drinks water";
    }
}
