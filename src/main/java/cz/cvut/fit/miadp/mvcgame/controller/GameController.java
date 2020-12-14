package cz.cvut.fit.miadp.mvcgame.controller;

import cz.cvut.fit.miadp.mvcgame.command.*;
import cz.cvut.fit.miadp.mvcgame.model.GameModelInterface;
import cz.cvut.fit.miadp.mvcgame.model.coordinations.VerticalDirection;
import javafx.scene.input.KeyCode;

import java.util.List;

public class GameController {

    private GameModelInterface model;

    public GameController(GameModelInterface model) {
        this.model = model;
    }

    public boolean handleUserInput(List<KeyCode> pressedKeysCodes, int lives) {
        for(KeyCode code : pressedKeysCodes) {
            switch(code) {
                case UP:
                    model.registerCommand(new MoveCannonCommand(model, VerticalDirection.UP));
                    break;
                case DOWN:
                    model.registerCommand(new MoveCannonCommand(model, VerticalDirection.DOWN));
                    break;
                case SPACE:
                    model.registerCommand(new CreateMissileCommand(model));
                    break;
                case A:
                    model.registerCommand(new PowerCannonCommand(model, VerticalDirection.UP));
                    break;
                case S:
                    model.registerCommand(new PowerCannonCommand(model, VerticalDirection.DOWN));
                    break;
                case Q:
                    model.registerCommand(new AimCannonCommand(model, VerticalDirection.UP));
                    break;
                case W:
                    model.registerCommand(new AimCannonCommand(model, VerticalDirection.DOWN));
                    break;
                case P:
                    model.registerCommand(new UpgradeCannonCommand(model));
                    break;
                case F:
                    return lives == 0;
                default:
                    return false;
            }
        }
        return false;
    }
}
