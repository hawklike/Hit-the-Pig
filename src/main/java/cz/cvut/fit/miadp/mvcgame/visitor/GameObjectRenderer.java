package cz.cvut.fit.miadp.mvcgame.visitor;

import cz.cvut.fit.miadp.mvcgame.model.object.GameObject;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class GameObjectRenderer implements GameObjectVisitor {

    private GraphicsContext gr;

    public void setGraphicsContext(GraphicsContext gr) {
        this.gr = gr;
    }

    @Override
    public void visitGameObject(GameObject object) {
        Image sprite = new Image(object.getImgResource());
        object.setHeight(sprite.getHeight());
        object.setWidth(sprite.getWidth());
        gr.drawImage(sprite, object.getPosition().getX(), object.getPosition().getY());
    }
}
