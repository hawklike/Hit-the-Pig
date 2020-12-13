package cz.cvut.fit.miadp.mvcgame.abstract_factory;

import cz.cvut.fit.miadp.mvcgame.config.MvcGameConfig;
import cz.cvut.fit.miadp.mvcgame.model.object.cannon.AdvancedCannon;
import cz.cvut.fit.miadp.mvcgame.model.object.enemy.AdvancedEnemy;
import cz.cvut.fit.miadp.mvcgame.util.Randomizer;

public class AdvancedGameObjectFactory implements AbstractGameObjectFactory {

    @Override
    public AdvancedCannon createCannon() {
        return new AdvancedCannon();
    }

    @Override
    public AdvancedEnemy createEnemy() {
        return new AdvancedEnemy(new Randomizer().createPosition(
                MvcGameConfig.MAX_X / 3,
                MvcGameConfig.MAX_X - 64,
                64, MvcGameConfig.MAX_Y - 64
        ));
    }
}
