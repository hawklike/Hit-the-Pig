package cz.cvut.fit.miadp.mvcgame.view;

import cz.cvut.fit.miadp.mvcgame.controller.GameController;
import cz.cvut.fit.miadp.mvcgame.model.GameModel;
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
        gr.drawImage(new Image("icons/fit-icon-256x256.png"), model.getLogoPos().getX(), model.getLogoPos().getY());
    }

}
