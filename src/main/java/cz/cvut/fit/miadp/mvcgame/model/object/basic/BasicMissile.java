package cz.cvut.fit.miadp.mvcgame.model.object.basic;

import cz.cvut.fit.miadp.mvcgame.model.coordinations.Position;
import cz.cvut.fit.miadp.mvcgame.model.object.base.AbstractMissile;
import cz.cvut.fit.miadp.mvcgame.strategy.MovingStrategy;

public class BasicMissile extends AbstractMissile {

    public BasicMissile(Position initialPosition, double initialAngle, int initialVelocity, MovingStrategy movingStrategy) {
        super(initialPosition, initialAngle, initialVelocity, movingStrategy);
    }

    @Override
    public void move() {
        movingStrategy.updatePosition(this);
    }
}
