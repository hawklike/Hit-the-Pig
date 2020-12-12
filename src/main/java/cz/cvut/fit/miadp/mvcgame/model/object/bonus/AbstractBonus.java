package cz.cvut.fit.miadp.mvcgame.model.object.bonus;

import cz.cvut.fit.miadp.mvcgame.model.coordinations.Position;
import cz.cvut.fit.miadp.mvcgame.model.object.LifetimeLimitedGameObject;

public abstract class AbstractBonus extends LifetimeLimitedGameObject {

    public AbstractBonus(String imgResource, Position initialPosition) {
        super(imgResource, initialPosition);
    }
}
