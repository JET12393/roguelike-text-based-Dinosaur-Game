package game.actor;

import edu.monash.fit2099.engine.*;
import game.Application;
import game.GameDriver;
import game.action.TerminateGameAction;
import game.action.WinAction;
import game.item.EcoPoints;

import java.util.Collections;
import java.util.List;

/**
 * Class representing the Player.
 */
public class Player extends Actor {

	private Menu menu = new Menu();
	private int turn = 0;
	/**
	 * Constructor.
	 *
	 * @param name        Name to call the player in the UI
	 * @param displayChar Character to represent the player in the UI
	 * @param hitPoints   Player's starting number of hitpoints
	 */
	public Player(String name, char displayChar, int hitPoints) {
		super(name, displayChar, hitPoints);
		//EcoPoints.setEcoPoints(5000000);
	}

	@Override
	public Action playTurn(Actions actions, Action lastAction, GameMap map, Display display) {
		turn++;
		// to display the ecopoints and turn, as well as checking the win condition
		Display display1= new Display();
		display1.println("Current EcoPoints : " +EcoPoints.getEcoPoints() + " & Current turn : " + turn);
		if (GameDriver.isChallenge()) {
			if (EcoPoints.getEcoPoints() >= GameDriver.getEcoPointsGoal() && turn <= GameDriver.getTurnLimit()) {
				return new WinAction(true);
			}
			else if (turn > GameDriver.getTurnLimit()){
				return new WinAction(false);
			}
		}

		// Handle multi-turn Actions
		//to allow game termination each turn
		actions.add(new TerminateGameAction());
		if (lastAction.getNextAction() != null)
			return lastAction.getNextAction();
		//for crossing maps
		Location bottomOfMap2 = Application.getGameMaps().get(1).at(map.locationOf(this).x(),24);
		Location topOfMap1 = Application.getGameMaps().get(0).at(map.locationOf(this).x(), 0);
		if (map==Application.getGameMaps().get(0) && map.locationOf(this).y()==0 && bottomOfMap2.getGround().canActorEnter(this)){
			actions.add(new MoveActorAction(bottomOfMap2,"to second Park!","8"));
		}
		else if (map==Application.getGameMaps().get(1) && map.locationOf(this).y()== 24 && topOfMap1.getGround().canActorEnter(this)){
			actions.add(new MoveActorAction(topOfMap1,"to first Park!","2"));
		}
		return menu.showMenu(this, actions, display);
	}

	@Override
	public List<Item> getInventory() {
		return Collections.unmodifiableList(inventory);
	}
}
