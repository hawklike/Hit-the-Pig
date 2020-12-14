package cz.cvut.fit.miadp.mvcgame.bridge;

import cz.cvut.fit.miadp.mvcgame.config.MvcGameConfig;
import cz.cvut.fit.miadp.mvcgame.model.coordinations.Dimension;
import cz.cvut.fit.miadp.mvcgame.model.coordinations.Position;
import cz.cvut.fit.miadp.mvcgame.model.object.GameObject;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class JavaFxGraphics implements GameGraphicsImplementor {

    private GraphicsContext gc;

    public JavaFxGraphics(GraphicsContext gc) {
        this.gc = gc;
    }

    @Override
    public void drawImage(String path, Position pos) {
        Image img = new Image(path);
        this.gc.drawImage(img, pos.getX(), pos.getY());

    }

    @Override
    public void drawText(String text, Position pos) {
        this.gc.fillText(text, pos.getX(), pos.getY());

    }

    @Override
    public void drawLine(Position beginPos, Position endPos) {
        this.gc.strokeLine(beginPos.getX(), beginPos.getY(), endPos.getX(), endPos.getY());
    }

    public void clear() {
        this.gc.clearRect(0, 0, MvcGameConfig.MAX_X, MvcGameConfig.MAX_Y);
    }

    @Override
    public Dimension getDimension(GameObject object) {
        Image img = new Image(object.getImgResource());
        return new Dimension(img.getWidth(), img.getHeight());
    }
}