package cz.cvut.fit.miadp.mvcgame.abstract_factory;

import cz.cvut.fit.miadp.mvcgame.model.object.cannon.AdvancedCannon;

public class AdvancedGameObjectFactory implements AbstractGameObjectFactory {

    @Override
    public AdvancedCannon createCannon() {
        return new AdvancedCannon();
    }
}
