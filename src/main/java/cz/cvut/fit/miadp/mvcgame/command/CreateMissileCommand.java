package cz.cvut.fit.miadp.mvcgame.command;

import cz.cvut.fit.miadp.mvcgame.model.GameModelInterface;

public class CreateMissileCommand extends AbstractGameCommand {

    public CreateMissileCommand(GameModelInterface subject) {
        super(subject);
    }

    @Override
    protected void execute() {
        subject.createMissile();
    }
}
