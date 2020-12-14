package cz.cvut.fit.miadp.mvcgame.state;

import cz.cvut.fit.miadp.mvcgame.model.object.cannon.AbstractCannon;
import cz.cvut.fit.miadp.mvcgame.observer.CannonObservable;
import cz.cvut.fit.miadp.mvcgame.observer.CannonObserver;
import cz.cvut.fit.miadp.mvcgame.util.Log;

import java.util.ArrayList;
import java.util.List;

public class CannonStateHolder implements CannonObservable {

    private CannonState state;

    private List<CannonObserver> observers;

    private int activeUpgrades;

    public CannonStateHolder(AbstractCannon initState, CannonObserver observer) {
        activeUpgrades = 0;
        state = initState;
        observers = new ArrayList<>();
        registerObserver(observer);
    }

    public void upgrade() {
        activeUpgrades++;
        Log.print("active upgrades" + activeUpgrades);
        state.nextState(this);
    }

    public void upgrade(CannonState state) {
        this.state = state;
        notifyObservers();
        state.nextState(this);
    }

    public void downgrade(CannonState state) {
        if(--activeUpgrades > 0) return;
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
