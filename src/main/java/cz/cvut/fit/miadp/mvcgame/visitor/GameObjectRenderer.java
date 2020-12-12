package cz.cvut.fit.miadp.mvcgame.visitor;

import cz.cvut.fit.miadp.mvcgame.bridge.GameGraphicsInterface;
import cz.cvut.fit.miadp.mvcgame.model.object.GameObject;
import javafx.scene.image.Image;

public class GameObjectRenderer implements GameObjectVisitor {

    private GameGraphicsInterface gr;

    public void setGraphicsContext(GameGraphicsInterface gr) {
        this.gr = gr;
    }

    @Override
    public void visitGameObject(GameObject object) {
        Image sprite = new Image(object.getImgResource());
        object.setHeight(sprite.getHeight());
        object.setWidth(sprite.getWidth());
        gr.drawImage(object.getImgResource(), object.getPosition());
    }
}
