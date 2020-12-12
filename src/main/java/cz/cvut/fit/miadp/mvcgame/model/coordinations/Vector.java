package cz.cvut.fit.miadp.mvcgame.model.coordinations;

public class Vector {
    private int dX;
    private int dY;

    public Vector(int dX, int dY) {
        this.dX = dX;
        this.dY = dY;
    }

    public int getDX() {
        return dX;
    }

    public int getDY() {
        return dY;
    }

    public void setDY(int y) {
        this.dY = y;
    }

    public void setDX(int x) {
        this.dX = x;
    }
}
