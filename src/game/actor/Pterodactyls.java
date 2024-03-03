package game.actor;

import edu.monash.fit2099.engine.*;
import game.Gender;
import game.action.AttackAction;
import game.behaviour.Behaviour;
import game.behaviour.WanderBehaviour;
import game.item.*;

import java.util.ArrayList;

public class Pterodactyls extends Dinosaur{
    private Behaviour behaviour;
    //    private ArrayList<Class<?>> foodSource= new ArrayList<Class<?>>();
    private final int UNCONSCIOUS_LIMIT=20;
    public static final Behaviour PTERODACTYLS_DEFAULT_BEHAVIOUR = new WanderBehaviour();

    /**
     * Constructor, random gender
     * All Pteoridactyls are represented by a 'P' and have 100 hit points.
     * @param name name of this Pterodactyls
     */
    public Pterodactyls(String name, int currentAge) {
        super("Pterodactyls", 'P', 100, 100, 10, 30, 20,200,15,30, currentAge, PTERODACTYLS_DEFAULT_BEHAVIOUR);
        behaviour = new WanderBehaviour();
        this.setWaterLevel(30);
        addFoodSource();
    }

    /**
     * Constructor, with gender input by user
     * @param name the name of this Pterodactyls
     * @param gender the gender of this Pterodactyls
     */
    public Pterodactyls(String name, Gender gender, int currentAge) {
        super("Pterodactyls", 'P', 100,100,10,30,gender,20,200,15,30, currentAge,PTERODACTYLS_DEFAULT_BEHAVIOUR);
        behaviour = new WanderBehaviour();
        this.setWaterLevel(30);
        addFoodSource();
    }

    /**
     *
     * @param otherActor the Actor that might be performing attack
     * @param direction  String representing the direction of the other Actor
     * @param map        current GameMap
     * @return
     */
    @Override
    public Actions getAllowableActions(Actor otherActor, String direction, GameMap map) {
        return new Actions(new AttackAction(this));
    }

    /**
     * set the hit points
     * @param hitPoints the amount of hit points of the Pterodactyls
     */
    public void setHitPoints(int hitPoints){
        this.hitPoints=hitPoints;
    }

    /**
     * to add food source for Pterodactyls which is carnivore
     */
    public void addFoodSource() {
        this.foodSource.add(Fish.class);

    }



    /**
     * the egg is laid
     * @param map location where the egg is placed
     * @return
     */
    @Override
    public Egg layEgg(GameMap map) {
        return new PterodactylsEgg(map);
    }
}
