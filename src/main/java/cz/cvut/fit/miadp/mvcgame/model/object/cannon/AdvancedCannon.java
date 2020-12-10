package cz.cvut.fit.miadp.mvcgame.model.object.cannon;

import cz.cvut.fit.miadp.mvcgame.config.MvcGameConfig;
import cz.cvut.fit.miadp.mvcgame.strategy.ForwardMovingStrategy;

public class AdvancedCannon extends AbstractCannon {

    public AdvancedCannon() {
        super(MvcGameConfig.PRO_CANNON_POWER,
                MvcGameConfig.PRO_CANNON_MOVE_STEP,
                MvcGameConfig.PRO_CANNON_SHOOT_DELAY_MILLIS,
                new ForwardMovingStrategy());
    }
}
