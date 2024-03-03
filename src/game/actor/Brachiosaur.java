package game.actor;

import edu.monash.fit2099.engine.*;
import game.Gender;
import game.action.DeathAction;
import game.behaviour.Behaviour;
import game.behaviour.MatingBehaviour;
import game.behaviour.WanderBehaviour;
import game.ground.Dirt;
import game.item.BrachiosaurEgg;
import game.item.Egg;
import game.item.Fruit;
import game.item.VegetarianMealKit;

public class Brachiosaur extends Dinosaur{
    private Behaviour behaviour;
//    private ArrayList<Class<?>> foodSource= new ArrayList<Class<?>>();
    public static final Behaviour BRACHIOSAUR_DEFAULT_BEHAVIOUR = new WanderBehaviour();

    /**
     * Constructor, random gender
     * All Brachiosaurs are represented by a 'B' and have 160 hit points.
     *
     * @param name the name of this Brachiosaur
     */
    public Brachiosaur(String name, int currentAge) {
        super("Brachiosaur",'B',160,1000,30,50, 15,200,15, 100, currentAge, BRACHIOSAUR_DEFAULT_BEHAVIOUR);
        setHitPoints(100);
        setWaterLevel(50);
        behaviour = new WanderBehaviour();
        addFoodSource();
    }

    /**
     * Constructor, with gender input by user
     * @param name the name of this Brachiosaur
     * @param gender the gender of this Brachiosaur
     */
    public Brachiosaur(String name, Gender gender, int currentAge){
        super("Brachiosaur",'B',160,1000,30,50,gender,20,15,15, 100, currentAge, BRACHIOSAUR_DEFAULT_BEHAVIOUR);
        setHitPoints(100);
        setWaterLevel(50);
        behaviour = new WanderBehaviour();
        addFoodSource();
    }

    /**
     * set the hit points
     * @param hitPoints the amount of hit points of the Pterodactyls
     */
    public void setHitPoints(int hitPoints){
        this.hitPoints=hitPoints;
    }

    /**
     * to add food source for Brachiosaur which is herbivore
     */
    public void addFoodSource(){
        this.foodSource.add(Fruit.class);
        this.foodSource.add(VegetarianMealKit.class);
    }

    final double CHANCE_KILL_BUSH = 0.5;
    public void killBush(Actor actor, GameMap map, Location location){
        if (map.locationOf(actor) == location){
            if (Math.random() <= CHANCE_KILL_BUSH) {
                removeBush(location);
            }
        }
    }

    /**
     * remove bush from map
     * @param location
     */
    public void removeBush(Location location){
        Dirt dirt = new Dirt();
        location.setGround(dirt);
    }


    /**
     * the egg is laid
     * @param map location where the egg is placed
     * @return
     */
    public Egg layEgg(GameMap map){
        return new BrachiosaurEgg(map);
    }

}

