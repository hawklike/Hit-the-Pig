package cz.cvut.fit.miadp.mvcgame.model.object;

import cz.cvut.fit.miadp.mvcgame.config.MvcGameConfig;
import cz.cvut.fit.miadp.mvcgame.model.Position;

public abstract class AbstractMissile extends GameObject {

    public AbstractMissile(Position initialPosition) {
        super(MvcGameConfig.MISSILE_IMG_RESOURCE);
        position = initialPosition;
    }


    public abstract void move(Long time);

}
