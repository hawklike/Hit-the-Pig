package cz.cvut.fit.miadp.mvcgame.view;

import cz.cvut.fit.miadp.mvcgame.bridge.GameGraphicsInterface;
import cz.cvut.fit.miadp.mvcgame.config.MvcGameConfig;
import cz.cvut.fit.miadp.mvcgame.controller.GameController;
import cz.cvut.fit.miadp.mvcgame.model.GameModelInterface;
import cz.cvut.fit.miadp.mvcgame.model.coordinations.Position;
import cz.cvut.fit.miadp.mvcgame.model.object.cannon.CannonConfiguration;
import cz.cvut.fit.miadp.mvcgame.observer.GUIObserver;
import cz.cvut.fit.miadp.mvcgame.visitor.GameObjectRenderer;

import java.text.DecimalFormat;

public class GameView implements GUIObserver {

    private GameController controller;
    private GameModelInterface model;

    private GameGraphicsInterface gr;
    private GameObjectRenderer renderer;

    public GameView(GameModelInterface model) {
        this.model = model;
        controller = new GameController(model);
        gr = null;
        this.model.registerObserver(this);
        renderer = new GameObjectRenderer();
    }

    public GameController getController() {
        return controller;
    }

    @Override
    public void updateGUI() {
        render();
    }

    public void setGraphicsContext(GameGraphicsInterface gr) {
        if(this.gr == null) {
            this.gr = gr;
            renderer.setGraphicsContext(gr);
            render();
        }
    }

    private void render() {
        if(gr == null) return;
        gr.clear();
        renderText();
        model.getGameObjects().forEach(gameObject -> gameObject.acceptVisitor(renderer));
    }

    private void renderText() {
        CannonConfiguration cannon = model.getCannonConfig();
        DecimalFormat angleFormat = new DecimalFormat("#.##");
        String angle = angleFormat.format(cannon.getAngle());
        int power = cannon.getPower();
        int lives = model.getLives();
        gr.drawText(
                "Lives: " + lives + "  Power: " + power + "  Angle: " + angle,
                new Position(MvcGameConfig.GAMEINFO_POSX, MvcGameConfig.GAMEINFO_POSY));

    }

}
