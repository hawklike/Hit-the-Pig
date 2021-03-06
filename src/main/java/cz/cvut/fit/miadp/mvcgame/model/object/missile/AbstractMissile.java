package cz.cvut.fit.miadp.mvcgame.model.object.missile;

import cz.cvut.fit.miadp.mvcgame.model.coordinations.Position;
import cz.cvut.fit.miadp.mvcgame.model.object.LifetimeLimitedGameObject;
import cz.cvut.fit.miadp.mvcgame.strategy.MovingStrategy;

@SuppressWarnings("WeakerAccess")
public abstract class AbstractMissile extends LifetimeLimitedGameObject {

    private double angle;
    private int velocity;
    protected MovingStrategy movingStrategy;

    public AbstractMissile(Position initialPosition, double initAngle, int initVelocity, MovingStrategy movingStrategy, String imgResource) {
        super(imgResource, initialPosition);
        angle = initAngle;
        velocity = initVelocity;
        this.movingStrategy = movingStrategy;
    }

    public void move() {
        movingStrategy.updatePosition(this);
    }

    public double getAngle() {
        return angle;
    }

    public int getVelocity() {
        return velocity;
    }

    public int getPower() {
        return velocity;
    }
}
