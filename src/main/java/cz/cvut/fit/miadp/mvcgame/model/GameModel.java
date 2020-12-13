package cz.cvut.fit.miadp.mvcgame.model;

import cz.cvut.fit.miadp.mvcgame.MvcGame;
import cz.cvut.fit.miadp.mvcgame.abstract_factory.AbstractGameObjectFactory;
import cz.cvut.fit.miadp.mvcgame.abstract_factory.BasicGameObjectFactory;
import cz.cvut.fit.miadp.mvcgame.config.MvcGameConfig;
import cz.cvut.fit.miadp.mvcgame.factory.BonusFactory;
import cz.cvut.fit.miadp.mvcgame.model.coordinations.CannonDirection;
import cz.cvut.fit.miadp.mvcgame.model.object.GameObject;
import cz.cvut.fit.miadp.mvcgame.model.object.bonus.AbstractBonus;
import cz.cvut.fit.miadp.mvcgame.model.object.bonus.Cake;
import cz.cvut.fit.miadp.mvcgame.model.object.bonus.ExtraLife;
import cz.cvut.fit.miadp.mvcgame.model.object.cannon.AbstractCannon;
import cz.cvut.fit.miadp.mvcgame.model.object.cannon.CannonConfiguration;
import cz.cvut.fit.miadp.mvcgame.model.object.enemy.AbstractEnemy;
import cz.cvut.fit.miadp.mvcgame.model.object.missile.AbstractMissile;
import cz.cvut.fit.miadp.mvcgame.observer.CannonObserver;
import cz.cvut.fit.miadp.mvcgame.observer.GUIObservable;
import cz.cvut.fit.miadp.mvcgame.observer.GUIObserver;
import cz.cvut.fit.miadp.mvcgame.state.CannonStateHolder;
import cz.cvut.fit.miadp.mvcgame.util.Log;
import cz.cvut.fit.miadp.mvcgame.util.Timer;

import java.util.*;

public class GameModel implements GUIObservable, CannonObserver, GameModelInterface {
    private AbstractCannon cannon;
    private List<AbstractMissile> missiles;
    private List<AbstractBonus> bonuses;
    private List<AbstractEnemy> enemies;

    private List<GUIObserver> observers;
    private AbstractGameObjectFactory objectFactory;
    private BonusFactory bonusFactory;

    private CannonStateHolder cannonState;

    private int lives = 3;
    private int destroyedEnemies = 0;

    private long ticks = 0;
    private long showBonus = 0;
    private long upgradeCannon = 0;


    public GameModel() {
        missiles = new LinkedList<>();
        objectFactory = new BasicGameObjectFactory();
        cannon = objectFactory.createCannon();
        observers = new LinkedList<>();
        cannonState = new CannonStateHolder(cannon, this);
        bonusFactory = new BonusFactory();
        bonuses = new LinkedList<>();
        enemies = new LinkedList<>(Arrays.asList(objectFactory.createEnemy(), objectFactory.createEnemy()));
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

    //todo remove this function
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
        objects.addAll(bonuses);
        objects.addAll(enemies);
        return objects;
    }

    public CannonConfiguration getCannonConfig() {
        return new CannonConfiguration(cannon.getAngle(), cannon.getPower());
    }

    public int getLives() {
        return lives;
    }

    public int getDestroyedEnemies() {
        return destroyedEnemies;
    }

    public void update() {
        ticks++;
//        Log.print(ticks);
        handleMissiles();
        handleBonuses();
        handleEnemies();
        checkCollisions();
        notifyObservers();
    }

    private void handleBonuses() {
        createBonus();
        bonuses.removeIf(bonus -> bonus.getAge(Timer.Unit.MILLIS) > MvcGameConfig.BONUS_LIFETIME_MILLIS);
    }

    private void createBonus() {
        if(++showBonus > MvcGameConfig.BONUS_RESPAWN_TICKS) {
            showBonus = 0;
            bonuses.add(bonusFactory.createBonus());
        }
    }

    private void checkCollisions() {
        missiles.forEach(missile -> {
            bonusCollision(missile);
            enemyCollision(missile);
        });
    }

    private void bonusCollision(AbstractMissile missile) {
        Iterator<AbstractBonus> iter = bonuses.iterator();
        while(iter.hasNext()) {
            AbstractBonus bonus = iter.next();
            if(missile.collidesWith(bonus)) {
                if(bonus instanceof Cake) cannonState.upgrade();
                else if(bonus instanceof ExtraLife) lives++;
                iter.remove();
            }
        }
    }

    private void enemyCollision(AbstractMissile missile) {
        Iterator<AbstractEnemy> iter = enemies.iterator();
        while(iter.hasNext()) {
            AbstractEnemy enemy = iter.next();
            if(missile.collidesWith(enemy)) {
                enemy.hit(missile.getPower());
                if(enemy.isDead()) {
                    destroyedEnemies++;
                    iter.remove();
                }
            }
        }
    }

    private void handleEnemies() {
        createEnemies();
        enemies.forEach(AbstractEnemy::move);
        enemies.removeIf(enemy -> enemy.getPosition().getX() < -enemy.getWidth());
    }

    private void createEnemies() {

    }

    private void handleMissiles() {
        missiles.forEach(AbstractMissile::move);
        missiles.removeIf(missile -> missile.getPosition().getX() > MvcGame.getWindowWidth() ||
                missile.getPosition().getY() > MvcGame.getWindowHeight());
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
