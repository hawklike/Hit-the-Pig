package cz.cvut.fit.miadp.mvcgame.controller;

import cz.cvut.fit.miadp.mvcgame.model.GameModel;
import javafx.scene.input.KeyCode;

import java.util.List;

import static cz.cvut.fit.miadp.mvcgame.model.Direction.DOWN;
import static cz.cvut.fit.miadp.mvcgame.model.Direction.UP;

public class GameController {

    private GameModel model;

    public GameController(GameModel model) {
        this.model = model;
    }

    public void handleUserInput(List<KeyCode> pressedKeysCodes) {
        for(KeyCode code : pressedKeysCodes) {
            switch(code) {
                case UP:
                    model.moveCannon(UP);
                    break;
                case DOWN:
                    model.moveCannon(DOWN);
                    break;
                case SPACE:
                    model.createMissile();
                    break;
            }
        }
    }
}
