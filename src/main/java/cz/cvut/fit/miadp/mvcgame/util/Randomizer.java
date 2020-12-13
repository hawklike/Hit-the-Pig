package cz.cvut.fit.miadp.mvcgame.util;

import cz.cvut.fit.miadp.mvcgame.model.coordinations.Position;

import java.util.concurrent.ThreadLocalRandom;

public class Randomizer {

    public Position createPosition(int minX, int maxX, int minY, int maxY) {
        int posX = ThreadLocalRandom.current().nextInt(minX, maxX);
        int posY = ThreadLocalRandom.current().nextInt(minY, maxY);
        return new Position(posX, posY);
    }
}
