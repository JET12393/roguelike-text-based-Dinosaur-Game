package game.ground;

import edu.monash.fit2099.engine.Ground;
import edu.monash.fit2099.engine.Location;
import game.item.EcoPoints;
import game.item.Fruit;

public class Tree extends Ground {
	private static Location treeLocation;
	private int age = 0;
	private int numFruit=0;

	public Tree() {
		super('+');
	}

	public static Location getTreeLocation() {
		return treeLocation;
	}

	/**
	 * increase the age of tree each turn and instantiate and drop fruit if chances allowed
	 * @param location The location of the Tree
	 */
	@Override
	public void tick(Location location) {
		super.tick(location);
		this.treeLocation = location;

		age++;
		if (age == 10)
			displayChar = 't';
		if (age == 20)
			displayChar = 'T';

		double fruitProduceChance=0.5;
		double chance=Math.random();
		double fruitDropChance=0.05;
		double actualChance=Math.random();
		if (chance<=fruitProduceChance){
			Fruit fruit= new Fruit(location.map());
			EcoPoints.addEcoPoints(1);
			if (actualChance<=fruitDropChance){
				location.addItem(fruit);
			}
		}
	}

}
