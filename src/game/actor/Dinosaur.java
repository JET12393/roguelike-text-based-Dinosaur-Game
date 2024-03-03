package game.actor;

import edu.monash.fit2099.engine.*;
import game.Gender;
import game.action.AttackAction;
import game.action.FeedAction;
import game.action.StarvingAction;
import game.behaviour.*;
import game.item.Egg;
import game.item.Food;

import javax.swing.plaf.basic.BasicTableHeaderUI;
import java.util.ArrayList;

/**
 * base class for all type of dinosaur
 */
public abstract class Dinosaur extends Actor {
    private int currentAge;
    private final int HATCH_ECOPOINTS;
    private final int PREGNANCY_TURN;
    private final int ADULT_AGE;
    private final Gender gender;
    private Behaviour behaviour=new WanderBehaviour();
    private int deathTurn=0;
    private int pregnancyTurnCount=0;
    private int unconsciousLimit;
    private int waterLevel;
    private int rainUnconsciousLimit;
    private int corpsePoints;
    private final Behaviour DEFAULT_BEHAVIOUR;
    public final ArrayList<Class<?>> foodSource = new ArrayList<>();


    /**
     *
     * @param name name of dinosaur
     * @param displayChar display character of the dinosaur
     * @param hitPoints food level of dinosaur, basically represents the health point (hp)
     * @param hatchEcoPoints the amount of ecopoints gifted if egg is hatched
     * @param pregnancyTurn the number of turn dinosaur will be pregnant before laying egg
     * @param adultAge used to determine whether the dinosaur is adult to be able to perform mating
     */
    public Dinosaur(String name, char displayChar, int hitPoints,int hatchEcoPoints,int pregnancyTurn,int adultAge,int unconsciousLimit, int waterLevel, int rainUnconsciousLimit, int corpsePoints, int currentAge, Behaviour behaviour) {
        super(name, displayChar, hitPoints);
        this.HATCH_ECOPOINTS=hatchEcoPoints;
        this.PREGNANCY_TURN=pregnancyTurn;
        this.ADULT_AGE=adultAge;
        this.gender=Gender.getRandomGender();
        this.unconsciousLimit=unconsciousLimit;
        this.waterLevel=waterLevel;
        this.rainUnconsciousLimit=rainUnconsciousLimit;
        this.corpsePoints=corpsePoints;
        this.currentAge=currentAge;
        this.DEFAULT_BEHAVIOUR=behaviour;
    }

    /**
     * Constructor, this constructor takes in gender by user to instantiate the dinosaur
     */
    public Dinosaur(String name, char displayChar, int hitPoints, int hatchEcoPoints, int pregnancyTurn, int adultAge, Gender gender, int unconsciousLimit, int waterLevel, int rainUnconsciousLimit, int corpsePoints, int currentAge, Behaviour behaviour){
        super(name,displayChar,hitPoints);
        this.HATCH_ECOPOINTS=hatchEcoPoints;
        this.PREGNANCY_TURN=pregnancyTurn;
        this.ADULT_AGE=adultAge;
        this.gender=gender;
        this.unconsciousLimit=unconsciousLimit;
        this.waterLevel=waterLevel;
        this.rainUnconsciousLimit=rainUnconsciousLimit;
        this.corpsePoints=corpsePoints;
        this.currentAge=currentAge;
        this.DEFAULT_BEHAVIOUR=behaviour;
    }

    /**
     *
     * @param actions    collection of possible Actions for dinosaur
     * @param lastAction The Action this Actor took last turn. Can do interesting things in conjunction with Action.getNextAction()
     * @param map        the map containing the Actor
     * @param display    the I/O object to which messages may be written
     * @return actions
     */
    @Override
    public Action playTurn(Actions actions, Action lastAction, GameMap map, Display display) {
        this.currentAge++;
        this.hitPoints--;
        this.waterLevel--;


        if (this.behaviour instanceof PregnantBehaviour)
            setPregnancyTurnCount(getPREGNANCY_TURN()+1);
        if (lastAction instanceof StarvingAction) {
            deathTurn++;
        }
        else {
            deathTurn = 0;
        }

        // Sets behaviour accordingly
        if (this.hitPoints<=0 || this.waterLevel <= 0) {
            setBehaviour(new UnconsciousBehaviour());
        }
        else if (this.waterLevel < 40) {
            setBehaviour(new ThirstyBehaviour());
        }
        else if (this.hitPoints > this.maxHitPoints/2 && getCurrentAge()>=getADULT_AGE() && !(getBehaviour() instanceof PregnantBehaviour)) {
            setBehaviour(new MatingBehaviour());
        }
        else if (!(getBehaviour() instanceof PregnantBehaviour)) {
            setBehaviour(DEFAULT_BEHAVIOUR);
        }

        Action wander = behaviour.getAction(this, map);
        if (wander != null)
            return wander;

        return new DoNothingAction();

    }

    /**
     * Get allowable player actions to interact with the dinosaur
     *
     * @param actor the Actor that might be performing attack
     * @param direction  String representing the direction of the other Actor
     * @param map        current GameMap
     * @return Possible actions to interact with the dinosaur
     */
    public Actions getAllowableActions(Actor actor, String direction, GameMap map) {
        Actions actions = new Actions();
        actions.add(new AttackAction(this));
        Location location= map.locationOf(actor);
        try {
            for (Item item : actor.getInventory()) {
                for (Class<?> diet : foodSource) {
                    if (diet==item.getClass()) {
                        actions.add(new FeedAction(this, (Food) item));
                    }
                }
            }
        }
        catch (RuntimeException e){
            return actions;
        }
        return actions;
    }

    public abstract Egg layEgg(GameMap map);

    public int getUnconsciousLimit() {
        return unconsciousLimit;
    }

    public void setUnconsciousLimit(int unconsciousLimit) {
        this.unconsciousLimit = unconsciousLimit;
    }

    public boolean isMale(){
        return getGender()==Gender.MALE;
    }

    //below is all the getter and setter that is automatically generated
    public int getCurrentAge() {
        return currentAge;
    }

    public void setCurrentAge(int currentAge) {
        this.currentAge = currentAge;
    }

    public int getHATCH_ECOPOINTS() {
        return HATCH_ECOPOINTS;
    }

    public int getPREGNANCY_TURN() {
        return PREGNANCY_TURN;
    }

    public int getADULT_AGE() {
        return ADULT_AGE;
    }

    public Gender getGender() {
        return gender;
    }

    public Behaviour getBehaviour() {
        return behaviour;
    }

    public void setBehaviour(Behaviour behaviour) {
        this.behaviour = behaviour;
    }

    public int getDeathTurn() {
        return deathTurn;
    }

    public void setDeathTurn(int deathTurn) {
        this.deathTurn = deathTurn;
    }

    public int getPregnancyTurnCount() {
        return pregnancyTurnCount;
    }

    public void setPregnancyTurnCount(int pregnancyTurnCount) {
        this.pregnancyTurnCount = pregnancyTurnCount;
    }

    public int getWaterLevel(){
        return waterLevel;
    }

    public void setWaterLevel(int waterLevel){
        this.waterLevel=waterLevel;
    }

    public int getRainUnconsciousLimit(){
        return rainUnconsciousLimit;
    }

    public void setRainUnconsciousLimit(int rainUnconsciousLimit){
        this.rainUnconsciousLimit=rainUnconsciousLimit;
    }
}
