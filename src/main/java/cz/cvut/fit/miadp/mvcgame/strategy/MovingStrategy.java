package cz.cvut.fit.miadp.mvcgame.strategy;

import cz.cvut.fit.miadp.mvcgame.model.object.base.AbstractMissile;

public interface MovingStrategy {
    void updatePosition(AbstractMissile missile);
}
