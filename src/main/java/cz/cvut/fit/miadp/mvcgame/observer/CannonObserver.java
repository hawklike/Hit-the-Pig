package cz.cvut.fit.miadp.mvcgame.observer;

import cz.cvut.fit.miadp.mvcgame.model.object.cannon.AbstractCannon;

public interface CannonObserver {
    void updateCannon(AbstractCannon cannon);
}
