package cz.cvut.fit.miadp.mvcgame.model.object.bonus;

import cz.cvut.fit.miadp.mvcgame.config.MvcGameConfig;
import cz.cvut.fit.miadp.mvcgame.model.coordinations.Position;

public class ExtraLife extends AbstractBonus {

    public ExtraLife(Position initialPosition) {
        super(MvcGameConfig.LIFE_IMG_RESOURCE, initialPosition);
    }
}
