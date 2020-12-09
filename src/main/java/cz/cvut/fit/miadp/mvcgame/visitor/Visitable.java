package cz.cvut.fit.miadp.mvcgame.visitor;

public interface Visitable {
    void acceptVisitor(GameObjectVisitor visitor);
}
