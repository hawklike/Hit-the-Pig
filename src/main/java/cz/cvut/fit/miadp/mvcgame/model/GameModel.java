package cz.cvut.fit.miadp.mvcgame.model;

import cz.cvut.fit.miadp.mvcgame.model.object.Cannon;

import static cz.cvut.fit.miadp.mvcgame.model.Direction.DOWN;
import static cz.cvut.fit.miadp.mvcgame.model.Direction.UP;

public class GameModel {
    private Cannon cannon;

    public GameModel() {
        cannon = new Cannon();
    }

    public Position getCannonPosition() {
        return cannon.getPosition();
    }

    public void moveCannon(Direction direction) {
        switch(direction) {
            case UP:
                cannon.move(UP);
                break;
            case DOWN:
                cannon.move(DOWN);
                break;
            case LEFT:
            case RIGHT:
                break;
        }
    }

    public Cannon getCannon() {
        return cannon;
    }
}
