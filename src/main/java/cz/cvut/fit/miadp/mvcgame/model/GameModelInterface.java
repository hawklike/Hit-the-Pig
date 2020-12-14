package cz.cvut.fit.miadp.mvcgame.model;

import cz.cvut.fit.miadp.mvcgame.command.AbstractGameCommand;
import cz.cvut.fit.miadp.mvcgame.model.coordinations.VerticalDirection;
import cz.cvut.fit.miadp.mvcgame.model.object.GameObject;
import cz.cvut.fit.miadp.mvcgame.model.object.bonus.AbstractBonus;
import cz.cvut.fit.miadp.mvcgame.model.object.cannon.AbstractCannon;
import cz.cvut.fit.miadp.mvcgame.model.object.cannon.CannonConfiguration;
import cz.cvut.fit.miadp.mvcgame.model.object.enemy.AbstractEnemy;
import cz.cvut.fit.miadp.mvcgame.model.object.missile.AbstractMissile;
import cz.cvut.fit.miadp.mvcgame.observer.GUIObserver;

import java.util.List;

public interface GameModelInterface {
    void moveCannon(VerticalDirection direction);

    void aimCannon(VerticalDirection direction);

    void powerCannon(VerticalDirection direction);

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

    void registerCommand(AbstractGameCommand command);

    void undoLastCommand();

    AbstractCannon getCannon();

    List<AbstractMissile> getMissiles();

    List<AbstractBonus> getBonuses();

    List<AbstractEnemy> getEnemies();
}
