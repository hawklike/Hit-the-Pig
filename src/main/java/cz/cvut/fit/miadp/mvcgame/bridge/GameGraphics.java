package cz.cvut.fit.miadp.mvcgame.bridge;

import cz.cvut.fit.miadp.mvcgame.model.coordinations.Dimension;
import cz.cvut.fit.miadp.mvcgame.model.coordinations.Position;
import cz.cvut.fit.miadp.mvcgame.model.object.GameObject;

public class GameGraphics implements GameGraphicsInterface {

    private GameGraphicsImplementor implementor;

    public GameGraphics(GameGraphicsImplementor implementor) {
        this.implementor = implementor;
    }

    @Override
    public void drawImage(String path, Position pos) {
        this.implementor.drawImage(path, pos);

    }

    @Override
    public void drawText(String text, Position pos) {
        this.implementor.drawText(text, pos);

    }

    @Override
    public void drawRectangle(Position leftTop, Position rightBottom) {
        this.implementor.drawLine(
                leftTop,
                new Position(rightBottom.getX(), leftTop.getY())
        );
        this.implementor.drawLine(
                new Position(rightBottom.getX(), leftTop.getY()),
                rightBottom
        );
        this.implementor.drawLine(
                rightBottom,
                new Position(leftTop.getX(), rightBottom.getY())
        );
        this.implementor.drawLine(
                new Position(leftTop.getX(), rightBottom.getY()),
                leftTop
        );
    }

    @Override
    public void clear() {
        this.implementor.clear();
    }

    @Override
    public Dimension getDimension(GameObject object) {
        return implementor.getDimension(object);
    }

}