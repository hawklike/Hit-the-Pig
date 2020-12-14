package cz.cvut.fit.miadp.mvcgame.command;

import cz.cvut.fit.miadp.mvcgame.model.GameModelInterface;
import cz.cvut.fit.miadp.mvcgame.model.coordinations.VerticalDirection;

public class AimCannonCommand extends AbstractGameCommand {

    private VerticalDirection direction;

    public AimCannonCommand(GameModelInterface subject, VerticalDirection direction) {
        super(subject);
        this.direction = direction;
    }

    @Override
    protected void execute() {
        subject.aimCannon(direction);
    }
}
