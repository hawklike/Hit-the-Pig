package cz.cvut.fit.miadp.mvcgame.model.object.cannon;

public class CannonConfiguration {
    private double angle;
    private int power;

    public CannonConfiguration(double angle, int power) {
        this.angle = angle;
        this.power = power;
    }

    public double getAngle() {
        return angle;
    }

    public int getPower() {
        return power;
    }
}
