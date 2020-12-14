package cz.cvut.fit.miadp.mvcgame.factory;

import cz.cvut.fit.miadp.mvcgame.config.MvcGameConfig;
import cz.cvut.fit.miadp.mvcgame.model.coordinations.Position;
import cz.cvut.fit.miadp.mvcgame.model.object.bonus.AbstractBonus;
import cz.cvut.fit.miadp.mvcgame.model.object.bonus.Cake;
import cz.cvut.fit.miadp.mvcgame.model.object.bonus.ExtraLife;
import cz.cvut.fit.miadp.mvcgame.util.Randomizer;

public class BonusFactory {

    public AbstractBonus createBonus() {
        return createBonus(new Randomizer().createPosition(
                MvcGameConfig.MAX_X / 5,
                MvcGameConfig.MAX_X / 2 + MvcGameConfig.MAX_X / 4,
                MvcGameConfig.HORIZON_POSY, MvcGameConfig.MAX_Y - 64
                )
        );
    }

    public AbstractBonus createBonus(Position position) {
        if(new Randomizer().flipCoin()) return new Cake(position);
        else return new ExtraLife(position);
    }

}
