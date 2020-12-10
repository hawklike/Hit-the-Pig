package cz.cvut.fit.miadp.mvcgame.observer;

public interface CannonStateObservable {
    void registerObserver(CannonObserver observer);

    void unregisterObserver(CannonObserver observer);

    void notifyObservers();
}
