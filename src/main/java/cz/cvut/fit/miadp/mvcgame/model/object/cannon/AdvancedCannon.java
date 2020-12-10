package cz.cvut.fit.miadp.mvcgame.model.object.cannon;

import cz.cvut.fit.miadp.mvcgame.config.MvcGameConfig;
import cz.cvut.fit.miadp.mvcgame.memento_singleton.CannonCareTaker;
import cz.cvut.fit.miadp.mvcgame.model.coordinations.Position;
import cz.cvut.fit.miadp.mvcgame.state.CannonStateHolder;
import cz.cvut.fit.miadp.mvcgame.strategy.ForwardMovingStrategy;

public class AdvancedCannon extends AbstractCannon {

    public AdvancedCannon() {
        super(MvcGameConfig.PRO_CANNON_POWER,
                MvcGameConfig.PRO_CANNON_MOVE_STEP,
                MvcGameConfig.PRO_CANNON_SHOOT_DELAY_MILLIS,
                new ForwardMovingStrategy());
    }

    public AdvancedCannon(Position position) {
        super(position,
                MvcGameConfig.PRO_CANNON_POWER,
                MvcGameConfig.PRO_CANNON_MOVE_STEP,
                MvcGameConfig.PRO_CANNON_SHOOT_DELAY_MILLIS,
                new ForwardMovingStrategy());
    }

    @Override
    public void nextState(CannonStateHolder cannonState) {
        new Thread(() -> {
            try {
                Thread.sleep(MvcGameConfig.PRO_CANNON_SHOOT_TIME);
                downgrade(cannonState);
            } catch(InterruptedException ie) {
                downgrade(cannonState);
            }
        }).start();
    }

    private void downgrade(CannonStateHolder cannonState) {
        BasicCannon basicCannon = new BasicCannon(getPosition());
        basicCannon.restore(CannonCareTaker.getInstance().restoreLast());
        cannonState.downgrade(basicCannon);
    }
}
