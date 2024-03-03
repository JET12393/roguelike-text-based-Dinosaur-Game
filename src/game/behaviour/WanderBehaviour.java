package game.behaviour;

import edu.monash.fit2099.engine.*;
import game.action.EatAction;
import game.actor.Dinosaur;
import game.item.Food;
import game.item.PortableItem;

import java.util.ArrayList;
import java.util.Random;

public class WanderBehaviour implements Behaviour {
	
	private Random random = new Random();


	/**
	 * Returns a MoveAction to wander to a random location, if possible.  
	 * If no movement is possible, returns null.
	 * 
	 * @param actor the Actor enacting the behaviour
	 * @param map the map that actor is currently on
	 * @return an Action, or null if no MoveAction is possible
	 */
	@Override
	public Action getAction(Actor actor, GameMap map) {
		ArrayList<Action> actions = new ArrayList<Action>();

		Food food = getFoodInTile(actor,map);
		if (food!=null){
			return new EatAction(food);
		}
		Item food1 = getClosestFood(actor,map);
		if (food1 != null) {
			Location starting = map.locationOf(actor);
			Location target = PortableItem.getItemLocation(map, food1);
			return FollowBehaviour.getMoveActionToFood(actor,starting,target);
		}

		for (Exit exit : map.locationOf(actor).getExits()) {
            Location destination = exit.getDestination();
            if (destination.canActorEnter(actor)) {
            	actions.add(exit.getDestination().getMoveAction(actor, "around", exit.getHotKey()));
            }
        }
		
		if (!actions.isEmpty()) {
			return actions.get(random.nextInt(actions.size()));
		}
		else {
			return null;
		}

	}
	public Food getFoodInTile(Actor actor, GameMap map) {

		Location here = map.locationOf(actor);
		for (Item item: here.getItems()) {
			if (((Dinosaur) actor).foodSource.contains(item)) {
				return (Food) item;
			}
		}

		return null;
	}

	public Item getClosestFood(Actor actor, GameMap map){
		Location location = map.locationOf(actor);
		Item food = null;
		int minimumDistance = 100;
		for (int y: map.getYRange()) {
			for (int x: map.getXRange()) {
				Location foodLocation = map.at(x, y);
				int distance = FollowBehaviour.distance(location, foodLocation);
				for (Item item: foodLocation.getItems()) {
					if (((Dinosaur)(actor)).foodSource.contains(item) && distance < minimumDistance) {
						minimumDistance = distance;
						food = item;
					}
				}
			}
		}
		return food;
	}


}
