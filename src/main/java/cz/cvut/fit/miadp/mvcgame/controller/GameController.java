package cz.cvut.fit.miadp.mvcgame.controller;

import cz.cvut.fit.miadp.mvcgame.model.GameModelInterface;
import cz.cvut.fit.miadp.mvcgame.model.coordinations.CannonDirection;
import javafx.scene.input.KeyCode;

import java.util.List;

public class GameController {

    private GameModelInterface model;

    public GameController(GameModelInterface model) {
        this.model = model;
    }

    public void handleUserInput(List<KeyCode> pressedKeysCodes) {
        for(KeyCode code : pressedKeysCodes) {
            switch(code) {
                case UP:
                    model.moveCannon(CannonDirection.UP);
                    break;
                case DOWN:
                    model.moveCannon(CannonDirection.DOWN);
                    break;
                case SPACE:
                    model.createMissile();
                    break;
                case A:
                    model.powerCannon(CannonDirection.UP);
                    break;
                case S:
                    model.powerCannon(CannonDirection.DOWN);
                    break;
                case Q:
                    model.upgradeCannon();
                    break;
            }
        }
    }
}
