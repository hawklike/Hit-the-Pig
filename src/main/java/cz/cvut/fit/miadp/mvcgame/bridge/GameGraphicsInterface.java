package cz.cvut.fit.miadp.mvcgame.bridge;

import cz.cvut.fit.miadp.mvcgame.model.coordinations.Dimension;
import cz.cvut.fit.miadp.mvcgame.model.coordinations.Position;
import cz.cvut.fit.miadp.mvcgame.model.object.GameObject;

public interface GameGraphicsInterface {

    public void drawImage(String path, Position pos);

    public void drawText(String text, Position pos);

    public void drawRectangle(Position leftTop, Position rightBottom);

    public void clear();

    public Dimension getDimension(GameObject object);
}