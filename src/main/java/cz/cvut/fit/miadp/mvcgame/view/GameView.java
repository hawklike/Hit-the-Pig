package cz.cvut.fit.miadp.mvcgame.view;

import cz.cvut.fit.miadp.mvcgame.MvcGame;
import cz.cvut.fit.miadp.mvcgame.controller.GameController;
import cz.cvut.fit.miadp.mvcgame.model.GameModel;
import cz.cvut.fit.miadp.mvcgame.model.object.Cannon;
import cz.cvut.fit.miadp.mvcgame.observer.Observer;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class GameView implements Observer {

    private GameController controller;
    private GameModel model;

    private GraphicsContext gr;

    public GameView(GameModel model) {
        this.model = model;
        controller = new GameController(model);
        gr = null;
        this.model.registerObserver(this);
    }

    public GameController getController() {
        return controller;
    }

    @Override
    public void update() {
        render();
    }

    public void setGraphicsContext(GraphicsContext gr) {
        if(this.gr == null) {
            this.gr = gr;
            render();
        }
    }

    private void render() {
        if(gr == null) return;
        gr.clearRect(0, 0, MvcGame.getWindowWidth(), MvcGame.getWindowHeight());
        drawCannon(model.getCannon());
    }

    private void drawCannon(Cannon cannon) {
        gr.drawImage(new Image(cannon.getImgResource()), cannon.getPosition().getX(), cannon.getPosition().getY());
    }

}
