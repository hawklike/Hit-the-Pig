package cz.cvut.fit.miadp.mvcgame.model.object.missile;

import cz.cvut.fit.miadp.mvcgame.model.coordinations.Position;
import cz.cvut.fit.miadp.mvcgame.strategy.MovingStrategy;

public class Missile extends AbstractMissile {

    public Missile(Position initialPosition, double initialAngle, int initialVelocity, MovingStrategy movingStrategy) {
        super(initialPosition, initialAngle, initialVelocity, movingStrategy);
    }

    public static Missile createInstance(Position initialPosition, double initialAngle, int initialVelocity, MovingStrategy movingStrategy) {
        Position position = new Position(initialPosition.getX(), initialPosition.getY());
        return new Missile(position, initialAngle, initialVelocity, movingStrategy);
    }

    @Override
    public void move() {
        movingStrategy.updatePosition(this);
    }
}
