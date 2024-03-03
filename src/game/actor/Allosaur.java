package game.actor;

import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.IntrinsicWeapon;
import game.Gender;
import game.behaviour.Behaviour;
import game.behaviour.FierceBehaviour;
import game.item.*;

import java.util.ArrayList;

public class Allosaur extends Dinosaur{
    private Behaviour behaviour;
    //private ArrayList<Class<?>> foodSource= new ArrayList<Class<?>>();
    private static final int ALLOSAUR_DAMAGE=20;
    private static final Behaviour ALLOSAUR_SPECIAL_BEHAVIOUR= new FierceBehaviour();



    /**
     * Constructor, random gender
     * All Allosaur are represented by a 'a' and have 100 hit points.
     *
     * @param name the name of this Allosaur
     */
    public Allosaur(String name,int currentAge) {
        super("Allosaur",'A',100,1000,20,50,20,20,200,50,currentAge, ALLOSAUR_SPECIAL_BEHAVIOUR);
        setHitPoints(20);
        behaviour = ALLOSAUR_SPECIAL_BEHAVIOUR;
        addFoodSource();
    }

    /**
     * Constructor , with gender input by user
     * @param name name of allosaur
     * @param gender gender of allosaur
     */
    public Allosaur(String name, Gender gender,int currentAge){
        super("Allosaur",'A',100,1000,20,50, gender,20,20,200,50,currentAge, ALLOSAUR_SPECIAL_BEHAVIOUR);
        setHitPoints(20);
        behaviour = ALLOSAUR_SPECIAL_BEHAVIOUR;
        addFoodSource();
    }

    public void setHitPoints(int hitPoints){
        this.hitPoints=hitPoints;
    }

    /**
     * to add food source for stegosaur which is herbivore
     */
    public void addFoodSource(){
        this.foodSource.add(Stegosaur.class);
        this.foodSource.add(CarnivoreMealKit.class);
        this.foodSource.add(BrachiosaurEgg.class);
        this.foodSource.add(StegosaurEgg.class);

    }

    public Egg layEgg(GameMap map){
        return new AllosaurEgg(map);
    }

    /**
     *
     * @return
     */
    @Override
    protected IntrinsicWeapon getIntrinsicWeapon(){
        return new IntrinsicWeapon(ALLOSAUR_DAMAGE, "claws!!");
    }
}
