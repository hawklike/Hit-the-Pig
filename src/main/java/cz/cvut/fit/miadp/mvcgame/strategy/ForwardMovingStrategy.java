package cz.cvut.fit.miadp.mvcgame.strategy;

import cz.cvut.fit.miadp.mvcgame.config.MvcGameConfig;
import cz.cvut.fit.miadp.mvcgame.model.coordinations.Vector;
import cz.cvut.fit.miadp.mvcgame.model.object.base.AbstractMissile;

public class ForwardMovingStrategy implements MovingStrategy {

    @Override
    public void updatePosition(AbstractMissile missile) {
        missile.move(new Vector(MvcGameConfig.BASIC_CANNON_POWER, 0));
    }
}
