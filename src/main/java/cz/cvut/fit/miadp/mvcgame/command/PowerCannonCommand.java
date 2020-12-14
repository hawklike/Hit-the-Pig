package cz.cvut.fit.miadp.mvcgame.command;

import cz.cvut.fit.miadp.mvcgame.model.GameModelInterface;
import cz.cvut.fit.miadp.mvcgame.model.coordinations.VerticalDirection;

public class PowerCannonCommand extends AbstractGameCommand {

    private VerticalDirection direction;

    public PowerCannonCommand(GameModelInterface subject, VerticalDirection direction) {
        super(subject);
        this.direction = direction;
    }

    @Override
    protected void execute() {
        subject.powerCannon(direction);
    }
}
