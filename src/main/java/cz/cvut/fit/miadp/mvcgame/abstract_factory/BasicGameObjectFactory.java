package cz.cvut.fit.miadp.mvcgame.abstract_factory;

import cz.cvut.fit.miadp.mvcgame.model.object.cannon.BasicCannon;

public class BasicGameObjectFactory implements AbstractGameObjectFactory {

    @Override
    public BasicCannon createCannon() {
        return new BasicCannon();
    }
}
