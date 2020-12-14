package cz.cvut.fit.miadp.mvcgame.model.object.enemy;

import cz.cvut.fit.miadp.mvcgame.config.MvcGameConfig;
import cz.cvut.fit.miadp.mvcgame.model.coordinations.Position;
import cz.cvut.fit.miadp.mvcgame.model.coordinations.Vector;
import cz.cvut.fit.miadp.mvcgame.model.object.GameObject;
import cz.cvut.fit.miadp.mvcgame.util.Randomizer;
import cz.cvut.fit.miadp.mvcgame.util.SoundPlayer;
import cz.cvut.fit.miadp.mvcgame.util.Timer;

public abstract class AbstractEnemy extends GameObject {

    protected int maxLives;
    protected int speed;
    protected int lives;

    private Timer lastHit;

    protected String hitImgResource;

    public AbstractEnemy(String imgResource, String hitImgResource, Position position, int maxLives, int speed) {
        super(imgResource, position);
        this.hitImgResource = hitImgResource;
        this.maxLives = maxLives;
        this.lives = maxLives;
        this.speed = speed;
    }

    public void move(int acc) {
        moveBy(new Vector(-1 * (speed + acc), 0));
    }

    public void hit(int power) {
        if(lastHit == null || lastHit.getTime(Timer.Unit.MILLIS) > MvcGameConfig.ENEMY_HIT_IMMORTALITY_MILLIS) {
            lastHit = new Timer();
            SoundPlayer player = new SoundPlayer();
            if(new Randomizer().flipCoin()) player.play(MvcGameConfig.ENEMY1_SOUND_RESOURCE);
            else player.play(MvcGameConfig.ENEMY2_SOUND_RESOURCE);
            lives -= power;
            int previousSpeed = speed;
            speed /= 2;
            if(speed <= 0) speed = previousSpeed;
            if(getLiveRatio() < MvcGameConfig.SHOW_DAMAGED_ENEMY_LIVES_RATIO) imgResource = hitImgResource;
        }
    }

    public boolean isDead() {
        return lives <= 0;
    }

    private double getLiveRatio() {
        return lives / (double) maxLives;
    }

}
