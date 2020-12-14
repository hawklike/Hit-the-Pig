package cz.cvut.fit.miadp.mvcgame.model.object.missile;

import cz.cvut.fit.miadp.mvcgame.config.MvcGameConfig;
import cz.cvut.fit.miadp.mvcgame.model.coordinations.Position;
import cz.cvut.fit.miadp.mvcgame.strategy.ForwardMovingStrategy;
import cz.cvut.fit.miadp.mvcgame.strategy.MovingStrategy;

public class Missile extends AbstractMissile {

    public Missile(Position initialPosition, double initialAngle, int initialVelocity, MovingStrategy movingStrategy, String imgResource) {
        super(initialPosition, initialAngle, initialVelocity, movingStrategy, imgResource);
    }

    public static Missile createInstance(Position initialPosition, double initialAngle, int initialVelocity, MovingStrategy movingStrategy) {
        Position position = new Position(initialPosition.getX(), initialPosition.getY());
        String imgResource;
        if(movingStrategy instanceof ForwardMovingStrategy) imgResource = MvcGameConfig.MISSILE2_IMG_RESOURCE;
        else imgResource = MvcGameConfig.MISSILE_IMG_RESOURCE;
        return new Missile(position, initialAngle, initialVelocity, movingStrategy, imgResource);
    }
}
