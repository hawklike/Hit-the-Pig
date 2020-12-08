package cz.cvut.fit.miadp.mvcgame.model;

import cz.cvut.fit.miadp.mvcgame.abstract_factory.AbstractGameObjectFactory;
import cz.cvut.fit.miadp.mvcgame.abstract_factory.GameObjectFactory_A;
import cz.cvut.fit.miadp.mvcgame.model.object.AbstractCannon;
import cz.cvut.fit.miadp.mvcgame.model.object.AbstractMissile;
import cz.cvut.fit.miadp.mvcgame.observer.Observable;
import cz.cvut.fit.miadp.mvcgame.observer.Observer;

import java.util.ArrayList;
import java.util.List;

import static cz.cvut.fit.miadp.mvcgame.model.Direction.DOWN;
import static cz.cvut.fit.miadp.mvcgame.model.Direction.UP;

public class GameModel implements Observable {
    private AbstractCannon cannon;
    private List<AbstractMissile> missiles;

    private List<Observer> observers;
    private AbstractGameObjectFactory objectFactory;


    public GameModel() {
        missiles = new ArrayList<>();
        objectFactory = new GameObjectFactory_A();
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
        missiles.add(objectFactory.createMissile(cannon.getPosition()));
        notifyObservers();
    }

    public AbstractCannon getCannon() {
        return cannon;
    }

    public List<AbstractMissile> getMissiles() {
        return missiles;
    }

    public void update() {
        //move enemies and other stuff
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
