package cz.cvut.fit.miadp.mvcgame.state;

import cz.cvut.fit.miadp.mvcgame.model.object.cannon.AbstractCannon;
import cz.cvut.fit.miadp.mvcgame.observer.CannonObservable;
import cz.cvut.fit.miadp.mvcgame.observer.CannonObserver;

import java.util.ArrayList;
import java.util.List;

public class CannonStateHolder implements CannonObservable {

    private CannonState state;

    private List<CannonObserver> observers;

    public CannonStateHolder(AbstractCannon initState, CannonObserver observer) {
        state = initState;
        observers = new ArrayList<>();
        registerObserver(observer);
    }

    public void upgrade() {
        state.nextState(this);
    }

    public void upgrade(CannonState state) {
        this.state = state;
        notifyObservers();
        upgrade();
    }

    public void downgrade(CannonState state) {
        this.state = state;
        notifyObservers();
    }

    @Override
    public void registerObserver(CannonObserver observer) {
        if(!observers.contains(observer)) {
            observers.add(observer);
        }
    }

    @Override
    public void unregisterObserver(CannonObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        observers.forEach(observer -> observer.updateCannon((AbstractCannon) state));
    }
}
