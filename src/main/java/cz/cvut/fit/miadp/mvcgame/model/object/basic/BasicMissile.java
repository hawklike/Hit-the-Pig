package cz.cvut.fit.miadp.mvcgame.model.object.basic;

import cz.cvut.fit.miadp.mvcgame.model.coordinations.Position;
import cz.cvut.fit.miadp.mvcgame.model.object.base.AbstractMissile;

public class BasicMissile extends AbstractMissile {

    public BasicMissile(Position initialPosition) {
        super(initialPosition);
    }

    @Override
    public void move(Long time) {

    }
}
