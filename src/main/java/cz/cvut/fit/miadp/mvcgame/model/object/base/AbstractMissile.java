package cz.cvut.fit.miadp.mvcgame.model.object.base;

import cz.cvut.fit.miadp.mvcgame.config.MvcGameConfig;
import cz.cvut.fit.miadp.mvcgame.model.coordinations.Position;
import cz.cvut.fit.miadp.mvcgame.model.object.GameObject;

public abstract class AbstractMissile extends GameObject {

    public AbstractMissile(Position initialPosition) {
        super(MvcGameConfig.MISSILE_IMG_RESOURCE);
        position = initialPosition;
    }


    public abstract void move(Long time);

}
