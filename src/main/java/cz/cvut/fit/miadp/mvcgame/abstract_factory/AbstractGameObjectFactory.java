package cz.cvut.fit.miadp.mvcgame.abstract_factory;

import cz.cvut.fit.miadp.mvcgame.model.object.cannon.AbstractCannon;
import cz.cvut.fit.miadp.mvcgame.model.object.enemy.AbstractEnemy;

public interface AbstractGameObjectFactory {
    AbstractCannon createCannon();

    AbstractEnemy createEnemy();
}
