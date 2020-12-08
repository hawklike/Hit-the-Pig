package cz.cvut.fit.miadp.mvcgame.abstract_factory;

import cz.cvut.fit.miadp.mvcgame.model.coordinations.Position;
import cz.cvut.fit.miadp.mvcgame.model.object.basic.BasicCannon;
import cz.cvut.fit.miadp.mvcgame.model.object.basic.BasicMissile;

public class BasicGameObjectFactory implements AbstractGameObjectFactory {

    @Override
    public BasicCannon createCannon() {
        return new BasicCannon(this);
    }

    @Override
    public BasicMissile createMissile(Position initialPosition) {
        Position position = new Position(initialPosition.getX(), initialPosition.getY());
        return new BasicMissile(position);
    }
}
