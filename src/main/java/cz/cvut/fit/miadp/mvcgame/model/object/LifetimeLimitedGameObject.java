package cz.cvut.fit.miadp.mvcgame.model.object;

import cz.cvut.fit.miadp.mvcgame.util.Timer;

public abstract class LifetimeLimitedGameObject extends GameObject {

    private Timer time;

    public LifetimeLimitedGameObject(String imgResource) {
        super(imgResource);
        time = new Timer();
    }

    public double getAge(Timer.Unit unit) {
        return time.getTime(unit);
    }

}
