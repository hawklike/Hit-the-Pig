package cz.cvut.fit.miadp.mvcgame.strategy;

import cz.cvut.fit.miadp.mvcgame.config.MvcGameConfig;
import cz.cvut.fit.miadp.mvcgame.model.coordinations.Vector;
import cz.cvut.fit.miadp.mvcgame.model.object.base.AbstractMissile;
import cz.cvut.fit.miadp.mvcgame.util.Timer;

public class RealMovingStrategy implements MovingStrategy {

    @Override
    public void updatePosition(AbstractMissile missile) {
        int velocity = missile.getVelocity();
        double angle = missile.getAngle();
        double time = missile.getAge(Timer.Unit.SECONDS);

        if(velocity < MvcGameConfig.BASIC_CANNON_MIN_POWER) velocity = MvcGameConfig.BASIC_CANNON_MIN_POWER;
        if(velocity > MvcGameConfig.BASIC_CANNON_MAX_POWER) velocity = MvcGameConfig.BASIC_CANNON_MAX_POWER;

        int dX = (int) (Math.sqrt(velocity) * Math.cos(Math.PI / 180 * angle));
        int dY = (int) (velocity * time * Math.sin(Math.PI / 180 * angle) - (MvcGameConfig.GRAVITY * Math.pow(time, 2)));

        missile.move(new Vector(Math.abs(dX), -dY));
    }
}
