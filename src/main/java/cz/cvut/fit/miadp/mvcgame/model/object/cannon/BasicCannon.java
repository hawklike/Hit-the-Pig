package cz.cvut.fit.miadp.mvcgame.model.object.cannon;

import cz.cvut.fit.miadp.mvcgame.config.MvcGameConfig;
import cz.cvut.fit.miadp.mvcgame.strategy.RealMovingStrategy;

public class BasicCannon extends AbstractCannon {

    public BasicCannon() {
        super(MvcGameConfig.BASIC_CANNON_POWER,
                MvcGameConfig.BASIC_CANNON_MOVE_STEP,
                MvcGameConfig.BASIC_CANNON_SHOOT_DELAY_MILLIS,
                new RealMovingStrategy());
    }
}
