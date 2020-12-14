package cz.cvut.fit.miadp.mvcgame.model.object.cannon;

import cz.cvut.fit.miadp.mvcgame.config.MvcGameConfig;
import cz.cvut.fit.miadp.mvcgame.model.coordinations.Position;
import cz.cvut.fit.miadp.mvcgame.model.coordinations.Vector;
import cz.cvut.fit.miadp.mvcgame.model.coordinations.VerticalDirection;
import cz.cvut.fit.miadp.mvcgame.model.object.GameObject;
import cz.cvut.fit.miadp.mvcgame.model.object.missile.AbstractMissile;
import cz.cvut.fit.miadp.mvcgame.model.object.missile.Missile;
import cz.cvut.fit.miadp.mvcgame.state.CannonState;
import cz.cvut.fit.miadp.mvcgame.strategy.MovingStrategy;
import cz.cvut.fit.miadp.mvcgame.util.SoundPlayer;
import cz.cvut.fit.miadp.mvcgame.util.Timer;

@SuppressWarnings("WeakerAccess")
public abstract class AbstractCannon extends GameObject implements CannonState {

    protected double angle;
    protected int power;

    protected int speed;
    protected double delayBetweenShots;

    protected MovingStrategy missileMovement;

    private Timer shootTimer;
    private Timer powerTimer;

    public AbstractCannon(int power, int speed, double delayBetweenShots, MovingStrategy missileMovement) {
        this(MvcGameConfig.CANNON_ANGLE, power, speed, delayBetweenShots, missileMovement);
    }

    public AbstractCannon(double angle, int power, int speed, double delayBetweenShots, MovingStrategy missileMovement) {
        this(new Position(MvcGameConfig.MAX_X / 10, MvcGameConfig.MAX_Y / 2), angle, power, speed, delayBetweenShots, missileMovement);
    }

    public AbstractCannon(Position position, int power, int speed, double delayBetweenShots, MovingStrategy missileMovement) {
        this(position, MvcGameConfig.CANNON_ANGLE, power, speed, delayBetweenShots, missileMovement);
    }

    public AbstractCannon(Position initialPosition, double angle, int power, int speed, double delayBetweenShots, MovingStrategy missileMovement) {
        super(MvcGameConfig.CANNON_IMG_RESOURCE, initialPosition);
        this.angle = angle;
        this.power = power;
        this.speed = speed;
        this.delayBetweenShots = delayBetweenShots;
        this.missileMovement = missileMovement;
    }


    public void move(VerticalDirection direction) {
        switch(direction) {
            case UP:
                if(position.getY() < MvcGameConfig.HORIZON_POSY) break;
                moveBy(new Vector(0, -1 * speed));
                break;
            case DOWN:
                if(position.getY() + height > MvcGameConfig.MAX_Y) break;
                moveBy(new Vector(0, speed));
                break;
        }
    }

    public void aim(VerticalDirection direction) {
        switch(direction) {
            case UP:
                if(angle + MvcGameConfig.CANNON_ANGLE_STEP > MvcGameConfig.CANNON_MAX_ANGLE) break;
                angle += MvcGameConfig.CANNON_ANGLE_STEP;
                break;
            case DOWN:
                if(angle - MvcGameConfig.CANNON_ANGLE_STEP < MvcGameConfig.CANNON_MIN_ANGLE) break;
                angle -= MvcGameConfig.CANNON_ANGLE_STEP;
                break;
        }
    }


    public void power(VerticalDirection direction) {
        if(powerTimer == null || powerTimer.getTime(Timer.Unit.MILLIS) > MvcGameConfig.CANNON_POWER_DELAY_MILLIS) {
            powerTimer = new Timer();
            switch(direction) {
                case UP:
                    if(power + MvcGameConfig.CANNON_POWER_STEP > MvcGameConfig.CANNON_MAX_POWER) break;
                    power += MvcGameConfig.CANNON_POWER_STEP;
                    break;
                case DOWN:
                    if(power - MvcGameConfig.CANNON_POWER_STEP < MvcGameConfig.CANNON_MIN_POWER) break;
                    power -= MvcGameConfig.CANNON_POWER_STEP;
                    break;
            }
        }
    }

    public AbstractMissile shoot() {
        if(shootTimer == null || shootTimer.getTime(Timer.Unit.MILLIS) > delayBetweenShots) {
            shootTimer = new Timer();
            new SoundPlayer().play(MvcGameConfig.CANNON_SOUND_RESOURCE);

            return Missile.createInstance(getPosition(),
                    angle,
                    power,
                    missileMovement);
        } else {
            return null;
        }
    }

    public double getAngle() {
        return angle;
    }

    public int getPower() {
        return power;
    }

    private class Memento {
        private double angle;
        private int power;

        Memento(double angle, int power) {
            this.angle = angle;
            this.power = power;
        }
    }

    protected Object createMemento() {
        return new Memento(angle, power);
    }

    public void restore(Object memento) {
        Memento m = (Memento) memento;
        angle = m.angle;
        power = m.power;
    }
}
