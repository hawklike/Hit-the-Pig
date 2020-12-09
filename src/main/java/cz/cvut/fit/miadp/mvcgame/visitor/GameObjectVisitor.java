package cz.cvut.fit.miadp.mvcgame.visitor;

import cz.cvut.fit.miadp.mvcgame.model.object.base.AbstractCannon;
import cz.cvut.fit.miadp.mvcgame.model.object.base.AbstractMissile;

public interface GameObjectVisitor {
    void visitCannon(AbstractCannon cannon);

    void visitMissile(AbstractMissile missile);
}
