package cz.cvut.fit.miadp.mvcgame.model;

import cz.cvut.fit.miadp.mvcgame.config.MvcGameConfig;

public class GameModel {
    private Position logoPos;

    public GameModel() {
        logoPos = new Position((MvcGameConfig.MAX_X / 2) - 128, (MvcGameConfig.MAX_Y / 2) - 128);
    }

    public Position getLogoPos() {
        return logoPos;
    }

    public void moveLogo(Direction direction) {
        switch(direction) {
            case UP:
                logoPos.setY(logoPos.getY() - 10);
                break;
            case DOWN:
                logoPos.setY(logoPos.getY() + 10);
                break;
            case LEFT:
                logoPos.setX(logoPos.getX() - 10);
                break;
            case RIGHT:
                logoPos.setX(logoPos.getX() + 10);
                break;
        }
    }
}
