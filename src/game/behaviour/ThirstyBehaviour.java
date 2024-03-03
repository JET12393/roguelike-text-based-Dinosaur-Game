package game.behaviour;

import edu.monash.fit2099.engine.*;
import game.action.DrinkAction;
import game.actor.Dinosaur;
import game.ground.Lake;

public class ThirstyBehaviour implements Behaviour{
    @Override
    public Action getAction(Actor actor, GameMap map) {
        Location myLocation = map.locationOf(actor);
        for (Exit exit: myLocation.getExits()) {
            if (exit.getDestination().getGround() instanceof Lake) {
                return new DrinkAction();
            }
        }
        Location target = getNearestWaterTile(map, (Dinosaur) actor);
        int currentDistance = FollowBehaviour.distance(myLocation, target);
        for (Exit exit : myLocation.getExits()) {
            Location destination = exit.getDestination();
            if (destination.canActorEnter(actor)) {
                int newDistance = FollowBehaviour.distance(destination, target);
                if (newDistance < currentDistance) {
                    return new MoveActorAction(destination, exit.getName());
                }
            }
        }
        return new DoNothingAction();
    }

    /**
     * Returns the location of the nearest water tile
     * @param map the map that the actor is in
     * @param actor the actor that we are finding the nearest water tile for
     * @return location of nearest water tile. Throws assertion error if there are none
     */
    public Location getNearestWaterTile(GameMap map, Dinosaur actor) {
        Location actorLocation = map.locationOf(actor);
        Location res = null;
        int minimumDistance = map.getXRange().max();
        for (int y: map.getYRange()) {
            for (int x: map.getXRange()) {
                Location myLocation = map.at(x, y);
                if (myLocation.getGround() instanceof Lake) {
                    int distance = FollowBehaviour.distance(actorLocation, myLocation);
                    if (distance < minimumDistance) {
                        minimumDistance = distance;
                        res = myLocation;
                    }
                }
            }
        }
        return res;
    }
}
