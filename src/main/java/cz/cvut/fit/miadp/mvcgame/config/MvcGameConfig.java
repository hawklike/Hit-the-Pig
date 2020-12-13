package cz.cvut.fit.miadp.mvcgame.config;

public class MvcGameConfig {
    public static final int MAX_X = 1280;
    public static final int MAX_Y = 720;

    public static final String BACKGROUND_IMG_RESOURCE = "images/background.png";

    public static final int GAMEINFO_POSX = 32;
    public static final int GAMEINFO_POSY = 32;

    public static final int HORIZON_POSY = 38;

    public static final int LIVES = 5;

    public static final int HARDER_DIFFICULTY_LIVES_BOUND = 7;
    public static final int HARDER_DIFFICULTY_DESTROYED_ENEMIES_BOUND = 50;

    public static final String CANNON_IMG_RESOURCE = "images/new/cannon.png";
    public static final double CANNON_POWER_DELAY_MILLIS = 500;
    public static final int CANNON_POWER_STEP = 1;
    public static final double CANNON_ANGLE_STEP = Math.PI / 18;
    public static final double CANNON_ANGLE = 0;
    public static final int CANNON_MIN_POWER = 0;
    public static final int CANNON_MAX_POWER = 70;
    public static final int CANNON_MAX_ANGLE = 90;
    public static final int CANNON_MIN_ANGLE = -90;

    public static final int BASIC_CANNON_MOVE_STEP = 5;
    public static final int BASIC_CANNON_POWER = 30;
    public static final int BASIC_CANNON_SHOOT_DELAY_MILLIS = 1000;

    public static final int PRO_CANNON_MOVE_STEP = 7;
    public static final int PRO_CANNON_POWER = 35;
    public static final int PRO_CANNON_SHOOT_DELAY_MILLIS = 500;
    public static final int PRO_CANNON_SHOOT_TIME = 5000;

    public static final String MISSILE_IMG_RESOURCE = "images/new/missile.png";

    public static final String CAKE_IMG_RESOURCE = "images/cake.png";
    public static final String LIFE_IMG_RESOURCE = "images/life.png";
    public static final int BONUS_RESPAWN_TICKS = 1000;
    public static final int BONUS_LIFETIME_MILLIS = 5000;

    public static final String ENEMY_DAMAGED_IMG_RESOURCE = "/images/new/collision.png";
    public static final double SHOW_DAMAGED_ENEMY_LIVES_RATIO = 0.55;
    public static final int ENEMY_HIT_IMMORTALITY_MILLIS = 350;
    public static final int MAX_ENEMIES = 8;
    public static final int MAX_STEPS_BETWEEN_ENEMIES = 900;
    public static final int MIN_STEPS_BETWEEN_ENEMIES = 300;

    public static final String BASIC_ENEMY_IMG_RESOURCE = "/images/new/enemy1.png";
    public static final int BASIC_ENEMY_MAX_LIVES = 30;
    public static final int BASIC_ENEMY_SPEED = 1;

    public static final String ADVANCED_ENEMY_IMG_RESOURCE = "/images/new/enemy2.png";
    public static final int ADVANCED_ENEMY_MAX_LIVES = 60;
    public static final int ADVANCED_ENEMY_SPEED = 2;

    public static final double GRAVITY = 9.8;
}