package cz.cvut.fit.miadp.mvcgame.command;

import cz.cvut.fit.miadp.mvcgame.model.GameModelInterface;

public class UpgradeCannonCommand extends AbstractGameCommand {

    public UpgradeCannonCommand(GameModelInterface subject) {
        super(subject);
    }

    @Override
    protected void execute() {
        subject.upgradeCannon();
    }
}
