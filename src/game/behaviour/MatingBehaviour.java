package game.behaviour;

import edu.monash.fit2099.engine.*;
import game.action.MatingAction;
import game.actor.Dinosaur;
import game.ground.Tree;

import java.util.ArrayList;

public class MatingBehaviour implements Behaviour{
    @Override
    public Action getAction(Actor actor, GameMap map) {
        Dinosaur target;
        ArrayList<Dinosaur> fitToBreed = getEligibleTarget(actor, map);
        if (fitToBreed.size() != 0) {
            int minDistance = FollowBehaviour.distance(map.locationOf(actor), map.locationOf(fitToBreed.get(0)));
            target = fitToBreed.get(0);
            for (Dinosaur dino : fitToBreed) {
                int distance = FollowBehaviour.distance(map.locationOf(actor), map.locationOf(dino));
                //find min distance
                if (distance < minDistance) {
                    minDistance = distance;
                    target = dino;
                }
            }
            //Stegosaur, Brachiosaur, Allosaur
            if (actor.getDisplayChar() == 'S' || actor.getDisplayChar() == 'B' || actor.getDisplayChar() == 'A') {
                if (minDistance == 1) {
                    return new MatingAction(target);
                }
                else {
                    return new FollowBehaviour(target).getAction(actor, map);
                }
            }
            //Pterodactyls
            else{
                if (minDistance == 1 && map.locationOf(target)==Tree.getTreeLocation() && map.locationOf(actor)==Tree.getTreeLocation()) {
                    return new MatingAction(target);
                }
                else {
                    return new DoNothingAction();
                }
            }
        }
        else{
            return new DoNothingAction();
        }
    }

    public ArrayList <Dinosaur> getEligibleTarget(Actor actor,GameMap map){
        ArrayList<Dinosaur> temp=new ArrayList<>();
        Dinosaur dino=(Dinosaur) actor;
        for (int x:map.getXRange()){
            for (int y:map.getYRange()){
                Location location= map.at(x,y);
                Actor actor1= map.getActorAt(location);
                if (actor1 instanceof Dinosaur && actor1.getClass()==dino.getClass() && ((Dinosaur) actor1).isMale()!=dino.isMale()){
                    temp.add((Dinosaur) actor1);
                }
            }
        }
        return temp;
    }
}
