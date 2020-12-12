package cz.cvut.fit.miadp;

import cz.cvut.fit.miadp.mvcgame.MvcGame;
import cz.cvut.fit.miadp.mvcgame.bridge.GameGraphics;
import cz.cvut.fit.miadp.mvcgame.bridge.GameGraphicsInterface;
import cz.cvut.fit.miadp.mvcgame.bridge.JavaFxGraphics;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;

import java.util.ArrayList;

public class MvcGameJavaFxLauncher extends Application {

    private static final MvcGame theMvcGame = new MvcGame();

    @Override
    public void init() {
        theMvcGame.init();
    }

    @Override
    public void start(Stage stage) {
        String winTitle = theMvcGame.getWindowTitle();
        int winWidth = MvcGame.getWindowWidth();
        int winHeight = MvcGame.getWindowHeight();

        stage.setTitle(winTitle);

        Group root = new Group();
        Scene theScene = new Scene(root);
        stage.setScene(theScene);

        Canvas canvas = new Canvas(winWidth, winHeight);
        root.getChildren().add(canvas);

        GraphicsContext gc = canvas.getGraphicsContext2D();
        GameGraphicsInterface gr = new GameGraphics(new JavaFxGraphics(gc));

        ArrayList<KeyCode> pressedKeysCodes = new ArrayList<>();

        theScene.setOnKeyPressed(
                e ->
                {
                    KeyCode code = e.getCode();

                    // only add once... prevent duplicates
                    if(!pressedKeysCodes.contains(code))
                        pressedKeysCodes.add(code);
                }
        );

        theScene.setOnKeyReleased(
                e ->
                {
                    KeyCode code = e.getCode();
                    pressedKeysCodes.remove(code);
                }
        );

        // the game-loop
        new AnimationTimer() {
            public void handle(long currentNanoTime) {
                theMvcGame.processPressedKeys(pressedKeysCodes);
                theMvcGame.update();
                theMvcGame.render(gr);
            }
        }.start();

        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}