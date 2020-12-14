package cz.cvut.fit.miadp.mvcgame.command;

import cz.cvut.fit.miadp.mvcgame.model.GameModelInterface;
import cz.cvut.fit.miadp.mvcgame.model.coordinations.VerticalDirection;

public class MoveCannonCommand extends AbstractGameCommand {

    private VerticalDirection direction;

    public MoveCannonCommand(GameModelInterface subject, VerticalDirection direction) {
        super(subject);
        this.direction = direction;
    }

    @Override
    protected void execute() {
        subject.moveCannon(direction);
    }
}
