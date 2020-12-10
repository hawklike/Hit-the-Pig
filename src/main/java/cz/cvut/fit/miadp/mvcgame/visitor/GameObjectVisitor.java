package cz.cvut.fit.miadp.mvcgame.visitor;

import cz.cvut.fit.miadp.mvcgame.model.object.cannon.AbstractCannon;
import cz.cvut.fit.miadp.mvcgame.model.object.missile.AbstractMissile;

public interface GameObjectVisitor {
    void visitCannon(AbstractCannon cannon);

    void visitMissile(AbstractMissile missile);
}
