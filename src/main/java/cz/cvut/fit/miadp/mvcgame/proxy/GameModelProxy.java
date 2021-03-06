package cz.cvut.fit.miadp.mvcgame.proxy;

import cz.cvut.fit.miadp.mvcgame.command.AbstractGameCommand;
import cz.cvut.fit.miadp.mvcgame.model.GameModelInterface;
import cz.cvut.fit.miadp.mvcgame.model.coordinations.VerticalDirection;
import cz.cvut.fit.miadp.mvcgame.model.object.GameObject;
import cz.cvut.fit.miadp.mvcgame.model.object.bonus.AbstractBonus;
import cz.cvut.fit.miadp.mvcgame.model.object.cannon.AbstractCannon;
import cz.cvut.fit.miadp.mvcgame.model.object.cannon.CannonConfiguration;
import cz.cvut.fit.miadp.mvcgame.model.object.enemy.AbstractEnemy;
import cz.cvut.fit.miadp.mvcgame.model.object.missile.AbstractMissile;
import cz.cvut.fit.miadp.mvcgame.observer.GUIObserver;

import java.util.List;

public class GameModelProxy implements GameModelInterface {
    private GameModelInterface subject;

    public GameModelProxy(GameModelInterface model) {
        subject = model;
    }

    @Override
    public void moveCannon(VerticalDirection direction) {
        subject.moveCannon(direction);
    }

    @Override
    public void aimCannon(VerticalDirection direction) {
        subject.aimCannon(direction);
    }

    @Override
    public void powerCannon(VerticalDirection direction) {
        subject.powerCannon(direction);
    }

    @Override
    public void createMissile() {
        subject.createMissile();
    }

    @Override
    public void upgradeCannon() {
        subject.upgradeCannon();
    }

    @Override
    public List<GameObject> getGameObjects() {
        return subject.getGameObjects();
    }

    @Override
    public CannonConfiguration getCannonConfig() {
        return subject.getCannonConfig();
    }

    @Override
    public int getLives() {
        return subject.getLives();
    }

    @Override
    public int getDestroyedEnemies() {
        return subject.getDestroyedEnemies();
    }

    @Override
    public void update() {
        subject.update();
    }

    @Override
    public void registerObserver(GUIObserver observer) {
        subject.registerObserver(observer);
    }

    @Override
    public void unregisterObserver(GUIObserver observer) {
        subject.unregisterObserver(observer);
    }

    @Override
    public void notifyObservers() {
        subject.notifyObservers();
    }

    @Override
    public void updateCannon(AbstractCannon cannon) {
        subject.updateCannon(cannon);
    }

    @Override
    public void registerCommand(AbstractGameCommand command) {
        subject.registerCommand(command);
    }

    @Override
    public void undoLastCommand() {
        subject.undoLastCommand();
    }

    @Override
    public AbstractCannon getCannon() {
        return subject.getCannon();
    }

    @Override
    public List<AbstractMissile> getMissiles() {
        return subject.getMissiles();
    }

    @Override
    public List<AbstractBonus> getBonuses() {
        return subject.getBonuses();
    }

    @Override
    public List<AbstractEnemy> getEnemies() {
        return subject.getEnemies();
    }

}
