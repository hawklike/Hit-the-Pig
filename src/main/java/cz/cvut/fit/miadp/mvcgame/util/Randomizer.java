package cz.cvut.fit.miadp.mvcgame.util;

import cz.cvut.fit.miadp.mvcgame.model.coordinations.Position;

import java.util.concurrent.ThreadLocalRandom;

public class Randomizer {

    public Position createPosition(int minX, int maxX, int minY, int maxY) {
        int posX = ThreadLocalRandom.current().nextInt(minX, maxX + 1);
        int posY = ThreadLocalRandom.current().nextInt(minY, maxY + 1);
        return new Position(posX, posY);
    }

    public boolean flipCoin() {
        return ThreadLocalRandom.current().nextInt(1, 3) % 2 == 0;
    }
}
