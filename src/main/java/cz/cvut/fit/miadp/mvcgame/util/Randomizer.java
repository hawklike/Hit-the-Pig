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

    /**
     * Returns true with probability 1:n.
     * For example, if n is set to 3, then
     * returns true with probability of 33.3 %.
     *
     * @param n probability
     * @return true with probability 1:n
     */
    public boolean oneTo(int n) {
        return ThreadLocalRandom.current().nextInt(1, n + 1) % n == 0;
    }
}
