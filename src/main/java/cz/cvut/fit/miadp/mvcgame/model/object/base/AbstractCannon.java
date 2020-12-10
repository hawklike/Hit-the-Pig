package cz.cvut.fit.miadp.mvcgame.model.object.base;

import cz.cvut.fit.miadp.mvcgame.config.MvcGameConfig;
import cz.cvut.fit.miadp.mvcgame.model.coordinations.CannonDirection;
import cz.cvut.fit.miadp.mvcgame.model.coordinations.Position;
import cz.cvut.fit.miadp.mvcgame.model.object.GameObject;
import cz.cvut.fit.miadp.mvcgame.visitor.GameObjectVisitor;

public abstract class AbstractCannon extends GameObject {

    protected double angle;
    protected int power;

    public AbstractCannon() {
        this(new Position(MvcGameConfig.MAX_X / 7, MvcGameConfig.MAX_Y / 2));
    }

    @SuppressWarnings("WeakerAccess")
    public AbstractCannon(Position initialPosition) {
        super(MvcGameConfig.CANNON_IMG_RESOURCE);
        position = initialPosition;
    }

    public abstract void move(CannonDirection direction);

    public abstract void aim(CannonDirection direction);

    public abstract void power(CannonDirection direction);

    public abstract AbstractMissile shoot();

    public double getAngle() {
        return angle;
    }

    public int getPower() {
        return power;
    }

    @Override
    public void acceptVisitor(GameObjectVisitor renderer) {
        renderer.visitCannon(this);
    }
}
