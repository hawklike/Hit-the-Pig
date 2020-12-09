package cz.cvut.fit.miadp.mvcgame.visitor;

import cz.cvut.fit.miadp.mvcgame.model.object.base.AbstractCannon;
import cz.cvut.fit.miadp.mvcgame.model.object.base.AbstractMissile;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class GameObjectRenderer implements GameObjectVisitor {

    private GraphicsContext gr;

    public void setGraphicsContext(GraphicsContext gr) {
        this.gr = gr;
    }

    @Override
    public void visitCannon(AbstractCannon cannon) {
        gr.drawImage(new Image(cannon.getImgResource()), cannon.getPosition().getX(), cannon.getPosition().getY());
    }

    @Override
    public void visitMissile(AbstractMissile missile) {
        gr.drawImage(new Image(missile.getImgResource()), missile.getPosition().getX(), missile.getPosition().getY());

    }
}
