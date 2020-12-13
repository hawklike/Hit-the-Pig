package cz.cvut.fit.miadp.mvcgame.config;

public class MvcGameConfig {
    public static final int MAX_X = 1280;
    public static final int MAX_Y = 720;

    public static final int GAMEINFO_POSX = 32;
    public static final int GAMEINFO_POSY = 32;

    public static final String CANNON_IMG_RESOURCE = "images/cannon.png";
    public static final double CANNON_POWER_DELAY_MILLIS = 500;
    public static final int CANNON_POWER_STEP = 1;
    public static final double CANNON_ANGLE_STEP = Math.PI / 18;
    public static final double CANNON_ANGLE = 0;
    public static final int CANNON_MIN_POWER = 0;
    public static final int CANNON_MAX_POWER = 50;
    public static final int CANNON_MAX_ANGLE = 90;
    public static final int CANNON_MIN_ANGLE = -90;

    public static final int BASIC_CANNON_MOVE_STEP = 3;
    public static final int BASIC_CANNON_POWER = 10;
    public static final int BASIC_CANNON_SHOOT_DELAY_MILLIS = 1500;

    public static final int PRO_CANNON_MOVE_STEP = 6;
    public static final int PRO_CANNON_POWER = 15;
    public static final int PRO_CANNON_SHOOT_DELAY_MILLIS = 500;
    public static final int PRO_CANNON_SHOOT_TIME = 5000;

    public static final String MISSILE_IMG_RESOURCE = "images/missile.png";

    public static final String CAKE_IMG_RESOURCE = "images/cake.png";
    public static final String LIFE_IMG_RESOURCE = "images/life.png";
    public static final int BONUS_RESPAWN_TICKS = 2000;
    public static final int BONUS_LIFETIME_MILLIS = 5000;

    public static final String ENEMY_DAMAGED_IMG_RESOURCE = "/images/collision.png";
    public static final double SHOW_DAMAGED_ENEMY_LIVES_RATIO = 0.55;

    public static final String BASIC_ENEMY_IMG_RESOURCE = "/images/enemy1.png";
    public static final int BASIC_ENEMY_MAX_LIVES = 10;
    public static final int BASIC_ENEMY_SPEED = 1;

    public static final String ADVANCED_ENEMY_IMG_RESOURCE = "/images/enemy2.png";
    public static final int ADVANCED_ENEMY_MAX_LIVES = 30;
    public static final int ADVANCED_ENEMY_SPEED = 2;

    public static final double GRAVITY = 9.8;
}