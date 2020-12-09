package cz.cvut.fit.miadp.mvcgame.model;

import cz.cvut.fit.miadp.mvcgame.Log;
import cz.cvut.fit.miadp.mvcgame.MvcGame;
import cz.cvut.fit.miadp.mvcgame.abstract_factory.AbstractGameObjectFactory;
import cz.cvut.fit.miadp.mvcgame.abstract_factory.BasicGameObjectFactory;
import cz.cvut.fit.miadp.mvcgame.config.MvcGameConfig;
import cz.cvut.fit.miadp.mvcgame.model.coordinations.Direction;
import cz.cvut.fit.miadp.mvcgame.model.object.GameObject;
import cz.cvut.fit.miadp.mvcgame.model.object.base.AbstractCannon;
import cz.cvut.fit.miadp.mvcgame.model.object.base.AbstractMissile;
import cz.cvut.fit.miadp.mvcgame.observer.Observable;
import cz.cvut.fit.miadp.mvcgame.observer.Observer;

import java.util.ArrayList;
import java.util.List;

import static cz.cvut.fit.miadp.mvcgame.model.coordinations.Direction.DOWN;
import static cz.cvut.fit.miadp.mvcgame.model.coordinations.Direction.UP;

public class GameModel implements Observable {
    private AbstractCannon cannon;
    private List<AbstractMissile> missiles;

    private List<Observer> observers;
    private AbstractGameObjectFactory objectFactory;

    private Long time = 0L;
    private Long shotTime = 0L;

    public GameModel() {
        missiles = new ArrayList<>();
        objectFactory = new BasicGameObjectFactory();
        cannon = objectFactory.createCannon();
        observers = new ArrayList<>();
    }

    public void moveCannon(Direction direction) {
        switch(direction) {
            case UP:
                cannon.move(UP);
                break;
            case DOWN:
                cannon.move(DOWN);
                break;
            case LEFT:
            case RIGHT:
                break;
        }
        notifyObservers();
    }

    public void createMissile() {
        if(time - MvcGameConfig.MISSILE_TIME_DELAY > shotTime) {
            shotTime = time;
            missiles.add(cannon.shoot());
            notifyObservers();
        }
    }

    public AbstractCannon getCannon() {
        return cannon;
    }

    public List<AbstractMissile> getMissiles() {
        return missiles;
    }

    public List<GameObject> getGameObjects() {
        List<GameObject> objects = new ArrayList<>();
        objects.add(cannon);
        objects.addAll(missiles);
        return objects;
    }

    public void update() {
        time++;
        moveMissiles();
        //move enemies and other stuff
    }

    private void moveMissiles() {
        missiles.forEach(missile -> missile.move(time));
        removeMissiles();
        notifyObservers();
    }

    private void removeMissiles() {
        missiles.removeIf(missile -> missile.getPosition().getX() > MvcGame.getWindowWidth() ||
                missile.getPosition().getY() > MvcGame.getWindowHeight());
        Log.print("Active missiles: " + missiles.size());
    }

    @Override
    public void registerObserver(Observer observer) {
        if(!observers.contains(observer)) {
            observers.add(observer);
        }
    }

    @Override
    public void unregisterObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        observers.forEach(Observer::update);
    }
}
