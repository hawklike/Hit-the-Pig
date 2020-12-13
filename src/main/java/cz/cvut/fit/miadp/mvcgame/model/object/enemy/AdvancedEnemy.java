package cz.cvut.fit.miadp.mvcgame.model.object.enemy;

import cz.cvut.fit.miadp.mvcgame.config.MvcGameConfig;
import cz.cvut.fit.miadp.mvcgame.model.coordinations.Position;

public class AdvancedEnemy extends AbstractEnemy {
    public AdvancedEnemy(Position position) {
        super(MvcGameConfig.ADVANCED_ENEMY_IMG_RESOURCE,
                MvcGameConfig.ENEMY_DAMAGED_IMG_RESOURCE,
                position,
                MvcGameConfig.ADVANCED_ENEMY_MAX_LIVES,
                MvcGameConfig.ADVANCED_ENEMY_SPEED
        );
    }
}
