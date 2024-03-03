package game.action;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;

public class WinAction extends Action {
    private boolean hasWon;
    public WinAction(boolean hasWon){
        this.hasWon = hasWon;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        map.removeActor(actor);
        if (hasWon) {
            return "CONGRATULATIONS!!! YOU WON THE GAME!";
        }
        else{
            return "TURN LIMIT REACHED!!!!  YOU LOSE ! TRY HARDER NEXT TIME!!!";
        }
    }

    @Override
    public String menuDescription(Actor actor) {
        return null;
    }
}
