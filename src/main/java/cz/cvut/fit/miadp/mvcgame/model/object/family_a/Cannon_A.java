package cz.cvut.fit.miadp.mvcgame.model.object.family_a;

import cz.cvut.fit.miadp.mvcgame.config.MvcGameConfig;
import cz.cvut.fit.miadp.mvcgame.model.Direction;
import cz.cvut.fit.miadp.mvcgame.model.Vector;
import cz.cvut.fit.miadp.mvcgame.model.object.AbstractCannon;

public class Cannon_A extends AbstractCannon {

    @Override
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
