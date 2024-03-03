package game.ground;

import edu.monash.fit2099.engine.Exit;
import edu.monash.fit2099.engine.Ground;
import edu.monash.fit2099.engine.Location;

import java.util.List;

/**
 * A class that represents bare dirt.
 */
public class Dirt extends Ground {

	public Dirt() {
		super('.');
	}

	/**
	 * dirt can also experience the joy of time.
	 * @param location The location of the Ground
	 */
	@Override
	public void tick(Location location){
		super.tick(location);
		DirtToBush(location);
	}


	/**
	 * use random number generator to obtain chance for dirt to become bush
	 * perform comparison between chance obtained by random number generator and actual chance
	 * call growbush() method to create bush once condition satisfies
	 * @param location location of the dirt
	 */
	public void DirtToBush(Location location){
		final double DIRT_CHANCE = 0.01;
		final double NEXT_TO_TWO_BUSH = 0.1;
		final int NEXT_TO_TREE=0;
		double actualChance=DIRT_CHANCE;

		int bushCount=0;
		List<Exit> Exits =location.getExits();
		for (int i=0;i<Exits.size();i++){
			Ground nextToGround=location.getExits().get(i).getDestination().getGround();
			if (nextToGround instanceof Bush){
				bushCount++;
			}
		}
		if (bushCount>=2){
			actualChance=NEXT_TO_TWO_BUSH;
		}
		for (int i=0;i<Exits.size();i++){
			Ground nextToGround=location.getExits().get(i).getDestination().getGround();
			if (nextToGround instanceof Tree){
				actualChance=NEXT_TO_TREE;
			}
		}

		double randomChance=Math.random();
		if (randomChance<=actualChance){
			growBush(location);
		}
	}


	/**
	 * create bush and set the location of that dirt to bush
	 * @param location the location of dirt that will become bush
	 */
	public void growBush(Location location){
		Bush bush = new Bush();
		location.setGround(bush);
	}
}
