package game.actor;


import edu.monash.fit2099.engine.*;
import game.action.AttackAction;
import game.action.DeathAction;
import game.behaviour.Behaviour;
import game.Gender;
import game.behaviour.MatingBehaviour;
import game.behaviour.UnconsciousBehaviour;
import game.behaviour.WanderBehaviour;
import game.item.*;

import java.util.ArrayList;

/**
 * A herbivorous dinosaur.
 *
 */
public class Stegosaur extends Dinosaur {
	// Will need to change this to a collection if Stegosaur gets additional Behaviours.
	private Behaviour behaviour;
	//private ArrayList <Class<?>> foodSource= new ArrayList<Class<?>>();
	private final int UNCONSCIOUS_LIMIT=20;
	public static final Behaviour STEGOSAUR_DEFAULT_BEHAVIOUR = new WanderBehaviour();


	/** 
	 * Constructor, random gender
	 * All Stegosaurs are represented by a 'd' and have 100 hit points.
	 * 
	 * @param name the name of this Stegosaur
	 */
	public Stegosaur(String name,int currentAge) {
		super("Stegosaur",'S',100,100,10,30,20,200,15, 50, currentAge, STEGOSAUR_DEFAULT_BEHAVIOUR);
		setHitPoints(1);
		behaviour = new WanderBehaviour();
		addFoodSource();
	}

	public Stegosaur(String name,Gender gender,int currentAge){
		super("Stegosaur",'S',100,100,10,30,gender,20,200,15, 50, currentAge, STEGOSAUR_DEFAULT_BEHAVIOUR);
		setHitPoints(50);
		behaviour = new WanderBehaviour();
		addFoodSource();
	}

	@Override
	public Actions getAllowableActions(Actor otherActor, String direction, GameMap map) {
		return new Actions(new AttackAction(this));
	}


	public void setHitPoints(int hitPoints){
		this.hitPoints=hitPoints;
	}

	/**
	 * to add food source for stegosaur which is herbivore
	 */
	public void addFoodSource(){
		this.foodSource.add(Fruit.class);
		this.foodSource.add(VegetarianMealKit.class);
	}

	public Egg layEgg(GameMap map){
		return new StegosaurEgg(map);
	}


}
