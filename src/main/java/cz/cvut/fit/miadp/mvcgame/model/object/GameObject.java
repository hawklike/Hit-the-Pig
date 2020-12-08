package cz.cvut.fit.miadp.mvcgame.model.object;

import cz.cvut.fit.miadp.mvcgame.model.coordinations.Position;
import cz.cvut.fit.miadp.mvcgame.model.coordinations.Vector;

public abstract class GameObject {
    protected Position position;

    private final String imgResource;

    protected GameObject(String imgResource) {
        this.imgResource = imgResource;
    }

    public String getImgResource() {
        return imgResource;
    }

    protected void move(Vector v) {
        position.add(v);
    }

    public Position getPosition() {
        return position;
    }
}
