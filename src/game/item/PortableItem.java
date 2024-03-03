package game.item;

import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Ground;
import edu.monash.fit2099.engine.Item;
import edu.monash.fit2099.engine.Location;

/**
 * Base class for any item that can be picked up and dropped.
 */
public class PortableItem extends Item {

	public PortableItem(String name, char displayChar) {
		super(name, displayChar, true);
	}

	public static Location getItemLocation(GameMap map, Item item) {
		for (int y : map.getYRange()) {
			for (int x : map.getXRange()) {
				if (map.at(x, y).getItems().contains(item)) {
					return map.at(x, y);
				}
			}
		}
		return null;
	}


}
