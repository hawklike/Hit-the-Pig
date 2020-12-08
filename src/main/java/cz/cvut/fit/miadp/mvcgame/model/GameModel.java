package cz.cvut.fit.miadp.mvcgame.model;

import cz.cvut.fit.miadp.mvcgame.model.object.Cannon;
import cz.cvut.fit.miadp.mvcgame.observer.Observable;
import cz.cvut.fit.miadp.mvcgame.observer.Observer;

import java.util.ArrayList;
import java.util.List;

import static cz.cvut.fit.miadp.mvcgame.model.Direction.DOWN;
import static cz.cvut.fit.miadp.mvcgame.model.Direction.UP;

public class GameModel implements Observable {
    private Cannon cannon;
    private List<Observer> observers;

    public GameModel() {
        cannon = new Cannon();
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

    public Cannon getCannon() {
        return cannon;
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
