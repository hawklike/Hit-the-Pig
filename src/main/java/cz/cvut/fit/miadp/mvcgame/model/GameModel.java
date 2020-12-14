package cz.cvut.fit.miadp.mvcgame.model;

import cz.cvut.fit.miadp.mvcgame.MvcGame;
import cz.cvut.fit.miadp.mvcgame.abstract_factory.AbstractGameObjectFactory;
import cz.cvut.fit.miadp.mvcgame.abstract_factory.AdvancedGameObjectFactory;
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
import cz.cvut.fit.miadp.mvcgame.util.Randomizer;
import cz.cvut.fit.miadp.mvcgame.util.SoundPlayer;
import cz.cvut.fit.miadp.mvcgame.util.Timer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class GameModel implements GUIObservable, CannonObserver, GameModelInterface {
    private AbstractCannon cannon;
    private List<AbstractMissile> missiles;
    private List<AbstractBonus> bonuses;
    private List<AbstractEnemy> enemies;

    private List<GUIObserver> observers;
    private AbstractGameObjectFactory objectFactory;
    private BonusFactory bonusFactory;

    private CannonStateHolder cannonState;

    private Randomizer randomizer;

    private int lives = MvcGameConfig.LIVES;
    private int destroyedEnemies = 0;

    private long ticks = 0;
    private long showBonus = 0;
    private long upgradeCannon = 0;

    private long createEnemies = 0;
    private int delayBetweenEnemies = MvcGameConfig.MAX_STEPS_BETWEEN_ENEMIES;


    public GameModel() {
        randomizer = new Randomizer();
        missiles = new ArrayList<>();
        objectFactory = new BasicGameObjectFactory();
        cannon = objectFactory.createCannon();
        observers = new ArrayList<>();
        cannonState = new CannonStateHolder(cannon, this);
        bonusFactory = new BonusFactory();
        bonuses = new ArrayList<>();
        enemies = new ArrayList<>(Arrays.asList(objectFactory.createEnemy(), objectFactory.createEnemy()));
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
        if(lives < 3) showBonus += 2;
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
                SoundPlayer player = new SoundPlayer();
                if(bonus instanceof Cake) {
                    cannonState.upgrade();
                    player.play(MvcGameConfig.CAKE_SOUND_RESOURCE);
                } else if(bonus instanceof ExtraLife) {
                    lives++;
                    player.play(MvcGameConfig.LIFE_SOUND_RESOURCE);
                }
                iter.remove();
            }
        }
    }

    private void enemyCollision(AbstractMissile missile) {
        boolean destroyed = false;
        Iterator<AbstractEnemy> iter = enemies.iterator();
        while(iter.hasNext()) {
            AbstractEnemy enemy = iter.next();
            if(missile.collidesWith(enemy)) {
                enemy.hit(missile.getPower());
                if(enemy.isDead()) {
                    destroyedEnemies++;
                    iter.remove();
                    destroyed = true;
                }
            }
        }
        if(destroyed && randomizer.flipCoin()) createEnemy();
    }

    private void handleEnemies() {
        createEnemies();
        moveEnemies();
        enemies.removeIf(enemy -> {
            if(enemy.getPosition().getX() < -enemy.getWidth()) {
                lives--;
                new SoundPlayer().play(MvcGameConfig.LIFE_DOWN_SOUND_RESOURCE);
                return true;
            } else return false;
        });
    }

    private void moveEnemies() {
        int acc;
        if(lives > MvcGameConfig.ULTRA_HARD_DIFFICULTY_LIVES_BOUND || destroyedEnemies > MvcGameConfig.ULTRA_HARD_DIFFICULTY_DESTROYED_ENEMIES_BOUND)
            acc = 2;
        else if(lives > MvcGameConfig.HARDER_DIFFICULTY_LIVES_BOUND || destroyedEnemies > MvcGameConfig.HARDER_DIFFICULTY_DESTROYED_ENEMIES_BOUND)
            acc = 1;
        else acc = 0;
        enemies.forEach(enemy -> enemy.move(acc));
    }

    private void createEnemies() {
        if(enemies.isEmpty()) createEnemy();
        if(enemies.size() <= MvcGameConfig.MAX_ENEMIES) {
            if(ticks - createEnemies >= delayBetweenEnemies) {
                createEnemies = ticks;
                if(delayBetweenEnemies > MvcGameConfig.MIN_STEPS_BETWEEN_ENEMIES) delayBetweenEnemies -= 100;
                createEnemy();
            }
        }
    }

    private void createEnemy() {
        if(randomizer.flipCoin()) objectFactory = new AdvancedGameObjectFactory();
        else objectFactory = new BasicGameObjectFactory();
        enemies.add(objectFactory.createEnemy());
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
