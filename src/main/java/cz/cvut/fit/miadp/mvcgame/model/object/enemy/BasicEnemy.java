package cz.cvut.fit.miadp.mvcgame.model.object.enemy;

import cz.cvut.fit.miadp.mvcgame.config.MvcGameConfig;
import cz.cvut.fit.miadp.mvcgame.model.coordinations.Position;

public class BasicEnemy extends AbstractEnemy {
    public BasicEnemy(Position position) {
        super(MvcGameConfig.BASIC_ENEMY_IMG_RESOURCE,
                MvcGameConfig.ENEMY_DAMAGED_IMG_RESOURCE,
                position,
                MvcGameConfig.BASIC_ENEMY_MAX_LIVES,
                MvcGameConfig.BASIC_ENEMY_SPEED
        );
    }
}
