package cz.cvut.fit.miadp.mvcgame.abstract_factory;

import cz.cvut.fit.miadp.mvcgame.model.coordinations.Position;
import cz.cvut.fit.miadp.mvcgame.model.object.base.AbstractCannon;
import cz.cvut.fit.miadp.mvcgame.model.object.base.AbstractMissile;
import cz.cvut.fit.miadp.mvcgame.strategy.MovingStrategy;

public interface AbstractGameObjectFactory {
    AbstractCannon createCannon();

    AbstractMissile createMissile(Position initialPosition, double initialAngle, int initialVelocity, MovingStrategy movingStrategy);
}
