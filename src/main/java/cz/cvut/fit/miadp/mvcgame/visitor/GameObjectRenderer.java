package cz.cvut.fit.miadp.mvcgame.visitor;

import cz.cvut.fit.miadp.mvcgame.bridge.GameGraphicsInterface;
import cz.cvut.fit.miadp.mvcgame.model.coordinations.Dimension;
import cz.cvut.fit.miadp.mvcgame.model.object.GameObject;

public class GameObjectRenderer implements GameObjectVisitor {

    private GameGraphicsInterface gr;

    public void setGraphicsContext(GameGraphicsInterface gr) {
        this.gr = gr;
    }

    @Override
    public void visitGameObject(GameObject object) {
        Dimension dimension = gr.getDimension(object);
        object.setHeight(dimension.getHeight());
        object.setWidth(dimension.getWidth());
        gr.drawImage(object.getImgResource(), object.getPosition());
    }
}
