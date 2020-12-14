package cz.cvut.fit.miadp.mvcgame.strategy;

import cz.cvut.fit.miadp.mvcgame.model.object.missile.AbstractMissile;

public interface MovingStrategy {
    void updatePosition(AbstractMissile missile);
}
