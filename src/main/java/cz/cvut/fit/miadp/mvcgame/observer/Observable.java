package cz.cvut.fit.miadp.mvcgame.observer;

public interface Observable {
    public void registerObserver(Observer observer);

    public void unregisterObserver(Observer observer);

    public void notifyObservers();
}
