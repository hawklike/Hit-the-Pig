package cz.cvut.fit.miadp.mvcgame;

import cz.cvut.fit.miadp.mvcgame.config.MvcGameConfig;
import cz.cvut.fit.miadp.mvcgame.controller.GameController;
import cz.cvut.fit.miadp.mvcgame.model.GameModel;
import cz.cvut.fit.miadp.mvcgame.view.GameView;
import javafx.scene.canvas.GraphicsContext;

import java.util.List;

// in future, use Bridge to remove this dependency

public class MvcGame {

    private GameModel model;
    private GameView view;
    private GameController controller;

    public void init() {
        model = new GameModel();
        view = new GameView(model);
        controller = view.getController();
    }

    public void processPressedKeys(List<String> pressedKeysCodes) {
        controller.processPressedKeys(pressedKeysCodes);
    }

    public void update() {
        // nothing yet
    }

    public void render(GraphicsContext gr) {
        view.render(gr);
    }

    public String getWindowTitle() {
        return "The MI-ADP.16 MvcGame";
    }

    public int getWindowWidth() {
        return MvcGameConfig.MAX_X;
    }

    public int getWindowHeight() {
        return MvcGameConfig.MAX_Y;
    }
}