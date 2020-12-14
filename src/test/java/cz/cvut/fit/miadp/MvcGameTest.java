package cz.cvut.fit.miadp;

import cz.cvut.fit.miadp.mvcgame.abstract_factory.AbstractGameObjectFactory;
import cz.cvut.fit.miadp.mvcgame.abstract_factory.AdvancedGameObjectFactory;
import cz.cvut.fit.miadp.mvcgame.abstract_factory.BasicGameObjectFactory;
import cz.cvut.fit.miadp.mvcgame.bridge.GameGraphics;
import cz.cvut.fit.miadp.mvcgame.bridge.GameGraphicsInterface;
import cz.cvut.fit.miadp.mvcgame.config.MvcGameConfig;
import cz.cvut.fit.miadp.mvcgame.model.GameModel;
import cz.cvut.fit.miadp.mvcgame.model.GameModelInterface;
import cz.cvut.fit.miadp.mvcgame.model.coordinations.Dimension;
import cz.cvut.fit.miadp.mvcgame.model.coordinations.Position;
import cz.cvut.fit.miadp.mvcgame.model.object.GameObject;
import cz.cvut.fit.miadp.mvcgame.model.object.bonus.Cake;
import cz.cvut.fit.miadp.mvcgame.model.object.cannon.AbstractCannon;
import cz.cvut.fit.miadp.mvcgame.model.object.cannon.BasicCannon;
import cz.cvut.fit.miadp.mvcgame.model.object.enemy.AbstractEnemy;
import cz.cvut.fit.miadp.mvcgame.model.object.enemy.AdvancedEnemy;
import cz.cvut.fit.miadp.mvcgame.model.object.enemy.BasicEnemy;
import cz.cvut.fit.miadp.mvcgame.model.object.missile.AbstractMissile;
import cz.cvut.fit.miadp.mvcgame.visitor.GameObjectRenderer;
import org.junit.Test;

import static cz.cvut.fit.miadp.mvcgame.model.coordinations.VerticalDirection.UP;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;


public class MvcGameTest {

    @Test
    public void createCannonTest() {
        AbstractGameObjectFactory factory = new AdvancedGameObjectFactory();
        AbstractCannon cannon = factory.createCannon();

        assertEquals(cannon.getPower(), MvcGameConfig.PRO_CANNON_POWER);
        assertEquals(cannon.getPosition().getX(), MvcGameConfig.MAX_X / 10);
        assertEquals(cannon.getPosition().getY(), MvcGameConfig.MAX_Y / 2);

        factory = new BasicGameObjectFactory();
        cannon = factory.createCannon();

        assertEquals(cannon.getPower(), MvcGameConfig.BASIC_CANNON_POWER);
        assertEquals(cannon.getPosition().getX(), MvcGameConfig.MAX_X / 10);
        assertEquals(cannon.getPosition().getY(), MvcGameConfig.MAX_Y / 2);
    }

    @Test
    public void cannonShootTest() {
        GameModelInterface model = new GameModel();
        model.createMissile();
        assertEquals(model.getMissiles().size(), 1);
        AbstractMissile missile = model.getMissiles().get(0);
        assertEquals(model.getCannon().getPosition().getX(), missile.getPosition().getX());
        assertEquals(model.getCannon().getPosition().getY(), missile.getPosition().getY());
    }

    @Test
    public void moveCannonTest() {
        GameModel model = mock(GameModel.class);
        when(model.getCannon()).thenReturn(new BasicCannon(new Position(128, 128)));

        AbstractCannon cannon = model.getCannon();
        cannon.move(UP);
        assertEquals(cannon.getPosition().getY(), 128 - MvcGameConfig.BASIC_CANNON_MOVE_STEP);
        cannon.move(UP);
        assertEquals(cannon.getPosition().getY(), 128 - 2 * MvcGameConfig.BASIC_CANNON_MOVE_STEP);
    }

    @Test
    public void drawBonus() {
        GameGraphicsInterface graphics = mock(GameGraphics.class);
        GameObjectRenderer renderer = new GameObjectRenderer();
        renderer.setGraphicsContext(graphics);

        Cake cake = mock(Cake.class);
        when(graphics.getDimension(cake)).thenReturn(new Dimension(32, 32));
        when(cake.getImgResource()).thenReturn(MvcGameConfig.CAKE_IMG_RESOURCE);

        renderer.visitGameObject(cake);

        verify(cake).setHeight(32);
        verify(cake).setWidth(32);
        verify(graphics).drawImage(MvcGameConfig.CAKE_IMG_RESOURCE, cake.getPosition());
    }

    @Test
    public void enemyHitTest() {
        AbstractEnemy enemy = new AdvancedEnemy(new Position(0, 0));
        enemy.hit(MvcGameConfig.BASIC_CANNON_POWER);
        assertFalse(enemy.isDead());
        assertEquals(enemy.getLives(), MvcGameConfig.ADVANCED_ENEMY_MAX_LIVES - MvcGameConfig.BASIC_CANNON_POWER);
    }

    @Test
    public void collisionTest() {
        GameObject o1 = new BasicEnemy(new Position(0, 0));
        GameObject o2 = new BasicEnemy(new Position(0, 0));

        GameGraphicsInterface graphics = mock(GameGraphics.class);
        GameObjectRenderer renderer = new GameObjectRenderer();
        renderer.setGraphicsContext(graphics);
        when(graphics.getDimension(any())).thenReturn(new Dimension(32, 32));

        renderer.visitGameObject(o1);
        renderer.visitGameObject(o2);

        assertTrue(o1.collidesWith(o2));

        o2.setPosition(new Position(100, 100));
        assertFalse(o1.collidesWith(o2));
    }
}