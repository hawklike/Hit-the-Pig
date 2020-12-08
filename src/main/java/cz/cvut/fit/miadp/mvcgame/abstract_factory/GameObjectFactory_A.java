package cz.cvut.fit.miadp.mvcgame.abstract_factory;

import cz.cvut.fit.miadp.mvcgame.model.Position;
import cz.cvut.fit.miadp.mvcgame.model.object.family_a.Cannon_A;
import cz.cvut.fit.miadp.mvcgame.model.object.family_a.Missile_A;

public class GameObjectFactory_A implements AbstractGameObjectFactory {

    @Override
    public Cannon_A createCannon() {
        return new Cannon_A();
    }

    @Override
    public Missile_A createMissile(Position initialPosition) {
        Position position = new Position(initialPosition.getX(), initialPosition.getY());
        return new Missile_A(position);
    }
}
