package cz.cvut.fit.miadp.mvcgame.proxy;

import cz.cvut.fit.miadp.mvcgame.model.GameModelInterface;
import cz.cvut.fit.miadp.mvcgame.model.coordinations.CannonDirection;
import cz.cvut.fit.miadp.mvcgame.model.object.GameObject;
import cz.cvut.fit.miadp.mvcgame.model.object.cannon.AbstractCannon;
import cz.cvut.fit.miadp.mvcgame.model.object.cannon.CannonConfiguration;
import cz.cvut.fit.miadp.mvcgame.observer.GUIObserver;

import java.util.List;

public class GameModelProxy implements GameModelInterface {
    private GameModelInterface subject;

    public GameModelProxy(GameModelInterface model) {
        subject = model;
    }

    @Override
    public void moveCannon(CannonDirection direction) {
        subject.moveCannon(direction);
    }

    @Override
    public void aimCannon(CannonDirection direction) {
        subject.aimCannon(direction);
    }

    @Override
    public void powerCannon(CannonDirection direction) {
        subject.powerCannon(direction);
    }

    @Override
    public void createMissile() {
        subject.createMissile();
    }

    @Override
    public void upgradeCannon() {
        subject.upgradeCannon();
    }

    @Override
    public List<GameObject> getGameObjects() {
        return subject.getGameObjects();
    }

    @Override
    public CannonConfiguration getCannonConfig() {
        return subject.getCannonConfig();
    }

    @Override
    public void update() {
        subject.update();
    }

    @Override
    public void registerObserver(GUIObserver observer) {
        subject.registerObserver(observer);
    }

    @Override
    public void unregisterObserver(GUIObserver observer) {
        subject.unregisterObserver(observer);
    }

    @Override
    public void notifyObservers() {
        subject.notifyObservers();
    }

    @Override
    public void updateCannon(AbstractCannon cannon) {
        subject.updateCannon(cannon);
    }
}
