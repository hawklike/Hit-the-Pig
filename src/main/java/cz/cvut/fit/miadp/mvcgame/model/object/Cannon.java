package cz.cvut.fit.miadp.mvcgame.model.object;

import cz.cvut.fit.miadp.mvcgame.config.MvcGameConfig;
import cz.cvut.fit.miadp.mvcgame.model.Direction;
import cz.cvut.fit.miadp.mvcgame.model.Position;
import cz.cvut.fit.miadp.mvcgame.model.Vector;

public class Cannon extends GameObject {

    public Cannon() {
        this(new Position(MvcGameConfig.MAX_X / 7, MvcGameConfig.MAX_Y / 2));
    }

    @SuppressWarnings("WeakerAccess")
    public Cannon(Position initialPosition) {
        super(MvcGameConfig.CANNON_IMG_RESOURCE);
        position = initialPosition;
    }

    public void move(Direction direction) {
        switch(direction) {
            case UP:
                move(new Vector(0, -1 * MvcGameConfig.CANNON_MOVE_STEP));
                break;
            case DOWN:
                move(new Vector(0, MvcGameConfig.CANNON_MOVE_STEP));
                break;
            case LEFT:
            case RIGHT:
                break;
        }
    }

}
