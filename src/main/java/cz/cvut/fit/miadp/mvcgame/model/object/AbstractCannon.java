package cz.cvut.fit.miadp.mvcgame.model.object;

import cz.cvut.fit.miadp.mvcgame.config.MvcGameConfig;
import cz.cvut.fit.miadp.mvcgame.model.Direction;
import cz.cvut.fit.miadp.mvcgame.model.Position;

public abstract class AbstractCannon extends GameObject {

    public AbstractCannon() {
        this(new Position(MvcGameConfig.MAX_X / 7, MvcGameConfig.MAX_Y / 2));
    }

    @SuppressWarnings("WeakerAccess")
    public AbstractCannon(Position initialPosition) {
        super(MvcGameConfig.CANNON_IMG_RESOURCE);
        position = initialPosition;
    }

    public abstract void move(Direction direction);

}
