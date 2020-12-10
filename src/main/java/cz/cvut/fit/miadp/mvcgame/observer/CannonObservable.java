package cz.cvut.fit.miadp.mvcgame.observer;

public interface CannonObservable {
    void registerObserver(CannonObserver observer);

    void unregisterObserver(CannonObserver observer);

    void notifyObservers();
}
