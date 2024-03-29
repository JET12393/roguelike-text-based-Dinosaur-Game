package game.action;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;

public class TerminateGameAction extends Action {

    @Override
    public String execute(Actor actor, GameMap map) {
        map.removeActor(actor);
        return "Player terminates the game!!!";
    }

    @Override
    public String menuDescription(Actor actor) {
        return "Terminating game!!!";
    }

    public String hotkey() {
        return "!";
    }
}
