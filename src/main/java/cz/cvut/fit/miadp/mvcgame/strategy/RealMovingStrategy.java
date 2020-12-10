package cz.cvut.fit.miadp.mvcgame.strategy;

import cz.cvut.fit.miadp.mvcgame.config.MvcGameConfig;
import cz.cvut.fit.miadp.mvcgame.model.coordinations.Vector;
import cz.cvut.fit.miadp.mvcgame.model.object.missile.AbstractMissile;
import cz.cvut.fit.miadp.mvcgame.util.Timer;

public class RealMovingStrategy implements MovingStrategy {

    @Override
    public void updatePosition(AbstractMissile missile) {
        int velocity = missile.getVelocity();
        double angle = missile.getAngle();
        double time = missile.getAge(Timer.Unit.SECONDS);

        int dX = (int) (Math.sqrt(velocity) * Math.cos(Math.PI / 180 * angle));
        int dY = (int) (velocity * time * Math.sin(Math.PI / 180 * angle) - (MvcGameConfig.GRAVITY * Math.pow(time, 2)));

        missile.moveBy(new Vector(Math.abs(dX), -dY));
    }
}
