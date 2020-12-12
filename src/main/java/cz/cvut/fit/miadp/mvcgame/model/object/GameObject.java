package cz.cvut.fit.miadp.mvcgame.model.object;

import cz.cvut.fit.miadp.mvcgame.model.coordinations.Position;
import cz.cvut.fit.miadp.mvcgame.model.coordinations.Vector;
import cz.cvut.fit.miadp.mvcgame.servant.Movable;
import cz.cvut.fit.miadp.mvcgame.servant.MoveServant;
import cz.cvut.fit.miadp.mvcgame.visitor.GameObjectVisitor;
import cz.cvut.fit.miadp.mvcgame.visitor.Visitable;
import javafx.geometry.Rectangle2D;

public abstract class GameObject implements Visitable, Movable {
    protected Position position;
    protected double width;
    protected double height;

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

    @Override
    public void acceptVisitor(GameObjectVisitor visitor) {
        visitor.visitGameObject(this);
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    private Rectangle2D getBoundary() {
        return new Rectangle2D(position.getX(), position.getY(), width, height);
    }

    public boolean collidesWith(GameObject otherObject) {
        return otherObject.getBoundary().intersects(getBoundary());
    }
}
