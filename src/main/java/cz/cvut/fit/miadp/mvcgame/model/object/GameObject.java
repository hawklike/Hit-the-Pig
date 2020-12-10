package cz.cvut.fit.miadp.mvcgame.model.object;

import cz.cvut.fit.miadp.mvcgame.model.coordinations.Position;
import cz.cvut.fit.miadp.mvcgame.model.coordinations.Vector;
import cz.cvut.fit.miadp.mvcgame.servant.Movable;
import cz.cvut.fit.miadp.mvcgame.servant.MoveServant;
import cz.cvut.fit.miadp.mvcgame.visitor.Visitable;

public abstract class GameObject implements Visitable, Movable {
    private Position position;

    private final String imgResource;

    protected GameObject(String imgResource, Position position) {
        this.imgResource = imgResource;
        this.position = position;
    }

    public String getImgResource() {
        return imgResource;
    }

    public void moveBy(Vector v) {
        MoveServant.moveBy(this, v);
    }

    public Position getPosition() {
        return position;
    }

    @Override
    public void setPosition(Position position) {
        this.position = position;
    }
}
