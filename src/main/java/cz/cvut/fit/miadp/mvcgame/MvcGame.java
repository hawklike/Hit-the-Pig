package cz.cvut.fit.miadp.mvcgame;

import cz.cvut.fit.miadp.mvcgame.bridge.GameGraphicsInterface;
import cz.cvut.fit.miadp.mvcgame.config.MvcGameConfig;
import cz.cvut.fit.miadp.mvcgame.controller.GameController;
import cz.cvut.fit.miadp.mvcgame.model.GameModel;
import cz.cvut.fit.miadp.mvcgame.model.GameModelInterface;
import cz.cvut.fit.miadp.mvcgame.proxy.GameModelProxy;
import cz.cvut.fit.miadp.mvcgame.view.GameView;
import javafx.scene.input.KeyCode;

import java.util.List;

public class MvcGame {

    private GameModelInterface model;
    private GameView view;
    private GameController controller;

    public void init() {
        model = new GameModelProxy(new GameModel());
        view = new GameView(model);
        controller = view.getController();
    }

    public void processPressedKeys(List<KeyCode> pressedKeysCodes) {
        controller.handleUserInput(pressedKeysCodes);
    }

    public void update() {
        model.update();
    }

    public void render(GameGraphicsInterface gr) {
        view.setGraphicsContext(gr);
    }

    public String getWindowTitle() {
        return "The MI-ADP.16 MvcGame";
    }

    public static int getWindowWidth() {
        return MvcGameConfig.MAX_X;
    }

    public static int getWindowHeight() {
        return MvcGameConfig.MAX_Y;
    }
}