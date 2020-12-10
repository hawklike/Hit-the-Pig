package cz.cvut.fit.miadp.mvcgame.model;

import cz.cvut.fit.miadp.mvcgame.MvcGame;
import cz.cvut.fit.miadp.mvcgame.abstract_factory.AbstractGameObjectFactory;
import cz.cvut.fit.miadp.mvcgame.abstract_factory.AdvancedGameObjectFactory;
import cz.cvut.fit.miadp.mvcgame.model.coordinations.CannonDirection;
import cz.cvut.fit.miadp.mvcgame.model.object.GameObject;
import cz.cvut.fit.miadp.mvcgame.model.object.cannon.AbstractCannon;
import cz.cvut.fit.miadp.mvcgame.model.object.missile.AbstractMissile;
import cz.cvut.fit.miadp.mvcgame.observer.Observable;
import cz.cvut.fit.miadp.mvcgame.observer.Observer;
import cz.cvut.fit.miadp.mvcgame.strategy.ForwardMovingStrategy;
import cz.cvut.fit.miadp.mvcgame.strategy.MovingStrategy;
import cz.cvut.fit.miadp.mvcgame.strategy.RealMovingStrategy;
import cz.cvut.fit.miadp.mvcgame.util.Log;

import java.util.ArrayList;
import java.util.List;

public class GameModel implements Observable {
    private AbstractCannon cannon;
    private List<AbstractMissile> missiles;

    private List<Observer> observers;
    private AbstractGameObjectFactory objectFactory;

    private MovingStrategy missileMovingStrategy;

    public GameModel() {
        missiles = new ArrayList<>();
        objectFactory = new AdvancedGameObjectFactory();
        cannon = objectFactory.createCannon();
        observers = new ArrayList<>();
        missileMovingStrategy = new RealMovingStrategy();
    }

    public void moveCannon(CannonDirection direction) {
        switch(direction) {
            case UP:
                cannon.move(CannonDirection.UP);
                break;
            case DOWN:
                cannon.move(CannonDirection.DOWN);
                break;
        }
        notifyObservers();
    }

    public void aimCannon(CannonDirection direction) {
        Log.print("angle: " + cannon.getAngle());
        switch(direction) {
            case UP:
                cannon.aim(CannonDirection.UP);
                break;
            case DOWN:
                cannon.aim(CannonDirection.DOWN);
                break;
        }
        notifyObservers();
    }

    public void powerCannon(CannonDirection direction) {
        Log.print("power: " + cannon.getPower());
        switch(direction) {
            case UP:
                cannon.power(CannonDirection.UP);
                break;
            case DOWN:
                cannon.power(CannonDirection.DOWN);
                break;
        }
        notifyObservers();
    }

    public void createMissile() {
        AbstractMissile missile = cannon.shoot();
        if(missile != null) {
            missiles.add(missile);
            notifyObservers();
        }
    }

    public List<GameObject> getGameObjects() {
        List<GameObject> objects = new ArrayList<>();
        objects.add(cannon);
        objects.addAll(missiles);
        return objects;
    }

    public void update() {
        moveMissiles();
        //move enemies and other stuff
    }

    private void moveMissiles() {
        missiles.forEach(AbstractMissile::move);
        removeMissiles();
        notifyObservers();
    }

    private void removeMissiles() {
        missiles.removeIf(missile -> missile.getPosition().getX() > MvcGame.getWindowWidth() ||
                missile.getPosition().getY() > MvcGame.getWindowHeight());
//        Log.print("Active missiles: " + missiles.size());
    }

    @Override
    public void registerObserver(Observer observer) {
        if(!observers.contains(observer)) {
            observers.add(observer);
        }
    }

    public void toggleMissileStrategy() {
        if(missileMovingStrategy instanceof ForwardMovingStrategy) {
            missileMovingStrategy = new RealMovingStrategy();
        } else if(missileMovingStrategy instanceof RealMovingStrategy) {
            missileMovingStrategy = new ForwardMovingStrategy();
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
