package cz.cvut.fit.miadp.mvcgame.model.object.basic;

import cz.cvut.fit.miadp.mvcgame.abstract_factory.AbstractGameObjectFactory;
import cz.cvut.fit.miadp.mvcgame.config.MvcGameConfig;
import cz.cvut.fit.miadp.mvcgame.model.coordinations.Direction;
import cz.cvut.fit.miadp.mvcgame.model.coordinations.Vector;
import cz.cvut.fit.miadp.mvcgame.model.object.base.AbstractCannon;
import cz.cvut.fit.miadp.mvcgame.model.object.base.AbstractMissile;

public class BasicCannon extends AbstractCannon {

    private AbstractGameObjectFactory objectFactory;

    public BasicCannon(AbstractGameObjectFactory objectFactory) {
        super();
        this.objectFactory = objectFactory;
    }

    @Override
    public void move(Direction direction) {

        switch(direction) {
            case UP:
                move(new Vector(0, -1 * MvcGameConfig.CANNON_MOVE_STEP));
                break;
            case DOWN:
                move(new Vector(0, MvcGameConfig.CANNON_MOVE_STEP));
                break;
            case LEFT:
            case RIGHT:
                break;
        }
    }

    @Override
    public AbstractMissile shoot() {
        return objectFactory.createMissile(getPosition());
    }
}
