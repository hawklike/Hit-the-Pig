package cz.cvut.fit.miadp.mvcgame.servant;

import cz.cvut.fit.miadp.mvcgame.model.coordinations.Position;
import cz.cvut.fit.miadp.mvcgame.model.coordinations.Vector;

public class MoveServant {
    public static void moveTo(Movable serviced, Position where) {
        serviced.setPosition(where);
    }

    public static void moveBy(Movable serviced, Vector vector) {
        int dx = serviced.getPosition().getX() + vector.getDX();
        int dy = serviced.getPosition().getY() + vector.getDY();
        serviced.setPosition(new Position(dx, dy));
    }
}
