package cz.cvut.fit.miadp.mvcgame.model.object;

import cz.cvut.fit.miadp.mvcgame.model.Position;
import cz.cvut.fit.miadp.mvcgame.model.Vector;

public abstract class GameObject {
    Position position;

    private final String imgResource;

    GameObject(String imgResource) {
        this.imgResource = imgResource;
    }

    public String getImgResource() {
        return imgResource;
    }

    void move(Vector v) {
        position.add(v);
    }

    public Position getPosition() {
        return position;
    }
}
