package cz.cvut.fit.miadp.mvcgame.model;

import cz.cvut.fit.miadp.mvcgame.model.coordinations.CannonDirection;
import cz.cvut.fit.miadp.mvcgame.model.object.GameObject;
import cz.cvut.fit.miadp.mvcgame.model.object.cannon.AbstractCannon;
import cz.cvut.fit.miadp.mvcgame.model.object.cannon.CannonConfiguration;
import cz.cvut.fit.miadp.mvcgame.observer.GUIObserver;

import java.util.List;

public interface GameModelInterface {
    void moveCannon(CannonDirection direction);

    void aimCannon(CannonDirection direction);

    void powerCannon(CannonDirection direction);

    void createMissile();

    void upgradeCannon();

    List<GameObject> getGameObjects();

    CannonConfiguration getCannonConfig();

    int getLives();

    int getDestroyedEnemies();

    void update();

    void registerObserver(GUIObserver observer);

    void unregisterObserver(GUIObserver observer);

    void notifyObservers();

    void updateCannon(AbstractCannon cannon);
}
