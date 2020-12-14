package cz.cvut.fit.miadp.mvcgame.model.object.bonus;

import cz.cvut.fit.miadp.mvcgame.config.MvcGameConfig;
import cz.cvut.fit.miadp.mvcgame.model.coordinations.Position;

public class Cake extends AbstractBonus {

    public Cake(Position initialPosition) {
        super(MvcGameConfig.CAKE_IMG_RESOURCE, initialPosition);
    }
}
