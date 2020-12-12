package cz.cvut.fit.miadp.mvcgame.visitor;

import cz.cvut.fit.miadp.mvcgame.model.object.GameObject;

public interface GameObjectVisitor {
    void visitGameObject(GameObject object);
}
