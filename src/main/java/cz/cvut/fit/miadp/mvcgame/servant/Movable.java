package cz.cvut.fit.miadp.mvcgame.servant;

import cz.cvut.fit.miadp.mvcgame.model.coordinations.Position;

public interface Movable {
    void setPosition(Position position);

    Position getPosition();
}
