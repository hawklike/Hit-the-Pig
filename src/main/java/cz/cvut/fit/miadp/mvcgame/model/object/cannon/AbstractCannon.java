package cz.cvut.fit.miadp.mvcgame.model.object.cannon;

import cz.cvut.fit.miadp.mvcgame.config.MvcGameConfig;
import cz.cvut.fit.miadp.mvcgame.model.coordinations.CannonDirection;
import cz.cvut.fit.miadp.mvcgame.model.coordinations.Position;
import cz.cvut.fit.miadp.mvcgame.model.coordinations.Vector;
import cz.cvut.fit.miadp.mvcgame.model.object.GameObject;
import cz.cvut.fit.miadp.mvcgame.model.object.missile.AbstractMissile;
import cz.cvut.fit.miadp.mvcgame.model.object.missile.Missile;
import cz.cvut.fit.miadp.mvcgame.state.CannonState;
import cz.cvut.fit.miadp.mvcgame.strategy.MovingStrategy;
import cz.cvut.fit.miadp.mvcgame.util.Timer;
import cz.cvut.fit.miadp.mvcgame.visitor.GameObjectVisitor;

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
        this(new Position(MvcGameConfig.MAX_X / 7, MvcGameConfig.MAX_Y / 2), angle, power, speed, delayBetweenShots, missileMovement);
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


    public void move(CannonDirection direction) {
        switch(direction) {
            case UP:
                move(new Vector(0, -1 * speed));
                break;
            case DOWN:
                move(new Vector(0, speed));
                break;
        }
    }

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

    public AbstractMissile shoot() {
        if(shootTimer == null || shootTimer.getTime(Timer.Unit.MILLIS) > delayBetweenShots) {
            shootTimer = new Timer();

            if(power < MvcGameConfig.CANNON_MIN_POWER) power = MvcGameConfig.CANNON_MIN_POWER;
            if(power > MvcGameConfig.CANNON_MAX_POWER) power = MvcGameConfig.CANNON_MAX_POWER;

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

    @Override
    public void acceptVisitor(GameObjectVisitor renderer) {
        renderer.visitCannon(this);
    }
}
