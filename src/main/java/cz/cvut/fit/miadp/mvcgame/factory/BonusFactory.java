package cz.cvut.fit.miadp.mvcgame.factory;

import cz.cvut.fit.miadp.mvcgame.config.MvcGameConfig;
import cz.cvut.fit.miadp.mvcgame.model.coordinations.Position;
import cz.cvut.fit.miadp.mvcgame.model.object.bonus.AbstractBonus;
import cz.cvut.fit.miadp.mvcgame.model.object.bonus.Cake;
import cz.cvut.fit.miadp.mvcgame.model.object.bonus.ExtraLife;

import java.util.concurrent.ThreadLocalRandom;

public class BonusFactory {

    public AbstractBonus createBonus() {
        return createBonus(ThreadLocalRandom.current().nextInt(1, 10));
    }

    public AbstractBonus createBonus(int random) {
        int posX = ThreadLocalRandom.current().nextInt(MvcGameConfig.MAX_X / 5, MvcGameConfig.MAX_X - 64);
        int posY = ThreadLocalRandom.current().nextInt(64, MvcGameConfig.MAX_Y - 64);
        return createBonus(random, new Position(posX, posY));
    }

    public AbstractBonus createBonus(int random, Position position) {
        if(random % 2 == 0) return new Cake(position);
        else return new ExtraLife(position);
    }

}
