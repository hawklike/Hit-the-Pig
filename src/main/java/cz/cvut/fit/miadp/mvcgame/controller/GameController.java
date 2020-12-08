package cz.cvut.fit.miadp.mvcgame.controller;

import cz.cvut.fit.miadp.mvcgame.model.GameModel;

import java.util.List;

import static cz.cvut.fit.miadp.mvcgame.model.Direction.*;

public class GameController {

    private GameModel model;

    public GameController(GameModel model) {
        this.model = model;
    }

    public void processPressedKeys(List<String> pressedKeysCodes) {
        for(String code : pressedKeysCodes) {
            switch(code) {
                case "UP":
                    model.moveCannon(UP);
                    break;
                case "DOWN":
                    model.moveCannon(DOWN);
                    break;
                case "LEFT":
                    model.moveCannon(LEFT);
                    break;
                case "RIGHT":
                    model.moveCannon(RIGHT);
                    break;
            }
        }
    }
}
