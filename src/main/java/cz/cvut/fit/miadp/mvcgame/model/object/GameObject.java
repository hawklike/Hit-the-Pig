package cz.cvut.fit.miadp.mvcgame.model.object;

import cz.cvut.fit.miadp.mvcgame.model.coordinations.Position;
import cz.cvut.fit.miadp.mvcgame.model.coordinations.Vector;
import cz.cvut.fit.miadp.mvcgame.visitor.Visitable;

public abstract class GameObject implements Visitable {
    protected Position position;

    private final String imgResource;

    protected GameObject(String imgResource, Position position) {
        this.imgResource = imgResource;
        this.position = position;
    }

    public String getImgResource() {
        return imgResource;
    }

    public void move(Vector v) {
        position.add(v);
    }

    public Position getPosition() {
        return position;
    }
}
