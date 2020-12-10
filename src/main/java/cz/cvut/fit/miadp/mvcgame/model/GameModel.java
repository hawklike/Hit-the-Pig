package cz.cvut.fit.miadp.mvcgame.model;

import cz.cvut.fit.miadp.mvcgame.MvcGame;
import cz.cvut.fit.miadp.mvcgame.abstract_factory.AbstractGameObjectFactory;
import cz.cvut.fit.miadp.mvcgame.abstract_factory.BasicGameObjectFactory;
import cz.cvut.fit.miadp.mvcgame.model.coordinations.CannonDirection;
import cz.cvut.fit.miadp.mvcgame.model.object.GameObject;
import cz.cvut.fit.miadp.mvcgame.model.object.cannon.AbstractCannon;
import cz.cvut.fit.miadp.mvcgame.model.object.missile.AbstractMissile;
import cz.cvut.fit.miadp.mvcgame.observer.CannonObserver;
import cz.cvut.fit.miadp.mvcgame.observer.GUIObservable;
import cz.cvut.fit.miadp.mvcgame.observer.GUIObserver;
import cz.cvut.fit.miadp.mvcgame.state.CannonStateHolder;
import cz.cvut.fit.miadp.mvcgame.util.Log;

import java.util.ArrayList;
import java.util.List;

public class GameModel implements GUIObservable, CannonObserver, GameModelInterface {
    private AbstractCannon cannon;
    private List<AbstractMissile> missiles;

    private List<GUIObserver> observers;
    private AbstractGameObjectFactory objectFactory;

    private CannonStateHolder cannonState;

    private long ticks = 0;
    private long upgradeCannon = 0;

    private int score;

    public GameModel() {
        missiles = new ArrayList<>();
        objectFactory = new BasicGameObjectFactory();
        cannon = objectFactory.createCannon();
        observers = new ArrayList<>();
        cannonState = new CannonStateHolder(cannon, this);
        score = 0;
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

    public void upgradeCannon() {
        if(ticks - upgradeCannon > 400) {
            upgradeCannon = ticks;
            cannonState.upgrade();
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
        ticks++;
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
    public void registerObserver(GUIObserver observer) {
        if(!observers.contains(observer)) {
            observers.add(observer);
        }
    }

    @Override
    public void unregisterObserver(GUIObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        observers.forEach(GUIObserver::updateGUI);
    }

    @Override
    public void updateCannon(AbstractCannon cannon) {
        this.cannon = cannon;
    }
}
