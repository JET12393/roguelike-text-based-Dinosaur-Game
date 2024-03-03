package game.ground;

import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Ground;
import edu.monash.fit2099.engine.Location;
import game.actor.Pterodactyls;
import game.actor.Stegosaur;

import java.util.Random;

public class Lake extends Ground {
    private static Location lakeLocation;
    private double capacity=25.0;
    private int turn=0;
    private int numOfFish=5;

    /**
     * Constructor.
     *
     *
     */
    public Lake() {
        super('~');
    }

    @Override
    public void tick(Location location) {
        super.tick(location);
        this.lakeLocation = location;

        turn++;
        final double RAIN_CHANCE = 0.2;
        Random r = new Random();
        double rainfall = 0.1 + (0.6-0.1) * r.nextDouble();
        if (turn==10){
            double chance = Math.random();
            if (chance <= RAIN_CHANCE) {
                capacity += rainfall * 20;
            }
            turn=0;
        }

        final double NEW_FISH_CHANCE=0.6;
        double fishChance = Math.random();
        if (fishChance <= NEW_FISH_CHANCE){
            if (numOfFish<=25){
                numOfFish++;
            }
        }
    }

    public static Location getLakeLocation(){
        return lakeLocation;
    }

    public void pterodactylsFlewOver(Pterodactyls ptero){
        Random rand = null;
        int max = 2;
        int min = 0;
        int fish = rand.nextInt((max - min) + 1) + min;
        numOfFish -= fish;
        ptero.setWaterLevel(ptero.getWaterLevel()+30);
    }

    @Override
    public boolean canActorEnter(Actor actor) {
        if (actor.getDisplayChar() == 'S' || actor.getDisplayChar() == 'B' || actor.getDisplayChar() == 'A') {
            return false;
        } else {
            return true;
        }
    }
}
