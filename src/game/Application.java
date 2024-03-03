package game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Display;
import edu.monash.fit2099.engine.FancyGroundFactory;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.World;
import game.actor.*;
import game.ground.*;

/**
 * The main class for the Jurassic World game.
 *
 */
public class Application {
	private static ArrayList<GameMap> gameMaps= new ArrayList<GameMap>();

	public static ArrayList<GameMap> getGameMaps() {
		return new ArrayList<>(gameMaps);
	}

	public void runApplication() {
		World world = new World(new Display());

		FancyGroundFactory groundFactory = new FancyGroundFactory(new Dirt(), new Wall(), new Floor(), new Tree(), new Lake());
		
		List<String> map = Arrays.asList(
		"................................................................................",
		"....................................................................~...........",
		".....#######....................................................................",
		".....#_____#....................................................................",
		".....#_____#....................................................................",
		".....###.###....................................................................",
		"................................................................................",
		"......................................+++.......................................",
		".......................................++++.....................................",
		"...................................+++++........................................",
		".....................................++++++.....................................",
		"......................................+++.......................................",
		".....................................+++........................................",
		"................................................................................",
		"............+++.................................................................",
		".............+++++..............................................................",
		"...............++........................................+++++..................",
		".............+++....................................++++++++....................",
		"............+++.......................................+++.......................",
		"................................................................................",
		".........................................................................++.....",
		"........................................................................++.++...",
		".....................~...................................................++++...",
		"..........................................................................++....",
		"................................................................................");
		GameMap gameMap = new GameMap(groundFactory, map );
		world.addGameMap(gameMap);
		gameMaps.add(gameMap);
		
		Actor player = new Player("Player", '@', 100);
		//world.addPlayer(player, gameMap.at(9, 4));
		world.addPlayer(player, gameMap.at(29, 2));
		// Place a pair of stegosaurs in the middle of the map
		gameMap.at(30, 12).addActor(new Stegosaur("Stegosaur",Gender.FEMALE,50));
		gameMap.at(32, 12).addActor(new Stegosaur("Stegosaur",Gender.MALE,50));
		
		// place a vending machine in map
		gameMap.at(35,11).setGround(new VendingMachine());

		// place brachiosaurs in map
		gameMap.at(21,10).addActor(new Brachiosaur("Brachiosaur",Gender.MALE,100));
		gameMap.at(25,15).addActor(new Brachiosaur("Brachiosaur",Gender.MALE,100));
		gameMap.at(20,10).addActor(new Brachiosaur("Brachiosaur",Gender.FEMALE,100));
		gameMap.at(25,14).addActor(new Brachiosaur("Brachiosaur",Gender.FEMALE,100));
		gameMap.at(31,12).addActor(new Allosaur("Allosaur",Gender.MALE,100));
		gameMap.at(70,2).addActor(new Pterodactyls("Pt",Gender.FEMALE,100));

		List<String> map2 = Arrays.asList(
				"................................................................................",
				"................................................................................",
				".....#######....................................................................",
				".....#_____#....................................................................",
				".....#_____#....................................................................",
				".....###.###....................................................................",
				"................................................................................",
				".......~..............................+++.......................................",
				".......................................++++.....................................",
				"...................................+++++........................................",
				".....................................++++++.....................................",
				"......................................+++.......................................",
				".....................................+++...............................~........",
				"................................................................................",
				"............+++.................................................................",
				".............+++++..............................................................",
				"...............++........................................+++++..................",
				".............+++....................................++++++++....................",
				"............+++.......................................+++.......................",
				"................................................................................",
				".........................................................................++.....",
				"........................................................................++.++...",
				".........................................................................++++...",
				"..........................................................................++....",
				"................................................................................");
		GameMap gameMap2 = new GameMap(groundFactory, map2);
		world.addGameMap(gameMap2);
		gameMaps.add(gameMap2);

		world.run();
	}
}