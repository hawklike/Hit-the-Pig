package cz.cvut.fit.miadp.mvcgame.command;

import cz.cvut.fit.miadp.mvcgame.model.GameModelInterface;

public abstract class AbstractGameCommand {

    GameModelInterface subject;

    public AbstractGameCommand(GameModelInterface subject) {
        this.subject = subject;
    }

    protected abstract void execute();

    public void doExecute() {
        execute();
    }

    public void unExecute() {
    }
}
