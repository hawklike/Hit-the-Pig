package cz.cvut.fit.miadp.mvcgame.strategy;

import cz.cvut.fit.miadp.mvcgame.model.coordinations.Vector;
import cz.cvut.fit.miadp.mvcgame.model.object.missile.AbstractMissile;

public class ForwardMovingStrategy implements MovingStrategy {

    @Override
    public void updatePosition(AbstractMissile missile) {
        missile.moveBy(new Vector(missile.getVelocity(), 0));
    }
}
