package cz.cvut.fit.miadp.mvcgame.util;

import javafx.scene.media.AudioClip;

public class SoundPlayer {

    public void play(String file) {
        AudioClip sound = new AudioClip(getClass().getResource(file).toExternalForm());
        sound.play();
    }
}
