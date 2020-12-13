package cz.cvut.fit.miadp.mvcgame.abstract_factory;

import cz.cvut.fit.miadp.mvcgame.config.MvcGameConfig;
import cz.cvut.fit.miadp.mvcgame.model.object.cannon.BasicCannon;
import cz.cvut.fit.miadp.mvcgame.model.object.enemy.BasicEnemy;
import cz.cvut.fit.miadp.mvcgame.util.Randomizer;

public class BasicGameObjectFactory implements AbstractGameObjectFactory {

    @Override
    public BasicCannon createCannon() {
        return new BasicCannon();
    }

    @Override
    public BasicEnemy createEnemy() {
        return new BasicEnemy(new Randomizer().createPosition(
                MvcGameConfig.MAX_X / 3,
                MvcGameConfig.MAX_X - 64,
                64, MvcGameConfig.MAX_Y - 64
        ));
    }
}
