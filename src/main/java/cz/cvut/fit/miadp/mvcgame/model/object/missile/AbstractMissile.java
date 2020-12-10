package cz.cvut.fit.miadp.mvcgame.model.object.missile;

import cz.cvut.fit.miadp.mvcgame.config.MvcGameConfig;
import cz.cvut.fit.miadp.mvcgame.model.coordinations.Position;
import cz.cvut.fit.miadp.mvcgame.model.object.LifetimeLimitedGameObject;
import cz.cvut.fit.miadp.mvcgame.strategy.MovingStrategy;
import cz.cvut.fit.miadp.mvcgame.visitor.GameObjectVisitor;

@SuppressWarnings("WeakerAccess")
public abstract class AbstractMissile extends LifetimeLimitedGameObject {

    private double angle;
    private int velocity;
    protected MovingStrategy movingStrategy;

    public AbstractMissile(Position initialPosition, double initAngle, int initVelocity, MovingStrategy movingStrategy) {
        super(MvcGameConfig.MISSILE_IMG_RESOURCE, initialPosition);
        angle = initAngle;
        velocity = initVelocity;
        this.movingStrategy = movingStrategy;
    }

    public void move() {
        movingStrategy.updatePosition(this);
    }

    @Override
    public void acceptVisitor(GameObjectVisitor renderer) {
        renderer.visitMissile(this);
    }

    public double getAngle() {
        return angle;
    }

    public int getVelocity() {
        return velocity;
    }
}
