package cz.cvut.fit.miadp.mvcgame.abstract_factory;

import cz.cvut.fit.miadp.mvcgame.model.Position;
import cz.cvut.fit.miadp.mvcgame.model.object.AbstractCannon;
import cz.cvut.fit.miadp.mvcgame.model.object.AbstractMissile;

public interface AbstractGameObjectFactory {
    AbstractCannon createCannon();

    AbstractMissile createMissile(Position initialPosition);
}
