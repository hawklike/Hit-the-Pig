package cz.cvut.fit.miadp.mvcgame.model.object;

import cz.cvut.fit.miadp.mvcgame.model.coordinations.Position;
import cz.cvut.fit.miadp.mvcgame.util.Timer;

public abstract class LifetimeLimitedGameObject extends GameObject {

    private Timer time;

    public LifetimeLimitedGameObject(String imgResource, Position initialPosition) {
        super(imgResource, initialPosition);
        time = new Timer();
    }

    public double getAge(Timer.Unit unit) {
        return time.getTime(unit);
    }

}
