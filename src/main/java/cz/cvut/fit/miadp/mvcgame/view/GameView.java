package cz.cvut.fit.miadp.mvcgame.view;

import cz.cvut.fit.miadp.mvcgame.controller.GameController;
import cz.cvut.fit.miadp.mvcgame.model.GameModel;
import cz.cvut.fit.miadp.mvcgame.model.object.Cannon;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class GameView {

    private GameController controller;
    private GameModel model;

    public GameView(GameModel model) {
        this.model = model;
        controller = new GameController(model);
    }

    public GameController getController() {
        return controller;
    }

    public void render(GraphicsContext gr) {
        drawCannon(gr, model.getCannon());
    }

    private void drawCannon(GraphicsContext gr, Cannon cannon) {
        gr.drawImage(new Image(cannon.getImgResource()), cannon.getPosition().getX(), cannon.getPosition().getY());
    }

}
