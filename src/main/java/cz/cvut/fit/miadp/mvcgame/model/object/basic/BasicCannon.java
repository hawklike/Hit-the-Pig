package cz.cvut.fit.miadp.mvcgame.model.object.basic;

import cz.cvut.fit.miadp.mvcgame.abstract_factory.AbstractGameObjectFactory;
import cz.cvut.fit.miadp.mvcgame.config.MvcGameConfig;
import cz.cvut.fit.miadp.mvcgame.model.coordinations.CannonDirection;
import cz.cvut.fit.miadp.mvcgame.model.coordinations.Vector;
import cz.cvut.fit.miadp.mvcgame.model.object.base.AbstractCannon;
import cz.cvut.fit.miadp.mvcgame.model.object.base.AbstractMissile;
import cz.cvut.fit.miadp.mvcgame.strategy.RealMovingStrategy;
import cz.cvut.fit.miadp.mvcgame.util.Timer;

public class BasicCannon extends AbstractCannon {

    private AbstractGameObjectFactory objectFactory;

    private Timer shootTimer;
    private Timer powerTimer;

    public BasicCannon(AbstractGameObjectFactory objectFactory) {
        super();
        this.objectFactory = objectFactory;

        power = MvcGameConfig.BASIC_CANNON_POWER;
        angle = MvcGameConfig.BASIC_CANNON_ANGLE;
    }

    @Override
    public void move(CannonDirection direction) {
        switch(direction) {
            case UP:
                move(new Vector(0, -1 * MvcGameConfig.BASIC_CANNON_MOVE_STEP));
                break;
            case DOWN:
                move(new Vector(0, MvcGameConfig.BASIC_CANNON_MOVE_STEP));
                break;
        }
    }

    @Override
    public void aim(CannonDirection direction) {
        switch(direction) {
            case UP:
                angle += MvcGameConfig.CANNON_ANGLE_STEP;
                break;
            case DOWN:
                angle -= MvcGameConfig.CANNON_ANGLE_STEP;
                break;
        }
    }

    @Override
    public void power(CannonDirection direction) {
        if(powerTimer == null || powerTimer.getTime(Timer.Unit.MILLIS) > MvcGameConfig.CANNON_POWER_DELAY_MILLIS) {
            powerTimer = new Timer();
            switch(direction) {
                case UP:
                    power += MvcGameConfig.CANNON_POWER_STEP;
                    break;
                case DOWN:
                    power -= MvcGameConfig.CANNON_POWER_STEP;
                    break;
            }
        }
    }

    @Override
    public AbstractMissile shoot() {
        if(shootTimer == null || shootTimer.getTime(Timer.Unit.MILLIS) > MvcGameConfig.BASIC_CANNON_SHOOT_DELAY_MILLIS) {
            shootTimer = new Timer();
            return objectFactory.createMissile(
                    getPosition(),
                    angle,
                    power,
                    new RealMovingStrategy()
            );
        } else {
            return null;
        }
    }
}
