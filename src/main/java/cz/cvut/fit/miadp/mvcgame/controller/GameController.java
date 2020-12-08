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
                    model.moveLogo(UP);
                    break;
                case "DOWN":
                    model.moveLogo(DOWN);
                    break;
                case "LEFT":
                    model.moveLogo(LEFT);
                    break;
                case "RIGHT":
                    model.moveLogo(RIGHT);
                    break;
            }
        }
    }
}
