package cz.cvut.fit.miadp.mvcgame.observer;

public interface GUIObservable {
    void registerObserver(GUIObserver observer);

    void unregisterObserver(GUIObserver observer);

    void notifyObservers();
}
