package cz.cvut.fit.miadp.mvcgame.abstract_factory;

import cz.cvut.fit.miadp.mvcgame.model.coordinations.Position;
import cz.cvut.fit.miadp.mvcgame.model.object.basic.BasicCannon;
import cz.cvut.fit.miadp.mvcgame.model.object.basic.BasicMissile;
import cz.cvut.fit.miadp.mvcgame.strategy.MovingStrategy;

public class BasicGameObjectFactory implements AbstractGameObjectFactory {

    @Override
    public BasicCannon createCannon() {
        return new BasicCannon(this);
    }

    @Override
    public BasicMissile createMissile(Position initialPosition, double initialAngle, int initialVelocity, MovingStrategy movingStrategy) {
        Position position = new Position(initialPosition.getX(), initialPosition.getY());
        return new BasicMissile(position, initialAngle, initialVelocity, movingStrategy);
    }
}
